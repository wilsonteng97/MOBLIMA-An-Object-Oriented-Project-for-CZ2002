package View.moviegoer;

import static Presenter.Presenter.*;
import static Presenter.Query.*;

import View.View;

import java.util.Scanner;

public class CusShowtimeView extends View{
	private String movieInput;
	public CusShowtimeView(String movieInput) {
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie: ");
		String movieIn = sc.next();
		 
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 2)) {
			switch (choice) {
		        case 1:
		            displayShowtime(movieIn); 
		            //display seat
		            //choose seat available
		            //booking
		            break;
		        case 2:
		        	break;
			}
		}
		
	}
	@Override
	protected void starter() {
		displayMenu();		
	}
}



