/**
 * 
 */
package Model;

/**
 * @author wilso
 *
 */
import java.io.Serializable;
import java.util.Hashtable;

@SuppressWarnings("serial")
public class Seat implements Serializable {
	
	private Integer seatID; // SeatID starts from 1, starts from the row nearest to the cinema.
	private String cinemaID;
	private int seatCol = 9;
	private int seatRow = 18;
	private Integer operatorID;
	private ShowTime showtime;
	private Boolean occupied;	

	public Seat(Integer seatID, int seatCol, int seatRow, ShowTime showtime) {
		this.seatID = seatID;
		this.seatCol = seatCol;
		this.seatRow = seatRow;
		this.showtime = showtime;
		this.occupied = false;
	}

	public void setupTheSeat()
	{

	}
	
	// seatID
	public int getSeatID() {
		return seatID;
	}
	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	
	// seat
	public int getRow() {
		return seatRow;
	}
	public void setRow(int seatRow) {
		this.seatRow = seatRow;
	}
	public int getCol() {
		return seatCol;
	}
	public void setCol(int seatCol) {
		this.seatCol = seatCol;
	}
	
	// cinemaID
	public String getCinemaID() {
		return cinemaID;
	}
	public void setCinemaID(String cinemaID) {
		this.cinemaID = cinemaID;
	}
	
	public ShowTime getShowtime()
	{
		return showtime;
	}
	
	// operatorID
	public Integer getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(Integer operatorID) {
		this.operatorID = operatorID;
	}
	
	// occupied
	// return boolean of whether seat is occupied at input showTime
	public boolean isOccupiedAt() {
		return occupied;
	}
	public void setOccupiedAt(boolean value) {
		occupied = value;
	}
	
	// printSeat
	public void printSeat(ShowTime showTime) {
		String symbolToPrint = this.isOccupiedAt() ? "X" : " ";
		System.out.print("[" + symbolToPrint + "] ");
	}
}

