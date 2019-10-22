/**
 * 
 */
package Model;
/**
 * @author wilso
 *
 */
public class Cinema {
	private final int cinemaid;
	private final int row;
	private final int col;
	private final double baseprice;
	private final boolean isPlatinum;
	private final boolean is3D;

	private final int numofseats;
	private int numemptyseats;
	private final Seat[] seats;

	public Cinema(int cinemaid, int row, int col,  double baseprice, boolean isPlatinum, boolean is3D) {
		this.cinemaid = cinemaid;
		this.row = row;
		this.col = col;
		this.baseprice = baseprice;
		this.isPlatinum = isPlatinum;
		this.is3D = is3D;
		
		this.numofseats = row * col;
		this.seats = new Seat[numofseats];
		for (int i=0; i<this.numofseats; i++) {
			this.seats[i] = new Seat(i+1);
		}
		this.setNumemptyseats(numofseats);
	}

	/**
	 * @return the cinemaid
	 */
	public int getCinemaid() {
		return cinemaid;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @return the baseprice
	 */
	public double getBaseprice() {
		return baseprice;
	}

	/**
	 * @return the isPlatinum
	 */
	public boolean isPlatinum() {
		return isPlatinum;
	}

	/**
	 * @return the is3D
	 */
	public boolean isIs3D() {
		return is3D;
	}

	/**
	 * @return the numemptyseats
	 */
	public int getNumemptyseats() {
		return numemptyseats;
	}

	/**
	 * @param numemptyseats the numemptyseats to set
	 */
	public void setNumemptyseats(int numemptyseats) {
		this.numemptyseats = numemptyseats;
	}
	
	
}
