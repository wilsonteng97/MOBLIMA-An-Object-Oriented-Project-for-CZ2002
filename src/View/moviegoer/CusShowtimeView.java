package View.moviegoer;

import static Presenter.Presenter.*;
import static Model.Enums.ShowingStatus.*;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Presenter.*;
import View.View;
import java.util.Scanner;
import static Model.Enums.MovieType.*;
import Model.Movie;
import Model.Seat;
import Model.ShowTime;
import java.util.ArrayList;
import java.util.Date;


public class CusShowtimeView extends View{
	private Movie movie;
	
	Scanner sc = new Scanner(System.in);
	
	public CusShowtimeView(Movie movieInput) {
		movie=movieInput;
	}
	
	private void displayMenu() {
        ArrayList<ShowTime> showtimeList = getShowTimeList(movie);	
		Date today = new Date();
        Date tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
        Date afterTomorrow = new Date(new Date().getTime() + 2* 24 * 60 * 60 * 1000);
        Date dateSelected;
        

        if (movie.getStatus().equals(NOW_SHOWING)) {
            
        	System.out.println("Movie Showtime");
        	System.out.println();
        	System.out.println("(1) " + formatTimeDate(today) + " (today)\n"+
                    "(2) " + formatTimeDate(tomorrow) + " (tomorrow)\n"+
                    "(3) " + formatTimeDate(afterTomorrow) + " (after tomorrow)\n"+
                    "Please choose a date:");
            int choice = sc.nextInt();
    		switch (choice) {
                case 1:
                	dateSelected = today;
                    break;
                case 2:
                	dateSelected = tomorrow;
                    break;
                default:
                	dateSelected = afterTomorrow;
                    break;
            }
        }
        else {
        	System.out.println();
        	System.out.println("1. " + formatTimeDate(tomorrow)+
                    "\n2. " + formatTimeDate(afterTomorrow)+
                    "\nPlease choose a date:");
        	int choice = sc.nextInt();
    		switch (choice) {
                case 1:
                	dateSelected = tomorrow;
                    break;
                default:
                	dateSelected = afterTomorrow;
                    break;
            }
        }
        System.out.println();
        System.out.println("Showtime on " + formatTimeDate(dateSelected));
        System.out.println();
        int index = 1;
        for (ShowTime s : showtimeList) {
            System.out.println( index + ": " + s.getTime());
            index++;
        }

        if (movie.getShowTimes() != null) {
            for (ShowTime s : movie.getShowTimes()) {
                if (s.getTime().equals(dateSelected)) showtimeList.add(s);
            }
        }

        if (showtimeList.isEmpty()) {
        	System.out.println("No showtime on that day.");
        	goBack();
        	end();
            return;
        }

//        int i = 0;
//        for (ShowTime s : showtimeList) {
//            System.out.println(++i + ": " + s);
//        }
        System.out.println();
        System.out.println("Please choose a showtime:\n");
        
        int choice = sc.nextInt();        

        ShowTime showtime = showtimeList.get(choice - 1);
        displayShowtimeDetail(showtime);
	}

	private void displayShowtimeDetail(ShowTime showtime) {
		System.out.println();
		System.out.println("Details for " + showtime.getTime());
		System.out.println("(1) Check seat availability"+
                "(2) Book seat"+
                "(3) Check price"+
                "(4) Return");

		int choice = sc.nextInt();
        switch (choice) {
            case 1:
                displaySeat(showtime.getSeats());
                displayShowtimeDetail(showtime);
                break;
            case 2:
                displaySeat(showtime.getSeats());
                bookSeatMenu(showtime);
                break;
            case 3:
                displayPrice(showtime);
                break;
            case 4:
            	end();
                break;
        }
    }
	
	private void displayPrice(ShowTime showtime) {
        double basePrice = showtime.getMovieTickets().get(0).getPrice();
        Movie movie = showtime.getMovie();
        System.out.println("Ticket price for " + movie.getTitle() + " (" + movie.getType().equals(MOVIE3D) != null ? "3D" : "Digital" + ")");
        System.out.printf("                    " + "Weekdays" + "        " + "Weekends\n" +
                "Adults              %-8.2f        %-8.2f\n" +
                "Senior Citizens     %-8.2f        %-8.2f\n\n", basePrice, basePrice * 1.2, basePrice * 0.5, basePrice * 0.5 * 1.2);
        System.out.println("Discount on holidays\n");
        goBack();
        displayShowtimeDetail(showtime);
    }
	
	private void displaySeat(Seat[][] seats) {
        
        System.out.println("                    -------Screen------");
        System.out.println("     1  2  3  4  5  6  7  8  9     10 11 12 13 14 15 16 17 18");
        for (int row = 0; row < 9; row++) {
            System.out.print(row + 1 + "   ");
            for (int col = 0; col < 16; col++) {
                if (seats[row][col].isOccupiedAt()) System.out.print("[X]");
                else System.out.print("[ ]");

            }
            System.out.println();
        }
        System.out.println();
    }
	
	private void bookSeatMenu(ShowTime showtime) {
        System.out.println("Enter the row (1 - 8) of the seat:");
        int row = sc.nextInt();
        System.out.println("Enter the column (1 - 16) of the seat:");
        int col = sc.nextInt();

        if (showtime.getSeatAt(row, col) == null) {
            System.out.println("Error. Please choose another seat.");
            bookSeatMenu(showtime);
        }
        else if (showtime.getSeatAt(row, col).isOccupiedAt()) {
            System.out.println("The seat has been booked. Please choose another seat.");
            bookSeatMenu(showtime);
        }
        else {
            System.out.println(showtime.getMovie().getTotalSales());
            intent(this, new BookingView(showtime.getSeatAt(row, col)));
        }
    }

	@Override
	protected void starter() {
		displayMenu();		
	}
	protected void end() {
    	((MovieListingView)(getPrevious())).starter(movie);
	}
}



