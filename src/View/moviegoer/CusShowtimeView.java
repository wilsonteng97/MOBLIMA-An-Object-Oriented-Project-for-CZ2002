package View.moviegoer;

import static Presenter.Presenter.*;
import static Presenter.Query.*;
import static Presenter.PurchaseNOrder.*;

import View.View;

import java.util.Scanner;

import Model.Seat;
import Model.ShowTime;

public class CusShowtimeView extends View{
	private String movieName;
	public CusShowtimeView(String movieInput) {
		movieName=movieInput;
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 2)) {
			switch (choice) {
		        case 1:
		            displayShowtime(movieName); 
		            System.out.println("Please choose a showtime: ");
		    		double showtimeIn = sc.nextDouble();
		    		ShowTime showtime = passDoubleShowtime(showtimeIn);
		            displaySeat(showtime.getSeats());
		            System.out.println("Please choose seat row: ");
		    		int seatrow = sc.nextInt();
		    		System.out.println("Please choose seat no: ");
		    		int seatno = sc.nextInt();
		            selectSeat(seatrow, seatno);
		            intent(this, new BookingView(movieName, showtime, seatrow, seatno));
		            break;
		        case 2:
		        	break;
			}
		}
		
	}
	private void displaySeat(Seat[][] seats) {
        System.out.println("                    -------Screen------");
        System.out.println("     1  2  3  4  5  6  7  8     9 10 11 12 13 14 15 16");
        for (int row = 0; row <= 8; row++) {
            System.out.print(row + 1 + "   ");
            for (int col = 0; col <= 16; col++) {
                if (seats[row][col] == null) System.out.print("   ");
                else System.out.print(seats[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }
	@Override
	protected void starter() {
		displayMenu();		
	}
}



