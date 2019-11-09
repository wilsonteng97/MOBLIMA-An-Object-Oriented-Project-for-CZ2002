package View.admin;
import Presenter.CinemaOperator;
import Presenter.Presenter;
import java.util.Scanner;

public class AdminShowtimeView extends View{
	private Movie movie;
	public AdminShowtimeView(Movie movie) {
		displayMenu();
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie]
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Add Showtime\n"
				+ "(3) Update Showtime\n"
				+ "(4) Remove Showtime\n"
				+ "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (passChoiceNumber(choice, 1, 5)) { //[presenter: change passChoiceNumber() to boolean]
			switch (choice) {
		        case 1:
		        	displayShowtime(movie); //[presenter: displayShowtime(Movie movie)]
		            break;
		        case 2:
		            CinemaOperator.addShowtime(movie); //[presenter: addShowtime(Movie movie), add in parameter Movie]
		            break;
		        case 3:
		        	CinemaOperator.updateShowtime(movie); //[presenter: updateShowtime(Movie movie)]
		        	break;
		        case 4:
		        	CinemaOperator.removeShowtime(movie); //[presenter: removeShowtime(Movie movie)]
		        	break;
		        case 5:
		        	break;
			}
		}
	}
}



