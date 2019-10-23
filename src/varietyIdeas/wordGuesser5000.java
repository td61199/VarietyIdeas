package varietyIdeas;

import java.util.Arrays;
import java.util.Scanner;

public class wordGuesser5000 {
	public boolean[] letters; // represents the letter graveyard. 0 - a, 1 - b, & so on
	public boolean[] gletters; // represents correctly guessed letters 
	private String selectedWord;
	Scanner s = new Scanner(System.in);
	public int tries; // how many guesses is set
	public int sel; //this is the number of correctly guessed letters

	wordGuesser5000(int tries) {
		this.tries = tries;
		this.letters = new boolean[26];
		this.gletters = new boolean[26];
		Arrays.fill(letters, false); // sets every index to false
		System.out.println("Enter selected word");
		this.selectedWord = s.next();
		for(int i = 0 ; i < 1000; i ++) {
			System.out.println("///////////////////");
			System.out.println("8888888888888888888");
			
		}
		run: for( int i = tries ; i >= 0; i--) {
			System.out.println("Guesses Remaining = " +i);
			printWord();
			System.out.println("Guess a letter");
			char a = s.next().charAt(0);
			makeGuess(a);
			printWord();
			System.out.println();
			guessWord();
			printGraveyard();
			if(sel == selectedWord.length()) {
				int go = tries - i; //how many guesses were needed
				System.out.println("Good Game! ");
				System.out.println("You have correctly guessed the word");
				break run;
			}
			if(i == 0) {
				System.out.println("Good Game, Try Again ");
				break run;
			}
			System.out.println("********************");
			
		}
		
	}

	public void printWord() { 
		
		for (int i = 0; i < selectedWord.length(); i++) {
				char checkRun = Character.toLowerCase(selectedWord.charAt(i));
				int ascii = (int) checkRun;
				int alphaRun = ascii - 97;
			if(gletters[alphaRun] == true ) {
				
				System.out.print(selectedWord.charAt(i) + " ");
			}
			else 
				System.out.print("_ ");
		}
	}

	public void makeGuess(char a) {
		char aRun = Character.toLowerCase(a); // aRun is the variable that is the lowercase version of char a
		int ascii = (int) aRun; // get ascii val of a
		int alpha = ascii - 97; // this is the index comparison of the ascii val
		if (letters[alpha] == true)
			System.out.println("This letter has been guessed already");
		else {
			
			letters[alpha] = true;
			for(int i = 0; i < selectedWord.length();i++) {
				int test = (int)Character.toLowerCase(selectedWord.charAt(i)); //tests a character in the selected word
				if(ascii != test) {
					continue;
				}
				else {
					sel++;
					gletters[alpha] = true;
					
				}
				
			}
			
			
		}

	}
	public void guessWord() {
		System.out.println("Would you like to guess the word?");
		System.out.println("[1] -> Yes");
		System.out.println("[2] -> No");
		int rep = s.nextInt();
		while(rep != 1 && rep != 2) {
			System.out.println("That isn't a valid answer. Enter again");
			rep = s.nextInt();
		}
		if(rep == 1) {
			System.out.println("Enter your guess ");
			String guess = s.next();
			if( guess.toLowerCase().equals(selectedWord) ) {
				//System.out.println("Good Game! You have correctly guessed the word");
				sel = selectedWord.length();
			}
			else {
				System.out.println("That isn't the word");
				tries--;
			}
		}
		
		System.out.println("********************");

	}
	public void printGraveyard() {
		System.out.print("Graveyard -> ");
		for(int i = 0; i < letters.length; i++) {
			if(letters[i] == true) {
				int ascii = i + 97;
				char x = (char) ascii;
				System.out.print(x + ", ");
			}
			else
				continue;
		}
		System.out.println();
	}

	
	public static void main (String [] args) {
		wordGuesser5000 g1 = new wordGuesser5000(12); 
	}
	
	
}
