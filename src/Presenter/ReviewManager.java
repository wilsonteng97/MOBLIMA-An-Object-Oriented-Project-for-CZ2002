package Presenter;

import Model.Review;
import Presenter.Query;

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

    public void addReview(String movieIn){
        this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie]
        
        System.out.println("Please provide your review.");
        review = sc.next();
        reviewList.movie.add(review);
        updateReviewList();
    }

    public void giveRating (String movieIn){
        this.movie = passStringMovie(movieIn);

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

    public double getMovieRating(Movie movie){
        return movie.getMovieRating();
    }

    public Review[] displayReview(Movie movie){
        return all_reviews;
    }
}