package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

import Model.Movie;
import Model.ShowTime;

import Model.Enums.*;

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
	
	private Double totalSales;
	private List<String> languageList;
	private List<String> directorList;
	private List<String> castList;
	private List<ShowTime> showTimes;

	
	public Movie(String title, AgeRestriction ageRestriction, MovieType type, ShowingStatus status, 
				String opening, String runtime, String synopsis, Boolean blockBuster) {
		this.movieID = -1;
		
		this.title = title;
		this.ageRestriction = ageRestriction;
		this.type = type;
		this.status = status;
		this.opening = opening;
		this.runtime = runtime;
		this.synopsis = synopsis;
		this.blockBuster = blockBuster;
		
		this.totalSales = 0.0;
		this.languageList = new ArrayList<String>();
		this.directorList = new ArrayList<String>();
		this.castList = new ArrayList<String>();
		this.showTimes = new ArrayList<ShowTime>();
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
	
	// languageList
	public List<String> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(ArrayList<String> languagelist) {
		this.directorList = languagelist;
	}
	
	// directorList
	public List<String> getDirectorList() {
		return directorList;
	}
	public void setDirectorList(ArrayList<String> directorlist) {
		this.directorList = directorlist;
	}
	
	// castList
	public List<String> getCastList() {
		return castList;
	}
	public void setCastlist(ArrayList<String> castlist) {
		this.castList = castlist;
	}
	
	//showTime
	public List<ShowTime> getShowTimes() {
		return showTimes;
	}
	public void setShowTimes(List<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}
	public void addShowTime(ShowTime showTime) {
		showTimes.add(showTime);
	}
	public void removeShowTime(ShowTime showTime) {
		showTimes.remove(showTime);
	}
	
	// Other Methods
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("(1)"); result.append(this.getMovieID()); result.append("\n");
		result.append("(2)"); result.append(this.getTitle()); result.append("\n");
		result.append("(3)"); result.append(this.getAgeRestriction()); result.append("\n");
		result.append("(4)"); result.append(this.getType()); result.append("\n");
		result.append("(5)"); result.append(this.getStatus()); result.append("\n");
		result.append("(6)"); result.append(this.getOpening()); result.append("\n");
		result.append("(7)"); result.append(this.getRunTime()); result.append("\n");
		result.append("(8)"); result.append(this.getSynopsis()); result.append("\n");
		result.append("(9)"); result.append(this.isBlockBuster()); result.append("\n");
		result.append("(10)"); result.append(this.getTotalSales()); result.append("\n");
		result.append("(11)"); result.append(this.getLanguageList()); result.append("\n");
		result.append("(12)"); result.append(this.getDirectorList()); result.append("\n");
		result.append("(13)"); result.append(this.getCastList()); result.append("\n");
		result.append("(14)"); result.append(this.getShowTimes());
		return result.toString();
	}
	public boolean equals(Object o) {
		Movie movie = (Movie)o;
		return this.movieID == movie.getMovieID();
	}
}
