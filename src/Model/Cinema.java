/**
 * 
 */
package Model;
/**
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Enums.*;
import Model.Seat;

// TODO: Auto-generated Javadoc
/**
 * The Class Cinema.
 * This class the information of a particular cinema.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Cinema implements Serializable {
	
	/** The cinema ID. */
	private String cinemaID; // eg. 1P for 1st PLATINUM Cinema or 1N for 1st NORMAL Cinema
	/** The cinema name. */
	private String cinemaName; // This is for display.
	/** The cinema operator ID. */
	private Integer operatorID;
	/** The enum cinema class type for the cinema. */
	private CinemaClass cinemaClass;
	/** The cinema operator object. */
	private CinemaOperator cinemaOperator;
	/** The base price charged for the cinema. */
	private Double basePrice;
	/** The show times at the cinema. */
	private List<ShowTime> showTimes;
	/** The seats in the cinema. */
	private List<Seat> seats;
	/** The number of rows of seats in the cinema. */
	private Integer no_of_rows;
	/** The number of columns of seats in the cinema. */
	private Integer no_of_columns;
	
	/**
	 * Instantiates a new cinema.
	 *
	 * @param cinemaID the cinema ID
	 * @param cinemaName the cinema name
	 * @param cinemaClass the cinema class
	 * @param cinemaOperator the cinema operator
	 * @param basePrice the base price
	 * @param showTimes the show times
	 * @param seats the seats
	 * @param no_of_rows the no of rows
	 * @param no_of_columns the no of columns
	 */
	public Cinema(String cinemaID, String cinemaName, CinemaClass cinemaClass, CinemaOperator cinemaOperator, Double basePrice) {
		this.cinemaID = cinemaID;
		this.cinemaName = cinemaName;
	//	this.setOperatorID(operatorID);
		this.cinemaClass = cinemaClass;
		this.cinemaOperator = cinemaOperator;
		this.setBasePrice(basePrice);
		this.showTimes = new ArrayList<ShowTime>();
		this.seats = new ArrayList<Seat>();
		this.no_of_rows = 0;
		this.no_of_columns = 0;
	}
	
	/**
	 * This method gets the cinema ID.
	 *
	 * @return the cinema ID
	 */
	// cinemaID
	public String getCinemaID() {
		return cinemaID;
	}
	
	/**
	 * This method sets the cinema ID.
	 *
	 * @param cinemaID the new cinema ID
	 */
	public void setCinemaID(String cinemaID) {
		this.cinemaID = cinemaID;
	}
	
	/**
	 * This method sets the cinema name.
	 *
	 * @return the cinema name
	 */
	// cinemaName
	public String getCinemaName() {
		return cinemaName;
	}
	
	/**
	 * This method sets the cinema name.
	 *
	 * @param cinemaName the new cinema name
	 */
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	/**
	 * This method gets the operator ID.
	 *
	 * @return the operator ID
	 */
	// operator
	public Integer getOperatorID() {
		return operatorID;
	}
	
	/**
	 * This method sets the operator ID.
	 *
	 * @param operatorID the new operator ID
	 */
	public void setOperatorID(Integer operatorID) {
		this.operatorID = operatorID;
	}
	
	/**
	 * This method gets the enum cinema class.
	 *
	 * @return the cinema class
	 */
	// cinemaClass
	public CinemaClass getCinemaClass() {
		return cinemaClass;
	}
	
	/**
	 * This method sets the cinema class.
	 *
	 * @param cinemaClass the new cinema class
	 */
	public void setCinemaClass(CinemaClass cinemaClass) {
		this.cinemaClass = cinemaClass;
	}
	
	/**
	 * This method gets the cinema operator object.
	 *
	 * @return the cinema operator
	 */
	public CinemaOperator getCinemaOperator()
	{
		return cinemaOperator;
	}
	
	/**
	 * This method sets the cinema operator.
	 *
	 * @param cinemaOperator the new cinema operator
	 */
	public void setCinemaOperator(CinemaOperator cinemaOperator)
	{
		this.cinemaOperator = cinemaOperator;
	}

	/**
	 * This method gets the base price.
	 *
	 * @return the base price
	 */
	public Double getBasePrice() {
		return basePrice;
	}
	
	/**
	 * This method sets the base price.
	 *
	 * @param basePrice the new base price
	 */
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	// showTime
	// public void addShowTime(ShowTime showTime) {
	// 	showTimes.add(showTime);
	// }
	// public void removeShowTime(ShowTime showTime) {
	// 	showTimes.remove(showTime);
	// }
	// public void setShowTimes(List<ShowTime> showTimes) {
	// 	this.showTimes = showTimes;
	/**
	 * This method gets the show times.
	 *
	 * @return the show times
	 */
	// }
	public List<ShowTime> getShowTimes() {
		return showTimes;
	}
	
	/**
	 * This method generates the show times for the specific movie object.
	 *
	 * @param input_movie the input movie 
	 * @return the show times
	 */
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
	
	/**
	 * This method gets the seat list.
	 *
	 * @return the seat list
	 */
	// baasePrice
	public List<Seat> getSeatList() {
		return seats;
	}
	
	/**
	 * This method sets the seat list.
	 *
	 * @param seats the new seat list
	 */
	public void setSeatList(List<Seat> seats) {
		this.seats = seats;
	}
	
	/**
	 * This method gets the specific seat.
	 *
	 * @param seatID the seat ID
	 * @return the specific seat
	 */
	// seat
	public Seat getSpecificSeat(Integer seatID) {
		for(Seat seat: seats) {
			if(seat.getSeatID()==seatID) {
				return seat;
			}
		}
		return null;
	}
	
	/**
	 * This method gets the specific seat based on the seat id set by its location from the row and column.
	 *
	 * @param seatRow the seat row
	 * @param seatCol the seat column
	 * @return the specific seat
	 */
	public Seat getSpecificSeat(Integer seatRow, Integer seatCol) {
		Integer seatID = this.getNoOfSeatColumn()*seatRow + seatCol;
		for(Seat seat: seats) {
			if(seat.getSeatID()==seatID) {
				return seat;
			}
		}
		return null;
	}
	
	/**
	 * This method gets the total number of seats.
	 *
	 * @return the total no of seats
	 */
	// getTotalNoOfSeats
	private Integer getTotalNoOfSeats() {
		return this.getNoOfSeatColumn()*this.getNoOfSeatRow();
	}
	
	/**
	 * This method sets the number of rows.
	 *
	 * @param no_of_rows the new no of seat row
	 */
	// no_of_rows
	private void setNoOfSeatRow(int no_of_rows) {
		this.no_of_rows = no_of_rows;
	}
	
	/**
	 * This method gets the number of seats' rows.
	 *
	 * @return the no of seat row
	 */
	public int getNoOfSeatRow() {
		return no_of_rows;
	}
	
	/**
	 * This method sets the number of columns.
	 *
	 * @param no_of_columns the new no of seat column
	 */
	// no_of_columns
	private void setNoOfSeatColumn(int no_of_columns) {
		this.no_of_columns = no_of_columns;
	}
	
	/**
	 * This method sets the number of seats' columns.
	 *
	 * @return the no of seat column
	 */
	public int getNoOfSeatColumn() {
		return no_of_columns;
	}
	
	// initializeSeatsList
