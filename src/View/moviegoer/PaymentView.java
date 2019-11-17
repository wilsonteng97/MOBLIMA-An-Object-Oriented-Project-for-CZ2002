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

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentView for moviegoer to process payment.
 */
public class PaymentView extends View{
	
	/** The price. */
	private double price;
    
    /** The seat. */
    private Seat seat;
    
    /** The customer. */
    private Customer customer;
    
    /** The id. */
    private String id;
    
    /** The gst. */
    private double GST;
    
    /** The total price. */
    private double totalPrice;
    	
	/** The sc. */
	Scanner sc = new Scanner(System.in);
	
	/** The transaction method. */
	TransactionMethod transactionMethod = null;
    
    /**
     * Instantiates a new payment view.
     *
     * @param customer the customer
     * @param seat the seat
     * @param price the price
     */
    public PaymentView(Customer customer, Seat seat, double price) {
    	this.customer = customer;
        this.seat = seat;
        this.price = price;
    	setTransactionID();
	}	
    
    /**
     * Display menu.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
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
	
	/**
	 * Sets the transaction method.
	 */
	private void setTransactionMethod()
	{
		while(transactionMethod == null)
		{
			String choice = passChoiceString("Set the transaction from the following: \n"
			+"DEBIT_CREDIT, E_WALLET, QR_CODE");
			transactionMethod = getValueTransactionMethod(choice);
		}
	}
   
    /**
     * Sets the transaction ID.
     *
     * @return the string
     */
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
    
    /**
     * Save booking.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
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

	/**
	 * Starter.
	 */
	@Override
	protected void starter() {
		try {
			displayMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}