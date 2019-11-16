package View;
import View.admin.MovieListView;
import View.admin.CinemaListView;
import View.admin.AdminShowtimeView;
import View.admin.SystemSettingView;

import static Presenter.AdminManager.*;
import static Presenter.Presenter.*;
import static Presenter.LoginManager.*;

import java.io.IOException;
import java.util.Scanner;

public class AdminView extends View {
	private boolean loggedIn;

	public AdminView() {
		loggedIn = true;
	}

	@Override
	protected void starter() {
		if (loggedIn == false)
			adminLogin();
		else
			displayMenu();
	}

	private void adminLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please login to access staff system");
		System.out.println("Enter Username: ");
		String adminName = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		if (verifyStaff(adminName, password)) {
			loggedIn = true;
			System.out.println();
			System.out.println("Login successful!");
			displayMenu();
		} else {
			System.out.println();
			System.out.println("Your username or password could be incorrect.");
			adminLogin();
		}

	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(
				"Welcome, please make a selection:\n" + "(1) Modify movie listing\n" + "(2) Modify cinema listing\n"
						+ "(3) Modify movie showtime\n" + "(4) Configure system settings\n" + "(5) Initialize admins\n"
						+ "(6) Initialize cinema operator \n" + "(7) Logout\n" + "Please enter your choice:");
		int choice = sc.nextInt();
		if (verifyChoiceNumber(choice, 1, 7)) {
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
				try {
					initialiseAdminAccounts();
				} catch (IOException e1) {
					System.out.println("Fail to load admin accounts");
				}
					displayMenu();
					break;
				case 6:
					try {
						initialiseCinemaOperators();
					} catch (IOException e) {
						System.out.println("Fail to load cinema operators");
					}
					displayMenu();
					break;
	            case 7:
	                loggedIn = false;
	                System.out.println();
	                System.out.println("You have logged out.");
	                end();
	                break;
				}
			}
			else
			{
				System.out.println();
				System.out.println("Incorrect input, please try again");
				displayMenu();
			}
	}
}

