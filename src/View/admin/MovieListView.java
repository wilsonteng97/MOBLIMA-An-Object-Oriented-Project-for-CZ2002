package View.admin;
import View.View;
import Presenter.CinemaOperator;
import Presenter.Presenter;
import Presenter.AdminManager;

import java.lang.annotation.Inherited;
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
				+ "(3) Update Movie\n"
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
		            CinemaOperator.addMovie();
		            break;
		        case 3:
		        	CinemaOperator.updateMovieListing();
		        	break;
		        case 4:
		        	CinemaOperator.removeMovie();
		        	break;
		        case 5:
		        	break;
			}
		}
	}
}