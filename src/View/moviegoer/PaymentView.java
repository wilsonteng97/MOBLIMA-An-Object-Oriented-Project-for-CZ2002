package View.moviegoer;
import Presenter.Presenter; 
import java.util.Scanner;

public class PaymentView extends View{
    private Double price;
    private String TID;
	
    public PaymentView(Double price) {
    	this.price = price;
    	generateTID();
    	displayMenu();
	}	
    private void generateTID() {
        TID = cinema.getCinemaCode(); //[model: getCinemaCode]
        TID = TID.concat(passSearchMovieTime()); //[presenter: is this method convert current time to string?]
    }
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Transaction ID: " + TID);
    	System.out.println("Ticket price: " + price);
    	System.out.println("GST: " + round(price * 0.07, 2));
    	System.out.println("Grand total: " + (price+round(price * 0.07, 2)));
    	System.out.println("Ticket price: " + price);		
    	System.out.println("(1) Confirm Payment\n"
    			+ "(2) Cancel Payment");
		int choice = sc.nextInt();
		while (passChoiceNumber(choice, 1, 2)) { 
			switch(choice) {
			case 1:
				saveBooking(); //[presenter: save the booking to booking history]
				break;
			case 2:
				break;
			}
		}
    }
	
}



