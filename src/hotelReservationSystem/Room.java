package hotelReservationSystem;

public class Room {
	private String roomNumber, category;
	private boolean isAvailable=true;
	private double price;
	
	public Room(String roomNumber, String category, double price) {
		this.roomNumber=roomNumber;
		this.category=category;
		this.price=price;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public String getCategory() {
		return category;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void seatAvailable(boolean available) {
		isAvailable = available;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", category=" + category + ", isAvailable=" + isAvailable + ", price="
				+ price + "]";
	}
}
