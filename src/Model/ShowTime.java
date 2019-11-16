package Model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class ShowTime implements Serializable {
	
	private Integer showTimeID;
	private Cinema cinema;
	private Movie movie;
	private Date time;
	private Seat[][] seats;
	private int row = 8;
	private int col = 16;
	private List<MovieTicket> movieTickets;
	
	public ShowTime()
	{
		seats = new Seat[8][16];
	}
	
	public ShowTime(Cinema cinema, Movie movie, Date time) {
		this.showTimeID = -1;
		this.cinema = cinema;
		this.movie = movie;
		this.time = time;
		
		movieTickets = new ArrayList<MovieTicket>();
	}
	
	
	// showTimeID
	public int getShowTimeID() {
		return showTimeID;
	}
	public void setShowTimeID(int showTimeID) {
		this.showTimeID = showTimeID;
	}
	
	// cinema
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	// movie
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	// time
	public Date getTime() {
 		return time;
 	}
 	public void setTime(Date time) {
 		this.time = time;
 	}
 
 	public Seat getSeatAt(int row, int col)
 	{
 		if(row > 8 || col > 16 || row <1 || col <1)
 		{
 			return null;
 		}
 		
 		return seats[row-1][col-1];
 	}
 	
 	public Seat[][] getSeats()
 	{
 		return seats;
 	}
 	
 	// movieTickets
 	public void addMovieTicket(MovieTicket movieTicket) {
 		movieTickets.add(movieTicket);
 	}
 	public void removeMovieTicket(MovieTicket movieTicket) {
 		movieTickets.remove(movieTicket);
 	}
 	public List<MovieTicket> getMovieTickets() {
 		return movieTickets;
 	}
 	
 	// getShowTimeString
 	public String getShowTimeString() {
 		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");  
 		String strDate = dateFormat.format(this.time); 
 		return strDate;
 	}
 	// Format can be "yyyy-mm-dd hh:mm:ss"
 	public String getShowTimeString(String SpecificDateFormat) {
 		DateFormat dateFormat = new SimpleDateFormat(SpecificDateFormat);  
 		String strDate = dateFormat.format(this.time); 
 		return strDate;
 	}
}