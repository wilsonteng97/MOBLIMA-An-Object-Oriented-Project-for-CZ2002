
package Model;

import java.io.Serializable;

import Model.Enums.*;

@SuppressWarnings("serial")
public class MovieTicket implements Serializable {
	
	private Integer movieTicketID;
	private TicketType ticketType;
	private ShowTime showTime;
	private Booking booking;
	private String seatNo;
	private Double price;
	
	public MovieTicket(TicketType ticketType, ShowTime showTime, String seatNo, Double price) {
		this.movieTicketID = -1;
		this.ticketType = ticketType;
		this.showTime = showTime;
		this.booking = null;
		this.seatNo = seatNo;
		this.price = price;
	}
	
	// movieTicketID
	public int getMovieTicketID() {
		return movieTicketID;
	}
	public void setMovieTicketID(int movieTicketID) {
		this.movieTicketID = movieTicketID;
	}
	
	// ticketType
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	// showTime
	public ShowTime getShowTime() {
		return showTime;
	}
	public void setShowTime(ShowTime showTime) {
		this.showTime = showTime;
	}
	
	// booking
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	// seatNo
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	
	// price
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}