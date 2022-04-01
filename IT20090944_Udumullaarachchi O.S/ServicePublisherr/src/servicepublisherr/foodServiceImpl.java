package servicepublisherr;

import FoodService.FoodService;

public class foodServiceImpl implements FoodService {

	Food r1 = new Food("001", "Rice", 550);
	Food r2 = new Food("002", "Noodles", 300);
	Food r3 = new Food("003", "Pasta", 800);

	Food[] Foods = { r1, r2, r3 };

	@Override
	public void displayFoods() {
		for (Food r : Foods) {
			System.out.println("Food number : " + r.getFoodNumber());
			System.out.println("Food type : " + r.getFoodType());
			System.out.println("Food cost per day : " + r.getFoodPrice());

			System.out.println();
		}
	}

	@Override
	public double reserveFood(String FoodNumber, int noOffood) {
		if (FoodNumber.equalsIgnoreCase("001")) {
			return (550 * noOffood);
		} else if (FoodNumber.equalsIgnoreCase("002")) {
			return (300 * noOffood);
		} else if (FoodNumber.equalsIgnoreCase("003")) {
			return (800 * noOffood);
		} else {
			System.out.println("Invalid Food number");
			return 0;
		}
	}
}
