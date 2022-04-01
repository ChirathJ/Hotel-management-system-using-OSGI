package servicesubsciberr;


import java.util.Scanner;
import java.io.IOException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import FoodService.FoodService;

public class ServiceActivator implements BundleActivator{

	ServiceReference serviceReference;

    public void start(BundleContext bundleContext) throws Exception{
    	
    	serviceReference = bundleContext.getServiceReference(FoodService.class.getName());
		FoodService servicePublish = (FoodService) bundleContext.getService(serviceReference);

		System.out.println(" Chef Subcriber registered and started successfully");
		
        try{
            while (true){
            	
            	System.out.println();
            	System.out.println("=====Welcome to the hotel food services====");
            	System.out.println("View Food details : Press '1'");
            	System.out.println("Order Food        : Press '2'");
                System.out.println("Type as 'exit' to exit.");
                System.out.println("=======================================");
                System.out.println();
                
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter option: ");
                String option = sc.next();
                System.out.println();

                if (option.equalsIgnoreCase("exit")){
                    break;
                }
                
                else if (servicePublish == null){
                    System.out.println("No hotel Food  available.");
                }

                else if (option.equalsIgnoreCase("1")){
                	servicePublish.displayFoods();
                }
                
                else if(option.equalsIgnoreCase("2")){
                	
                    String reservedFoodNumber = "";
                    System.out.print("Enter Food number  : ");
                    reservedFoodNumber = sc.next();
                    
                    int nooffoods;
                    System.out.print("Enter no of foods that you want to reserve : ");
                    nooffoods = sc.nextInt();
                    
                    System.out.println("Total cost : " +servicePublish.reserveFood(reservedFoodNumber, nooffoods));
                }
                else {
                	System.out.println("Incorrect option");
                }
            }
        }catch (Exception ex){
        	
        }
    }


    public void stop(BundleContext context){
    	System.out.println(" Food reservation service subscriber stopped");
		context.ungetService(serviceReference);
    }
}