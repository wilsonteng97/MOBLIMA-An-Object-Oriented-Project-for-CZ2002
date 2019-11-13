package View.moviegoer;
import Presenter.Presenter;
import Presenter.Query;
import View.View;

import java.util.Scanner;

import Model.Movie;

public class CusShowtimeView extends View{
	private Movie movie;
	public CusShowtimeView() {
		
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		this.movie = Query.passStringMovie(movieIn); 
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (Presenter.verifyChoiceNumber(choice, 1, 2)) {
			switch (choice) {
		        case 1:
		            Query.displayShowtime(movie); 
		            break;
		        case 2:
		        	break;
			}
		}
	}
	@Override
	protected void starter() {
		displayMenu();		
	}
}



