package View.moviegoer;

import static Presenter.Presenter.*;
import static Presenter.Query.*;
import static Presenter.PurchaseNOrder.*;
import static Model.Seat.*;

import View.View;

import java.util.Scanner;

import Model.Seat;
import Model.ShowTime;

public class CusShowtimeView extends View{
	private String movieName;
	public CusShowtimeView(String movieIn) {
		movieName=movieIn;
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
		            System.out.println("Enter the showtime you choose: ");
		    		double showtimeIn = sc.nextDouble();
		    		ShowTime showtime = passDoubleShowtime(showtimeIn);
		            displaySeat(showtime.getSeats());
		            System.out.println("Enter the seat row you choose: ");
		    		int seatrowIn = sc.nextInt();
		    		System.out.println("Enter the seat number you choose: ");
		    		int seatnoIn = sc.nextInt();
					selectSeat(seatrowIn, seatnoIn);
					intent(this, new BookingView(movieName, showtime, seatrowIn, seatnoIn));
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
                if (seats[row][col] == null) System.out.print("[ ]");
                else System.out.print("["+seats[row][col]+"]");
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



