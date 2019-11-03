package Presenter;

public class ReviewManager {
    int rating;
    String review;
    Scannner sc = new Scanner(System.in);

    public ReviewManager()  {
        this.giveRating(userID);
        this.addReview(userID);
    }

    public String addReview(int userID){
        System.out.println("Please provide your review.");
        review = sc.next();
        return review;
    }

    public int giveRating (int userID){
        do {
            System.out.println("Please provide your rating (1-5).");
            rating = sc.nextInt();
        } while ((rating>0) && (rating<6));
        
        return rating;
    }
}