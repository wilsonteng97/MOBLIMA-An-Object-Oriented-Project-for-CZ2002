/**
 * 
 */
package Model;

/**
 * @author wilso
 *
 */
public class Customer {
	private final int customerid;
	private final String passwordhash;
	private final String name;
	private final String email;
	private final String mobile;
	private final String creditcardno;
	private int age;
	
	private boolean ismember;
//	private BookingHistory bookinghist;
	
	public Customer(int customerid, String passwordhash, String name, String email, String mobile, String creditcardno, int age) {
        this.customerid = customerid;
        this.passwordhash = passwordhash;
		this.name = name;
		this.email = email;
        this.mobile = mobile;
        this.creditcardno = creditcardno;
        this.age = age;
        
        this.setMember(false);
//        this.bookinghist = BookingHistory();
	}
	
	public boolean isChild() {
		return (age<=16);
	}
	
	public boolean isAdult() {
		return (age>16 && age<60);
	}
	
	public boolean isSeniorCitizen() {
		return (age>=60);
	}

	/**
	 * @return the customerid
	 */
	public int getCustomerid() {
		return customerid;
	}

	/**
	 * @return the passwordhash
	 */
	public String getPasswordhash() {
		return passwordhash;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @return the creditcardno
	 */
	public String getCreditCardNo() {
		return creditcardno;
	}

	/**
	 * @return the ismember
	 */
	public boolean isMember() {
		return ismember;
	}

	/**
	 * @param ismember the ismember to set
	 */
	public void setMember(boolean ismember) {
		this.ismember = ismember;
	}
}
