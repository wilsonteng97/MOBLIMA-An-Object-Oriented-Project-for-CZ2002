package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Model.Booking;

/**
 * The Class Customer.
 * This class contains the information of the customer.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Customer implements Serializable{
	
	/** The customer ID. */
	private Integer customerID;
	/** The name. */
	private String name;
	/** The mobile number. */
	private String mobile; // Mobile Number
	/** The email address. */
	private String email;
	/** The date of birth. */
	private Date DOB; // Date of Birth
	/** The password. */
	String password;
	/** The age. */
	private Integer age;
	/** The boolean expression of whether the individual is a senior citizen. */
	private boolean isSenior;

/** The bookings. */
//	private boolean ismember;
	List<Booking> bookings;

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerID the customer ID
	 * @param name the customer's name
	 * @param mobile the mobile number
	 * @param email the email address
	 * @param DOB the date of birth
	 * @param password the password is for the customer to use when loggin in
	 */
	public Customer(int customerID, String name, String mobile, String email, Date DOB, String password) {
        this.customerID = customerID;
		this.name = name;
        this.mobile = mobile;
		this.email = email;
		this.DOB = DOB;
		this.password = password;
        bookings = new ArrayList<Booking>();
//        this.setMember(false);
	}
	
	/**
	 * Instantiates a new customer with important information on the individual.
	 *
	 * @param name the name
	 * @param mobile the mobile number
	 * @param email the email address
	 * @param isSenior the boolean expression if customer is a senior citizen.
	 */
	public Customer(String name, String mobile, String email, boolean isSenior) {
		this.name = name;
        this.mobile = mobile;
		this.email = email;
        bookings = new ArrayList<Booking>();
        this.isSenior = isSenior;
	}
	
	/**
	 * Gets the customer ID.
	 *
	 * @return the customer ID
	 */
	public int getCustomerID() {
		return customerID;
	}
	
	/**
	 * Sets the customer ID.
	 *
	 * @param customerID the new customer ID
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the mobile number
	 *
	 * @return the mobile no
	 */
	public String getMobileNo() {
		return mobile;
	}
	
	/**
	 * Sets the mobile number
	 *
	 * @param mobile the new mobile no
	 */
	public void setMobileNo(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the email address.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email address.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Sets the date of birth.
	 *
	 * @param DOB the new date of birth
	 */
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	
	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public Date getDOB() {
		return DOB;
	}
	
	/**
	 * Sets the password for login.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the password for login.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Compute the age of the customer with date of birth and current date.
	 */
	private void computeAge() {
		Calendar dob = Calendar.getInstance();  
		dob.setTime(DOB);  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
		
		if (today.get(Calendar.MONTH)<dob.get(Calendar.MONTH)) {
		  age--;
		  this.age = age;
		}
		if (today.get(Calendar.MONTH)==dob.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH)<dob.get(Calendar.DAY_OF_MONTH)) {
		  age--;
		  this.age = age;
		}
		
		this.age = age;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		computeAge();
		return this.age;
	}
	
	/**
	 * Sets whether the customer is a senior citizen.
	 *
	 * @param isSenior the new checks if is senior
	 */
	public void setIsSenior(boolean isSenior) {
		this.isSenior = isSenior;
	}
	
	/**
	 * Gets the checks on whether the customer is a senior citizen.
	 *
	 * @return the checks if is senior
	 */
	public boolean getIsSenior() {
		return isSenior;
	}
	
	/**
	 * Gets the bookings.
	 *
	 * @return the bookings
	 */
	// bookings
	public List<Booking> getBookings() {
		return bookings;
	}
	
	/**
	 * Adds the booking.
	 *
	 * @param booking the booking
	 */
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}
	
	/**
	 * Removes the booking.
	 *
	 * @param booking the booking
	 */
	public void removeBooking(Booking booking) {
		bookings.remove(booking);
	}
}
