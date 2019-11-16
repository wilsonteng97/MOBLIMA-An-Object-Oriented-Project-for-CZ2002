package View;

import View.moviegoer.BookingHistoryView;
import View.moviegoer.MovieListingView;
import java.util.Scanner;

public class MovieGoerView extends View{
	public MovieGoerView() {
	}

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
