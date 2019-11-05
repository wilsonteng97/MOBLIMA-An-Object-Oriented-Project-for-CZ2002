/**
 * 
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Movie;
import Model.ShowTime;

import Model.Cinema;

/**
 * @author wilso
 *
 */
public class CinemaOperator implements Serializable{
	private Integer operatorID;
	private String operatorName;
	private String location;
	private Integer numOfCinemas;
	private List<Cinema> cinemas;

	
	public CinemaOperator(String operatorName, String location) {
		this.operatorID = -1;
		this.operatorName = operatorName;
		this.location = location;
		this.cinemas = new ArrayList<Cinema>();
		this.numOfCinemas = 0;
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
	public Integer getNumOfCinemas() {
		return numOfCinemas;
	}
	public void addCinema(Cinema cinema) {
		cinemas.add(cinema);
		this.numOfCinemas++;
	}
	public void removeCinema(Cinema cinema) {
		cinemas.remove(cinema);
		this.numOfCinemas--;
	}
	
	// cinemas
	public List<Cinema> getCinemas() {
		return cinemas;
	}
	public List<Cinema> getCinemas(Movie input_movie) {
		List<Cinema> cinemas_with_input_movie = new ArrayList<Cinema>();
		
		for(Cinema c: cinemas) {
			if(c.getShowTimes(input_movie)!=null) {
				cinemas_with_input_movie.add(c);
			}
		}
		return cinemas_with_input_movie;
	}
	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
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
