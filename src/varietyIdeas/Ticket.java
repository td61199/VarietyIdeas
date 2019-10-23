package varietyIdeas;

import java.text.SimpleDateFormat;
import java.util.*;

/*
 * Ticket class holds users name and all Calendar information.
 * Serves as ticket system for CommercialPlane system.
 * 
 * @author Tahj Dosso
 * @since 5/19/19
 * @acknowledgements Brian Howard
 * */
public class Ticket {
	private String ticketHolder;
	private Calendar departureDate; // in mmdy format
	Calendar date = new GregorianCalendar(2019, Calendar.JANUARY, 1);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd");
	private String printDate;
	private String name;
	private int month;
	private int day;
	private int year;
	private int timeH;
	private int timeM;
	private boolean sold = false;

	// System.out.println(date);

	Scanner s = new Scanner(System.in);

	/*
	 * Interactive constructor that asks user to input all information that is
	 * asked. This information will be set to the fields of this class.
	 */

	public Ticket() {
		/*
		 * This asks a user for a name, saves as String
		 */
		System.out.println("What is the name of this ticket holder?");
		System.out.println();
		String name = s.next();
		this.ticketHolder = name;
		/*
		 * Asks a user for date. A month of 1-12 and day of 1-31, respectively
		 */
		System.out.println("What is your departure date?");
		System.out.println("The format is MMDY.");
		System.out.println("First value month. Second value day.");
		int month = getInteger(s);
		month = month - 1;
		int day = getInteger(s);
		date.set(Calendar.MONTH, month);
		date.set(Calendar.DATE, day);
		/*
		 * Asks user for time input, 24 hour clock
		 */
		System.out.println("What is your departure time?");
		System.out.println("The format is a 24 hour clock. ");
		System.out.println("First value Hour. Second value minute");
		int timeH = getInteger(s);
		int timeM = getInteger(s);
		this.timeH = timeH;
		this.timeM = timeM;

		date.set(Calendar.HOUR_OF_DAY, timeH);
		date.set(Calendar.MINUTE, timeM);

		// asks user to input the year
		System.out.println("What is the year?");
		int year = getInteger(s);
		date.set(Calendar.YEAR, year);

		this.departureDate = date;
		this.printDate = sdf.format(date.getTime());
		// System.out.println(printDate);
		// System.out.println("the time is " +timeH +":" +timeM);

	}

	/*
	 * This is a second constructor that allows user to pass information, instead of
	 * the use of Scanner class.
	 */
	public Ticket(String name, int month, int day, int year, int timeH, int timeM) {
		this.name = name;
		this.month = month - 1;
		this.day = day;
		this.year = year;
		this.timeM = timeM;
		this.timeH = timeH;
		date.set(Calendar.MONTH, this.month);
		date.set(Calendar.DATE, this.day);
		date.set(Calendar.YEAR, this.year);
		date.set(Calendar.HOUR_OF_DAY, this.timeH);
		date.set(Calendar.MINUTE, this.timeM);
		this.printDate = sdf.format(date.getTime());
		// System.out.println(printDate);
		// System.out.println("the time is " +timeH +":" +timeM);

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
	 * Sets ticket sold field to true
	 */
	public void sellTicket() {
		this.sold = true;
	}

	/*
	 * Sets ticket sold field to false
	 */
	public void recallTicket() {
		this.sold = false;
	}

	/*
	 * Checks if ticket is sold and prints out corresponding statement.
	 */
	public void isTicketSold() {
		if (this.sold == false)
			System.out.println("This ticket isn't sold.");
		else
			System.out.println("This ticket is sold.");
	}
	/*
	 * returns if ticket is sold or not return boolean, sold
	 */

	public boolean returnTicket() {
		return sold;
	}
	/*
	 * returns ticket holder if no name is present prompt user to enter their
	 * desired name
	 */

	public String getTicketHolder() {
		if (ticketHolder == "") {
			System.out.println("Enter your desired name.");
			String name = s.nextLine();
			this.setTicketHolderName(name);
			return ticketHolder;
		}

		else
			return ticketHolder;
	}

	/*
	 * Sets ticketHolder to passed variable name
	 * 
	 * @param name
	 */
	public void setTicketHolderName(String name) {
		this.ticketHolder = name;
	}

	/*
	 * returns the month
	 * 
	 * @return int
	 */
	public int getMonth() {
		return month;
	}
	/*
	 * Sets month to what ever value m is, if it passes condition.
	 * 
	 * @param m
	 */

	public void setMonth(int m) {
		while (m > 12 || m < 0) {
			System.out.println("This isn't a valid month. Enter again.");
			int newMonth = s.nextInt();
			m = newMonth;
		}
		this.month = m;
	}

	/*
	 * returns year
	 * 
	 * @treturn int
	 */
	public int getYear() {
		return year;
	}

	/*
	 * Sets year to passed value of y, if it passes condition.
	 * 
	 * @param y
	 */
	public void setYear(int y) {
		while (y < 2019 || y > 2040) {
			System.out.println("This isn't a valid year. Enter again.");
			int newYear = s.nextInt();
			y = newYear;
		}
		this.year = y;
	}

	/*
	 * return day
	 * 
	 * @return int
	 */
	public int getDay() {
		return day;
	}

	/*
	 * sets day value to d, if it passes the condition.
	 * 
	 * @param d
	 */
	public void setDay(int d) {
		while (d > 31 || d < 1) {
			System.out.println("This isn't a valid day. Enter again.");
			int newDay = s.nextInt();
			d = newDay;
		}
		this.day = d;

	}

	/*
	 * returns timeM, minute
	 * 
	 * @return int
	 */
	public int getTimeM() {
		return timeM;
	}

	/*
	 * set timeM to value m, if it passes the condition
	 * 
	 * @param m
	 */
	public void setMinute(int m) {
		while (m < 0 || m > 59) {
			System.out.println("This isn't a valid minute. Enter again.");
			int newMinute = s.nextInt();
			m = newMinute;
		}
		this.timeM = m;

	}

	/*
	 * returns timeH, hour
	 * 
	 * @return boolean
	 */
	public int getTimeH() {
		return timeH;
	}

	/*
	 * set hour to passed value h, if it passes the condition
	 * 
	 * @param h
	 */
	public void setHour(int h) {
		while (h < 0 || h > 24) {
			System.out.println("This isn't a valid hour. Enter again.");
			int newHour = s.nextInt();
			h = newHour;
		}
		this.timeH = h;

	}

	/*
	 * prints timeH and timeM in a clock format. (ex -> 03:20)
	 */
	public void printTime() {
		System.out.println(" " + getTimeH() + ":" + getTimeM() + " ");
	}

	/*
	 * prints a whole version of the departure date
	 */
	public void getDepartureDate() {
		printTime();
		System.out.println(printDate);
	}

	/*
	 * returns "S" if sold is true returns "-" if sold is false
	 * 
	 * @return String
	 */
	public String toString() {
		if (sold)
			return "S";
		else
			return "-";

	}

	/*
	 * main to check above methods
	 */
	public static void main(String[] args) {
		Ticket T = new Ticket();
		Ticket P = new Ticket("Tahj", 5, 23, 2019, 6, 30);
		T.getDepartureDate();
		System.out.println();
		P.getDepartureDate();
	}

}
