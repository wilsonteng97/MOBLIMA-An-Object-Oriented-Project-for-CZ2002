package View.moviegoer;

import static Presenter.Presenter.*;
import static Presenter.AdminManager.*;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Query.*;
import View.View;

import java.util.Scanner;

public class MovieListingView extends View{
	
    public MovieListingView() {
	}	
    
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("(1) List all movies\n" 
    			+ "(2) List the top 5 movies by sales\n"
    			+ "(3) List the top 5 movies by ratings\n"
    			+ "(4) Search Movie" 
    			+ "(5) Return");
    	System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) {
			switch (choice) {
            case 1:
            	displayMovieListing(); 
            	System.out.println("Enter the movie you choose: ");
        		String movieName = sc.next();
        		intent(this, new CusShowtimeView(movieName));
                break;
            case 2:
                getTop5RankingSales();
                break;
            case 3:
                getTop5RankingRating();
                break;
            case 4:
            	System.out.println("Please Enter the Movie: ");
            	String movieIn = sc.next();
            	searchMovie(movieIn); 
                break;
            case 5:
                break;
			}
		}
	}
	@Override
	protected void starter() {
      displayMenu();
	}
}



