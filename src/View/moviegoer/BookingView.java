package View.moviegoer;
import Model.Customer;
import Model.Cinema;
import Model.Seat;
import Presenter.Presenter;
import Presenter.Query;
import java.util.Scanner;

public class BookingView extends View{
	private Seat seat;
	private Movie movie;
	private Showtime showtime;
	private Cinema cinema;
    private Double price;
	
    public BookingView() {
    	Customer customer = new Customer(); //[model: customer constructer without parameter]
    	Seat seat = new Seat(); //[model: customer constructer without parameter]
    	displayMenu();
	}	
    private void displayMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("(1) Please Choose Cinema\n"
    			+ "(2) Please Choose Movie\n"
    			+ "(3) Please Choose Showtime\n"
    			+ "(4) Please Choose Seat Row\n"
    			+ "(5) Please Choose Seat Number\n"
    			+ "(6) Please Enter your Name\n"
    			+ "(7) Please Enter your Mobile Number\n"
    			+ "(8) Please Enter your Email\\n"
    			+ "(9) Print Booking Details"
        		+ "(10) Return\n");
    	System.out.println("Enter the number of your choice: ");
		  choice = sc.nextInt();

		while (verifyChoiceNumber(choice, 1, 10)) { //[presenter: change passChoiceNumber() to boolean] Done by KJ
			switch(choice) {
			case 1:
				String cinemaIn = sc.next();
				this.cinema = passStringCinema(cinemaIn); //[presenter: change input from string to Cinema]
				break;
			case 2:
				String movieIn = sc.next();
				this.movie = passStringMovie(movieIn); //[presenter: change input from string to Movie]
				break;
			case 3:
				double showtimeIn = sc.next();
				this.showtime = passDoubleShowtime(showtimeIn); //[presenter: change input from double to Showtime]
				break;
			case 4:
				String seatRowIn = sc.next();
				seat.setSeatRow(seatRowIn);
				break;
			case 5:
				int seatNoIn = sc.nextInt();
				seat.setSeatNo(seatNoIn);
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
			case 9:
				printBookingDetail();
			case 10:
				break;
			  }
		  }
    }
	//[model/presenter: save customer to database?]
	
	//need help, incomplete code computePrice() according to holiday, age, movie type, cinema class
		
	/*private double computePrice(price) {
        Holiday holiday = getHoliday(showtime); //[model: Holiday class, getholiday()]
        if (holiday != null) {
            price = price.holidayDiscount(); //[model: holidayDiscount()]
        }
        else {
           
        }
        return price;
    }*/
		
	private void printBookingDetail() {
        System.out.println("Cinema: " + cinema + " (" + cinema.getOperator() + ")");
        System.out.println("Showtime: " + showtime);
        System.out.println("Seat Row: " + seat.getSeatRow() + "Seat Number" + seat.getSeatNo());
        System.out.println();
        System.out.println("Ticket price: " + computePrice(price) + " SGD (Excl. GST)");
    }
}
