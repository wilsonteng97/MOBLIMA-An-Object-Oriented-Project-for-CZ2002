package View.moviegoer;
import static Presenter.Presenter.*;
import static Presenter.PurchaseNOrder.*;

import View.View;

import java.util.Scanner;

public class PaymentView extends View{
    private Double price;
    private String TID;
	
    public PaymentView(Double price) {
    	this.price = price;
    	generateTID();
	}	
    
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Transaction ID: " + TID);
    	System.out.println("Ticket price: " + price);
    	System.out.println("GST: " + Math.round(price * 0.07*100)/100);
    	System.out.println("Grand total: " + (price+Math.round(price * 0.07*100)/100));
    	System.out.println("Ticket price: " + price);		
    	System.out.println("(1) Confirm Payment\n"
    			+ "(2) Cancel Payment");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 2)) { 
			switch(choice) {
			case 1:
				saveBooking(); //[presenter: save the booking to booking history]
				break;
			case 2:
				break;
			}
		}
    }
	@Override
	protected void starter() {
		displayMenu();		
	}
	
}



