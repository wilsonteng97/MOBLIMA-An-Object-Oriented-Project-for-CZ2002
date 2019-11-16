package Presenter;

import Model.Customer;
import Model.Movie;
import Model.Review;
import static Presenter.Query.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import static Presenter.Presenter.*;
import static Presenter.CinemaOperatorManager.*;

public class ReviewManager {
      
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private static HashMap<Movie, ArrayList<Review>> reviewList;

    public ReviewManager()  {
        
    }

    public static void addNewReview(Movie movie) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Write Review:");
    	System.out.println("Please enter your name:");
        String name = sc.next();
        Customer customer = passStringCustomer(name);
        System.out.println("Please enter your rating: (integer between 1 ~ 5)");
        int rating = sc.nextInt();
        System.out.println("Please enter your comments:");
        String comment = sc.next();
        
        Review review = new Review(rating, comment, null, customer);        
        movie.addReview(review);
		System.out.println("Successfully created review for " + movie.getTitle());
    	if(reviewList.get(movie) == null) 
        	reviewList.put(movie, new ArrayList<>());
        reviewList.get(movie).add(review);
        updateReviewList();
    }              

    public static void removeReview(Movie movie, Review review) throws IOException
    {
        movie.removeReview(review);
    }

    public static double getMovieRating(Movie movie) {
        double aveRating = movie.getReviewRatingAverage();
        return aveRating;
//    	ArrayList<Review> reviewList = getReviewList(movie);
//        if (reviewList == null || reviewList.isEmpty()) return 0;
//        else {
//            double sum = 0;
//            for (Review review : reviewList) sum += review.getRating();
//            return Math.round(sum / reviewList.size()*10)/10;
//        }
    }
    
    public static ArrayList<Review> getReviewList(Movie movie) {
        return reviewList.get(movie);
    }
    
    public static void updateReviewList() throws IOException {
    	writeDataFile(reviewList, reviewListFile);
    }

    public static void displayReview(Movie movie){
    	System.out.println("Reviews for " + movie.getTitle());
        ArrayList<Review> reviewList = getReviewList(movie);
        if (reviewList != null){
            int index = 0;
            for (Review r : reviewList) {
                System.out.println(++index + "Customer:     " + r.getCustomer());
                System.out.println("  Date:     " + formatTimeDate(r.getDate()));
                System.out.println("  Rating:   " + r.getRating());
                System.out.println("  Comments: " + r.getComment());
                System.out.println();
            }
        }
        else{
            System.out.println("Currently no review.");
        }
    }
}