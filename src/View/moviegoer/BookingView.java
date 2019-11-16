package View.moviegoer;

import static Model.Enums.MovieType.MOVIE3D;
import static Presenter.Presenter.*;
import static Presenter.PurchaseNOrder.*;
import View.View;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import Model.Cinema;
import Model.Customer;
import Model.Holiday;
import Model.Movie;
import Model.Seat;
import Model.ShowTime;

public class BookingView extends View{

	private Seat seat;
    private String ticketType;
    private double price;
    private boolean bookingDone;
    Scanner sc = new Scanner(System.in);
    public BookingView(Seat seat) {
    	this.seat = seat;
        price = seat.getShowtime().getMovieTickets().get(0).getPrice();
        bookingDone = false;
        computePrice();
    }	

    private void computePrice() {
    	Date movieDate = seat.getShowtime().getTime();
    	Calendar c1 = Calendar.getInstance();
        c1.setTime(movieDate);
    	Holiday holiday = getHoliday(seat.getShowtime().getTime());
        if (holiday != null) {
            double rate = holiday.getRate();
            price = rate * price;
            ticketType = holiday.getName();
        }
        else {
            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
            		c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                price = price * 1.2;
                ticketType = "Weekend";
            }
            else {
                ticketType = "Weekday";
            }
        }
    }
    
    private void displayMenu() {
    	System.out.println("Booking detail");
    	System.out.println();
        printBookingDetail();
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
    	
	private void printBookingDetail() {
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
        		+ "Validation upon entering");
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


/*private void displayMenu() {
/*boolean[] arrayBoo = new boolean[4];
int choice;

System.out.println("(1) Please Enter your Name\n"
		+ "(2) Please Enter your Mobile Number\n"
		+ "(3) Please Enter your Email\n"
		+ "(4) Please Enter your Age\n"
		+ "(5) Print Booking Details\n"
		+ "(6) Make Payment\n"
		+ "(7) Return\n");
System.out.println("Enter the number of your choice: ");
choice = sc.nextInt();

while (verifyChoiceNumber(choice, 1, 7)) { 

	switch(choice) {
	
	case 1:
		String nameIn = sc.next();
		recordName(nameIn);

		arrayBoo[0]=true;

		break;
	case 2:
		String mobileIn = sc.next();
		recordMobileNo(mobileIn);

		arrayBoo[1]=true;

		break;
	case 3:
		String emailIn = sc.next();
		recordEmail(emailIn);

		arrayBoo[2]=true;
		break;
	case 4:
		int ageIn = sc.nextInt();
		arrayBoo[3]=true;

		break;
	case 5:
		printBookingDetail();
	case 6:

		for (int i=0;i<4;i++) {
			if (arrayBoo[i] == false)
				System.out.println("please fill in ("+(i+1)+")");
			else {
				
				price = computePrice(movieName, showtime, ageIn);
				//computePrice(String movieName, ShowTime showtime, int ageIn)
				//[presenter: computePrice() according to holiday, age, movie type, cinema class]
				intent(this, new PaymentView(price));
			}
		}
		

		break;
	case 7:
		break;
	  }
  }
}*/