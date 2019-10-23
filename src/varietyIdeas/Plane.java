package varietyIdeas;

import java.util.*;

/*
 * Plane class is abstract and it's primary goal is to extend to
 * CommercialPlane.
 * 
 * 
 * @author Tahj Dosso
 * @since 5/19/19
 * @acknowledgements Brian Howard
 * */
public abstract class Plane {
	protected Seat[][] planeSeats;
	protected int topSpeedinMPH;
	protected int row;
	protected int col;
	protected Scanner s = new Scanner(System.in);
	/*
	 * These constants serve as defaults, if the condtions aren't met these
	 * constants will be used
	 */
	protected final static int DEFAULT_SPEED = 561;
	protected final static int DEFAULT_ROWS = 5;
	protected final static int DEFAULT_COLS = 10;

	/*
	 * Creates a new plane object with user input to fill the fields of the class
	 * 
	 */
	public Plane() {
		Scanner s = new Scanner(System.in);
		System.out.println("What is this planes top speed?");
		int preSpeed = getInteger(s);
		if (preSpeed > DEFAULT_SPEED) {
			System.out.println("This planes spped is too fast. Setting to default speed. (561 MPH)");
			this.topSpeedinMPH = DEFAULT_SPEED;
		} else
			this.topSpeedinMPH = preSpeed;

		System.out.println("How many rows are in your plane?");
		int preRow = getInteger(s);

		if (preRow > DEFAULT_ROWS) {
			System.out.println("The selection of rows is too high. Seting to default. (Four rows)");
			this.row = DEFAULT_ROWS;
		} else
			this.row = getInteger(s);

		System.out.println("How many seats back (columnns) are there?");
		int preCol = getInteger(s);
		if (preCol > DEFAULT_COLS) {
			System.out.println("The selection of columns is too high. Setting to default. (10 columns)");
			this.col = DEFAULT_COLS;
		} else
			this.col = preCol;
		this.planeSeats = new Seat[row][col];
		createSeat();
	}

	/*
	 * This method makes sure that a users input is an int, if not will send user to
	 * enter a value again
	 * 
	 * @param s, the only parameter and is an object of Scanner class
	 */
	public static int getInteger(Scanner s) {
		while (true) {
			try {
				return Integer.parseInt(s.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid integer");
			}
		}
	}

	/*
	 * createSeat creates all seat objects for the corresponding seat array
	 * 
	 */
	protected void createSeat() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				planeSeats[r][c] = new Seat();
			}
		}
	}

	/*
	 * returns topSpeedinMPH
	 * 
	 * @return int
	 */
	protected int getTopSpeedinMPH() {
		return topSpeedinMPH;
	}

	/*
	 * returns row
	 * 
	 * @return int
	 */
	protected int getRow() {
		return row;
	}

	/*
	 * returns col
	 * 
	 * @return col
	 */
	protected int getCol() {
		return col;
	}

}
