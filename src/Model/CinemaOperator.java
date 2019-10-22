/**
 * 
 */
package Model;

/**
 * @author wilso
 *
 */
public class CinemaOperator {
	private final String cinemaoperatorname;
	private final int numofcinemas;
	private final Cinema[] cinemas;
	private final Movie[] moviesshowing;
	
	public CinemaOperator(String cinemaoperatorname, int numofcinemas, Movie[] moviesshowing) {
		this.cinemaoperatorname = cinemaoperatorname;
		this.numofcinemas = numofcinemas;
		
		this.cinemas = new Cinema[numofcinemas];
		for (int i=0; i<this.numofcinemas; i++) {
			this.cinemas[i] = new Cinema(i+1, 10, 15, 10.0, false, false);
		}
		
		this.moviesshowing = new Movie[];
		this.moviesshowing = moviesshowing;
	}

	/**
	 * @return the cinemaoperatorname
	 */
	public String getCinemaOperatorName() {
		return cinemaoperatorname;
	}
	
	/**
	 * @return the numofcinemas
	 */
	public String getNumOfCinemas() {
		return numofcinemas;
	}
}
