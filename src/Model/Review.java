package Model;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {
	private Integer rating;
	private String comment;
	private Date date;
	private Customer customer;
	private Movie movie;
	public Review (Integer rating, String comment, Date date, Customer customer, Movie movie) {
		this.rating = rating;
		this.comment = comment;
		this.date = date;
		this.customer = customer;
		this.movie = movie;
	}
	
	public Movie getMovie()
	{
		return movie;
	}
	//Get Methods
	public Integer getRating() {
		return this.rating;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
}
