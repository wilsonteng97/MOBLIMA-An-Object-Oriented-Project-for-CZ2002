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
	private int row = 8;
	private int col = 16;
	private List<MovieTicket> movieTickets;
	private Seat[][] cinemaLayout;

	public ShowTime()
	{
		cinemaLayout = new Seat[row][col];
		setupTheSeat();
	}

	public void setupTheSeat()
	{
		int id = 1;
		for(int i = 1; i<=row; i++)
		{
			for (int j =1; j<=col; j++)
			{
				cinemaLayout[i-1][j-1] = new Seat(id,i,j, this);
				id++;
				System.out.println(cinemaLayout[i-1][j-1].getSeatID());
			}
		}
	}
	
	public ShowTime(Cinema cinema, Movie movie, Date time) {
		this.showTimeID = -1;
		this.cinema = cinema;
		this.movie = movie;
		this.time = time;
		this.cinemaLayout = new Seat[row][col];
		movieTickets = new ArrayList<MovieTicket>();
		setupTheSeat();
	}
	public void setSeats()
	{
		cinemaLayout = new Seat[8][16];
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
 		
 		return cinemaLayout[row-1][col-1];
 	}
 	
 	public Seat[][] getSeats()
 	{
		// if (cinemaLayout==null) setupTheSeat();
 		return cinemaLayout;
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