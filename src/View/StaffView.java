package View;

public class StaffView implements View{
	private boolean loggedIn;
	public StaffView(boolean login) {
		loggedIn = login;
	}
	private boolean getLoggedIn() {
		return loggedIn;
	}
	private void setLoggedIn(boolean login) {
		loggedIn = login;
	}
	private void displayMenu() {
		System.out.println("(1) System Setting\n"
				+ "(2) Movie Listing");
	}
}
