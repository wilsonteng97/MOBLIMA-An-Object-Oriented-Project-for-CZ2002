package View;
import Presenter.Presenter;
import View.admin.AdminShowtimeView;
import View.admin.CinemaListView;
import View.admin.MovieListView;
import View.admin.SystemSettingView;

import java.util.Scanner;

public class AdminView implements View{
	private boolean loggedIn = false;
	private String adminName;
	private String password;
	public AdminView() {
		if(loggedIn == false)
			adminLogin();
		else
			displayMenu();
	}
	
	private void adminLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please login to access staff system");
		System.out.println("Enter Username: ");
		adminName = sc.next();
		System.out.println("Enter Password: ");
		password = sc.next();
		verifyStaff(adminName,password); //[presenter]
		if (verifyStaff(adminName, password)) {
            loggedIn = true;
            System.out.println("Login successful!");
            displayMenu();
        }
        else {
            System.out.println("Invalid username or password.");
        }
		
	}
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);	
		System.out.println("Welcome, please make a selection:\n"
					+ "(1) Modify movie listing\n"
					+ "(2) Modify cinema listing\n"
					+ "(3) Modify movie showtime\n"
					+ "(4) Configure system settings\n"
					+ "(5) Logout"
					+ "Please enter choice");
			int choice = sc.nextInt();
			while (passChoiceNumber(choice, 1, 5)) { 
				switch (choice) {
	            case 1:
	                intent(this, new MovieListView());
	                break;
	            case 2:
	                intent(this, new CinemaListView());
	                break;
	            case 3:
	                intent(this, new AdminShowtimeView());
	                break;
	            case 4:
	                intent(this, new SystemSettingView());
	                break;
	            case 5:
	                loggedIn = false;
	                System.out.println("You have logged out.");
	                
	                break;
				}
			}
	}
}
