package Presenter;

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

    public void addReview(Movie movie){
        System.out.println("Please provide your review.");
        review = sc.next();
        reviewList.get(movie).add(review);
        updateReviewList();
    }

    public int giveRating (){
        do {
            System.out.println("Please provide your rating (1-5).");
            rating = sc.nextInt();
        } while (!((rating>0) && (rating<6)));
        
        return rating;
    }

    public static void removeReview(Movie movie, Review review)
    {
        reviewList.get(movie).remove(review);
        updateReviewList();
    }

    public double getMovieRating(Movie movie){
        return movie.getMovieRating();
    }
}