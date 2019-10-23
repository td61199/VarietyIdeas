package varietyIdeas;

public class InventoryTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory Store = new Inventory(20);
		Store.createItem("Apple", 5, "Fruit");
		Store.createItem("Bunch of Grapes", 16, "Fruit");
		Store.createItem("Lettuce", 3, "Vegetable");
		Store.createItem("Ketchup", 10, "Condiment");
		Store.createItem("Mustard", 4, "Condiment");
		Store.createItem("Eggs", 64, "Produce");
		Store.createItem("Chicken Legs", 13, "Meat");
		Store.createItem("Salmon", 4, "Fish");
		Store.createItem("Red Snapper", 6, "Fish");
		Store.createItem("Peanuts", 120, "Nuts");
		Store.createItem("Walnuts", 45, "Nuts");
		Store.createItem("Brocoli", 12, "Vegetable");
		Store.createItem("Pepper", 6, "Vegetable");
		Store.createItem("Carrots", 12, "Vegetable");
		Store.createItem("Bag of Rice", 34, "Grain");
		Store.createItem("Box of Oatmeal", 4, "Grain");
		Store.printAll();
		Store.printBYtype("Vegetable");
		Store.printBYtype("Fruit");
	}

}
