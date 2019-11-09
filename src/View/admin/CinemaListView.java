package View.admin;
import Presenter.CinemaOperator;
import Presenter.Presenter;
import java.util.Scanner;

public class CinemaListView extends View{
	public CinemaListView() {
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
		while (passChoiceNumber(choice, 1, 3)) { 
			switch (choice) {
		        case 1:
		            displayCinema(); //[presenter: displayCinema()]
		            break;
		        case 2:
		        	System.out.println("Enter the cinema you want to add: ");
		        	String cinemaIn = sc.next();
		        	CinemaOperator.addCinema(passStringCinema(cinemaIn)); //[presenter: change input from string to Cinema]
		            break;
		        case 3:
		        	System.out.println("Enter the cinema you want to remove: ");
		        	String cinemaInn = sc.next();
		        	CinemaOperator.removeCinema(passStringCinema(cinemaIn)); 
		            break;
		        case 3:
		            break;
			}
		}
	}
}



