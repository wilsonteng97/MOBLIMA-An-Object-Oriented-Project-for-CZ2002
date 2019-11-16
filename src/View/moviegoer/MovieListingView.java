package View.moviegoer;

import static Presenter.Presenter.*;
import static Presenter.AdminManager.*;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Query.*;
import static Model.Enums.ShowingStatus.*;
import View.View;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Movie;
import Presenter.CinemaOperatorManager;

public class MovieListingView extends View{
	private boolean top5Sales = false;
	private boolean top5Rating = false;
	Scanner sc = new Scanner(System.in);
    public MovieListingView() {
	}	
    
    private void displayMenu() {
    	System.out.println("Movie Listing");
    	System.out.println();
    	System.out.println("(1) List all movies\n" 
    			+ "(2) List the top 5 movies by sales\n"
    			+ "(3) List the top 5 movies by ratings\n"
    			+ "(4) Search Movie" 
    			+ "(5) Return");
    	System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		switch (choice) {
            case 1:
            	top5Sales = false;
            	top5Rating = false;
            	displayMovieListing(); 
                break;
            case 2:
                top5Sales = true;
                top5Rating = false;
                displayMovieListing();
                break;
            case 3:
            	top5Sales = false;
            	top5Rating = true;
            	displayMovieListing();
                break;
            case 4:
            	searchMovie(); 
                break;
            case 5:
            	break;
			}
		end();
	}
	
	@Override
	protected void starter() {
      displayMenu();
	}
	protected void starter(Movie movie) {
		displayMovieDetail(movie);
		}

	private void searchMovie() {
		System.out.println();
		System.out.println("Enter the movie you choose: ");
		String movieName = sc.next();
        Movie movieResult = passStringMovie(movieName);
        if (movieResult==null) {
        	System.out.println();
        	System.out.println("No movie found");
            displayMenu();
        }
        else {
        	System.out.println();
        	System.out.println(movieResult.getTitle() + " (" + movieResult.getStatus().toString() + ")");
            displayMovieDetail(movieResult);
        }
    }
	
	 private void displayMovieDetail(Movie movie) {
		 System.out.println();
		 System.out.println(movie.toString());
		 System.out.println();
		 System.out.println("1. Display showtime\n"+
	                "2. Display/write reviews\n"+
	                "3. Go back");

		 int choice = sc.nextInt();
			while (verifyChoiceNumber(choice, 1, 3)) {
				switch (choice) {
		            case 1:
		            	intent(this, new CusShowtimeView(movie));
		                break;
		            case 2:
		                intent(this, new ReviewView(movie));
		                break;
		            case 3:
		                break;
		        }
	        displayMovieListing();
	        }
	    }
	
	private void displayMovieListing() {
	    ArrayList<Movie> movieListing = CinemaOperatorManager.getMovieList();
	
	    if (top5Sales) 
	    	movieListing = getTop5RankingSales();
	    else if (top5Rating)
	    	movieListing = getTop5RankingRating();
	    else 
	    	movieListing = getMovieList();
	
	    if (movieListing.isEmpty()) {
	    	System.out.println();
	    	System.out.println("Movie listing is not available");
	        displayMenu();
	    }
	    int index = 0;
        if (top5Rating) {  
            for (Movie movie : movieListing) {
                if (movie.getStatus().equals(NO_LONGER_AVAILABLE)) 
                	continue;
                System.out.println();
                System.out.println(++index + ". " + movie.getTitle() 
                        + "(" + movie.getStatus().toString() + ") " +
                        "[" + (getMovieRating(movie) == 0 ? "No rating" : getMovieRating(movie)) + "]");
            }
        }
        else if (top5Sales){
            for (Movie movie : movieListing) {  
                if (movie.getStatus().equals(NO_LONGER_AVAILABLE)) 
                	continue;
                System.out.println();
                System.out.println(++index + ". " + movie.getTitle() 
                                + "(" + movie.getStatus().toString() + ") " +
                        "[" + (movie.getTotalSales() == 0 ? "No sale" : movie.getTotalSales()) + "]");
            }
        }
        else {
        	System.out.print("\n");
            for (Movie movie : movieListing) {  
                if (movie.getStatus().equals(NO_LONGER_AVAILABLE)) 
                	continue;
                System.out.println();
                System.out.println(++index + ". " + movie.getTitle() 
                                + "(" + movie.getStatus().toString() + ") " );
            }
        }
	
        System.out.println(index + 1 + ". Return");
        System.out.print("\n");
        int choice = sc.nextInt();

        if (choice == index + 1) 
        	starter();
        else {
            Movie movie = movieListing.get(choice - 1);
            if (movie.getStatus().equals(NO_LONGER_AVAILABLE)) {
                movie = movieListing.get(choice);
            }
            displayMovieDetail(movie);
        }
	}
}

