package receptionistconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import roomProducerService.roomsServices;

public class receptionistActivator implements BundleActivator {

	ServiceReference<?> serviceReferenceRoom;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Receptionist Consumer");

		serviceReferenceRoom = context.getServiceReference(roomsServices.class.getName());
		roomsServices roomService = (roomsServices) context.getService(serviceReferenceRoom);

		roomService.sampleRoomsDetails();

		while (true) {
			roomService.roomsReceptionistDetails();

			System.out.println("");
			System.out.println("Add New Room Details         :   1");
			System.out.println("Update Existing Room Details :   2");
			System.out.println("Delete Existing Room Details :   3");
			System.out.println("Quit                         :  -1");
			System.out.println("");
			
			System.out.print("Which service do you to access :");
			Scanner serv = new Scanner(System.in);
			int servI = serv.nextInt();

			if (servI == 1) {
				roomService.addRooms();
			}

			else if (servI == 2) {
				roomService.updateRooms();
			}

			else if (servI == 3) {
				roomService.deleteRooms();
			}
			
			else if (servI == -1) {
				break;
			}

			else {
				continue;
			}

			System.out.print("Do you want to quit? (y/n) :");
			Scanner aQuit = new Scanner(System.in);
			String aQuitS = aQuit.next();

			if (aQuitS.equalsIgnoreCase("y")) {
				break;
			}
		}
		System.out.println("");
		System.out.println("-----------------Thank you and Good bye!------------------");
		System.out.println("--------------------Have a nice day!----------------------");
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReferenceRoom);
		System.out.println("Stop Receptionist Consumer");
	}

}
