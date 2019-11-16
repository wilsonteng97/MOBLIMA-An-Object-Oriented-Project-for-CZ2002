package View;

import Presenter.Presenter;
import View.moviegoer.BookingHistoryView;
import View.moviegoer.BookingView;
import View.moviegoer.CusShowtimeView;
import View.moviegoer.MovieListingView;
import View.moviegoer.ReviewView;

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
				+ "(2) Booking History\n"
				+ "(3) Movie Review\n"
				+ "(4) Movie Showtime\n"
				+ "(5) Book Movie Ticket\n"
				+ "(6) Return");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (Presenter.verifyChoiceNumber(choice, 1, 3)) { 
			switch (choice) {
	        case 1:
	            intent(this, new MovieListingView());
	            break;
	        case 2:
	            intent(this, new BookingHistoryView());
	            break;
	        case 3:
	            //intent(this, new ReviewView());
	            break;
	        case 4:
	            //intent(this, new CusShowtimeView());
	            break;
	        case 5:
	            //intent(this, new BookingView());
	            break;
	        case 6:
	            break;
			}
		}
	}
}
