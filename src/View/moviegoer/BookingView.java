package View.moviegoer;

import Presenter.Presenter;
import Presenter.Query;
import Presenter.PurchaseNOrder;
import View.View;

import java.util.Scanner;

public class BookingView extends View{
	private int age;
    private Double price;
	
    public BookingView() {
	}	
    private void displayMenu() {
    	int choice;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("(1) Please Choose Cinema\n"
    			+ "(2) Please Choose Movie\n"
    			+ "(3) Please Choose Showtime\n"
    			+ "(4) Please Choose your Seat\n"
    			+ "(5) Please Enter your Name\n"
    			+ "(6) Please Enter your Mobile Number\n"
    			+ "(7) Please Enter your Email\n"
    			+ "(8) Please Enter your Age\n"
    			+ "(9) Print Booking Details\n"
    			+ "(10) Make Payment\n"
        		+ "(11) Return\n");
    	System.out.println("Enter the number of your choice: ");
		choice = sc.nextInt();

		while (Presenter.verifyChoiceNumber(choice, 1, 10)) { 
			switch(choice) {
			case 1:
				String cinemaIn = sc.next();
				this.cinema = passStringCinema(cinemaIn); //[presenter: change input from string to Cinema] done by KJ
				break;
			case 2:
				String movieIn = sc.next();
				this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie] done by KJ
				break;
			case 3:
				double showtimeIn = sc.nextDouble();
				this.showtime = passDoubleShowtime(showtimeIn); //[presenter: change input from double to Showtime] done by KJ
				break;
			case 4:
				Seat seatIn = selectSeat(); //[presenter: selectSeat(), return Seat seat] done by KJ
				if (seatAvailable(seatIn)) //[presenter: seatAvailable(Seat seat)check whether the seat is available]
					this.seat=seatIn;
				else
					System.out.println("This seat is not available, please choose another seat");
				break;
			case 6:
				String nameIn = sc.next();
				customer.setName(nameIn);
				break;
			case 7:
				String mobileIn = sc.next();
				customer.setMobileNo(mobileIn);
				break;
			case 8:
				String emailIn = sc.next();
				customer.setEmail(emailIn);
				break;
			case 8:
				Int ageIn = sc.nextInt();
				this.age = ageIn;
				break;
			case 9:
				printBookingDetail();
			case 10:
				intent(this, new PaymentView());
				break;
			case 11:
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

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	protected void starter() {
    	displayMenu();
	}
}
