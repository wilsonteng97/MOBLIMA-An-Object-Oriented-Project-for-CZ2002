package View.moviegoer;
import static Presenter.ReviewManager.*;
import View.View;
import static Presenter.Presenter.*;
import java.util.Scanner;

public class ReviewView extends View{
    public ReviewView() {
	}	
    
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		/*this.movie = passStringMovie(movieIn); */
    	System.out.println("(1) Write a review\n"
    			+ "(2) View all reviews\n"
    			+ "(3) Give a Rating\n"
    			+ "(4) View Average Rating\n"
    			+ "(5) Return\n");
    	System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { 
			switch(choice) {
			case 1:
				addReview(movieIn); 
				break;
			case 2:
				displayReview(movieIn); 
				break;
			case 3:
				giveRating(movieIn); 
				break;
			case 4:
				getMovieRating(movieIn); 
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



