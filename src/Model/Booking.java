package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import Model.Enums.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Booking.
 * This class the information of a particular Booking.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Booking implements Serializable{
	
	/** The booking ID. */
	private String bookingID;
	/** The customer. */
	private Customer customer;
	/** The date. */
	private Date date;
	/** The transaction. */
	private Transaction transaction;
	/** The status. */
	private BookingStatus status;
	/**  The list of movie tickets tied to this particular Booking. */
	private List<MovieTicket> movieTickets;
	private Seat seat;
	
	/**
	 * Instantiates a new booking. Default booking ID is -1.
	 *
	 * @param bookingID the booking ID
	 * @param customer the customer who made the booking
	 * @param date the date the booking was made
	 * @param transaction the transaction associated with this booking
	 * @param status the status of the booking {@code BookingStatus}
	 * @param seat The list of movie tickets tied to this particular Booking
	 */
	public Booking(Customer customer, Date date, Transaction transaction,
					BookingStatus status, Seat seat) {
		this.bookingID = transaction.getTransaction_ID();
		this.customer=customer;
		this.date = date;
		this.status = status;
		this.transaction = transaction;
		this.seat = seat;
	}

	/**
	 * This method gets the transaction id.
	 *
	 * @return the tid
	 */
	// TID
	public String getTID() {
		return transaction.getTransaction_ID();
	}
		
////	/**
////	 * Gets the seat.
////	 *
////	 * @return the seat
////	 */
////	// seat
////	public Seat getSeat() {
////		return seat;
////	}
//	
////	/**
////	 * Sets the seat.
////	 *
////	 * @param seat the new seat
////	 */
////	public void setSeat(Seat seat) {
////		this.seat=seat;
////	}
	
	/**
	 * This method sets the booking ID.
	 *
	 * @param bookingID the new booking ID
	 */
	// bookingID
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	
	/**
	 * This method gets the booking ID.
	 *
	 * @return the booking ID
	 */
	public String getBookingID() {
		return bookingID;
	}
	
	/**
	 * This method gets the customer object.
	 *
	 * @return the customer
	 */
	// customer
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * This method sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * This method gets the date.
	 *
	 * @return the date
	 */
	// date
	public Date getDate() {
		return date;
	}
	
	/**
	 * This method sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * This method gets the transaction object.
	 *
	 * @return the transaction
	 */
	// transaction
	public Transaction getTransaction() {
		return transaction;
	}
	
	/**
	 * This method sets the transaction.
	 *
	 * @param transaction the new transaction
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	/**
	 * This method gets the enum booking status.
	 *
	 * @return the status
	 */
	// status
	public BookingStatus getStatus() {
		return status;
	}
	
	/**
	 * This method sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	/**
	 * This method gets the movie tickets.
	 *
	 * @return the movie tickets
	 */
	// movieTickets
	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}
	
	/**
	 * This method adds the movie ticket object.
	 *
	 * @param ticket the ticket
	 */
	public void addMovieTicket(MovieTicket ticket) {
		movieTickets.add(ticket);
	}
	
	/**
	 * This method removes the movie ticket.
	 *
	 * @param ticket the ticket
	 */
	public void removeMovieTicket(MovieTicket ticket) {
		movieTickets.remove(ticket);
	}

}
