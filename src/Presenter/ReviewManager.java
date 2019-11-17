package Presenter;

import Model.Movie;
import Model.Review;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static Presenter.CinemaOperatorManager.*;

public class ReviewManager {
      
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private static HashMap<Movie, ArrayList<Review>> reviewList;

    public ReviewManager()  {
        
    }    
    public static void readReviewList()
    {
        if(readDataFile_HashMap(reviewListFile) == null)
        {
            reviewList = new HashMap<>();
        }
        else
        {
            reviewList = (HashMap<Movie, ArrayList<Review>>) readDataFile_HashMap(reviewListFile);
        }
    }

    public static void addNewReview(Review review) throws IOException {
        if(reviewList.get(review.getMovie()) == null) 
        	reviewList.put(review.getMovie(), new ArrayList<>());
        reviewList.get(review.getMovie()).add(review);
        updateReviewList();
    }             

    public static void removeReview(Movie movie, Review review) throws IOException
    {
        movie.removeReview(review);
    }

    public static double getMovieRating(Movie movie) {
        double aveRating = movie.getReviewRatingAverage();
        return aveRating;
    }
    
    public static ArrayList<Review> getReviewList(Movie movie) {
        return reviewList.get(movie);
    }
    
    public static void updateReviewList() throws IOException {
    	writeDataFile(reviewList, reviewListFile);
    }
}