package roomProducerService;

public interface roomsServices {

	void roomsCustomerDetails();
	void roomsReceptionistDetails();
	int getPrice(int id);
	int getBulkPrice(int id,int quantity);
	String getName(int id);
	void addRooms();
	void deleteRooms();
	void updateRooms();
	void sampleRoomsDetails();

}
