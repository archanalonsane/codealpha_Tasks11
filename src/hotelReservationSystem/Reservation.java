package hotelReservationSystem;

import java.util.UUID;

public class Reservation {
	private String reservationId = UUID.randomUUID().toString();
	private Room room;
	private String customerName;
	private int numOfNights;
	private double totalPrice;
	
	public Reservation(Room room, String customerName, int numOfNights) {
		this.room=room;
		this.customerName=customerName;
		this.numOfNights=numOfNights;
		this.totalPrice=room.getPrice()*numOfNights;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", room=" + room + ", customerName=" + customerName
				+ ", numOfNights=" + numOfNights + ", totalPrice=" + totalPrice + "]";
	}
	
	public String getReservationId() {
		return reservationId;
		
	}
}

