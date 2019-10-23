package varietyIdeas;

import java.util.*;



/*
 * Commercial plane class extends plane class
 * has an arraylist for buyers and a 2d array fpr tickets
 * 
 * @author Tahj Dosso
 * @since 5/19/19
 * @acknowledgements Brian Howard
 * */
public class CommercialPlane extends Plane {
	private int flightNumber;
	// private Seat[][] planeSeats;
	private Ticket[][] tickets;
	private double costPerSeat;
	private static ArrayList<Patron> buyers = new ArrayList<Patron>(50);
	// private int topSpeedinMPH;
	// private int row;
	// private int col;
	/*
	 * constant that is used when conditions aren't met in constructor
	 */
	final static double DEFAULT_COST = 250.00;

	/*
	 * 
	 * Calls the constructor from parent class, and has extra lines for filling the
	 * cost field
	 */
	public CommercialPlane() {
		super();
		this.tickets = new Ticket[row][col];
		createAllTickets();

		System.out.println("How much does each seat cost?");
		double preCost = s.nextDouble();
		if (preCost > DEFAULT_COST) {
			System.out.println("This selected cost is too high. Setting to default price. ($250.00)");
			this.costPerSeat = DEFAULT_COST;
		} else
			this.costPerSeat = preCost;
		Random r = new Random();
		this.flightNumber = r.nextInt(101) + 10000;
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
	 * returns flight number
	 * 
	 * @return int
	 */
	public int getFlightNumber() {
		return flightNumber;
	}

	/*
	 * returns cost per set
	 * 
	 * @return double
	 */
	public double getCostPerSeat() {
		return costPerSeat;
	}

	/*
	 * changes the cost per set, by setting value to "newCost
	 */
	public void changeCostPerSeat(int newCost) {
		this.costPerSeat = newCost;
	}

	/*
	 * creates all the tickets in respect to the product of the rows and col
	 * 
	 */
	public void createAllTickets() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				tickets[r][c] = new Ticket("", 1, 1, 2019, 0, 0);
			}
		}

	}

	/*
	 * sells seat to patron that is passed. Checks for seat availability and
	 * compares to the seat that the patron selects. Withdraws the cost per seat
	 * from the patrons balance. Changes selected seat to an "X" and corresponding
	 * ticket to an "S"
	 * 
	 * @param p, an object of the patron class
	 */
	public void sellSeat(Patron p) {
		this.printSeatGrid();
		System.out.println("What seat would you like, " + p.getFirstName() + " ?");
		System.out.println("There are " + (row) + " row's " + "and " + (col) + " column's to choose from.");
		System.out.println("Enter a preferred row number and column number");
		int selectedRow = s.nextInt() - 1;
		while (selectedRow >= planeSeats.length) {
			System.out.println("This row isn't in the plane. Pick again.");
			int newSelectedRow = s.nextInt() - 1;
			selectedRow = newSelectedRow;
		}
		int selectedCol = s.nextInt() - 1;

		while (selectedCol >= planeSeats[selectedRow].length) {
			System.out.println("This column isn't in the plane. Pick again.");
			int newSelectedCol = s.nextInt() - 1;
			selectedCol = newSelectedCol;
		}
		Seat selectedSeat = planeSeats[selectedRow][selectedCol];
		while (selectedSeat.getOccupy() != false) {
			System.out.println("This seat is unavailable. Select a row and column again.");
			selectedRow = s.nextInt() - 1;
			while (selectedRow >= planeSeats.length) {
				System.out.println("This row isn't in the plane. Pick again.");
				int newSelectedRow = s.nextInt() - 1;
			}
			selectedCol = s.nextInt() - 1;
			while (selectedCol >= planeSeats[selectedRow].length) {
				System.out.println("This column isn't in the plane. Pick again.");
				int newSelectedCol = s.nextInt() - 1;
				selectedCol = newSelectedCol;
			}
			selectedSeat = planeSeats[selectedRow][selectedCol];
		}
		if (p.getBalance() < costPerSeat)
			System.out.println("You don't have enough to buy a ticket. Excuse this inconvience.");

		else {
			p.subtractBalance(costPerSeat);
			selectedSeat.occupySeat();
			tickets[selectedRow][selectedCol].sellTicket();
			tickets[selectedRow][selectedCol].setTicketHolderName(p.getFirstName());
		}

		System.out.println("Your balance " + p.getFirstName() + " is " + p.getBalance());
	}

	/*
	 * prints a grid of all the seats in the plane object
	 * 
	 */
	public void printSeatGrid() {
		System.out.println("[Plane Seating]");
		int seatNumberX = 1;
		int seatNumberY = 1;
		for (int c = 0; c < col; c++) {
			System.out.print("  " + seatNumberY);
			seatNumberY++;
		}
		for (int r = 0; r < row; r++) {
			System.out.println("\n" + (seatNumberX) + Arrays.toString(planeSeats[r]));
			// result = result + "\n" + (seatNumberX)+ Arrays.toString(planeSeats[r]);
			seatNumberX++;
		}
		for (int i = 0; i < col; i++) {
			System.out.print("  *");
		}
		System.out.println();
	}

	/*
	 * prints a grid of the tickets that correspond to the seats
	 */
	public void printTicketGrid() {
		System.out.println("[Tickets]");
		int ticketX = 1;
		int ticketY = 1;
		for (int r = 0; r < tickets.length; r++) {
			System.out.println("\n" + (ticketX) + Arrays.deepToString(tickets[r]));
			ticketX++;
		}
		for (int i = 0; i < col; i++) {
			System.out.print("  *");
		}
		System.out.println();
	}

	/*
	 * Adds a patron to the buyer list
	 * 
	 * @param p
	 */
	public void add2BuyerList(Patron p) {
		buyers.add(p);
	}

	/*
	 * Removes a patron from the buyer list
	 * 
	 * @param p
	 */
	public void removeBuyers(Patron p) {
		buyers.remove(buyers.indexOf(p));
	}

	/*
	 * loops through all the buyers in the list and prompts them to buy a ticket
	 * 
	 * @param b, a list of patrons
	 */
	public void sell2Buyers(ArrayList<Patron> b) {
		for (int run = 0; run < b.size(); run++) {
			Patron currentBuyer = (Patron) b.get(run);
			sellSeat(currentBuyer);
		}
	}

	/*
	 * Tells the total number of seats available for called-upin flight
	 */
	public void seatStatus() {
		printSeatGrid();
		int openSeats = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (planeSeats[r][c].toString() == "-")
					openSeats++;
			}
		}
		if (openSeats == 0)
			System.out.println("This flight is booked.");
		else
			System.out.println("There are " + openSeats + " seat(s) available.");
	}

	/*
	 * Prints out all of the flight information
	 */
	public void printFlightInfo() {
		System.out.println("********************");
		System.out.println("FLIGHT NUMBER : " + getFlightNumber());
		System.out.println("DATE OF DEPARTURE : " + tickets[row - 1][col - 1].getMonth() + "/"
				+ tickets[row - 1][col - 1].getDay() + "/" + tickets[row - 1][col - 1].getYear());
		System.out.println("TIME OF DEPARTURE : " + tickets[row - 1][col - 1].getTimeH() + ":"
				+ tickets[row - 1][col - 1].getTimeM());
		System.out.println("********************");
		System.out.println();
	}

	/*
	 * sets the planes flight info to all the fields that are passed, given if they
	 * respect the conditions
	 * 
	 * @param month
	 * 
	 * @param day
	 * 
	 * @param year
	 * 
	 * @param hour
	 * 
	 * @param minute *
	 */
	public void UpdateFlightInfo(int month, int day, int year, int hour, int minute) {
		System.out.println("Do you wish to update this flight's info? Enter y or n.");
		String res = s.next();
		String pl = s.nextLine();
		while (!(res.equalsIgnoreCase("Y") || res.equalsIgnoreCase("N"))) {
			System.out.println("Not a valid response. Enter again.");
			res = s.nextLine();
		}

		if (res.equalsIgnoreCase("N"))
			System.out.println("Okay. Have a good day. :)");
		else {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					tickets[r][c].setMonth(month);
					tickets[r][c].setDay(day);
					tickets[r][c].setYear(year);
					tickets[r][c].setHour(hour);
					tickets[r][c].setMinute(minute);
				}

			}
			System.out.println("*******Flight Information has been updated*******");
		}
		System.out.println();
		/*
		 * Passes the patron and asks if they want to return their ticket. if "y", then
		 * the ticket is returned and the cost per seat is deposited back to their
		 * balance.
		 * 
		 * @param p
		 */
	}

	public void returnTicket(Patron p) {
		int returnedRow = 0;
		int returnedCol = 0;
		checkLoop: for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				while (tickets[r][c].getTicketHolder() == p.getFirstName()) {
					returnedRow = r;
					returnedCol = c;
					break checkLoop;
				}
			}
		}
		System.out.println("Do you want to return your ticket. Enter y or n.");
		String res = s.next();
		String pl = s.nextLine();
		while (!(res.equalsIgnoreCase("Y") || res.equalsIgnoreCase("N"))) {
			System.out.println("Not a valid response. Enter again.");
			res = s.nextLine();
		}

		if (res.equalsIgnoreCase("N"))
			System.out.println("Glad you are still travelling with us. :)");
		else {
			p.deposit(costPerSeat);
			tickets[returnedRow][returnedCol].recallTicket();
			planeSeats[returnedRow][returnedCol].unOccupySeat();
			System.out.println("Thank you for considering flying with us. We wish you the best.");
		}
		System.out.println();
	}

	/*
	 * sets all tickets to unsold and all seats to unoccupied, returns all money to
	 * patrons balance
	 */
	public void clearFlight() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (planeSeats[r][c].getOccupy() == true)
					planeSeats[r][c].unOccupySeat();
				tickets[r][c].recallTicket();
				tickets[r][c].setTicketHolderName("");
				tickets[r][c].setMonth(1);
				tickets[r][c].setDay(1);
				tickets[r][c].setYear(2019);
				tickets[r][c].setHour(1);
				tickets[r][c].setMinute(1);
			}

		}
		for (int i = 0; i < buyers.size(); i++) {
			buyers.get(i).deposit(costPerSeat);
		}

		System.out.println("ALL SEATS HAVE BEEN EMPTIED, ALL TICKETS RECALLED.");
		System.out.println();
		printSeatGrid();
		System.out.println();

	}
	/*
	 * This method checks every seat and sees if plane is empty, 
	 * at first occupied seat, returns false.
	 * Else will return false
	 * @return boolean
	 * */

	public boolean isPlaneEmpty() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (tickets[r][c].toString() == "S")
					return false;
			}
		}
		return true;
	}
	/*
	 * This method prints out all seat occupants,
	 * if seat is empty, takes not and prints out "Seat "num" is unoccupied
	 * Else prints out who is at what seat.
	 * */
	public void planeOccupants() {
		int occupyNum = 0;
		if (isPlaneEmpty() == true)
			System.out.println("Plane is empty. NO CURRENT BUYERS");
		else {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					occupyNum++;
					if (planeSeats[r][c].getOccupy() == false) {
						System.out.println("******************");
						System.out.println("Seat " + occupyNum + " is unoccupied.");
						System.out.println("******************");
						System.out.println();
					} else {
						System.out.println(tickets[r][c].getTicketHolder() + " is in Seat " + occupyNum + ". ");
						System.out.println();
					}

				}

			}

		}
		seatStatus();
	}
