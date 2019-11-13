package View.moviegoer;

import Presenter.CinemaOperator;
import Presenter.Presenter;
import View.View;

import java.util.Scanner;

public class CusShowtimeView extends View{
	public CusShowtimeView() {
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie] done by KJ
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (passChoiceNumber(choice, 1, 2)) {
			switch (choice) {
		        case 1:
		            displayShowtime(movie); //[presenter: displayShowtime(Movie movie)] done by KJ
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



