package Presenter;

import Model.Movie;
import Model.Review;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static Presenter.CinemaOperatorManager.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ReviewManager .
 */
public class ReviewManager {
      
    /** The Constant reviewListFile is the txt file. */
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    
    /** The review list. */
    private static HashMap<Movie, ArrayList<Review>> reviewList;

    /**
     * Instantiates a new review manager.
     */
    public ReviewManager()  {
        
    }    
    
    /**
     * Read review list from the txt file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void readReviewList() throws IOException
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

    /**
     * Adds the new review and update it into the txt file.
     *
     * @param review the review
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void addNewReview(Review review) throws IOException {
        if(reviewList.get(review.getMovie()) == null) 
        	reviewList.put(review.getMovie(), new ArrayList<>());
        reviewList.get(review.getMovie()).add(review);
        updateReviewList();
    }             

    /**
     * Removes the review.
     *
     * @param movie the movie
     * @param review the review
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void removeReview(Movie movie, Review review) throws IOException
    {
        movie.removeReview(review);
    }

    /**
     * Gets the movie's average rating.
     *
     * @param movie the movie
     * @return the movie rating
     */
    public static double getMovieRating(Movie movie) {
        double aveRating = movie.getReviewRatingAverage();
        return aveRating;
    }
    
    /**
     * Gets the review list.
     *
     * @param movie the movie
     * @return the review list
     */
    public static ArrayList<Review> getReviewList(Movie movie) {
        return reviewList.get(movie);
    }
    
    /**
     * Update the review list onto the txt file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void updateReviewList() throws IOException {
    	writeDataFile(reviewList, reviewListFile);
    }
}