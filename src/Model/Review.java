package Model;

import java.util.Date;

public class Review {
	private Integer rating;
	private String synopsis;
	private Date date;
	private Customer customer;
	
	public Review (Integer rating, String synopsis, Date date, Customer customer) {
		this.rating = rating;
		this.synopsis = synopsis;
		this.date = date;
		this.customer = customer;
	}
	
	//Get Methods
	public Integer getRating() {
		return this.rating;
	}
	
	public String getSynopsis() {
		return this.synopsis;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
}
