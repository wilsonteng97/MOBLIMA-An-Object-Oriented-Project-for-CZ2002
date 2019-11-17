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
		System.out.println("Menu\n" + "----\n" + 
				"Welcome Staff, please make a selection:\n" + "(1) Modify movie listing\n" + "(2) Modify cinema listing\n"
						 + "(3) Configure system settings\n" + "(4) Initialize admins\n"
						+ "(5) Display customers details \n" + "(6) Logout\n" + "\nPlease enter your choice:");
		int choice = sc.nextInt();
		if (verifyChoiceNumber(choice, 1, 6)) {
			switch (choice) {
			case 1:
				intent(this, new MovieListView());
				break;
			case 2:
				intent(this, new CinemaListView());
				break;
			case 3:
				intent(this, new SystemSettingView());
				break;
			case 4:
				try {
					initialiseAdminAccounts();
					System.out.println("You initialised admin accounts correctly");
					} catch (IOException e1) {
					System.out.println("Fail to load admin accounts");
					}
					displayMenu();
					break;
			case 5:
				displayMenu();
				break;
			case 6:
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

