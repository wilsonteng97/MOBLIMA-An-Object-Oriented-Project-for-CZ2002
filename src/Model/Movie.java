package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.StringBuilder;

import Model.Movie;
import Model.ShowTime;

import Model.Enums.*;

@SuppressWarnings("serial")
public class Movie implements Serializable{
	private Integer movieID;
	private String title;
	private AgeRestriction ageRestriction;
	private MovieType type;
	private ShowingStatus status;
	private String opening;
	private String runtime;
	private String synopsis;
	private Boolean blockBuster;
	
	private Double totalSales = 0.0;
	private String director;
	private ArrayList<String> cast;
	private ArrayList<ShowTime> showTimes;
	private ArrayList<Review> reviewList;

	
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
	
	// movieCode
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public Integer getMovieID() {
		return movieID;
	}
	
	// title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	// ageRestriction
	public AgeRestriction getAgeRestriction() {
		return ageRestriction;
	}
	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}
	
	// type
	public void setType(MovieType type) {
		this.type = type;
	}
	
	public MovieType getType() {
		return type;
	}
	
	// status
	public ShowingStatus getStatus() {
		return status;
	}
	public void setStatus(ShowingStatus status) {
		this.status = status;
	}
	
	// opening
	public void setOpening(String opening) {
		this.opening = opening;
	}
	public String getOpening() {
		return opening;
	}
	
	// runTime
	public void setRunTime(String runtime) {
		this.runtime = runtime;
	}
	public String getRunTime() {
		return runtime;
	}

	// Synopsis
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getSynopsis() {
		return synopsis;
	}
	
	// blockBuster
	public boolean isBlockBuster(){
		return blockBuster;
	}
	public void setBlockBuster(Boolean blockBuster){
		this.blockBuster = blockBuster;
	}

	public ArrayList<String> getCast()
	{
		return cast;
	}

	public void setCast(ArrayList<String> cast)
	{
		this.cast = cast;
	}

	// totalSales
	public Double getTotalSales(){
		return totalSales;
	}
	public void addTotalSales(int amount){
		this.totalSales += amount;
	}
	public void minusTotalSales(Double amount){
		this.totalSales -= amount;
		if (this.totalSales<0) {
			totalSales=0.0;
		}
	}
	public static Comparator<Movie> movieSalesComparator = new Comparator<Movie>() {

		public int compare(Movie m1, Movie m2) {
			Double total_sales1 = m1.getTotalSales();
			Double total_sales2 = m2.getTotalSales();
	
		//	  ascending order
		//    return total_sales1.compareTo(total_sales2);
		//    descending order
		   return total_sales2.compareTo(total_sales1);
		}};
	
	// languageList
	// public List<String> getLanguageList() {
	// 	return languageList;
	// }
	// public void setLanguageList(ArrayList<String> languagelist) {
	// 	this.directorList = languagelist;
	// }
	
	// directorList
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	// castList
	public List<String> getCastList() {
		return cast;
	}
	public void setCastlist(ArrayList<String> castlist) {
		this.cast = castlist;
	}
	
	//showTime
	public ArrayList<ShowTime> getShowTimes() {
		return showTimes;
	}
	public void setShowTimes(ArrayList<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}
	// public void addShowTime(ShowTime showTime) {
	// 	showTimes.add(showTime);
	// }
	// public void removeShowTime(ShowTime showTime) {
	// 	showTimes.remove(showTime);
	// }
	
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}

	public void addReview(Review review) {
		this.reviewList.add(review);
	}
	
	public void removeReview(Review review) {
		if (reviewList.contains(review)) {
			this.reviewList.remove(review);
		}
	}

	public double getReviewRatingAverage() {
		double count = 0;
    int i=0;
		for (Review r : reviewList) {

			count+=r.getRating();
			i++;
		}
		return count/i;
	}
	public static Comparator<Movie> reviewRatingAvgComparator = new Comparator<Movie>() {

		public int compare(Movie m1, Movie m2) {
			Double average_rating1 = m1.getReviewRatingAverage();
			Double average_rating2 = m2.getReviewRatingAverage();
		   return average_rating2.compareTo(average_rating1);
		}};
	
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
		result.append("(12) Available Showtimes: "); result.append(this.getShowTimes());
		return result.toString();
	}
	public boolean equals(Object o) {
		Movie movie = (Movie)o;
		return this.movieID == movie.getMovieID();
	}
}
