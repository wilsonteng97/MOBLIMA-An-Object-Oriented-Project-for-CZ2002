/**
 * 
 */
package Model;
/**
 * @author wilso
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Enums.*;

public class Cinema implements Serializable {
	private Integer cinemaID;
	private String cinemaName; // This is for display.
	private CinemaOperator operator;
	private CinemaClass cinemaClass;
	private List<ShowTime> showTimes;
	private List<Seat> seats;
	private Integer no_of_rows;
	private Integer no_of_columns;
	
	public Cinema(Integer cinemaID, String cinemaName, CinemaOperator operator, CinemaClass cinemaClass) {
		this.cinemaID = cinemaID;
		this.cinemaName = cinemaName;
		this.setOperator(operator);
		this.cinemaClass = cinemaClass;

		this.showTimes = new ArrayList<ShowTime>();
		this.seats = new ArrayList<Seat>();
		this.no_of_rows = 0;
		this.no_of_columns = 0;
	}
	
	// cinemaID
	public Integer getCinemaID() {
		return cinemaID;
	}
	public void setCinemaID(Integer cinemaID) {
		this.cinemaID = cinemaID;
	}
	
	// cinemaName
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	// operator
	public CinemaOperator getOperator() {
		return operator;
	}
	public void setOperator(CinemaOperator operator) {
		this.operator = operator;
	}
	
	// cinemaClass
	public CinemaClass getCinemaClass() {
		return cinemaClass;
	}
	public void setCinemaClass(CinemaClass cinemaClass) {
		this.cinemaClass = cinemaClass;
	}
	
	// showTime
	public void addShowTime(ShowTime showTime) {
		showTimes.add(showTime);
	}
	public void removeShowTime(ShowTime showTime) {
		showTimes.remove(showTime);
	}
	public void setShowTimes(List<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}
	public List<ShowTime> getShowTimes() {
		return showTimes;
	}
	// Get ShowTimes By Movie
	public List<ShowTime> getShowTimes(Movie input_movie) {
		List<ShowTime> showtime_for_specific_input_movie = new ArrayList<ShowTime>();
		
		for(ShowTime st: showTimes) {
			if(st.getMovie().getMovieID() == input_movie.getMovieID()) {
				showtime_for_specific_input_movie.add(st);
			}
		}
		return showtime_for_specific_input_movie;
	}
	
	// seats
	public void addSeat(Seat seat) {
		seats.add(seat);
	}
	public void removeSeat(Seat seat) {
		seats.remove(seat);
	}
	public List<Seat> getSeatList() {
		return seats;
	}
	public void setSeatList(List<Seat> seats) {
		this.seats = seats;
	}
	
	// seat
	public Seat getSpecificSeat(String seatRow, Integer seatNo) {
		for(Seat seat: seats) {
			if(seat.getSeatRow().equals(seatRow) && seat.getSeatNo()==seatNo) {
				return seat;
			}
		}
		return null;
	}
	
	// no_of_rows
	public void setNoOfSeatRow(int no_of_rows) {
		this.no_of_rows = no_of_rows;
	}
	public int getNoOfSeatRow() {
		return no_of_rows;
	}
	
	// no_of_columns
	public void setNoOfSeatColumn(int no_of_columns) {
		this.no_of_columns = no_of_columns;
	}
	public int getNoOfSeatColumn() {
		return no_of_columns;
	}
}
