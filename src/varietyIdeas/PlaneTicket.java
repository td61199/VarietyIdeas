package varietyIdeas;
import java.util.*;

public class PlaneTicket extends Ticket{
	private String ticketHolder;
	private Calendar departureDate; // in mmdy format
	Calendar date = new GregorianCalendar(2019,Calendar.JANUARY, 1);
	private String printDate;
	private String name;
	private int month;
	private int day;
	private int year;
	private int timeH;
	private int timeM;
	
	Scanner s = new Scanner(System.in);
	
		public PlaneTicket() {
			super();
		}
		
		public PlaneTicket(String name, int month, int day, int year, int timeH, int timeM) {
			super(name, month, day, year, timeH, timeM);
		}
		public String getTicketHolder() {
			if(ticketHolder == "") {
				return "No one has this ticket.";
			}
			else 
				return ticketHolder;
			}
		public void setTicketHolderName(String name) {
			this.ticketHolder = name;
		}
		public int getMonth() {
			return month;
		}
		public int getYear() {
			return year;
		}
		public int getDay() {
			return day;
		}
		public int getTimeM() {
			return timeM;
		}
		public int getTimeH() {
			return timeH;
		}
		public void printTime() {
			System.out.println(" "+getTimeH() + ":" +getTimeM()+" ");
		}
		public void getDepartureDate() {
			printTime();
			System.out.println(printDate);
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			PlaneTicket defaultT = new PlaneTicket("Tahj", 05, 23, 2019, 23, 45);
			//PlaneTicket inputT = new PlaneTicket();
			defaultT.getDepartureDate();
			//inputT.getDepartureDate();
		}
		

}
