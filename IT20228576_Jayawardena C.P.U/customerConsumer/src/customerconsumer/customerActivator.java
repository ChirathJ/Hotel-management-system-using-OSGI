package customerconsumer;

import billProducerService.billService;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import roomProducerService.roomsServices;

public class customerActivator implements BundleActivator {

	ServiceReference<?> serviceReferenceRoom, serviceReferenceBill;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Customer Consumer");

		serviceReferenceRoom = context.getServiceReference(roomsServices.class.getName());
		roomsServices roomService = (roomsServices) context.getService(serviceReferenceRoom);

		serviceReferenceBill = context.getServiceReference(billService.class.getName());
		billService billService = (billService) context.getService(serviceReferenceBill);

		roomService.sampleRoomsDetails();

		boolean booked = false;

		while (true) {

			System.out.println("");
			System.out.println("**************Spend Over 40000 And Get A 15% Discount**************");

			roomService.roomsCustomerDetails();

			System.out.println("");
			System.out.print("Enter the room ID you want to reserve :");
			Scanner pId = new Scanner(System.in);
			int rId = pId.nextInt();

			if (rId == -1) {
				break;
			}

			int rPrice = roomService.getPrice(rId);

			if (rPrice == -1) {
				System.out.println("");
				System.out.println("error!!");
				continue;
			} else {
				System.out.println("");
				System.out.println("Room number " + rId + " price = Rs." + rPrice);
			}

			System.out.println("");
			System.out.print("How many rooms do you want to reserve? :");
			Scanner qAns = new Scanner(System.in);
			String qAnsS = qAns.next();
			int qAnsI = Integer.parseInt(qAnsS);

			if (qAnsI <= 0) {
				System.out.println("error!!");
				continue;
			}

			int rBulkPrice = roomService.getBulkPrice(rId, qAnsI);
			System.out.println("Room number " + rId + " X " + qAnsI + " price = Rs." + rBulkPrice);

			System.out.println("");
			System.out.print("Do you want to reserve? (y/n) :");
			Scanner bAns = new Scanner(System.in);
			String bAnsS = bAns.next();

			if (bAnsS.equalsIgnoreCase("y")) {
				System.out.println("");
				System.out.println("Adding to the bill....");
				System.out.println("");

				String name = roomService.getName(rId);
				boolean con = billService.addAmount(qAnsI, name, rBulkPrice);

				if (con == true) {
					System.out.println("Succesfully added to the bill Rs." + rBulkPrice);
					System.out.println("Bill total Rs." + billService.checkTotal());
					booked = true;
				} else {
					System.out.println("error!!");
				}
			} else if (bAnsS.equalsIgnoreCase("n")) {
			} else {
				System.out.println("error!!");
				break;
			}

			System.out.println("");
			System.out.print("Do you want to quit? (y/n) :");
			Scanner aQuit = new Scanner(System.in);
			String aQuitS = aQuit.next();

			if (aQuitS.equalsIgnoreCase("y")) {

				if (booked == true) {
					System.out.println("");
					System.out.println("Bill printing...");
					System.out.println("");

					billService.printBill();
				}
				billService.clearBill();

				break;
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("--------Thank you and Good bye!---------");
		System.out.println("-------------Have a nice day!-----------");
		System.out.println("");
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReferenceRoom);
		context.ungetService(serviceReferenceBill);
		System.out.println("Stop Customer Consumer");
	}

}