//	public void initializeSeatsList(Integer no_of_columns, Integer no_of_rows) {
//		if ((no_of_columns<1) || (no_of_rows<1)) {
//			return; // TO-DO -> Throw Exception
//		}
//		this.setNoOfSeatColumn(no_of_columns);
//		this.setNoOfSeatRow(no_of_rows);
//		
//		this.seats = new ArrayList<Seat>(this.getTotalNoOfSeats());
//		for (int row=1; row<=this.getNoOfSeatRow(); row++) {
//			for (int col=1; col<=this.getNoOfSeatColumn(); col++) {
//				Integer seatID = this.getNoOfSeatColumn()*row + col;
//				this.seats.add(new Seat(seatID, this.getCinemaID(), this.getOperatorID()));
//			}
//		}
//	}
	
	
	/**
	 * Prints the cinema seats specifically from the show time.
	 *
	 * @param st the st
	 */
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
	
	/**
	 * Prints the cinema seats for all show times to show the cinema layout.
	 */
	public void printCinemaSeatsForAllShowTimes() {
		System.out.println();
		System.out.println("[Cinema Operator " + this.operatorID + " | Cinema " + this.getCinemaID() + " | " + this.getCinemaName() + "]");
		for (ShowTime st : showTimes) {
			this.printCinemaSeatsSpecificShowTime(st);
			System.out.println("\n");
		}
	}
}
