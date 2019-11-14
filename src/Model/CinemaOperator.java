/**
 * 
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Movie;
import Model.ShowTime;
import Model.Enums.CinemaClass;
import Model.Cinema;

/**
 * @author wilso
 *
 */
public class CinemaOperator implements Serializable{
	private Integer operatorID;
	private String operatorName;
	private String location;
	private Integer numOfNormalCinemas;
	private Integer numOfPlatinumCinemas;
	private List<Cinema> cinemas;

	
	public CinemaOperator(Integer operatorID, String operatorName, String location) {
		this.operatorID = operatorID;
		this.operatorName = operatorName;
		this.location = location;
		this.cinemas = new ArrayList<Cinema>();
		this.numOfNormalCinemas=0;
		this.numOfPlatinumCinemas=0;
	}

	// operator_ID
	public int getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}
	
	// operatorName 
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	// location 
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	// numOfCinemas
	private void setNumOfNormalCinemas(Integer numOfNormalCinemas) {
		this.numOfNormalCinemas = numOfNormalCinemas;
	}
	private void setNumOfPlatinumCinemas(Integer numOfPlatinumCinemas) {
		this.numOfPlatinumCinemas = numOfPlatinumCinemas;
	}
	public Integer getNumOfCinemas() {
		return numOfNormalCinemas + numOfPlatinumCinemas;
	}
	public Integer getNumOfCinemas(CinemaClass cinemaClass) {
		switch(cinemaClass) {
		case NORMAL:
			return this.numOfNormalCinemas;
		case PLATINUM:
			return this.numOfPlatinumCinemas;
		default:
			return 0;
		}
	}

	public void addCinema(CinemaClass cinemaClass) {		
		String cinemaID, cinemaName;
		switch(cinemaClass) {
		case NORMAL:
			this.numOfNormalCinemas++;
			cinemaID = this.numOfNormalCinemas + "N";
			cinemaName = this.getOperatorName() + this.getLocation().toUpperCase();
			//cinemas.add(new Cinema(cinemaID, cinemaName, this.getOperatorID(), CinemaClass.NORMAL));
			break;
		case PLATINUM:
			this.numOfPlatinumCinemas++;
			cinemaID = this.numOfPlatinumCinemas + "P";
			cinemaName = this.getOperatorName() + this.getLocation().toUpperCase();
			//cinemas.add(new Cinema(cinemaID, cinemaName, this.getOperatorID(), CinemaClass.PLATINUM));		break;
		default:
			break; // TO-DO throw exception
		}
	}
	public void removeCinema(Cinema cinema) {
		switch(cinema.getCinemaClass()) {
		case NORMAL:
			this.numOfNormalCinemas--;
			break;
		case PLATINUM:
			this.numOfPlatinumCinemas--;
			break;
		default:
			break; // TO-DO throw exception
		}
		cinemas.remove(cinema);
	}
	
	// cinema
	public Cinema getCinema(String cinemaID) {
		for (Cinema c : cinemas) {
			if (c.getCinemaID()==cinemaID) {
				return c;
			}
		}
		return null; // TO-DO throw exception
	}
	
	// cinemas
	public List<Cinema> getCinemas() {
		return cinemas;
	}
	public List<Cinema> getCinemas(Movie input_movie) {
		List<Cinema> cinemas_with_input_movie = new ArrayList<Cinema>();
		
		for(Cinema c : cinemas) {
			if(c.getShowTimes(input_movie)!=null) {
				cinemas_with_input_movie.add(c);
			}
		}
		return cinemas_with_input_movie;
	}
	
	// initializeCinemasList
		public void initializeCinemasList(Integer numOfNormalCinemas, Integer numOfPlatinumCinemas) {
			if ((numOfNormalCinemas<0) || (numOfPlatinumCinemas<0)) {
				return; // TO-DO -> Throw Exception
			}
			
			this.setNumOfNormalCinemas(numOfNormalCinemas); this.setNumOfPlatinumCinemas(numOfPlatinumCinemas);
			this.cinemas = new ArrayList<Cinema>(this.getNumOfCinemas());
			// initialize Normal Cinemas
			for (int normalCinema=1; normalCinema<=this.getNumOfCinemas(CinemaClass.NORMAL); normalCinema++) {
				this.addCinema(CinemaClass.NORMAL);
			}
			// initialize Platinum Cinemas
			for (int platinumCinema=1; platinumCinema<=this.getNumOfCinemas(CinemaClass.PLATINUM); platinumCinema++) {
				this.addCinema(CinemaClass.PLATINUM);
			}
		}

	// returns all the movies showing for this particular operator
	public List<Movie> getMovies() {
		List<Movie> movies_showing_for_this_operator = new ArrayList<Movie>();
		
		for(Cinema c : cinemas) {
			for(ShowTime st : c.getShowTimes()) {
				if(!movies_showing_for_this_operator.contains(st.getMovie())) {
					movies_showing_for_this_operator.add(st.getMovie());
				}
			}
		}
		return movies_showing_for_this_operator;
	}
	

}
