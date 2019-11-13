package View.moviegoer;
 
import java.util.Scanner;


import Model.Booking;
import View.View;

public class BookingHistoryView extends View{
	
    public void BookingView() {
    	displayMenu();
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your Name");
    	String customerName = sc.next();
    	Booking bookingHistory[] = getBookingHistory(customerName); // [presenter: getBookingHistory()]

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



