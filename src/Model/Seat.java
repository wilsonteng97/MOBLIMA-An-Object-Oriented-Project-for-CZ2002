/**
 * 
 */
package Model;

/**
 *
 */
import java.io.Serializable;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class Seat.
 * This class contains the information of the seat in the cinema.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Seat implements Serializable {
	
	/** The seat ID. SeatID starts from 1, starts from the
	 * row nearest to the cinema. */
	private Integer seatID; 
	/** The cinema ID. */
	private String cinemaID;
	/** The number of seats in a column. */
	private int seatCol;
	/** The number of seats in a row. */
	private int seatRow;
	/** The cinema operator ID. */
	private Integer operatorID;
	/** The particular movie's show time. */
	private ShowTime showtime;
	/** The boolean expression to check if the seat is occupied. */
	private Boolean occupied;	


	/**
	 * Instantiates a new seat.
	 *
	 * @param seatID the seat ID
	 * @param seatCol the number of seats in a column
	 * @param seatRow the number of seats in a row
	 * @param showtime the show time
	 */
	public Seat(Integer seatID, int seatRow, int seatCol, ShowTime showtime) {
		this.seatID = seatID;
		this.seatCol = seatCol;
		this.seatRow = seatRow;
		this.showtime = showtime;
		this.occupied = false;
	}
	
	/**
	 * Gets the seat ID.
	 *
	 * @return the seat ID
	 */
	// seatID
	public int getSeatID() {
		return seatID;
	}
	
	/**
	 * Sets the seat ID.
	 *
	 * @param seatID the new seat ID
	 */
	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	
	/**
	 * Gets the number of seats in a row.
	 *
	 * @return the row
	 */
	// seat
	public int getRow() {
		return seatRow;
	}
	
	/**
	 * Sets the number of seats in a row.
	 *
	 * @param seatRow the new row
	 */
	public void setRow(int seatRow) {
		this.seatRow = seatRow;
	}
	
	/**
	 * Gets the number of seats in a column.
	 *
	 * @return the col
	 */
	public int getCol() {
		return seatCol;
	}
	
	/**
	 * Sets the number of seats in a column.
	 *
	 * @param seatCol the new col
	 */
	public void setCol(int seatCol) {
		this.seatCol = seatCol;
	}
	
	/**
	 * Gets the cinema ID.
	 *
	 * @return the cinema ID
	 */
	// cinemaID
	public String getCinemaID() {
		return cinemaID;
	}
	
	/**
	 * Sets the cinema ID.
	 *
	 * @param cinemaID the new cinema ID
	 */
	public void setCinemaID(String cinemaID) {
		this.cinemaID = cinemaID;
	}
	
	/**
	 * Gets the movie's show time.
	 *
	 * @return the showtime
	 */
	public ShowTime getShowtime(){
		return showtime;
	}
	
	/**
	 * Sets the movie's show time.
	 *
	 * @param showtime the new showtime
	 */
	public void setShowtime(ShowTime showtime){
		this.showtime = showtime;
	}
	
	/**
	 * Gets the cinema operator ID.
	 *
	 * @return the operator ID
	 */
	// operatorID
	public Integer getOperatorID() {
		return operatorID;
	}
	
	/**
	 * Sets the cinema operator ID.
	 *
	 * @param operatorID the new operator ID
	 */
	public void setOperatorID(Integer operatorID) {
		this.operatorID = operatorID;
	}
	
	// occupied
	/**
	 * Boolean expression to check if the seat is occupied.
	 *
	 * @return true, if is occupied at
	 */
	// return boolean of whether seat is occupied at input showTime
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * Sets whether the seat is occupied.
	 *
	 * @param value the new occupied value
	 */
	public void setOccupied(boolean value) {
		occupied = value;
	}
	
	/**
	 * Prints the seat based on the show time.
	 *
	 * @param showTime the show time
	 */
	// printSeat
	public void printSeat() {
		String symbolToPrint = this.isOccupied() ? "X" : " ";
		System.out.print("[" + symbolToPrint + "] ");
	}
}

