package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import Model.Enums.*;

@SuppressWarnings("serial")
public class Booking implements Serializable{
	private Integer bookingID;
	
	private Customer customer;
	private Date date;
	private Transaction transaction;
	private BookingStatus status;
	private List<MovieTicket> movieTickets;
	
	public Booking(Customer customer, Date date, Transaction transaction, 
					BookingStatus status, List<MovieTicket> movieTickets) {
		this.bookingID = -1;
		this.status = status;
		this.date = date;
		this.transaction = transaction;
		this.customer = customer;
		this.movieTickets = movieTickets;
	}
	
	// bookingID
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public int getBookingID() {
		return bookingID;
	}
	
	// customer
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	// date
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	// transaction
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	// status
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	// movieTickets
	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}
	public void addMovieTicket(MovieTicket ticket) {
		movieTickets.add(ticket);
	}
	public void removeMovieTicket(MovieTicket ticket) {
		movieTickets.remove(ticket);
	}

}
