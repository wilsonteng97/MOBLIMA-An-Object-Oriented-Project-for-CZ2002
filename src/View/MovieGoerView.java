package View;
import java.util.Scanner;

public class MovieGoerView extends View{
	public MovieGoerView() {
		displayMenu();
	}
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome, please make a selection:"
				+ "(1) Movie Listing\n"
				+ "(2) Booking History\n"
				+ "(3) Return");
		System.out.println("Enter the number of your choice: ");
		choice = sc.nextInt();
		while (passChoiceNumber(choice, 1, 3)) { 
			switch (choice) {
	        case 1:
	            intent(this, new MovieListing());
	            break;
	        case 2:
	            intent(this, new BookingHistoryView());
	            break;
	        case 3:
	            break;
			}
		}
	}
}
