package roomProducer;

import java.util.HashMap;
import java.util.Scanner;

import roomProducerService.roomsServices;

public class roomsServiceImpl implements roomsServices {

	HashMap<Integer, String> roomName = new HashMap<Integer, String>();
	HashMap<Integer, Integer> roomPrice = new HashMap<Integer, Integer>();
	HashMap<Integer, String> roomsSize = new HashMap<Integer, String>();
	HashMap<Integer, String> roomFacility = new HashMap<Integer, String>();

	int countRooms = 3;
	boolean chng = false;

	@Override
	public void roomsCustomerDetails() {
		System.out.println("");
		System.out.println("---------------------------Room Details-----------------------------");
		System.out.println("");
		System.out.println("ID\t\tName\t\tSleeps\t\tFacilities");
		System.out.println("--------------------------------------------------------------------");
		for (int i = 1; i <= countRooms; ++i) {
			if (roomName.get(i) != null) {
				System.out.print(i);
				System.out.print("\t\t");
				System.out.print(roomName.get(i));
				System.out.print("\t\t");
				System.out.print(roomsSize.get(i));
				System.out.print("\t");
				System.out.println(roomFacility.get(i));
			}
		}
		System.out.println("--------------------------------------------------------------------");
	}
	
	@Override
	public void roomsReceptionistDetails() {
		System.out.println("");
		System.out.println("-----------------------------------Room Details------------------------------------");
		System.out.println("");
		System.out.println("ID\t\tName\t\tSleeps\t\tPrice\t\tFacilities");
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 1; i <= countRooms; ++i) {
			if (roomName.get(i) != null) {
				System.out.print(i);
				System.out.print("\t\t");
				System.out.print(roomName.get(i));
				System.out.print("\t\t");
				System.out.print(roomsSize.get(i));
				System.out.print("\t");
				System.out.print(roomPrice.get(i));
				System.out.print("\t\t");
				System.out.println(roomFacility.get(i));
			}
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}

	@Override
	public int getPrice(int id) {

		int price = -1;

		if (id <= countRooms && roomName.get(id) != null) {

			price = roomPrice.get(id);
		} else {
			System.out.print("Error!! Invalid ID");
		}

		return price;
	}

	@Override
	public int getBulkPrice(int id, int quantity) {
		int price = -1;
		int bulkPrice = -1;

		price = getPrice(id);
		bulkPrice = price * quantity;

		return bulkPrice;
	}

	@Override
	public String getName(int id) {
		String name = null;

		if (id <= countRooms && roomName.get(id) != null) {
			name = roomName.get(id);

		} else {
			System.out.print("Error!! Invalid ID");
		}

		return name;
	}

	@Override
	public void addRooms() {
		System.out.println("");
		System.out.println("Add New Room Details");
		System.out.println("");

		System.out.print("Enter Name : ");
		Scanner rName = new Scanner(System.in);
		String rNameS = rName.next();

		System.out.println("");
		System.out.print("Enter Size (Adults) : ");
		Scanner rSize = new Scanner(System.in);
		String rSizeS = rSize.next();
		
		System.out.println("");
		System.out.print("Enter Price : ");
		Scanner rPrice = new Scanner(System.in);
		int rPriceI = rPrice.nextInt();

		System.out.println("");
		System.out.print("Enter Facilities : ");
		Scanner rFacil = new Scanner(System.in);
		String rFacilS = rFacil.next();

		countRooms++;

		roomName.put(countRooms, rNameS);
		roomsSize.put(countRooms, rSizeS);
		roomFacility.put(countRooms, rFacilS);
		roomPrice.put(countRooms, rPriceI);

		System.out.println("");
		System.out.println("Successfully Added " + rNameS + " Room Details");
		System.out.println("");

	}

	@Override
	public void deleteRooms() {
		System.out.println("");
		System.out.println("Delete Room Details");

		System.out.println("");
		System.out.print("Enter Room ID : ");
		Scanner roID = new Scanner(System.in);
		int roIDI = roID.nextInt();

		String tname = roomName.get(roIDI);

		roomName.remove(roIDI);
		roomsSize.remove(roIDI);
		roomFacility.remove(roIDI);
		roomPrice.remove(roIDI);

		System.out.println("");
		System.out.println("Successfully Deleted " + tname + " Room Details");
		System.out.println("");

	}

	@Override
	public void updateRooms() {
		System.out.println("");
		System.out.println("Update Room Details");

		System.out.println("");
		System.out.print("Enter Room ID : ");
		Scanner eId = new Scanner(System.in);
		int eIdI = eId.nextInt();

		System.out.println("");
		System.out.print("Enter Name : ");
		Scanner rName = new Scanner(System.in);
		String rNameS = rName.next();

		System.out.println("");
		System.out.print("Enter Size (Adults) : ");
		Scanner rSize = new Scanner(System.in);
		String rSizeS = rSize.next();
		
		System.out.println("");
		System.out.print("Enter Price : ");
		Scanner rPrice = new Scanner(System.in);
		int rPriceI = rPrice.nextInt();

		System.out.println("");
		System.out.print("Enter Facilities : ");
		Scanner rFacil = new Scanner(System.in);
		String rFacilS = rFacil.next();

		roomName.put(eIdI, rNameS);
		roomsSize.put(eIdI, rSizeS);
		roomFacility.put(eIdI, rFacilS);
		roomPrice.put(eIdI, rPriceI);

		System.out.println("");
		System.out.println("Successfully Updated " + rNameS + " Employee Details");
		System.out.println("");

	}

	@Override
	public void sampleRoomsDetails() {
		if (chng == false) {
			roomName.put(1, "Master");
			roomName.put(2, "Deluxe");
			roomName.put(3, "Super");

			roomPrice.put(1, 25000);
			roomPrice.put(2, 15000);
			roomPrice.put(3, 20000);

			roomsSize.put(1, "4-Adults");
			roomsSize.put(2, "2-Adults");
			roomsSize.put(3, "6-Adults");

			roomFacility.put(1, "wifi/spa/pool");
			roomFacility.put(2, "wifi/pool");
			roomFacility.put(3, "wifi/spa");
			chng = true;
		}
	}
}
