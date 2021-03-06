import java.util.Arrays;
import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
	private World testObject;

	@Before
	public void setup() {
		testObject = new World();
	}

	@Test
	public void cellWithZeroNeighborsDies() {
		testObject.add(new Cell(10, 20));

		World next = testObject.getNext();

		Assert.assertFalse(next.contains(new Cell(10, 20)));
	}

	@Test
	public void cellWithOneNeighborDies() {
		testObject.add(new Cell(10, 20));
		testObject.add(new Cell(11, 20));

		World next = testObject.getNext();

		Assert.assertFalse(next.contains(new Cell(10, 20)));
	}

	@Test
	public void cellWithTwoNeighborsLives() {
		testObject.add(new Cell(10, 20));
		testObject.add(new Cell(11, 20));
		testObject.add(new Cell(9, 20));

		World next = testObject.getNext();

		Assert.assertTrue(next.contains(new Cell(10, 20)));
	}

	@Test
	public void cellWithThreeNeighborsLives() {
		testObject.add(new Cell(10, 20));
		testObject.add(new Cell(11, 20));
		testObject.add(new Cell(9, 20));
		testObject.add(new Cell(11, 21));

		World next = testObject.getNext();

		Assert.assertTrue(next.contains(new Cell(10, 20)));
	}

	@Test
	public void cellWithFourNeighborsDies() {
		testObject.add(new Cell(10, 20));
		testObject.add(new Cell(11, 20));
		testObject.add(new Cell(9, 20));
		testObject.add(new Cell(11, 21));
		testObject.add(new Cell(9, 21));

		World next = testObject.getNext();

		Assert.assertFalse(next.contains(new Cell(10, 20)));
	}

	@Test
	public void cellWithFiveNeighborsDies() {
		testObject.add(new Cell(10, 20));
		testObject.add(new Cell(11, 20));
		testObject.add(new Cell(9, 20));
		testObject.add(new Cell(11, 21));
		testObject.add(new Cell(9, 21));
		testObject.add(new Cell(10, 19));

		World next = testObject.getNext();

		Assert.assertFalse(next.contains(new Cell(10, 20)));
	}

	@Test
	public void cellWithThreeNeighborsSpawns() {
		testObject.add(new Cell(11, 20));
		testObject.add(new Cell(9, 20));
		testObject.add(new Cell(11, 21));

		World next = testObject.getNext();

		Assert.assertTrue(next.contains(new Cell(10, 20)));
	}

	@Test
	public void integrationTest() {
		testObject.add(new Cell(0, 0));
		testObject.add(new Cell(1, 1));
		testObject.add(new Cell(0, 2));

		World next = testObject.getNext();

		Assert.assertEquals(
				new HashSet<Cell>(Arrays.asList(new Cell(0, 1), new Cell(1, 1))),
				next);
	}
}
