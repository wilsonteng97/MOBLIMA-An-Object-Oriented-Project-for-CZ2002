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
	
	private Integer seatID;
	private Integer seatNo;
	private String seatRow;
	private Cinema cinema;
	private Hashtable<ShowTime, Boolean> occupied;
	
	public Seat(int seatNo, String seatRow, Cinema cinema) {
		this.seatID = -1;
		this.seatNo = seatNo;
		this.seatRow = seatRow;
		this.cinema = cinema;
		
		this.occupied = new Hashtable<ShowTime, Boolean>();
	}
	
	// seatID
	public int getSeatID() {
		return seatID;
	}
	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	
	// seatNo
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	// seatRow
	public String getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}
	
	// cinema
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	// occupied
	// return boolean of whether seat is occupied at input showTime
	public boolean isOccupiedAt(ShowTime showTime) {
		return occupied.get(showTime);
	}
	public void setOccupiedAt(ShowTime showTime, boolean value) {
		occupied.put(showTime, value);
	}
}

