package Presenter;

import Model.Movie;
import Model.Review;
import static Presenter.Query.*;
import static Presenter.Presenter.*;

public class ReviewManager {
    int rating;
    String review;
    Scannner sc = new Scanner(System.in);
    // Customer CustReview = new Customer();
    // int userID = CustReview.getEmail();
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private static Hashmap<Movie, ArrayList<ReviewList>> reviewList;

    public ReviewManager()  {
        
    }

    public static void addReview(String movieIn){
        Movie movie = passStringMovie(movieIn); 
        
        System.out.println("Please provide your review.");
        review = sc.next();
        reviewList.movie.add(review);
        updateReviewList();
    }

    public static void giveRating (String movieIn){
        Movie movie = passStringMovie(movieIn);

        do {
            System.out.println("Please provide your rating (1-5).");
            rating = sc.nextInt();
        } while (!((rating>0) && (rating<6)));
        
        //the proceed to add rating for movie
    }

    public static void removeReview(Movie movie, Review review)
    {
        reviewList.get(movie).remove(review);
        updateReviewList();
    }

    public static double getMovieRating(String movieIn){
    	Movie movie = passStringMovie(movieIn);
    	return movie.getMovieRating();
    }

    public static Review[] displayReview(String movieIn){
    	Movie movie = passStringMovie(movieIn);
    	return all_reviews;
    }
}