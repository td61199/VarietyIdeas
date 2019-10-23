package varietyIdeas;

public class Item {

    private String itemName;
    public int itemCount;
    private String itemType;
    /*
      Constructor creates item, with a name, a price
     */

    public Item(String itemName, int itemCount, String itemType) {
	this.itemName = itemName;
	this.itemCount = itemCount;
	this.itemType = itemType;
    }
    public String getItemName() {
	return itemName; //returns itemName
    }
    public int getItemCount() {
	return itemCount; // returns number of items
    }
    public String getItemType() {
	return itemType; //returns Item type
    }
    public void subtractCount(int sub) {
	itemCount = itemCount - sub;
	//subtracts "sub" from the items quantity
    }
    public void addQuantity(int add) {
	itemCount = itemCount + add;
	//adds "add" to item quantity
    }
    public void printItemInfo() {
    	System.out.println("*************************");
    	System.out.println("Item Name -> " + itemName);
    	System.out.println("Item Count -> "+ itemCount);
    	System.out.println("Item Type -> " + itemType);
    	System.out.println();
    	
    }

public static void main(String [] args) {
	Item apple = new Item("Apple", 5, "Produce");
	apple.printItemInfo();
	Item banana = new Item("Banana", 3, "Produce");
	banana.printItemInfo();
	
	
}


}
