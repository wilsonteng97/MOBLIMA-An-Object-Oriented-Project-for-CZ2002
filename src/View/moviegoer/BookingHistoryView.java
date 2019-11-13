package View.moviegoer;
 
import java.util.Scanner;
import Presenter.BookingManager;

public class BookingHistoryView extends View{
	
    public BookingView() {
    	displayMenu();
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your Name");
    	int customerName = sc.next();
    	BookingHistory bookingHistory[] = getBookingHistory(customerName); // [presenter: getBookingHistory()] done by KJ

        if (bookingHistory == null) {
            System.out.println("No history to show.");
        }
        else {
            for (int i=0; i<50; i++) {
                System.out.println(bookingHistory[i]);
            }
        }
    }
}



