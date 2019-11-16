package View.moviegoer;
 
import java.util.ArrayList;
import java.util.Scanner;
import Model.Customer;
import Presenter.CustomerManager;
import Presenter.Query;

import static Presenter.BookingManager.*;
import View.View;

public class BookingHistoryView extends View{
	
    public BookingHistoryView() {
    	
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your Name");
    	String customerName = sc.next();
    	
    	Customer check_cust = Query.passStringCustomer(customerName);
    	if (check_cust != null) {
    		System.out.println("Booking History");  	
    		System.out.println();
    		getBookingHistory(customerName); 
    		end();
    	}
    	else {
    		System.out.println("No such customer exist");
    		end();
    	}
    }
	@Override
	protected void starter() {
		displayMenu();
		
	}
}




