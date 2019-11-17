package View.moviegoer;
import static Presenter.BookingManager.*;
import static Presenter.CinemaOperatorManager.*;
import View.View;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Model.Booking;
import Model.Customer;
import Model.Movie;
import Model.Seat;

public class PaymentView extends View{
	private double price;
    private Seat seat;
    private Customer customer;
    private String TID;
    private double GST;
    private double totalPrice;
    
    Scanner sc = new Scanner(System.in);
    
    public PaymentView(Customer customer, Seat seat, double price) {
    	this.customer = customer;
        this.seat = seat;
        this.price = price;
    	generateTID();
    	computeTotalPrice();
	}	
    
    private void displayMenu() throws IOException {
    	System.out.println("Movie Payment");
    	System.out.println();
    	System.out.println("Transaction ID: " + TID);
    	System.out.println("Ticket price: " + price);
    	System.out.println("GST: " + GST);
    	System.out.println("Grand total: " + totalPrice);
        if (customer.getIsSenior()) {
        	System.out.println("50% off for senior citizen");
        }

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
   
    private void generateTID() {
    	TID = seat.getShowtime().getCinema().getCinemaID() +
                new SimpleDateFormat("YYYYMMddhhmm").format(new Date().getTime())
        ;
    }
    
    private void computeTotalPrice() {
        if (customer.getIsSenior()) 
        	price /= 2;
        GST = Math.round(price * 7)/100;
        totalPrice = Math.round((price+GST)*100)/100;
    }
    
    private void saveBooking() throws IOException {
       try {
    	seat.setOccupiedAt(seat.getShowtime(), true);
        Movie movie = seat.getShowtime().getMovie();
        getMovieList().get(getMovieList().indexOf(movie)).addTotalSales(1);
        Booking record = new Booking(TID, customer, seat);
        addBooking(record);
		updateShowTime();
        updateMovieListing();
        System.out.println("Payment has been made.");
       }
	    catch (IOException ex) {
	        ex.printStackTrace();
	        System.out.println("Payment failed.");
	    }
	        end();	    
    }

	@Override
	protected void starter() {
		try {
			displayMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}


