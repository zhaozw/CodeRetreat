import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class Cell extends Point {

	public Cell() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cell(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Cell(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public Collection<Cell> getNeighbours() {
		return new ArrayList<Cell>(8) {
			{
				//@formatter:off
				add(new Cell(x-1, y-1)); add(new Cell(x  , y-1)); add(new Cell(x+1, y-1));
				add(new Cell(x-1, y  ));                          add(new Cell(x+1, y  ));
				add(new Cell(x-1, y+1)); add(new Cell(x  , y+1)); add(new Cell(x+1, y+1));
				//@formatter:on
			}
		};
	}

}
