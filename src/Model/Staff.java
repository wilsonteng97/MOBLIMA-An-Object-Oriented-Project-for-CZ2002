/**
 * 
 */
package Model;

/**
 * @author wilso
 *
 */
public class Staff {
	private final int staffid;
	private final String name;
	private final String mobile;
	private final String email;
	private final String passwordhash;

    public Staff(int staffid, String name, String mobile, String email, String passwordhash) {
        this.staffid = staffid;
    	this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.passwordhash = passwordhash;
    }

	/**
	 * @return the staffid
	 */
	public int getStaffid() {
		return staffid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the passwordhash
	 */
	public String getPasswordhash() {
		return passwordhash;
	}
    
}
