package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.StringBuilder;

import Model.Movie;
import Model.ShowTime;

import Model.Enums.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Movie.
 * This class contains the information with regards to the movie.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Movie implements Serializable{
	
	/** The movie ID. */
	private Integer movieID;
	/** The title of movie. */
	private String title;
	/** The age restriction classification tagged to movie. */
	private AgeRestriction ageRestriction;
	/** The type of screening of the movie at the cinema. */
	private MovieType type;
	/** The status of the movie with regards to its current availability. */
	private ShowingStatus status;
	/** The opening date of the movie. */
	private String opening;
	/** The runtime of the entire movie. */
	private String runtime;
	/** The synopsis of the movie. */
	private String synopsis;
	/** The boolean expression if the movie is a blockbuster. */
	private Boolean blockBuster;
	/** The total sales of the movie collected to date. */
	private Double totalSales = 0.0;
	/** The movie director. */
	private String director;
	/** The casts of the movie. */
	private ArrayList<String> cast;
	/** The show times of the movie. */
	private ArrayList<ShowTime> showTimes;
	/** The review list of the movie. */
	private ArrayList<Review> reviewList;

	
	/**
	 * Instantiates a new movie. The default ID is at -1.
	 *
	 * @param title the title
	 * @param ageRestriction the age restriction classification
	 * @param type the type of screening
	 * @param status the screening status
	 * @param opening the opening date
	 * @param director the director
	 * @param runtime the runtime
	 * @param synopsis the synopsis
	 * @param blockBuster the boolean expression to check if the movie is a blockbuster
	 * @param cast the casts of the movie
	 */
	public Movie(String title, AgeRestriction ageRestriction, MovieType type, ShowingStatus status, 
				String opening, String director, String runtime, String synopsis, Boolean blockBuster, ArrayList<String> cast) {
		this.movieID = -1;
		
		this.title = title;
		this.ageRestriction = ageRestriction;
		this.type = type;
		this.status = status;
		this.opening = opening;
		this.director = director;
		this.runtime = runtime;
		this.synopsis = synopsis;
		this.blockBuster = blockBuster;
		this.cast = cast;
		this.totalSales = 0.0;
		this.reviewList = new ArrayList<Review>();
	//	this.languageList = new ArrayList<String>();
	//	this.directorList = new ArrayList<String>();
	//	this.castList = new ArrayList<String>();
	//	this.showTimes = new ArrayList<ShowTime>();
	}
	
	/**
	 * Sets the movie ID.
	 *
	 * @param movieID the new movie ID
	 */
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	
	/**
	 * Gets the movie ID.
	 *
	 * @return the movie ID
	 */
	public Integer getMovieID() {
		return movieID;
	}
	
	/**
	 * Gets the title of movie.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title of movie.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the age restriction classification.
	 *
	 * @return the age restriction
	 */
	public AgeRestriction getAgeRestriction() {
		return ageRestriction;
	}
	
	/**
	 * Sets the age restriction classification.
	 *
	 * @param ageRestriction the new age restriction
	 */
	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}
	
	/**
	 * Sets the type of screening.
	 *
	 * @param type the new type
	 */
	public void setType(MovieType type) {
		this.type = type;
	}
	
	/**
	 * Gets the type of screening.
	 *
	 * @return the type
	 */
	public MovieType getType() {
		return type;
	}
	
	/**
	 * Gets the screening status.
	 *
	 * @return the status
	 */
	public ShowingStatus getStatus() {
		return status;
	}
	
	/**
	 * Sets the screening status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ShowingStatus status) {
		this.status = status;
	}
	
	/**
	 * Sets the opening date.
	 *
	 * @param opening the new opening
	 */
	public void setOpening(String opening) {
		this.opening = opening;
	}
	
	/**
	 * Gets the opening date.
	 *
	 * @return the opening
	 */
	public String getOpening() {
		return opening;
	}
	
	/**
	 * Sets the run time.
	 *
	 * @param runtime the new run time
	 */
	public void setRunTime(String runtime) {
		this.runtime = runtime;
	}
	
	/**
	 * Gets the run time.
	 *
	 * @return the run time
	 */
	public String getRunTime() {
		return runtime;
	}

	/**
	 * Sets the synopsis.
	 *
	 * @param synopsis the new synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	/**
	 * Gets the synopsis.
	 *
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}
	
	/**
	 * Checks if the movie is a blockbuster.
	 *
	 * @return true, if is block buster
	 */
	// blockBuster
	public boolean isBlockBuster(){
		return blockBuster;
	}
	
	/**
	 * Sets whether the movie is a blockbuster.
	 *
	 * @param blockBuster the new block buster
	 */
	public void setBlockBuster(Boolean blockBuster){
		this.blockBuster = blockBuster;
	}

	/**
	 * Gets the cast list.
	 *
	 * @return the cast
	 */
	public ArrayList<String> getCast()
	{
		return cast;
	}

	/**
	 * Sets the cast list.
	 *
	 * @param cast the new cast
	 */
	public void setCast(ArrayList<String> cast)
	{
		this.cast = cast;
	}

	/**
	 * Gets the total sales.
	 *
	 * @return the total sales
	 */
	public Double getTotalSales(){
		return totalSales;
	}
	
	/**
	 * Adds to the total sales of the movie.
	 *
	 * @param amount the amount
	 */
	public void addTotalSales(int amount){
		this.totalSales += amount;
	}
	
	/**
	 * Deduct the total sales from a specified amount if necessary.
	 *
	 * @param amount the amount
	 */
	public void minusTotalSales(Double amount){
		this.totalSales -= amount;
		if (this.totalSales<0) {
			totalSales=0.0;
		}
	}
	
	/** The movie sales comparator to sort the movie based on its total sales in descending order. */
	public static Comparator<Movie> movieSalesComparator = new Comparator<Movie>() {

		public int compare(Movie m1, Movie m2) {
			Double total_sales1 = m1.getTotalSales();
			Double total_sales2 = m2.getTotalSales();
		   return total_sales2.compareTo(total_sales1);
		}};
	
	// languageList
	// public List<String> getLanguageList() {
	// 	return languageList;
	// }
	// public void setLanguageList(ArrayList<String> languagelist) {
	// 	this.directorList = languagelist;
	// }
	
	/**
	 * Gets the director.
	 *
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	
	/**
	 * Sets the director.
	 *
	 * @param director the new director
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * Gets the cast list.
	 *
	 * @return the cast list
	 */
	// castList
	public List<String> getCastList() {
		return cast;
	}
	
	/**
	 * Sets the cast list.
	 *
	 * @param castlist the new castlist
	 */
	public void setCastlist(ArrayList<String> castlist) {
		this.cast = castlist;
	}
	
	/**
	 * Gets the show times.
	 *
	 * @return the show times
	 */
	//showTime
	public ArrayList<ShowTime> getShowTimes() {
		return showTimes;
	}
	
	/**
	 * Sets the show times.
	 *
	 * @param showTimes the new show times
	 */
	public void setShowTimes(ArrayList<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}
	
	/**
	 * Adds the show time to movie.
	 *
	 * @param showTime the show time
	 */
	public void addShowTimeToMovie(ShowTime showTime) 
	{
	 	showTimes.add(showTime);
	 }
	
	/**
	 * Removes the show time from movie.
	 *
	 * @param showTime the show time
	 */
	public void removeShowTimeFromMovie(ShowTime showTime) {
		showTimes.remove(showTime);
	}
	
	/**
	 * Gets the review list.
	 *
	 * @return the review list
	 */
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}

	/**
	 * Adds the review to the existing review list.
	 *
	 * @param review the review
	 */
	public void addReview(Review review) {
		this.reviewList.add(review);
	}
	
	/**
	 * Removes the review from the review list.
	 *
	 * @param review the review
	 */
	public void removeReview(Review review) {
		if (reviewList.contains(review)) {
			this.reviewList.remove(review);
		}
	}

	/**
	 * Gets the average value of the review rating.
	 *
	 * @return the review rating average
	 */
	public double getReviewRatingAverage() {
		double count = 0;
		int i=0;
		for (Review r : reviewList) {
			count+=r.getRating();
			i++;
		}
		return count/i;
	}
	
	/** The comparator to sort the average value of the review rating in descending order. */
	public static Comparator<Movie> reviewRatingAvgComparator = new Comparator<Movie>() {

		public int compare(Movie m1, Movie m2) {
			Double average_rating1 = m1.getReviewRatingAverage();
			Double average_rating2 = m2.getReviewRatingAverage();
		   return average_rating2.compareTo(average_rating1);
		}};
	
	/**
	 * This method converts the attributes of the move to string for prinitng out of the movie information when necessary.
	 *
	 * @return the string
	 */
	// Other Methods
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("(1) ID: "); result.append(this.getMovieID()); result.append("\n");
		result.append("(2) Title: "); result.append(this.getTitle()); result.append("\n");
		result.append("(3) Classification: "); result.append(this.getAgeRestriction()); result.append("\n");
		result.append("(4) Viewing Type: "); result.append(this.getType()); result.append("\n");
		result.append("(5) Viewing Status: "); result.append(this.getStatus()); result.append("\n");
		result.append("(6) Opening Date: "); result.append(this.getOpening()); result.append("\n");
		result.append("(7) Runtime: "); result.append(this.getRunTime()); result.append("\n");
		result.append("(8) Synopsis: "); result.append(this.getSynopsis()); result.append("\n");
//		result.append("(9)"); result.append(this.isBlockBuster()); result.append("\n");
		result.append("(9) Total Sales: "); result.append(this.getTotalSales()); result.append("\n");
	//	result.append("(11)"); result.append(this.getLanguage()); result.append("\n");
		result.append("(10) Directed by: "); result.append(this.getDirector()); result.append("\n");
		result.append("(11) Starring: "); result.append(this.getCastList()); result.append("\n");
//		result.append("(12) Available Showtimes: "); result.append(this.getShowTimes());
		return result.toString();
	}
	
	/**
	 * This method checks the movie if it is the same as a given object.
	 *
	 * @param o the particular object
	 * @return true, if successful
	 */
	public boolean equals(Object o) {
		Movie movie = (Movie)o;
		return this.movieID == movie.getMovieID();
	}
}
