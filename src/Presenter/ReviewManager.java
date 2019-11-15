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

    public static void addReview(Movie movie){ 
        
        System.out.println("Please provide your review.");
        review = sc.next();
        reviewList.movie.add(review);
        updateReviewList();
        
        /*
         printHeader("Write Review:");
        String name = readString("Please enter your name:");
        printMenu("Please enter your rating: (integer between 1 ~ 5)");
        int rating = readChoice(1, 5);
        String content = readString("Please enter your comments:");
        Review review = new Review(this.movie, rating, content, name);

        try {
            addNewReview(movie, review);
            System.out.println("Successfully created review for " + movie.getTitle());
        }
        catch (IOException ex) {
            System.out.println("Failed to create review for " + movie.getTitle());
        }
         */
        
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

    public static Review[] displayReview(Movie movie){
    	return all_reviews;
    	/*
    	 printHeader("Reviews for " + movie.getTitle());
        ArrayList<Review> reviewList = CineplexManager.getReviewList(movie);

        if (reviewList != null){
            int index = 0;
            for (Review r : reviewList) {
                System.out.println(++index + " Name:     " + r.getName());
                System.out.println("  Date:     " + formatTimeMMddkkmm(r.getDate()));
                System.out.println("  Rating:   " + r.getRating());
                System.out.println("  Comments: " + addLinebreaks(r.getContent(), 45, 12));
                System.out.println();
            }
        }
        else{
            System.out.println("Currently no review.");
        }
    	 */
    }
}