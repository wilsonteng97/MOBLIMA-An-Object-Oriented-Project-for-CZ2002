package View;

import View.moviegoer.BookingHistoryView;
import View.moviegoer.MovieListingView;
import java.util.Scanner;

public class MovieGoerView extends View{
	public MovieGoerView() {
		displayMenu();
	}

	@Override
	protected void starter(){
		displayMenu();
	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome, please make a selection:\n"
				+ "(1) Movie Listing\n"
				+ "(2) View Booking History\n"
				+ "(3) Return");
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
