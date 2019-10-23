package varietyIdeas;


/*
Tahj Dosso, Indepedent Project
 */

import java.util.*;
import java.text.DecimalFormat;

public class Patron extends Human{
    private String firstName;
    private String lastName;
    private int age;
    public double balance;
    private ArrayList<Item> backpack;
    private static DecimalFormat twoDECI = new DecimalFormat(".##");
    /*
     *Construct a Patron Object with a given name,RouteNumber,balance
     @param theName
     */

    Patron (String firstName, String lastName, int age, double balance) {
	this.firstName = firstName;
	this.lastName = lastName;
	if(age > 120)
	    this.age = 18;
	else
	    this.age = age;
	this.balance = balance;
	backpack = new ArrayList<Item>(11);
     }  
    

    public String getFirstName() {
	return firstName;
    }
    //return the first name;
    
    public String getLastName() {
    return lastName;
    }
    //return the last name
    public int getAge() {
	return age;
	//returns age
    }
    public double getBalance() {
	return balance;
    }
    //return the balance
    public void addTObackpack(Item newItem) {
	backpack.add(newItem);
	//adds a new Item to a patron's backpack
    }
    public void printBackpack() {
	for(int index = 0; index < backpack.size(); index++) {
	    System.out.println("[" +(index+1)+ "]");
	    System.out.println(" " +backpack.get(index).getItemName());
	    System.out.println("Quantity -> " +backpack.get(index).getItemCount());
	    System.out.println("*******************");
	}
    }
    public void changeBalance(double value) {
	balance = value;
    }
    public void subtractBalance(double value) {
    	balance = balance - value;
    }
    public void deposit(double value) {
	balance = balance + value;
	
    }
    public double withdrawal(double value) {
	balance = balance - value;
	return value;
    }
    public String getFullName() {
    	 return getFirstName() + " " + getLastName();
    }
    public void printInfo() {
	System.out.println("********************************");
	System.out.println("Patron's name: " +getFullName());
	System.out.println("Patron's age: " +getAge());
	System.out.println("Balance: " + twoDECI.format(getBalance()));
	System.out.println("********************************");
    }
    
    public static void main(String[] args) {
	Patron Rico = new Patron("Rico", "Suarez", 23 , 3343.56);
	Patron Rachel = new Patron("Rachel", "Jane",21, 24354.45);
	//Patron Jacob = new Patron("Jacob",19, "555862457264", 1.00);
	Item apple = new Item("Apple" ,5, "Produce");
	Item shirt = new Item("Shirt" , 4, "Clothing");
	Rico.addTObackpack(apple);
	Rico.addTObackpack(shirt);
	Rico.printBackpack();
    }


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

    
}

