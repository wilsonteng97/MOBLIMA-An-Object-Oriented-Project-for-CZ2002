package View.moviegoer;

import static Model.Enums.MovieType.MOVIE3D;
import static Presenter.Presenter.*;
import static Presenter.PurchaseNOrder.*;
import View.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import Model.Cinema;
import Model.Customer;
import Model.Holiday;
import Model.Movie;
import Model.Seat;
import Model.ShowTime;
import static Presenter.AdminManager.*;

public class BookingView extends View{
	private Seat seat;
    private String ticketType;
    private double price;
    private boolean bookingDone;
    private ShowTime showTime;

    private double HOLIDAY_RATE = 1;
    private double WEEKEND_RATE = 1; 
    private double SENIOR_CITIZEN_RATE = 1;
    private double TOTAL_RATE = 1;
    
    Scanner sc = new Scanner(System.in);
    
    public BookingView(Seat seat, ShowTime showTime) {
        this.seat = seat;
        this.showTime=showTime;
        price = seat.getShowtime().getCinema().getBasePrice();
        bookingDone = false;
        System.out.println("Are you a Senior Citizen? (Y or N). ID will be checked when you enter the cinema");
        String input = null;
        while (input!="Y" || input!="y" || input!="N" || input!="n") {
            input = sc.next();
            input = input.toUpperCase();
            System.out.println("test");
        }
        Boolean isSeniorCitizen = input.equals("Y") ? true : false;
        computePrice(isSeniorCitizen);
        displayMenu();
    }	

    private void computePrice(Boolean isSeniorCitizen) {
        ArrayList<Holiday> holidayList = getHolidayList();
        if (!holidayList.isEmpty()) {
            for (Holiday h : holidayList) {
                if (h.getDate().getMonth()==showTime.getTime().getMonth() &&
                    h.getDate().getDay()== showTime.getTime().getDay()) {
                        HOLIDAY_RATE = h.getRate();
                    }
            }
        }
        if (showTime.getTime().getDay()==6 || showTime.getTime().getDay()==7) {
            WEEKEND_RATE = 1.2;
        }

        if (isSeniorCitizen) {
            SENIOR_CITIZEN_RATE = 0.5;
        }
        TOTAL_RATE *= HOLIDAY_RATE * WEEKEND_RATE * SENIOR_CITIZEN_RATE;
    }
    
    private void displayMenu() {
        double totalprice = price * TOTAL_RATE;
        System.out.println("Total Ticket price will be $" + totalprice);
    	System.out.println("Booking detail");
    	System.out.println();
        displayBookingDetail();
        System.out.println();
        System.out.println("(1) Proceed\n"+
                "(2) Return");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                customerInfo();
                break;
            case 2:            	
            	end();
                break;
        }
    }  
    	
	private void displayBookingDetail() {
		ShowTime showtime = seat.getShowtime();
        Movie movie = showtime.getMovie();
        Cinema cinema = showtime.getCinema();
        System.out.println();
        System.out.println(movie.getTitle() + " (" + movie.getType().equals(MOVIE3D) != null ? "3D" : "Digital" + ")");
        System.out.println(movie.getAgeRestriction());
        System.out.println("Cinema: " + cinema + " (" + cinema.getCinemaOperator() + ")");
        System.out.println("Showing on " + formatTimeDate(showtime.getTime()));
        System.out.println("Seat: Row " + (seat.getRow()+1) + " Col " + ((seat.getCol() > 8) ? seat.getCol() : (seat.getCol()+1)));
        System.out.println();
        System.out.println("Ticket type: " + ticketType);
        System.out.println("Ticket price: " + Math.round(price*100)/100 + " SGD (Excl. GST)");
    }

	private void customerInfo() {
		System.out.println();
		System.out.println("Please enter your name:");
        String name = sc.next();
        System.out.println("Please enter your mobile number:");
        String mobile = sc.next();
        System.out.println("Please enter your Email address:");
        String email = sc.next();
        System.out.println("Enter Y if you are senior citizen:\n"
        		+ "(Validation upon entering)");
        String seniorIn = sc.next();
        boolean isSenior = false;
        if (seniorIn=="Y") {
        	isSenior = true;
        }

        Customer customer = new Customer(name, mobile, email, isSenior);
        bookingDone = true;
        intent(this, new PaymentView(customer, seat, price));
    }
	
	@Override
	protected void starter() {
		if (bookingDone) 
			end();
		else
			displayMenu();
	}
	protected void end() {
		intent(this, new MovieListingView());
	}
}


