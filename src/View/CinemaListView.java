package View.staff;

import java.util.Scanner;

public class CinemaListView extends View{
	public CinemaListView() {
		displayMenu();
	}	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Display Cineplex\n"
				+ "(2) Add Cineplex\n"
				+ "(3) Display Cinema\n"
				+ "(4) Add Cinema\n");
		int choice = sc.nextInt();
        switch (choice) {
            case 1:
                //displayCinema();
                break;
            case 2:
                //addCinema();
                break;
            case 3:
                break;
        }
	}
}
