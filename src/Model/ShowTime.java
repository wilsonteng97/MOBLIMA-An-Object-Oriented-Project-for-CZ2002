package Model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowTime.
 * This class shows the information on the show time.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ShowTime implements Serializable {
	
	/** The show time ID. */
	private Integer showTimeID;
	/** The show time at the particular cinema. */
	private Cinema cinema;
	/** The show time for the particular movie. */
	private Movie movie;
	/** The time of the show time object. */
	private Date time;
	/** The allocated seats associated with the show time. */
	private Seat[][] seats;
	/** The number of seats in a row. */
	private int row = 8;
	/** The number of seats in a column. */
	private int col = 16;
	/** The movie tickets. */
	private List<MovieTicket> movieTickets;
	/** The cinema layout based on number of rows and columns. */
	private Seat[][] cinemaLayout;

	/**
	 * Instantiates a new show time and the cinema based on its layout.
	 */
	public ShowTime()
	{
		cinemaLayout = new Seat[row][col];
		setupTheSeat();
	}

	/**
	 * Setting up the seat based on the cinema layout.
	 */
	public void setupTheSeat()
	{
		int id = 1;
		for(int i = 1; i<row; i++)
		{
			for (int j =1; j<col; j++)
			{
				cinemaLayout[i][j] = new Seat(id,i,j, this);
				id++;
			}
		}
	}
	
	/**
	 * Instantiates a new show time.
	 *
	 * @param cinema the cinema
	 * @param movie the movie
	 * @param time the time
	 */
	public ShowTime(Cinema cinema, Movie movie, Date time) {
		this.showTimeID = -1;
		this.cinema = cinema;
		this.movie = movie;
		this.time = time;
		this.seats = new Seat[row][col];
		movieTickets = new ArrayList<MovieTicket>();
	}
	
	/**
	 * Sets the seats.
	 */
	public void setSeats()
	{
		seats = new Seat[8][16];
	}
	
	/**
	 * Gets the show time ID.
	 *
	 * @return the show time ID
	 */
	// showTimeID
	public int getShowTimeID() {
		return showTimeID;
	}
	
	/**
	 * Sets the show time ID.
	 *
	 * @param showTimeID the new show time ID
	 */
	public void setShowTimeID(int showTimeID) {
		this.showTimeID = showTimeID;
	}
	
	/**
	 * Gets the cinema for the associated show time.
	 *
	 * @return the cinema
	 */
	// cinema
	public Cinema getCinema() {
		return cinema;
	}
	
	/**
	 * Sets the cinema for the associated show time.
	 *
	 * @param cinema the new cinema
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	/**
	 * Gets the movie for the associated show time.
	 *
	 * @return the movie
	 */
	// movie
	public Movie getMovie() {
		return movie;
	}
	
	/**
	 * Sets the movie for the associated show time.
	 *
	 * @param movie the new movie
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	/**
	 * Gets the time of the show time object.
	 *
	 * @return the time
	 */
	// time
	public Date getTime() {
 		return time;
 	}
 	
	 /**
	  * Sets the time of the show time object.
	  *
	  * @param time the new time
	  */
	 public void setTime(Date time) {
 		this.time = time;
 	}
 
 	/**
	  * Gets the seat and check that the seat is within the actual layout of the cinema.
	  *
	  * @param row the row
	  * @param col the col
	  * @return the seat at
	  */
	 public Seat getSeatAt(int row, int col)
 	{
 		if(row > 8 || col > 16 || row <1 || col <1)
 		{
 			return null;
 		}
 		return seats[row-1][col-1];
 	}
 	
 	/**
	  * Gets the seats.
	  *
	  * @return the seats
	  */
	 public Seat[][] getSeats()
 	{
 		return seats;
 	}
 	
 	/**
	  * Adds the movie ticket object from the ticket list.
	  *
	  * @param movieTicket the movie ticket
	  */
	 // movieTickets
 	public void addMovieTicket(MovieTicket movieTicket) {
 		movieTickets.add(movieTicket);
 	}
 	
	 /**
	  * Removes the movie ticket object from the ticket list.
	  *
	  * @param movieTicket the movie ticket
	  */
	 public void removeMovieTicket(MovieTicket movieTicket) {
 		movieTickets.remove(movieTicket);
 	}
 	
	 /**
	  * Gets the movie tickets from the ticket list.
	  *
	  * @return the movie tickets
	  */
	 public List<MovieTicket> getMovieTickets() {
 		return movieTickets;
 	}
 	
 	/**
	  * Method to get the show time in string.
	  *
	  * @return the show time string
	  */
	 // getShowTimeString
 	public String getShowTimeString() {
 		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");  
 		String strDate = dateFormat.format(this.time); 
 		return strDate;
 	}
 	
	 /**
	  * Method to get the show time from string.
	  *
	  * @param SpecificDateFormat the specific date format
	  * @return the show time string
	  */
	 // Format can be "yyyy-mm-dd hh:mm:ss"
 	public String getShowTimeString(String SpecificDateFormat) {
 		DateFormat dateFormat = new SimpleDateFormat(SpecificDateFormat);  
 		String strDate = dateFormat.format(this.time); 
 		return strDate;
 	}
}