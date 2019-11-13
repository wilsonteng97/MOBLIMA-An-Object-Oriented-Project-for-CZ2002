/**
 * 
 */
package Model;

/**
 * @author wilso
 *
 */

import java.io.Serializable;

public class Admin implements Serializable {
	private Integer adminID;
	private String username;
	private String password;
	
	public Admin(String username, String password) {
		this.adminID = -1;
		this.username = username;
		this.password = password;
	}
	
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	public int getAdminID() {
		return adminID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
}
