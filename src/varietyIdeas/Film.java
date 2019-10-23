package varietyIdeas;
/**
 * 
 */

/**
 * @author tahjdosso
 *
 */
public class Film {
	private String title;
	private int year;
	private String genre;
	private int runTimeinMin;
	private String summary;

	public Film(String title, int year, String genre, int runTimeinMin, String summary) {
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.runTimeinMin = runTimeinMin;
		this.summary = summary;
	}
	
	public String getTitle() {
		return title;
		}
	public int getYear() {
		return year;
	}
	public String getGenre() {
		return genre;
	}
	public int getRunTime() {
		return runTimeinMin;
	}
	public String getSummary() {
		return summary;
	}
	public void movieDescription() {
		System.out.println("----------------------");
		System.out.println("Movie Title: " +getTitle());
		System.out.println("Genre Type: " +getGenre());
		System.out.println("Total Runtime: " +getRunTime());
		System.out.println();
		System.out.println("Summary");
		System.out.println(getSummary());	
		System.out.println("----------------------");
		System.out.println("**********************");

	}
	public static void main(String [] args) {
		Film film1 = new Film("Cast Away", 1989, "Action", 120, "A movie about a castaway");
		film1.movieDescription();
		
	}
	}
	
	
	
	
	
	
	
		

