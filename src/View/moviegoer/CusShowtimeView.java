package View.moviegoer;
import Presenter.CinemaOperator;
import Presenter.Presenter;
import java.util.Scanner;

public class CusShowtimeView extends View{
	private Movie movie;
	public CusShowtimeView() {
		displayMenu();
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie]
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (passChoiceNumber(choice, 1, 2)) {
			switch (choice) {
		        case 1:
		            displayShowtime(movie); //[presenter: displayShowtime(Movie movie)]
		            break;
		        case 2:
		        	break;
			}
		}
	}
}



