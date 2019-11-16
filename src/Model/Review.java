package Model;

import java.util.Date;

public class Review {
	private Integer rating;
	private String comment;
	private Date date;
	private Customer customer;
	
	public Review (Integer rating, String comment, Date date, Customer customer) {
		this.rating = rating;
		this.comment = comment;
		this.date = date;
		this.customer = customer;
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
