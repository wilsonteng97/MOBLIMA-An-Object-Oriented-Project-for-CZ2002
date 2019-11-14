package View.admin;
import View.View;
import static Presenter.CinemaOperatorManager.*;

import static Presenter.Presenter.*;
import static Presenter.AdminManager.*;
import java.util.Scanner;

public class MovieListView extends View{

	@Override
	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Display Movies\n"
				+ "(2) Add Movie\n"
				+ "(3) Update Movie Listing\n"
				+ "(4) Remove Movie\n"
				+ "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { 
			switch (choice) {
		        case 1:
					getMovieList(); //[presenter: displayMovie()] actual method is getMovieList instead of displayMovie, done by KJ
		            break;
		        case 2:
		        	System.out.println("Enter the movie you want to add: ");
		        	String movieIn = sc.next();
		        	addMovie(movieIn);
		            break;
		        case 3:
		        	updateMovieListing();
		        	break;
		        case 4:
		        	System.out.println("Enter the movie you want to add: ");
		        	String movieIn2 = sc.next();
		        	removeMovie(movieIn2);
		        	break;
		        case 5:
		        	break;
			}
		}
	}
}