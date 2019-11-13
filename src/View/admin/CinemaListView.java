package View.admin;
import View.View;
import Presenter.CinemaOperator;
import Presenter.Presenter;
import Presenter.AdminManager;
import java.util.Scanner;

public class CinemaListView extends View
{
	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Display Cinemas\n"
				+ "(2) Add Cinema\n"
				+ "(3) Remove Cinema\n"
				+ "(3) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 3)) { 
			switch (choice) {
		        case 1:
					getCinemaList(); //[presenter: displayCinema()] actual method is getCinemaList instead of displayCinema, done by KJ
		            break;
		        case 2:
		        	System.out.println("Enter the cinema you want to add: ");
		        	String cinemaIn = sc.next();
		        	CinemaOperator.addCinema(passStringCinema(cinemaIn)); //[presenter: change input from string to Cinema] done by KJ
		            break;
		        case 3:
		        	System.out.println("Enter the cinema you want to remove: ");
		        	String cinemaInn = sc.next();
		        	CinemaOperator.removeCinema(passStringCinema(cinemaIn)); 
		            break;
		        case 4:
		            break;
			}
		}
	}
}