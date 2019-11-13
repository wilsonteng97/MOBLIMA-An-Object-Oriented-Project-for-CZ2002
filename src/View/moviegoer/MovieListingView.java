package View.moviegoer;

import Presenter.Presenter;
import Presenter.AdminManager;
import Presenter.CinemaOperatorManager;
import Presenter.Query;
import View.View;

import java.util.Scanner;

import Model.Customer;

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
		while (Presenter.verifyChoiceNumber(choice, 1, 5)) {
			switch (choice) {
            case 1:
            	CinemaOperatorManager.readMovieListing(); 
                break;
            case 2:
                AdminManager.getTop5RankingSales();
                break;
            case 3:
                AdminManager.getTop5RankingRating();
                break;
            case 4:
            	System.out.println("Please Enter the Movie: ");
            	String movieIn = sc.next();
            	Movie movie = Query.passStringMovie(movieIn);
            	Query.searchMovie(movie); //[presenter: searchMovie()] correct method is passStringMovie, done by KJ
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



