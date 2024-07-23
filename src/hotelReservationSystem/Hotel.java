package hotelReservationSystem;
import java.util.List;
import java.util.ArrayList;
public class Hotel {
	private List<Room> rooms = new ArrayList<>();
	private List<Reservation> reservations = new ArrayList<>();
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public List<Room> searchRooms(String category){
		List<Room> availableRooms = new ArrayList<>();
		for(Room room : rooms) {
			if(room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}
	
	
	public Reservation makeReservation(String roomNumber, String customerName, int numOfNights) {
		for(Room room : rooms) {
			if(room.getRoomNumber().equals(roomNumber) && room.isAvailable()) {
				room.seatAvailable(false);
				Reservation reservation = new Reservation(room, customerName, numOfNights);
				reservations.add(reservation);
				return reservation;
			}
		}
		return null;
	}
	
	
	public Reservation viewBookingDetails(String reservaionId) {
		for(Reservation reservation : reservations) {
			if(reservation.getReservationId().equals(reservaionId)) {
				return reservation;
			}
		}
		return null;
	}
	
	
	

}
