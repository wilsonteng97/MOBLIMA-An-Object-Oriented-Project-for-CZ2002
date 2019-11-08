package View;
import java.util.Scanner;

public class AdminView implements View{
	private boolean loggedIn = false;
	private String adminName;
	private String password;
	public StaffView() {
		if(loggedIn == false)
		{
			adminlogin();
		}
		else
		{
			displayMenu();
		}
	}
	
	private void adminLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please login to access staff system");
		System.out.println("Enter Username: ")
		adminName = sc.next();
		System.out.println("Enter Password: ")
		password = sc.next();
		//verifyStaff(adminname,password);
		if (verifyStaff(adminName, password)) {
            loggedIn = true;
            System.out.println("Login successful!");
            displayMenu();
        }
        else {
            System.out.println("Invalid username or password.");
            destroy();
        }
		
	}
	private void displayMenu() {
			System.out.println("Welcome, please make a selection:\n"
					+ "(1) Modify movie listing\n"
				+ "(2) Configure system settings\n"
				+ "(3) Logout"
				+ "Please enter choice");
			int choice = sc.nextInt();
			switch (choice) {
            case 1:
                intent(this, new MovieListing());
                break;
            case 2:
                intent(this, new SystemSetting());
                break;
            case 3:
                loggedIn = false;
                System.out.println("You have logged out.");
                destroy();
                break;
        }
	}
}
