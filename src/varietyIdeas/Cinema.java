/**
 * 
 */
package varietyIdeas;
import java.util.*;

/**
 * @author tahjdosso
 *
 */
public class Cinema {
	private String cinemaName;
	private static ArrayList <Film> nowPlaying;
	private int numberOFtheatres;
	private int seatsPERtheatre;
	private int totalCap;  
	/*
	 * The total cap is determined by multiplying numberOFtheatres
	 * to spacePERtheatre.
	 */
	 public Cinema(String cinemaName, int numberOFtheatres, int seatsPERtheatre) {
		 this.cinemaName = cinemaName;
		 this.numberOFtheatres = numberOFtheatres;
		 this.seatsPERtheatre = seatsPERtheatre;
		 this.totalCap = seatsPERtheatre * numberOFtheatres;
		 this.nowPlaying = new ArrayList<Film>(10);
	 }
	 public String getCinemaName() {
		 return cinemaName;
	 }
	 public int getNumberOFtheatres() {
		 return numberOFtheatres;
	 }
	 public int getSeatsPERtheatre() {
		 return seatsPERtheatre;
	 }
	 public int getTotalCap() {
		 return totalCap;
	 }
	 public void addFilm(Film f) {
		 nowPlaying.add(f);
	 }
	 public void removeFilm(Film f) {
		 nowPlaying.remove(nowPlaying.indexOf(f));
	 }
	 public void checkFilmInfo(Film f) {
		 f.movieDescription();
	 }
	 public void printNowPlaying() {
		 for(int index = 0; index < nowPlaying.size(); index++) {
			 Film current = nowPlaying.get(index);
			 checkFilmInfo(current);
		 }
	 }
	 public int generateTicket() {
		 Random r = new Random();
		 int pass = getSeatsPERtheatre();
		 int rand = r.nextInt(pass);
		 System.out.println("Your ticket is " +rand+ ". Enjoy the film!");
		 return rand;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cinema c1 = new Cinema("Bana Cinema", 5, 50);
		Film film1 = new Film("Cast Away", 1989, "Action", 120, "A movie about a castaway");
		Film film2 = new Film("Spider Man", 2001, "Action", 132, "A movie about a Spider Man");
		Film film3 = new Film("African Queen", 1993, "Suspense", 128, "A movie about an African Queen");
		Film Friday = new Film("Friday", 1995, "Drama/Comdey", 97 , "A movie on Friday");
		c1.addFilm(Friday);
		c1.addFilm(film1);
		c1.addFilm(film2);
		c1.addFilm(film3);
		c1.printNowPlaying();
		c1.generateTicket();
	}

}
