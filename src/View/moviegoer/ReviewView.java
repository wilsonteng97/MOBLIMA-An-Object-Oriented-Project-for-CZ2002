package View.moviegoer;
import static Presenter.Presenter.formatTimeDate;
import static Presenter.Query.passStringCustomer;
import static Presenter.ReviewManager.*;
import View.View;
import static Model.Enums.ShowingStatus.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import Model.Customer;
import Model.Movie;
import Model.Review;

public class ReviewView extends View{
	private Movie movie;
	
	public ReviewView(Movie movie) {
    	this.movie=movie;
	}	    
	
    private void displayMenu() throws IOException {
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
                addReview();
                break;
            case 2:
            	displayReview();
                break;
            case 3:
            	end();
                break;
        }
        end();
    }	
    
    private void addReview(){
	    Scanner sc = new Scanner(System.in);
		System.out.println("Write Review:");
		System.out.println("Please enter your name:");
	    String name = sc.next();
	    Customer customer = passStringCustomer(name);
	    System.out.println("Please enter your rating: (integer between 1 ~ 5)");
	    int rating = sc.nextInt();
	    System.out.println("Please enter your comments:");
	    String comment = sc.next();
	    Date today = Calendar.getInstance().getTime();
	    Review review = new Review(rating, comment, today, customer, movie);
	    
	    try {
	        addNewReview(review);
	        System.out.println("Successfully added review for " + movie.getTitle());
	    }
	    catch (IOException ex) {
	        System.out.println("Failed to add review for " + movie.getTitle());
	    }
	    finally {
	        starter();
	    }
    }
    
    private void displayReview(){
	    System.out.println("Reviews for " + movie.getTitle());
	    ArrayList<Review> reviewList = getReviewList(movie);
	    if (reviewList != null){
	        int i = 0;
	        for (Review r : reviewList) {
	            System.out.println(++i + " Customer:     " + r.getCustomer().getName());
	            System.out.println("  Date:     " + formatTimeDate(r.getDate()));
	            System.out.println("  Rating:   " + r.getRating());
	            System.out.println("  Comments: " + r.getComment());
	            System.out.println();
	        }
	    }
	    else{
	        System.out.println("No review.");
	    }
	    goBack();
	    starter();
    }
        
    @Override
	protected void starter() {
    	try {
			displayMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void end() {
    	((MovieListingView)(getPrevious())).starter(movie);
	}
  }
