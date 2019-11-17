package View.moviegoer;
 
import java.util.Scanner;
import Model.Customer;
import Presenter.Query;

import static Presenter.BookingManager.*;
import static Presenter.Query.*;
import View.View;

public class BookingHistoryView extends View{
	
    public BookingHistoryView() {
    	
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your Name");
		String customerName = sc.nextLine();
    	
		Customer check_cust = passStringCustomer(customerName);
    	if (check_cust != null) {
    		System.out.println("Booking History");  	
    		System.out.println();
    		getBookingHistory(check_cust); 
    		goBack();
    		end();
    	}
    	else {
    		System.out.println("No such customer exist");
    		goBack();
    		end();
    	}
    }
	@Override
	protected void starter() {
		displayMenu();
		
	}
}




