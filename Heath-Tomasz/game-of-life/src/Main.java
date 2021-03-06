import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {
	public static void main(String... args) {
		final Display display = new Display();
		Shell shell = new Shell();
		shell.setLayout(new GridLayout());
		shell.setSize(800, 600);
		shell.setText("Game of Life");

		final World[] worldPointer = new World[1];
		World world = new World();
		world.add(new Cell(10, 10));
		world.add(new Cell(10, 11));
		world.add(new Cell(10, 12));
		worldPointer[0] = world;

		final Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent paintEvent) {
				for (int i = 0; i < canvas.getClientArea().width; i += 10) {
					paintEvent.gc.drawLine(i, 0, i,
							canvas.getClientArea().height);
					for (int j = 0; j < canvas.getClientArea().height; j += 10) {
						paintEvent.gc.drawLine(0, j,
								canvas.getClientArea().width, j);
					}
				}

				for (Cell cell : worldPointer[0]) {
					paintEvent.gc.setBackground(display
							.getSystemColor(SWT.COLOR_BLUE));
					paintEvent.gc.drawRectangle(cell.x * 10, cell.y * 10,
							(cell.x + 1) * 10, (cell.y + 1) * 10);
				}
			}
		});
		canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}
}
