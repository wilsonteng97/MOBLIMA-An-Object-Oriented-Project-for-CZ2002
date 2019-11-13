package View.admin;
import Model.*;
import View.View;
import Presenter.CinemaOperatorManager;
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
		this.movie = Presenter.Query.passStringMovie(movieIn); 
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Add Showtime\n"
				+ "(3) Update Showtime List\n"
				+ "(4) Remove Showtime\n"
				+ "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { 
			switch (choice) {
		        case 1:
		        	Presenter.Query.displayShowtime(movie); 
		            break;
		        case 2:
		        	System.out.println("Enter showtime: ");
		        	double showtimeIn = sc.nextInt();
		        	ShowTime showtime = Presenter.Query.passDoubleShowtime(showtimeIn);
		        	CinemaOperatorManager.addShowtime(movie, showtime); 
		            break;
		        case 3:
		        	CinemaOperatorManager.updateShowTime(); 
		        	break;
		        case 4:
		        	System.out.println("Enter showtime: ");
		        	double showtimeIn2 = sc.nextInt();
		        	ShowTime showtime2 = Presenter.Query.passDoubleShowtime(showtimeIn2);
		        	CinemaOperatorManager.removeShowtime(movie, showtime2); //[presenter: removeShowtime(Movie movie)]
		        	break;
		        case 5:
		        	break;
			}
		}
	}
}