package varietyIdeas;

public abstract class Plant {
	private String plantName;
	private String plantColor;
	private int rootDepth;
	private int plantAge;
	private double heightINinches;
	private double widthINinches;
	private boolean surviveBelow32F;
	
	
	public Plant(String plantName, String plantColor, int rootDepth, int plantAge, double heightINinches,
			double widthINinches, boolean surviveBelow32F) {
		super();
		this.plantName = plantName;
		this.plantColor = plantColor;
		this.rootDepth = rootDepth;
		this.plantAge = plantAge;
		this.heightINinches = heightINinches;
		this.widthINinches = widthINinches;
		this.surviveBelow32F = surviveBelow32F;
	}
	public String getPlantName() {
		return plantName;
	}
	public String getPlantColor() {
		return plantColor;
	}
	public int getRootDepth() {
		return rootDepth;
	}
	public int getPlantAge() {
		return plantAge;
	}
	public double getHeightINinches() {
		return heightINinches;
	}
	public double getWidthINinches() {
		return widthINinches;
	}
	public boolean isSurviveBelow32F() {
		return surviveBelow32F;
	}
	protected void setPlantColor(String plantColor) {
		this.plantColor = plantColor;
	}
	protected void changeRootDepth(int rootDepth) {
		this.rootDepth = rootDepth + this.rootDepth;
	}
	protected void increasePlantAge(int plantAge) {
		this.plantAge = plantAge + this.plantAge;
	}
	protected void setHeightINinches(double heightINinches) {
		this.heightINinches = heightINinches;
	}
	protected void setWidthINinches(double widthINinches) {
		this.widthINinches = widthINinches;
	}
	
	public abstract void water();
	
	

}
