package View.moviegoer;
import Presenter.ReviewManager;
import Presenter.Presenter;
import java.util.Scanner;

public class ReviewView extends View{
	private Movie movie;
	
    public ReviewView() {
    	displayMenu();
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie]
    	System.out.println("(1) Write a review\n"
    			+ "(2) View all reviews\n"
    			+ "(3) Give a Rating\n"
    			+ "(4) View Average Rating\n"
    			+ "(5) Return\n");
    	System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (passChoiceNumber(choice, 1, 5)) { //[presenter: change passChoiceNumber() to boolean]
			switch(choice) {
			case 1:
				ReviewManager.addReview(movie); //[presenter: change ReviewManager.addReview() to static, add in parameter]
				break;
			case 2:
				ReviewManager.displayReview(movie); //[presenter: add method ReviewManager.displayReview(Movie movie)]
				break;
			case 3:
				ReviewManager.giveRating(movie); //[presenter: same]
				break;
			case 4:
				ReviewManager.displayRating(movie); //[presenter: same]
				break;
			case 5:
				break;
		}
    }
}



