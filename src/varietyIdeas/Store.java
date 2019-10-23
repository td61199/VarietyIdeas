package varietyIdeas;

import java.util.ArrayList;

public class Store {
	private String storeName;
	private Inventory inventory; // inventory list for store
	private ArrayList<Patron> eList; // list of all employees for associated store

	public Store(String storeName, int i, int e) {

		this.storeName = storeName;
		inventory = new Inventory(i);
		eList = new ArrayList<Patron>(e);
	}

	public void addNewEmployee(Patron p) {
		eList.add(p);
	}

	public void removeEmployee(Patron p) {
		eList.remove(eList.indexOf(p));
	}
	public String getStoreName() {
		return storeName;
	}
}
