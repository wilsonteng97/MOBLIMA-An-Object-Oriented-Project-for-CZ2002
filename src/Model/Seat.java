/**
 * 
 */
package Model;
import java.util.Date;
/**
 * @author wilso
 *
 */
public class Seat {
	private final int seatid;
	private boolean booked;
	
	public Seat(int seatid) {
		this.seatid = seatid;
		this.setBooked(false);
	}

	/**
	 * @return the seatid
	 */
	public int getSeatid() {
		return seatid;
	}

	/**
	 * @return the booked
	 */
	public boolean isBooked() {
		return booked;
	}

	/**
	 * @param booked the booked to set
	 */
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
}
