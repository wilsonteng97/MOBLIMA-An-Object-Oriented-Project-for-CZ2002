package View.admin;
import Model.*;
import View.View;

import Presenter.Query.*;
import static Presenter.AdminManager.*;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Presenter.*;
import java.util.Scanner;

public class AdminShowtimeView extends View{
	private Movie movie;

	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie] done by KJ
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Add Showtime\n"
				+ "(3) Update Showtime\n"
				+ "(4) Remove Showtime\n"
				+ "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { //[presenter: change passChoiceNumber() to boolean] Changed, done by KJ
			switch (choice) {
		        case 1:
					getShowtimeList(movie); //[presenter: displayShowtime(Movie movie)] done by KJ, actual method is getShowtimeList instead of displayShowtime
		            break;
		        case 2:
		            CinemaOperator.addShowtime(movie, showtime); //[presenter: addShowtime(Movie movie), add in parameter Movie] added by KJ
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