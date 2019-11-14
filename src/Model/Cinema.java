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
import Model.Seat;

public class Cinema implements Serializable {
	private String cinemaID; // eg. 1P for 1st PLATINUM Cinema or 1N for 1st NORMAL Cinema
	private String cinemaName; // This is for display.
	private Integer operatorID;
	private CinemaClass cinemaClass;
	private CinemaOperator cinemaOperator;
	private List<ShowTime> showTimes;
	private List<Seat> seats;
	private Integer no_of_rows;
	private Integer no_of_columns;
	
	public Cinema(String cinemaID, String cinemaName, CinemaClass cinemaClass, CinemaOperator cinemaOperator) {
		this.cinemaID = cinemaID;
		this.cinemaName = cinemaName;
	//	this.setOperatorID(operatorID);
		this.cinemaClass = cinemaClass;
		this.cinemaOperator = cinemaOperator;
		this.showTimes = new ArrayList<ShowTime>();
		this.seats = new ArrayList<Seat>();
		this.no_of_rows = 0;
		this.no_of_columns = 0;
	}
	
	// cinemaID
	public String getCinemaID() {
		return cinemaID;
	}
	public void setCinemaID(String cinemaID) {
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
	public Integer getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(Integer operatorID) {
		this.operatorID = operatorID;
	}
	
	// cinemaClass
	public CinemaClass getCinemaClass() {
		return cinemaClass;
	}
	public void setCinemaClass(CinemaClass cinemaClass) {
		this.cinemaClass = cinemaClass;
	}
	
	public CinemaOperator getCinemaOperator()
	{
		return cinemaOperator;
	}
	public void setCinemaOperator(CinemaOperator cinemaOperator)
	{
		this.cinemaOperator = cinemaOperator;
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
	
	public List<Seat> getSeatList() {
		return seats;
	}
	public void setSeatList(List<Seat> seats) {
		this.seats = seats;
	}
	
	// seat
	public Seat getSpecificSeat(Integer seatID) {
		for(Seat seat: seats) {
			if(seat.getSeatID()==seatID) {
				return seat;
			}
		}
		return null;
	}
	public Seat getSpecificSeat(Integer seatRow, Integer seatCol) {
		Integer seatID = this.getNoOfSeatColumn()*seatRow + seatCol;
		for(Seat seat: seats) {
			if(seat.getSeatID()==seatID) {
				return seat;
			}
		}
		return null;
	}
	
	// getTotalNoOfSeats
	private Integer getTotalNoOfSeats() {
		return this.getNoOfSeatColumn()*this.getNoOfSeatRow();
	}
	
	// no_of_rows
	private void setNoOfSeatRow(int no_of_rows) {
		this.no_of_rows = no_of_rows;
	}
	public int getNoOfSeatRow() {
		return no_of_rows;
	}
	
	// no_of_columns
	private void setNoOfSeatColumn(int no_of_columns) {
		this.no_of_columns = no_of_columns;
	}
	public int getNoOfSeatColumn() {
		return no_of_columns;
	}
	
	// initializeSeatsList
	public void initializeSeatsList(Integer no_of_columns, Integer no_of_rows) {
		if ((no_of_columns<1) || (no_of_rows<1)) {
			return; // TO-DO -> Throw Exception
		}
		this.setNoOfSeatColumn(no_of_columns);
		this.setNoOfSeatRow(no_of_rows);
		
		this.seats = new ArrayList<Seat>(this.getTotalNoOfSeats());
		for (int row=1; row<=this.getNoOfSeatRow(); row++) {
			for (int col=1; col<=this.getNoOfSeatColumn(); col++) {
				Integer seatID = this.getNoOfSeatColumn()*row + col;
				this.seats.add(new Seat(seatID, this.getCinemaID(), this.getOperatorID()));
			}
		}
	}
	
	
	// printCinemaSeats
	public void printCinemaSeatsSpecificShowTime(ShowTime st) {
		String SpecificDateFormat = "yyyy-mm-dd hh:mm";
		System.out.println("Show Time ID:\t" + st.getShowTimeID());
		System.out.println("Show Time" + " (" + SpecificDateFormat + "):\t" + 
							st.getShowTimeString(SpecificDateFormat));
		
		System.out.println("\t\t[SCREEN]");
		int letter = 65; // starts from A
		for (Seat s : seats) {
			if (s.getSeatID()==1) {
				System.out.print((char)letter + "\t");
				letter++;
			}
			s.printSeat(st);
			if ((s.getSeatID()%this.getNoOfSeatColumn())==0 && 
				(s.getSeatID()!=this.getTotalNoOfSeats())) {
				System.out.println();
				System.out.print((char)letter + "\t");
			}
		}
	}
	public void printCinemaSeatsForAllShowTimes() {
		System.out.println();
		System.out.println("[Cinema Operator " + this.operatorID + " | Cinema " + this.getCinemaID() + " | " + this.getCinemaName() + "]");
		for (ShowTime st : showTimes) {
			this.printCinemaSeatsSpecificShowTime(st);
			System.out.println("\n");
		}
	}
}
