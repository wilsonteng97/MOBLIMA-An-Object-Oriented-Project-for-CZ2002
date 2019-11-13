package View.moviegoer;
 
import java.util.Scanner;
import Model.Customer;
import Presenter.BookingManager;
import View.View;

public class BookingHistoryView extends View{
	
    public BookingHistoryView() {
    	displayMenu();
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Enter your Name");
    	String customerNameIn = sc.next();
    	Customer customerName = Query.passStringCustomer(customerNameIn);
    	BookingManager.getBookingHistory(customerName); 
    }
	@Override
	protected void starter() {
		// TODO Auto-generated method stub
		
	}
}




