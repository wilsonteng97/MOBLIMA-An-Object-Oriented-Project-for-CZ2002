package View.moviegoer;
import Presenter.ReviewManager;
import View.View;
import Presenter.Presenter;
import java.util.Scanner;

public class ReviewView extends View{
	
    public ReviewView() {
    	
	}	
    private void displayMenu() {
    	/*Scanner sc = new Scanner(System.in);
    	System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		this.movie = passStringMovie(movieIn); */
    	System.out.println("(1) Write a review\n"
    			+ "(2) View all reviews\n"
    			+ "(3) Give a Rating\n"
    			+ "(4) View Average Rating\n"
    			+ "(5) Return\n");
    	System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (Presenter.verifyChoiceNumber(choice, 1, 5)) { 
			switch(choice) {
			case 1:
				ReviewManager.addReview(movie); //[presenter: change ReviewManager.addReview() to static, add in parameter] done by KJ
				break;
			case 2:
				ReviewManager.displayReview(movie); //[presenter: add method ReviewManager.displayReview(Movie movie)] done by KJ
				break;
			case 3:
				ReviewManager.giveRating(movie); //[presenter: same] done by KJ
				break;
			case 4:
				ReviewManager.getMovieRating(movie); //[presenter: same] Correct method is getMovieRating. done by KJ
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



