package View.moviegoer;
import Presenter.Presenter;
import Presenter.AdminManager;
import Presenter.Query;
import java.util.Scanner;

public class MovieListingView extends View{
	
    public MovieListingView() {
    	displayMenu();
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
		while (passChoiceNumber(choice, 1, 5)) {
			switch (choice) {
            case 1:
				updateMovieListing(); //[presenter: displayMovie()] correct method is updateMovieListing, done by KJ
                break;
            case 2:
                AdminManager.getTop5RankingSales();
                break;
            case 3:
                AdminManager.getTop5RankingRating();
                break;
            case 4:
				passStringMovie(); //[presenter: searchMovie()] correct method is passStringMovie, done by KJ
                break;
            case 5:
                break;
			}
		}
	}
}



