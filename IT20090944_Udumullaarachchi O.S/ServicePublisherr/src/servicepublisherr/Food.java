package servicepublisherr;

public class Food {
	private String FoodNumber;
	private String FoodType;
	private double FoodPrice;
	
	
	public Food(String FoodNumber, String FoodType, double FoodPrice) {
		super();
		this.FoodNumber = FoodNumber;
		this.FoodType = FoodType;
		this.FoodPrice = FoodPrice;
		
	}

	public String getFoodNumber() {
		return FoodNumber;
	}

	public void setFoodNumber(String FoodNumber) {
		this.FoodNumber = FoodNumber;
	}

	public String getFoodType() {
		return FoodType;
	}

	public void setFoodType(String FoodType) {
		this.FoodType = FoodType;
	}

	public double getFoodPrice() {
		return FoodPrice;
	}

	public void setFoodPrice(double FoodPrice) {
		this.FoodPrice = FoodPrice;
	}



	
}
