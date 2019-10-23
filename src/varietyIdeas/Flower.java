/**
 * 
 */
package varietyIdeas;

/**
 * @author tahjdosso
 *
 */
public class Flower extends Plant {

	private int petalCount;

	public Flower(String plantName, String plantColor, int rootDepth, int plantAge, double heightINinches,
			double widthINinches, boolean surviveBelow32F, int petalCount) {
		super(plantName, plantColor, rootDepth, plantAge, heightINinches, widthINinches, surviveBelow32F);
		this.petalCount = petalCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Project.Plant#getPlantName()
	 */
	public int getPetalCount() {
		return petalCount;
	}
	
	public void water() {

	}

}
