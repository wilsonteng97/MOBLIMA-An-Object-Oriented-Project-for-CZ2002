package View.moviegoer;

import static Presenter.BookingManager.*;
import static Presenter.CinemaOperatorManager.*;
import View.View;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import Model.Booking;
import Model.Customer;
import Model.Movie;
import Model.Seat;
import Model.Transaction;
import Model.Enums.BookingStatus;
import Model.Enums.ShowingStatus;
import Model.Enums.TransactionMethod;
import static Presenter.Presenter.*;
import static Model.Enums.TransactionMethod.*;

public class PaymentView extends View{
	private double price;
    private Seat seat;
    private Customer customer;
    private String id;
    private double GST;
    private double totalPrice;
    	
	Scanner sc = new Scanner(System.in);
	TransactionMethod transactionMethod = null;
    public PaymentView(Customer customer, Seat seat, double price) {
    	this.customer = customer;
        this.seat = seat;
        this.price = price;
    	setTransactionID();
	}	
    
    private void displayMenu() throws IOException {
		
    	System.out.println("Movie Payment\n");
		System.out.println("Transaction ID: " + id);
    	System.out.println("Ticket price: " + price);
    	System.out.println("GST: " + GST);
    	System.out.println("Grand total: " + price);
        if (customer.getIsSenior()) {
        	System.out.println("50% off for senior citizen");
        }
		setTransactionMethod();
        System.out.println();
        System.out.println("1. Confirm payment");
        System.out.println("2. Cancel");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                saveBooking();
                break;
            case 2:
            	end();
                break;
        }
	}
	
	private void setTransactionMethod()
	{
		while(transactionMethod == null)
		{
			String choice = passChoiceString("Set the transaction from the following: \n"
			+"DEBIT_CREDIT, E_WALLET, QR_CODE");
			transactionMethod = getValueTransactionMethod(choice);
		}
	}
   
    private String setTransactionID() {
		StringBuilder sb = new StringBuilder();
		double a = (Math.random()*((9999-1000)+1))+1000;
		Random r = new Random();
		for(int i =0; i<4; i++)
		{
			char c = (char)(r.nextInt(26) + 'a');
			sb.append(c);
		}
		sb.append(a);
		id = sb.toString();
		return id;
    }
    
    // private Double computeTotalPrice() {
    //     if (customer.getIsSenior()) 
    //     	price /= 2;
    //     GST = Math.round(price * 7)/100;
    //     totalPrice = Math.round((price+GST)*100)/100;
    //     return totalPrice;
    // }
    
    private void saveBooking() throws IOException {
        seat.setOccupied(true);
		Movie movie = seat.getShowtime().getMovie();
		movie.addTotalSales(1);
		Date today = Calendar.getInstance().getTime();
		Transaction transaction = new Transaction(setTransactionID(), price, today, transactionMethod);
        Booking record = new Booking(customer, today, transaction, BookingStatus.ACCEPTED, seat);
        addBooking(record);
        try {
			updateShowTime();
	        updateMovieListing();
		} catch (IOException e) {
			System.out.println("Fail to save the booking");
		}
        System.out.println();
        System.out.println("Payment succeed!");
        intent(this, new MovieListingView());
    }

	@Override
	protected void starter() {
		try {
			displayMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}



/*private void displayMenu() {
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
}*/