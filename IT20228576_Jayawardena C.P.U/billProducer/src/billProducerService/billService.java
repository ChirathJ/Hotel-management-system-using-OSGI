package billProducerService;

public interface billService {

	boolean addAmount(int quantity, String name, int price);
	double checkTotal();
	void printBill();
	void clearBill();
	double checkDiscount(double total);
}
