package View.admin;

import View.View;
import static Presenter.Query.*;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Presenter.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Movie;

public class AdminShowtimeView extends View{

	private Movie movieIn;
	
	public AdminShowtimeView(Movie movieIn)
	{
		this.setInputMovie(movieIn);
	}

	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		this.setInputMovie(movieIn);
		
		System.out.println("(1) Display Showtimes\n"
				+ "(2) Add Showtime\n"
				+ "(3) Update Showtime List\n"
				+ "(4) Remove Showtime\n"
				+ "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		Date showtimeIn;
		String inputString;
	    
		while (verifyChoiceNumber(choice, 1, 5)) { 
			switch (choice) {
		        case 1:
		        	displayShowtime(movieIn); 
		            break;
		        case 2:
		        	System.out.println("Enter showtime in the following format (dd/MMM/yyyy HH:mm): ");
		        	inputString = sc.next();
		        	showtimeIn = parseStringToDate(inputString);
		        	addShowtime(movieIn, showtimeIn); 
		            break;
		        case 3:
		        	updateShowTime(); 
		        	break;
		        case 4:
		        	System.out.println("Enter showtime: ");
		        	inputString = sc.next();
		        	showtimeIn = parseStringToDate(inputString);
		        	removeShowtime(movieIn, showtimeIn); 
		        	break;
		        case 5:
		        	break;
			}
		}
	}
	private void displayShowtime(Movie movieIn) {
		
	}
	
	private void removeShowtime(String movieIn, Date showtimeIn) {

	}

	private void addShowtime(String movieIn, Date showtimeIn) {
		
	}

	private Date parseStringToDate(String inputString) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");  
	    Date showtimeIn = null;
		try {
			showtimeIn = formatter.parse(inputString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return showtimeIn;
	}

	public Movie getInputMovie() {
		return this.movieIn;
	}

	public void setInputMovie(Movie movieIn) {
		this.movieIn = movieIn;
	}
}