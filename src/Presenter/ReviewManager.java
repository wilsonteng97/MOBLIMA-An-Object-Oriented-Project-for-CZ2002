package Presenter;

public class ReviewManager {
    int rating;
    String review;
    Scannner sc = new Scanner(System.in);

    // Customer CustReview = new Customer();
    // int userID = CustReview.getEmail();

    public ReviewManager()  {
        
    }

    public String addReview(){
        System.out.println("Please provide your review.");
        review = sc.next();
        return review;
    }

    public int giveRating (){
        do {
            System.out.println("Please provide your rating (1-5).");
            rating = sc.nextInt();
        } while (!((rating>0) && (rating<6)));
        
        return rating;
    }
}