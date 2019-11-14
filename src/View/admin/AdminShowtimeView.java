package View.admin;
import View.View;
import static Presenter.Query.*;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Presenter.*;
import java.util.Scanner;

public class AdminShowtimeView extends View{

	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		
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
		        	displayShowtime(movieIn); 
		            break;
		        case 2:
		        	System.out.println("Enter showtime: ");
		        	double showtimeIn = sc.nextInt();
		        	addShowtime(movieIn, showtimeIn); 
		            break;
		        case 3:
		        	updateShowTime(); 
		        	break;
		        case 4:
		        	System.out.println("Enter showtime: ");
		        	double showtimeIn2 = sc.nextInt();
		        	removeShowtime(movieIn, showtimeIn2); 
		        	break;
		        case 5:
		        	break;
			}
		}
	}
}