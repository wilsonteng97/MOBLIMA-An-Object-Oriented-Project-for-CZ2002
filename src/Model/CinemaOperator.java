package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.Movie;
import Model.ShowTime;
import Model.Enums.CinemaClass;
import Model.Cinema;

/**
 * The Class CinemaOperator.
 * This class contains the information of the cinema operator.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CinemaOperator implements Serializable{
	
	/** The operator ID. */
	private Integer operatorID;
	/** The operator name. */
	private String operatorName;
	/** The number of normal cinemas in the cinema oerator. */
	private Integer numOfNormalCinemas;
	/** The number of platinum cinemas in the cinema oerator. */
	private Integer numOfPlatinumCinemas;
	/** The cinemas in the cinema oerator. */
	private ArrayList<Cinema> cinemas;
	/** The default base price for the cinema operator. */
	private static Double DEFAULT_BASEPRICE = 10.0;
	/** The default platinum modifier for the cinema operator. */
	private static Double DEFAULT_PLATINUM_MODIFIER = 1.5;

	
	/**
	 * Instantiates a new cinema operator.
	 *
	 * @param operatorID is the operator ID of cinema oerator
	 * @param operatorName is the operator name of cinema oerator
	 */
	public CinemaOperator(Integer operatorID, String operatorName) {
		this.operatorID = operatorID;
		this.operatorName = operatorName;
		this.cinemas = new ArrayList<Cinema>();
		this.numOfNormalCinemas=0;
		this.numOfPlatinumCinemas=0;
	}

	/**
	 * This method gets the operator ID.
	 *
	 * @return the operator ID
	 */
	// operator_ID
	public int getOperatorID() {
		return operatorID;
	}
	
	/**
	 * This method sets the operator ID.
	 *
	 * @param operatorID the new operator ID
	 */
	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}
	
	/**
	 * This method gets the operator name.
	 *
	 * @return the operator name
	 */
	// operatorName 
	public String getOperatorName() {
		return operatorName;
	}
	
	/**
	 * This method sets the operator name.
	 *
	 * @param operatorName the new operator name
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	
	/**
	 * This method sets the number of normal cinemas.
	 *
	 * @param numOfNormalCinemas the new number of normal cinemas
	 */
	// numOfCinemas
	private void setNumOfNormalCinemas(Integer numOfNormalCinemas) {
		this.numOfNormalCinemas = numOfNormalCinemas;
	}
	
	/**
	 * This method sets the number of platinum cinemas.
	 *
	 * @param numOfPlatinumCinemas the new number of platinum cinemas
	 */
	private void setNumOfPlatinumCinemas(Integer numOfPlatinumCinemas) {
		this.numOfPlatinumCinemas = numOfPlatinumCinemas;
	}
	
	/**
	 * This method gets the number of cinemas.
	 *
	 * @return the number of cinemas
	 */
	public Integer getNumOfCinemas() {
		return numOfNormalCinemas + numOfPlatinumCinemas;
	}
	
	/**
	 * This method gets the number of cinemas based on the enum cinema class.
	 *
	 * @param cinemaClass the cinema class
	 * @return the number of cinemas
	 */
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

	/**
	 * This method adds the ticket base price based on enum cinema class.
	 *
	 * @param cinemaClass the cinema class
	 * @param basePrice the base price
	 */
	public void addCinema(CinemaClass cinemaClass, Double basePrice) {		
		String cinemaID, cinemaName;
		switch(cinemaClass) {
		case NORMAL:
			this.numOfNormalCinemas++;
			cinemaID = this.numOfNormalCinemas + "N";
			cinemaName = this.getOperatorName() + numOfNormalCinemas;
			cinemas.add(new Cinema(cinemaID, cinemaName, CinemaClass.NORMAL, this, basePrice));
			break;
		case PLATINUM:
			this.numOfPlatinumCinemas++;
			cinemaID = this.numOfPlatinumCinemas + "P";
			cinemaName = this.getOperatorName() + numOfPlatinumCinemas;
			cinemas.add(new Cinema(cinemaID, cinemaName, CinemaClass.PLATINUM, this, basePrice));
			break;
		default:
			break; // TO-DO throw exception
		}
	}
	
	/**
	 * This method removes the cinema object from the cinema operator.
	 *
	 * @param cinema the cinema
	 */
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
	
	/**
	 * This method gets the cinema object.
	 *
	 * @param cinemaID the cinema ID
	 * @return the cinema
	 */
	// cinema
	public Cinema getCinema(String cinemaID) {
		for (Cinema c : cinemas) {
			if (c.getCinemaID()==cinemaID) {
				return c;
			}
		}
		return null; // TO-DO throw exception
	}
	
	/**
	 * This method gets the cinemas.
	 *
	 * @return the cinemas
	 */
	// cinemas
	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}
	
	/**
	 * This method gets the cinemas based on the movie being screened at these cinemas.
	 *
	 * @param input_movie the input movie
	 * @return the cinemas
	 */
	public List<Cinema> getCinemas(Movie input_movie) {
		List<Cinema> cinemas_with_input_movie = new ArrayList<Cinema>();
		
		for(Cinema c : cinemas) {
			if(c.getShowTimes(input_movie)!=null) {
				cinemas_with_input_movie.add(c);
			}
		}
		return cinemas_with_input_movie;
	}
	
	/**
	 * This method initialise the cinemas list.
	 *
	 * @param numOfNormalCinemas the num of normal cinemas
	 * @param numOfPlatinumCinemas the num of platinum cinemas
	 */
	// initializeCinemasList
		public void initializeCinemasList(Integer numOfNormalCinemas, Integer numOfPlatinumCinemas) {
			if ((numOfNormalCinemas<0) || (numOfPlatinumCinemas<0)) {
				return; // TO-DO -> Throw Exception
			}
			
			this.setNumOfNormalCinemas(numOfNormalCinemas); this.setNumOfPlatinumCinemas(numOfPlatinumCinemas);
			this.cinemas = new ArrayList<Cinema>(this.getNumOfCinemas());
			// initialize Normal Cinemas
			for (int normalCinema=1; normalCinema<=this.getNumOfCinemas(CinemaClass.NORMAL); normalCinema++) {
				this.addCinema(CinemaClass.NORMAL, DEFAULT_BASEPRICE);
			}
			// initialize Platinum Cinemas
			for (int platinumCinema=1; platinumCinema<=this.getNumOfCinemas(CinemaClass.PLATINUM); platinumCinema++) {
				this.addCinema(CinemaClass.PLATINUM, DEFAULT_BASEPRICE*DEFAULT_PLATINUM_MODIFIER);
			}
		}

	/**
	 * This method gets the movies.
	 *
	 * @return the movies
	 */
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
