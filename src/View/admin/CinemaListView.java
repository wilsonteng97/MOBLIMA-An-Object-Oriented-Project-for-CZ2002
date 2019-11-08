package View.admin;
import Presenter.CinemaOperator;
import java.util.Scanner;

public class CinemaListView extends View{
	public CinemaListView() {
		displayMenu();
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Display Cinemas\n"
				+ "(2) Add Cinemas\n"
				+ "(3) Return\n");
		System.out.println("Enter the number of your choice: ");
		choice = sc.nextInt();
		while (passChoiceNumber(choice, 1, 3)) { 
			switch (choice) {
		        case 1:
		            displayCinema(); //[presenter: displayCinema()]
		            break;
		        case 2:
		            CinemaOperator.addCinema();
		            break;
		        case 3:
		            break;
			}
		}
	}
}



