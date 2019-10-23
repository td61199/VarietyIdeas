package varietyIdeas;
import java.util.*;

public class Bug {
	private int convoCt = 0;
	private Vector <String> rConvo = new Vector <String> ();
	
	
	public Bug() {}
	
	public int getConvoCt() {
		return convoCt;
	}
	
	public void readIn(String len) {
		rConvo.addElement(len);
		convoCt++;
		
	}
	public void clear() {
		rConvo.clear();
		convoCt = 0;
	}
	public void printAll() {
		for(int i = 0; i < rConvo.size(); i++)
			System.out.println(rConvo.elementAt(i));
	}
	public void print(int t) {
		if( t > rConvo.size() || t < 0)
			System.out.println("There isn't a conversation at this position");
		else
			System.out.println(rConvo.elementAt(t));
	}
	public void howMany(int selectedC) {
		//selectedC serves as the number of a conversation which is being selected
		int h = 0;
	first:	for(int i = 0; i < rConvo.size();i++) {
			if(selectedC == i) {
				h = i;
				break first;
			}
			else 
				System.out.println("This isn't a conversation number listed");
		}
	ASC:   for( int x = 0; x < rConvo.get(h).length(); x++) { //for loop to check specified cell(String)
			int ASCII = 65;
			int [] alphabet = new int[26];
			if((char) ASCII == rConvo.get(h).charAt(x))  {
											
				
				//checks if a char is equal to current ascii value
				ASCII++;
				if(ASCII > 126)
					break ASC;
			}
			else
				continue;
			
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
