package View.admin;
import Presenter.CinemaOperator;
import Presenter.Presenter;
import java.util.Scanner;

public class ShowtimeView extends View{
	private Movie movie;
	public ShowtimeView(Movie movie) {
		this.movie=movie;
		displayMenu();
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Add Showtime\n"
				+ "(3) Update Showtime\n"
				+ "(4) Remove Showtime\n"
				+ "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { //[presenter: change passChoiceNumber() to boolean] Done by KJ
			switch (choice) {
		        case 1:
		            displayShowtime(); //[presenter: displayShowtime()]
		            break;
		        case 2:
		            CinemaOperator.addShowtime();
		            break;
		        case 3:
		        	CinemaOperator.updateShowtime();
		        	break;
		        case 4:
		        	CinemaOperator.removeShowtime();
		        	break;
		        case 5:
		        	break;
			}
		}
	}
}



