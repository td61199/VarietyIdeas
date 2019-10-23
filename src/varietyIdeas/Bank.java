package varietyIdeas;

/*
Tahj Dosso, Independent Project
*/
import java.util.*;


/*
This bank contains a collection of patrons
 */
public class Bank {
    private ArrayList<Patron> patronList;
    private double vault;
    /*
Constructs a bank with no bank accounts
     */
    public Bank(double vault) {
	this.vault = vault;
	patronList = new ArrayList<Patron>();	
    }
    /**
       Adds a patron to the bank
       @param newPatron to add
     */
    
    public void addPatron(Patron newPatron)   {
	if(newPatron.getAge() < 13) 
	    System.out.println("You are to young to join this bank, " +newPatron.getFullName()+ ".");
	else
	   patronList.add(newPatron); // calls the "add" method of ArrayList, and adds a new patron

    }
    public double getVault() {
	return vault;// returns vault balance
    }
    
    public void removePatron(Patron patron) {
	patronList.remove(patronList.indexOf(patron)); // calls the "remove" method of the ArrayList class
    }

    /**
       Prints the entire list of patrons
     */
    
    public void printList() {
	for(int i=0; i < patronList.size(); i++) {
	    Patron save = patronList.get(i);
	    save.printInfo();
	}

    }
    public void addTOvault(double increase) {
	vault = vault + increase; // Increases vault total by passed-in parameter
	
    }
    public void payBank(Patron patron, double amt) {
	double pay = patron.withdrawal(amt);
	addTOvault(pay);
    }
	/**
	   Adds the sum of all the patrons balance
	 */
    public void totalPatronBal() {
	double sum = 0;
	for(int index = 0; index < patronList.size(); index++) {
	    Patron current = patronList.get(index);
	    sum = sum + current.getBalance();
	}
	System.out.println("The total Patron balance is " +sum);
       
    }
    
    public void getTotalBal() {
	double sum = 0;
	for(int index = 0; index < patronList.size(); index++) {
	    Patron current = patronList.get(index);
	    sum = sum + current.getBalance();
	}
	System.out.println("Tha Banks total balance is " +(sum + getVault()));
    }
    /**
       Checks all patron's balance and compare them to the value of atleast
       @param "atleast" balance to compare
     */
    
    public void check(double atleast) {
	int matches = 0;
	for(int index = 0; index < patronList.size(); index++) {
	    Patron current = patronList.get(index);
	    if(current.getBalance() >= atleast) {
		matches++;
		current.printInfo();
	    }

	}
	if(matches == 0)
	    System.out.println("No Patron has a high enough balance.");
    }

    public void returnIndex(Patron patron) {
	System.out.println("The index of "+patron.getFullName()+ " is " + patronList.indexOf(patron));
	//prints out index of passed name
	// @param patron 
	
    }

    public void vaultBalance() {
	System.out.println("The Vault's current balance is " +getVault());
    }


    public static void main(String [] args) {
	Bank b1 = new Bank(5000000);
	Patron p1 = new Patron("Jacob", "Luis" ,11 , 76345.56);
	Patron p2 = new Patron("Riley" , "James",23, 7622.87);
	Patron p3 = new Patron("Tahj" , "Dosso",19, 89939.32);
	Patron p4 = new Patron("Yaya" , "Loa",190, 820382.34);
	Patron p5 = new Patron("Marie" , "Ela",92, 459743.34);
	Patron p6 = new Patron("Kyra" , "Martin",23, 1500.50);
	b1.addPatron(p1);
	b1.addPatron(p2);
	b1.addPatron(p3);
	b1.addPatron(p4);
	b1.addPatron(p5);
	b1.addPatron(p6);
	b1.printList();
	b1.getTotalBal();
	b1.totalPatronBal();
			  
    }
}
