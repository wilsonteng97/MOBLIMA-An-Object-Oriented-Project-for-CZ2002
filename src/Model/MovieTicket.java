package Model;

import java.io.Serializable;

import Model.Enums.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieTicket.
 * This class contains the information of the movie ticket.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MovieTicket implements Serializable {
	
	/** The movie ticket ID. */
	private Integer movieTicketID;
	/** The ticket type based on the customer's age group. */
	private TicketType ticketType;
	/** The show time. */
	private ShowTime showTime;
	/** The booking. */
	private Booking booking;
	/** The seat number assigned for the customer of the ticket. */
	private String seatNo;
	/** The price that the customer paid for the ticket. */
	private Double price;
	
	/**
	 * Instantiates a new movie ticket.
	 *
	 * @param ticketType the ticket type based on customer's age group
	 * @param showTime the show time
	 * @param seatNo the seat number at the cinema
	 * @param price the price of the ticket
	 */
	public MovieTicket(TicketType ticketType, ShowTime showTime, String seatNo, Double price) {
		this.movieTicketID = -1;
		this.ticketType = ticketType;
		this.showTime = showTime;
		this.booking = null;
		this.seatNo = seatNo;
		this.price = price;
	}
	
	/**
	 * Gets the movie ticket ID.
	 *
	 * @return the movie ticket ID
	 */
	// movieTicketID
	public int getMovieTicketID() {
		return movieTicketID;
	}
	
	/**
	 * Sets the movie ticket ID.
	 *
	 * @param movieTicketID the new movie ticket ID
	 */
	public void setMovieTicketID(int movieTicketID) {
		this.movieTicketID = movieTicketID;
	}
	
	/**
	 * Gets the enum ticket type based on customer's age group.
	 *
	 * @return the ticket type
	 */
	// ticketType
	public TicketType getTicketType() {
		return ticketType;
	}
	
	/**
	 * Sets the ticket type based on customer's age group.
	 *
	 * @param ticketType the new ticket type
	 */
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * Gets the show time.
	 *
	 * @return the show time
	 */
	// showTime
	public ShowTime getShowTime() {
		return showTime;
	}
	
	/**
	 * Sets the show time.
	 *
	 * @param showTime the new show time
	 */
	public void setShowTime(ShowTime showTime) {
		this.showTime = showTime;
	}
	
	/**
	 * Gets the booking.
	 *
	 * @return the booking
	 */
	// booking
	public Booking getBooking() {
		return booking;
	}
	
	/**
	 * Sets the booking.
	 *
	 * @param booking the new booking
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	/**
	 * Gets the seat number in the cinema.
	 *
	 * @return the seat number
	 */
	// seatNo
	public String getSeatNo() {
		return seatNo;
	}
	
	/**
	 * Sets the seat number in the cinema.
	 *
	 * @param seatNo the new seat number
	 */
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	
	/**
	 * Gets the price of the ticket.
	 *
	 * @return the price
	 */
	// price
	public Double getPrice() {
		return price;
	}
	
	/**
	 * Sets the price of the ticket.
	 *
	 * @param price the new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
}