package KJ_FileIO_Test;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Customer implements Serializable{
	private Integer customerID;
	private String name;
	private String mobile; // Mobile Number
	private String email;
	private Date DOB; // Date of Birth
	private Integer age;	
//	private boolean ismember;
//	List<Booking> bookings;

	public Customer(String customerID, String name, String mobile, String email, Date DOB) {
        this.customerID = -1;
		this.name = name;
        this.mobile = mobile;
		this.email = email;
		this.DOB = DOB;
//        bookings = new ArrayList<Booking>();
        
//        this.setMember(false);
	}
	
	// customerID
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// mobileNo
	public String getMobileNo() {
		return mobile;
	}
	public void setMobileNo(String mobile) {
		this.mobile = mobile;
	}
	
	// email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// DOB
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	public Date getDOB() {
		return DOB;
	}
	
	// private method to compute Age
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
	
	// age
	public int getAge() {
		computeAge();
		return this.age;
	}
	
	// bookings
//	public List<Booking> getBookings() {
//		return bookings;
//	}
//	public void addBooking(Booking booking) {
//		bookings.add(booking);
//	}
//	public void removeBooking(Booking booking) {
//		bookings.remove(booking);
//	}
}

