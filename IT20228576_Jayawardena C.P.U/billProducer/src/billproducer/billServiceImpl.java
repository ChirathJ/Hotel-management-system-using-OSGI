package billproducer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import billProducerService.billService;

public class billServiceImpl implements billService {

	String bill[][] = new String[20][3];
	HashMap<Integer, Integer> billQuantity = new HashMap<Integer, Integer>();
	HashMap<Integer, String> billName = new HashMap<Integer, String>();
	HashMap<Integer, Integer> billPrice = new HashMap<Integer, Integer>();
	int countRecords = 0;

	@Override
	public boolean addAmount(int quantity, String name, int price) {

		countRecords++;
		
		billQuantity.put(countRecords, quantity);
		billName.put(countRecords, name);
		billPrice.put(countRecords, price);

		return true;
	}

	@Override
	public void printBill() {

		System.out.println("");
		System.out.println("-----------Water Vibe Resorts-----------");
		System.out.println("");
		System.out.println("Quantity\tName\t\tPrice");
		System.out.println("----------------------------------------");

		for (int i = 1; i <= countRecords; ++i) {
				System.out.print(billQuantity.get(i));
				System.out.print("\t\t");
				System.out.print(billName.get(i));
				System.out.print("\t\t");
				System.out.println(billPrice.get(i));
		}
		System.out.println("----------------------------------------");
		double subTotal = checkTotal();
		double discount = checkDiscount(subTotal);
		double total = subTotal - discount;
		System.out.println("Subtotal price               Rs." + subTotal);
		System.out.println("Discount                     Rs." + discount);
		System.out.println("Total price                  Rs." + total);
		System.out.println("");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Date and time : " + dtf.format(now));
		System.out.println("");
		System.out.println("----------------------------------------");

	}

	@Override
	public double checkTotal() {
		double total = 0;
		for (int i = 1; i <= countRecords; ++i) {
			total = total + billPrice.get(i);
		}
		return total;
	}

	@Override
	public double checkDiscount(double total) {

		double discount = 0;

		if (total > 40000) {
			discount = total * 15 / 100;
		}
		return discount;
	}

	@Override
	public void clearBill() {
		billQuantity.clear();
		billName.clear();
		billPrice.clear();
		
	}

}
