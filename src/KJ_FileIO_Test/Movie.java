package CZ2002_Mini_Project;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.List;

public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer movieID;
	private String title;
//	private Enums.AgeRestriction ageRestriction;
//	private MovieType type;
//	private ShowingStatus status;
	private String opening;
	private String runtime;
	private String synopsis;
	private Boolean blockBuster;
	
	private Double totalSales;
	private String director;
//	private ArrayList<String> cast;
//	private ArrayList<ShowTime> showTimes;

	
	public Movie(String title, String opening, String director, String runtime, String synopsis, Boolean blockBuster) {
		this.movieID = -1;
		
		this.title = title;
//		this.ageRestriction = ageRestriction;
//		this.type = type;
//		this.status = status;
		this.opening = opening;
		this.director = director;
		this.runtime = runtime;
		this.synopsis = synopsis;
		this.blockBuster = blockBuster;
//		this.cast = cast;
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
//	public AgeRestriction getAgeRestriction() {
//		return ageRestriction;
//	}
//	public void setAgeRestriction(AgeRestriction ageRestriction) {
//		this.ageRestriction = ageRestriction;
//	}
	
	// type
//	public void setType(MovieType type) {
//		this.type = type;
//	}
//	
//	public MovieType getType() {
//		return type;
//	}
	
	// status
//	public ShowingStatus getStatus() {
//		return status;
//	}
//	public void setStatus(ShowingStatus status) {
//		this.status = status;
//	}
	
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

//	public ArrayList<String> getCast()
//	{
//		return cast;
//	}
//
//	public void setCast(ArrayList<String> cast)
//	{
//		this.cast = cast;
//	}

	// totalSales
	public Double getTotalSales(){
		return totalSales;
	}
	public void addTotalSales(Double amount){
		this.totalSales += amount;
	}
	public void minusTotalSales(Double amount){
		this.totalSales -= amount;
		if (this.totalSales<0) {
			totalSales=0.0;
		}
	}
	
	// directorList
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	// castList
//	public List<String> getCastList() {
//		return castList;
//	}
//	public void setCastlist(ArrayList<String> castlist) {
//		this.castList = castlist;
//	}
	
	//showTime
//	public List<ShowTime> getShowTimes() {
//		return showTimes;
//	}
//	public void setShowTimes(List<ShowTime> showTimes) {
//		this.showTimes = showTimes;
//	}
//	public void addShowTime(ShowTime showTime) {
//		showTimes.add(showTime);
//	}
//	public void removeShowTime(ShowTime showTime) {
//		showTimes.remove(showTime);
//	}
}
