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

public class Seat implements Serializable {
	
	private Integer seatID; // SeatID starts from 1, starts from the row nearest to the cinema.
	private String cinemaID;
	private int seatNo;
	private int seatRow;
	private Integer operatorID;
	private ShowTime showtime;
	private Hashtable<ShowTime, Boolean> occupied;
	
	public Seat(Integer seatID, int seatNo, int seatRow, ShowTime showtime) {
		this.seatID = seatID;
		this.seatNo = seatNo;
		this.seatRow = seatRow;
		this.showtime = showtime;
		
		this.occupied = new Hashtable<ShowTime, Boolean>();
	}
	
	// seatID
	public int getSeatID() {
		return seatID;
	}
	public void setSeatID(int seatID) {
		this.seatID = seatID;
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
	public boolean isOccupiedAt(ShowTime showTime) {
		return occupied.get(showTime);
	}
	public void setOccupiedAt(ShowTime showTime, boolean value) {
		occupied.put(showTime, value);
	}
	
	// printSeat
	public void printSeat(ShowTime showTime) {
		String symbolToPrint = this.isOccupiedAt(showTime) ? "X" : " ";
		System.out.print("[" + symbolToPrint + "] ");
	}
}

