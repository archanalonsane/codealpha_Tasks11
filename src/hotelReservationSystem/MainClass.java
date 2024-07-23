package hotelReservationSystem;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hotel hotel = new Hotel();

		hotel.addRoom(new Room("101", "Single", 100.0));

		hotel.addRoom(new Room("102", "Double", 150.0));

		hotel.addRoom(new Room("201", "Suite", 250.0));

		while(true) {
			System.out.println("--------------------------------");
			System.out.println("Simple Hotel Reservation System");
			System.out.println("--------------------------------");
			System.out.println();
			System.out.println("1. Search Rooms.");
			System.out.println("2. Make Reservation.");
			System.out.println("3. Check Booking Details.");
			System.out.println("4. Exit.");
			System.out.println();
			System.out.println("Choose an Option: ");
			int choice = sc.nextInt();
         	sc.nextLine();


			switch(choice) {
			case 1: 
				System.out.println("Enter a room category that you want (Single, Double, Suite): ");
				String category = sc.nextLine();
				
				List<Room> availableRooms = hotel.searchRooms(category);
				if(availableRooms.isEmpty()) {
					System.out.println("No availale rooms in this category.");
					System.out.println("please select another category: ");
				}
				else {
					System.out.println("---------------------");
					System.out.println("Available rooms: ");
					for(Room room : availableRooms) {
						System.out.println(room);
					}
					System.out.println("---------------------------------");
				}
				break;
				
				
			case 2:
				System.out.println("Enter room number: ");
				String roomNumber = sc.nextLine();
				System.out.println("Enter your name: (first and last name)");
				String customerName = sc.nextLine();
				System.out.println("Enter number of nights: ");
				int numOfNights = sc.nextInt();
				sc.nextLine();
				Reservation reservation = hotel.makeReservation(roomNumber, customerName, numOfNights);
				if(reservation != null) {
					System.out.println("Your reservation successfully done, Thank You.. ");
					System.out.println("---------------------------------------");
					System.out.println(reservation);
					System.out.println("-------------------------------");
				}
				else {
					System.out.println("Reservation failed. Room might be unavailable or does not exist..");
				}
				break;
				
				
			case 3:
				System.out.println("Enter Reservaition Id: ");
				String reservationId = sc.nextLine();
				Reservation bookingDetails = hotel.viewBookingDetails(reservationId);
				if(bookingDetails != null) {
					System.out.println("Your booking Details: ");
					System.out.println("-----------------------------");
					System.out.println(bookingDetails);
					System.out.println("-----------------------------------");
				}
				else {
					System.out.println("No reservation found with this id.");
				}
				break;
				
				
			case 4: 
				System.out.println("-------------------------------");
				System.out.println("Exiting the apllication, Thank you for booking!");
				sc.close();
			    System.exit(0);
				
				break;
				
				
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
			
		}	

	}

}
