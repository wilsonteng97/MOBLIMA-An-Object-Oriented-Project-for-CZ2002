package View;

import View.moviegoer.BookingHistoryView;
import View.moviegoer.MovieListingView;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import static Presenter.AdminManager.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieGoerView is the main menu interface for the moviegoer.
 */
public class MovieGoerView extends View{
	
	/**
	 * Instantiates a new movie goer view.
	 */
	public MovieGoerView() {
	}

	/**
	 * Starter view of the menu interface. These are the list of operations that the moviegoer can perform.
	 */
	@Override
	protected void starter(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n"
				+ "Menu\n" + "----");
		System.out.println("Welcome Moviegoer, please make a selection:\n"
				+"(1) Movie Listing\n"
				+ "(2) View Booking History\n"
				+ "(3) Return\n");
		System.out.println("Please enter your choice: ");
		int choice = sc.nextInt();

		switch (choice) {
        case 1:
            intent(this, new MovieListingView());
            break;
        case 2:
            intent(this, new BookingHistoryView());
            break;
        case 3:
        	end();
            break;
		}		
	}
}
