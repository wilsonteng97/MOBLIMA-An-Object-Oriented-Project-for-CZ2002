package Model;

import java.util.Date;

public class Review {
	private int rating;
	private String synopsis;
	private Date date;
	private Customer customer;
	
	public Review (int rating, String synopsis, Date date, Customer customer) {
		this.rating = rating;
		this.synopsis = synopsis;
		this.date = date;
		this.customer = customer;
	}
	
//	public class int rating {
//		this.rating = rating;
//	}
//	
//	public class String synopsis {
//		this.synopsis = synopsis;
//	}
//	
//	public class Date date {
//		this.date = date;
//	}
//	
//	public class setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
	//Get Methods
	public int getRating() {
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