/*
 * This method takes two patrons and sees if they are on the buyers list.
 * If one or both are not on the list, no exchange is allowed. Else, they switch
 * @param p1
 * @param p2
 * */
	public void exchangeSeat(Patron p1, Patron p2) {
		String save1 = null;
		String save2 = null;
		int save1ValR = 0;
		int save1ValC = 0;
		int save2ValR = 0;
		int save2ValC = 0;
		if (isPlaneEmpty() == true)
			System.out.println("Plane is empty. NO EXCHANGE");
		else {
			for( int r = 0; r < row; r++) {
				for(int c = 0; c < col; c++) {
				if(p1.getFirstName() == tickets[r][c].getTicketHolder()) {
					save1 = p1.getFirstName();
					save1ValR = r;
					save1ValC = c;
					
				}
				else if(p2.getFirstName() == tickets[r][c].getTicketHolder()) {
					save2 = p2.getFirstName();
					save2ValR = r;
					save2ValC = c;
				}
				
			}
			
		}
		if(save1 == null || save2 == null)
			System.out.println("Exchange is not allowed. One or both of you doesn't have a ticket.");
		else {
			tickets[save1ValR][save1ValC].setTicketHolderName(p2.getFirstName());
			tickets[save2ValR][save2ValC].setTicketHolderName(p1.getFirstName());
			System.out.println("Seats have been switched.");
			}
		}
	}
	
	public static void main(String[] args) {
		Patron p = new Patron("Taco" , "Bell", 45, 3454.00);
		Patron r = new Patron("Luis", "Vuitton", 34, 899.00);
		Patron Rico = new Patron("Rico", "Savage",  23, 3343.56);
		Patron Rachel = new Patron("Rachel" , "Ray", 21, 24354.45);
		Patron Jacob = new Patron("Jacob","Correa", 19, 10000.00);
		Patron Rob = new Patron("Rob","Lowe", 23, 90000.00);
		Patron Zoe = new Patron("Zoe","Grant", 34, 900012.00);
		Patron Diana = new Patron("Diana","Dosso", 15, 89723.00);
		Patron BK = new Patron("Andrew" ,"Smith", 31, 56000.00);
		CommercialPlane Boeing = new CommercialPlane();
		Boeing.add2BuyerList(p);
		Boeing.add2BuyerList(Diana);
		Boeing.add2BuyerList(Zoe);
		Boeing.add2BuyerList(Rob);
		Boeing.add2BuyerList(Jacob);
		Boeing.add2BuyerList(BK);
		Boeing.add2BuyerList(Rachel);
		Boeing.add2BuyerList(Rico);
		//Boeing.add2BuyerList(r);
		Boeing.sell2Buyers(buyers);
		Boeing.planeOccupants();
		//Boeing.exchangeSeat(Rachel, p);
		//Boeing.planeOccupants();
		//Boeing.UpdateFlightInfo(12, 6, 2019, 12, 30);
		// Boeing.printFlightInfo();
		// Boeing.seatStatus();
		// Boeing.clearFlight();
		//Boeing.printSeatGrid();
		// Boeing.printTicketGrid();
	}

}
