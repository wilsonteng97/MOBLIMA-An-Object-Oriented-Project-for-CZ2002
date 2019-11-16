package View.moviegoer;
import static Presenter.ReviewManager.*;
import View.View;
import static Model.Enums.ShowingStatus.*;
import java.util.Scanner;

import Model.Movie;

public class ReviewView extends View{
	private Movie movie;
	public ReviewView(Movie movie) {
    	this.movie=movie;
	}	    
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Movie Review");
    	if (movie.getStatus() == COMING_SOON) {
    		System.out.println();
    		System.out.println("Movie coming soon.");
            end();
        }
    	System.out.println();
    	System.out.println("(1) Write a review\n"+
                "(2) View all reviews\n"+
                "(3) Return");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addReview(movie);
                break;
            case 2:
            	displayReview(movie);
                break;
            case 3:
            	end();
                break;
        }
        end();
    }	
	@Override
	protected void starter() {
    	displayMenu();
	}
	protected void end() {
    	
	}
  }



/*System.out.println("(1) Write a review\n"
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
}*/
