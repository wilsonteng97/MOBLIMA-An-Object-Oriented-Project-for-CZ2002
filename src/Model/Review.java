package Model;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Review.
 * This class contains the information on the movie review.
 * @version 1.0
 */
public class Review implements Serializable {
	
	/** The rating of the movie, in the range of 1 to 5. */
	private Integer rating;
	/** The comment given for the movie. */
	private String comment;
	/** The date of review provided. */
	private Date date;
	/** The customer that provided the review. */
	private Customer customer;
	/** The movie that the customer reviewed on. */
	private Movie movie;
	
	/**
	 * Instantiates a new review.
	 *
	 * @param rating the movie rating
	 * @param comment the comment on the movie
	 * @param date the date of provided review
	 * @param customer the customer
	 * @param movie the movie reviewed
	 */
	public Review (Integer rating, String comment, Date date, Customer customer, Movie movie) {
		this.rating = rating;
		this.comment = comment;
		this.date = date;
		this.customer = customer;
		this.movie = movie;
	}
	
	/**
	 * Gets the movie.
	 *
	 * @return the movie
	 */
	public Movie getMovie()
	{
		return movie;
	}
	
	/**
	 * Sets the movie.
	 *
	 * @param movie the movie
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public Integer getRating() {
		return this.rating;
	}
	
	/**
	 * Sets the rating.
	 *
	 * @param rating the rating
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
	}
	
	/**
	 * Sets the comment.
	 *
	 * @param comment the comment
	 */
	public void setComment (String comment) {
		this.comment = comment;
	}
	
	/**
	 * Gets the date when the review is given.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Sets the date when the review is given.
	 *
	 * @param date the date
	 */
	public void setDate (Date date) {
		this.date = date;
	}
	
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return this.customer;
	}
	
	/**
	 * Sets the customer.
	 *
	 * @param customer the customer
	 */
	public void setCustomer (Customer customer) {
		this.customer = customer;
	}
}
