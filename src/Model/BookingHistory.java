package Model;

public class BookingHistory {
	private Booking[] bookings;
	private Customer cust;
	private int noofbookings;
	
	public BookingHistory(Customer cust) {
		this.noofbookings = 0
		this.bookings = new Booking[noofbookings];
		this.cust = cust;
	}
	
	public int getNoOfBookings() {
		return noofbookings;
	}

	public void addBooking(Booking booking) {
		
		this.noofbookings += 1;
	}
	
	public int getBookings() {
		for (Booking bookings : booking) {
			booking.printBooking();
		}
	}

	public void addBooking(Booking booking) {
		
		this.noofbookings += 1;
	}
}
