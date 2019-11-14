package View.moviegoer;

import static Presenter.Presenter.*;
import Presenter.Query;
import Presenter.PurchaseNOrder;
import View.View;

import java.util.Scanner;

import Model.ShowTime;

public class BookingView extends View{
	
	private String movieName;
	private ShowTime showtime;
	private int seatrow;
	private int seatno;
    public BookingView(String movieIn, ShowTime showtimeIn, int seatrowIn, int searnoIn) {
    	movieName=movieIn;
    	showtime=showtimeIn;
    	seatrow=seatrowIn;
    	seatno=searnoIn;
	}	
    private void displayMenu() {
    	int choice;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("(1) Please Enter your Name\n"
    			+ "(2) Please Enter your Mobile Number\n"
    			+ "(3) Please Enter your Email\n"
    			+ "(4) Please Enter your Age\n"
    			+ "(5) Print Booking Details\n"
    			+ "(6) Make Payment\n"
        		+ "(7) Return\n");
    	System.out.println("Enter the number of your choice: ");
		choice = sc.nextInt();

		while (verifyChoiceNumber(choice, 1, 10)) { 
			switch(choice) {
			
			case 1:
				String nameIn = sc.next();
				recordName(nameIn);
				break;
			case 2:
				String mobileIn = sc.next();
				recordMobileNo(mobileIn);
				break;
			case 3:
				String emailIn = sc.next();
				recordEmail(emailIn);
				break;
			case 4:
				int ageIn = sc.nextInt();
				recordAge(ageIn);
				break;
			case 5:
				printBookingDetail();
			case 6:
				double price=computeprice(Cinema cinema, String movieIn, int age, double Showtime);
				intent(this, new PaymentView(price));
				break;
			case 7:
				break;
			  }
		  }
    }
	//[model/presenter: save customer name, mobile no, email]
	
	private void printBookingDetail() {
        System.out.println("Cinema: " + cinema + " (" + cinema.getOperator() + ")");
        System.out.println("Showtime: " + showtime);
        System.out.println("Seat Row: " + seat.getSeatRow() + "Seat Number" + seat.getSeatNo());
        System.out.println();
        System.out.println("Ticket price: " + computePrice(cinema, showtime, age, movie) + " SGD (Excl. GST)"); //[presenter: computePrice() according to holiday, age, movie type, cinema class]
    }
	
	@Override
	protected void starter() {
    	displayMenu();
	}
}
