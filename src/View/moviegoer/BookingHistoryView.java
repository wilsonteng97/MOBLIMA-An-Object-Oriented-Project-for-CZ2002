package View.moviegoer;
 
import java.util.Scanner;
import static Presenter.BookingManager.*;
import View.View;

public class BookingHistoryView extends View{
	
    public BookingHistoryView() {
    	
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your Name");
    	String customerName = sc.next();
    	System.out.println("Booking History");  	
    	System.out.println();
     	getBookingHistory(customerName); 
     	end();
    }
	@Override
	protected void starter() {
		displayMenu();
		
	}
}




