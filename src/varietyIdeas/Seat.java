package varietyIdeas;
/*
 * Class Seat creates a seat object with one field, occupy
 * occupy is a boolean and once constructed, said field
 * is set to false
 * 
 * @author Tahj Dosso
 * @since 05/13/19
 * */

public class Seat {
	private boolean occupy;

	// creates a seat object and set occupy to false
	public Seat() {
		this.occupy = false;
	}

	/*
	 * Checks if occupy is true or false. If false, set to true if true, print
	 * "This seat is occupied. Try another"
	 * 
	 */
	public void occupySeat() {
		if (occupy == true)
			System.out.println("This seat is occupied. Try another");
		else {
			occupy = true;
		}
	}

	/*
	 * returns occupy
	 * 
	 * @return boolean
	 */
	public boolean getOccupy() {
		return occupy;
	}

	/*
	 * checks if seat is occupied, if so, set occupy to false. If not, prints
	 * "This seat isn't occupied. It would be better to occupy"
	 * 
	 */
	public void unOccupySeat() {
		if (occupy == false)
			System.out.println("This seat isn't occupied. It would be better to occupy");
		else
			occupy = false;
	}

	/*
	 * checks if seat is occupied or not. If true, print "This seat is occupied." If
	 * false, print "This seat isn't occupied."
	 */
	public void isSeatOccupied() {
		if (this.occupy == false)
			System.out.println("This seat isn't occupied.");
		else
			System.out.println("This seat is occupied.");
	}

	/*
	 * toString method that retruns "-" if unoccupied and "X" if it is occupied
	 */
	@Override
	public String toString() {
		if (occupy) {
			return "X";
		} else {
			return "-";
		}
	}

	/*
	 * main that uses all previously declared methods
	 */
	public static void main(String[] args) {
		Seat seat1 = new Seat();
		seat1.occupySeat();
		seat1.occupySeat();
		seat1.isSeatOccupied();

	}

}
