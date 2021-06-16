package co.green.model;

public class Green {

	int g_id;
	String plantName;
	int plantWater;
	int plantPruning;
	int plantFood;
	
	
	public Green () {}

	public Green(int g_id, String plantName, int plantWater, int plantPruning, int plantFood) {
		super();
		this.g_id = g_id;
		this.plantName = plantName;
		this.plantWater = plantWater;
		this.plantPruning = plantPruning;
		this.plantFood = plantFood;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public int getPlantWater() {
		return plantWater;
	}
	public void setPlantWater(int plantWater) {
		this.plantWater = plantWater;
	}
	public int getPlantPruning() {
		return plantPruning;
	}
	public void setPlantPruning(int plantPruning) {
		this.plantPruning = plantPruning;
	}
	public int getPlantFood() {
		return plantFood;
	}
	public void setPlantFood(int plantFood) {
		this.plantFood = plantFood;
	}

	@Override
	public String toString() {
		return "식물명: " + plantName + "  물 주기:" + plantWater + "일  가지치기 주기: " + plantPruning
				+ "일  영양제 주기:" + plantFood + "일";
	}

	public void print() {
		System.out.printf("식물명 [%5s ]  물 주기 : %2d일,  가지치기 주기 : %2d일,  영양제 주기 : %2d일 ",plantName,plantWater,plantPruning,plantFood);
		System.out.println();
	}
	
	

	
	
	
}
