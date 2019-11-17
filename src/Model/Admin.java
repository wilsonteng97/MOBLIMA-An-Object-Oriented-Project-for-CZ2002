
package Model;

/**
 * @author wilso
 *
 */

import java.io.Serializable;

/**
 * The Class Admin.
 * This class contains the information used by the Administrator's to login -
 * the administrator ID, his/her username as well as the password.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Admin implements Serializable {
	
	/** The admin ID. */
	private Integer adminID;
	/** The username. */
	private String username;
	/** The password. */
	private String password;
	
	/**
	 * Instantiates a new Administrator. Default ID of the Administrator is -1.
	 *
	 * @param username username of Administrator
	 * @param password password of Administrator
	 */
	public Admin(String username, String password) {
		this.adminID = -1;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * This method sets the Administrator's ID.
	 *
	 * @param adminID the Administrator's new ID
	 */
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	/**
	 * This method gets the Administrator's ID.
	 *
	 * @return the Administrator's ID
	 */
	public int getAdminID() {
		return adminID;
	}
	
	/**
	 * This method sets the Administrator's username.
	 *
	 * @param username the Administrator's new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * This method gets the Administrator's username.
	 *
	 * @return the Administrator's username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * This method sets the Administrator's password.
	 *
	 * @param password the Administrator's new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This method gets the Administrator's password.
	 *
	 * @return the Administrator's password
	 */
	public String getPassword() {
		return password;
	}
}