package bartendersubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.bar.service.BarPublish;

public class BarTenderActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start barSubscriber");
		
		serviceReference = context.getServiceReference(BarPublish.class.getName());
		BarPublish barPublish = (BarPublish)context.getService(serviceReference);
		
		System.out.println("--------------------------------- WELCOME TO KURUM-BAR ---------------------------------\n");
		
		while(true) {
			barPublish.displayItems();
			
			System.out.print("Choose any item: ");
			Scanner scnDrink = new Scanner(System.in);
			int numDrink = scnDrink.nextInt();
			
			if(numDrink > 5) {
				System.out.println("Invalid number, Please enter a valid number");
				continue;
			}
			
			System.out.print("How many shots? ");
			Scanner scnShot = new Scanner(System.in);
			int numShot = scnShot.nextInt();
			
			System.out.print("Would you like to order again? Y/N / y/n: ");
			Scanner scnOd = new Scanner(System.in);
			String numOd = scnOd.next();
			
			barPublish.addBill(numDrink, numShot);
			
			if(numOd.equalsIgnoreCase("N")) {
				barPublish.printBill();
				break;
			}
		}
		
	}
	

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		
		System.out.println("Thank you for coming - See you next time");
		System.out.println("barSubscriber stopped");
	}
	

}
