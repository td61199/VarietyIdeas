package varietyIdeas;

import java.util.Vector;

public class Inventory {
	private Vector<Item> toryList;
	private int cap; // desired capacity for inventory
	
	public Inventory(int cap) {
		this.cap = cap;
		toryList = new Vector<Item>(cap);
	}
	public int getCap() {
		return cap; // returns cap
	}
	public void createItem(String name, int count, String type) {
	toryList.add(new Item(name, count, type));
	}
	public void printAll() {
		if(toryList.size() == 0)
			System.out.println("This inventory is empty");
		else {
		for (int i =0; i < toryList.size(); i++) {
			toryList.elementAt(i).printItemInfo();
		}
		
	}
	}
	public void printBYtype(String testType) {
		int check = 0;
		System.out.println("*************PRINTING BY TYPE -> " +testType+ " 2*****************");
		for( int i = 0; i < toryList.size(); i++) {
			if(testType == toryList.elementAt(i).getItemType()) {
				toryList.elementAt(i).printItemInfo();
				check++;
			}	
		}
		if(check == 0) {
			System.out.println("There are no items of this type in the Inventory.");
		}
		
	}
	public void clearInventory() {
		toryList.clear();
		System.out.println("******************************");
		System.out.println("The Invetory has been cleared.");
		System.out.println("******************************");
		System.out.println();
	}
	
	public void increaseItemCount(String itemName, int count) {
		int check = 0;
		for(int i = 0; i < toryList.size(); i++) {
			if(itemName == toryList.elementAt(i).getItemName()){
				toryList.get(i).addQuantity(count);
				check++;
		}
		}
	if(check == 0) 
		System.out.println("This item doesn't appear in your list.");
	}
	
	public void decreaseItemCount(String itemName, int count) {
		int check = 0;
		for(int i = 0; i < toryList.size(); i++) {
			if(itemName == toryList.elementAt(i).getItemName()) {
				toryList.get(i).subtractCount(count);
				check++;
			}
		}
	if(check == 0) 
		System.out.println("This item doesn't appear in your list.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory I = new Inventory(4);
	    I.createItem("Apple", 5, "Fruit");
		I.createItem("Pear", 3, "Fruit");
		I.createItem("Eggs", 12, "Produce");
		I.createItem("Lettuce", 3, "Vegetable");
		I.decreaseItemCount("Eggs", 1);
		I.increaseItemCount("Lettuce", 1);
		I.printAll();
		//I.printBYtype("Vegetable");
	}

}
