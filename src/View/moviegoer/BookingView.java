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
	private double price;
	
    public BookingView(String movieName, ShowTime showtime, int seatrow, int seatno) {
    	this.movieName=movieName;
    	this.showtime=showtime;
    	this.seatrow=seatrow;
    	this.seatno=seatno;
    }	
    private void displayMenu() {
    	boolean[] arrayBoo = new boolean[4];
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
    }
	//[model/presenter: save customer name, mobile no, email]
	
	private void printBookingDetail() {
        System.out.println("Showtime: " + showtime);
        System.out.println("Seat Row: " + seatrow + "Seat Number" + seatno);
        System.out.println();
        System.out.println("Ticket price: " + price + " SGD (Excl. GST)"); 
    }
	
	@Override
	protected void starter() {
    	displayMenu();
	}
}
