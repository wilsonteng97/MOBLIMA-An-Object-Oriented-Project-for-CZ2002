package View.admin;

import View.View;
import static Presenter.Query.*;
import static Presenter.AdminManager.confirmChoice;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Presenter.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Model.Cinema;
import Model.CinemaOperator;
import Model.Movie;
import Model.ShowTime;

import View.admin.CinemaListView;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminShowtimeView is for the admin to staff to adjust the show times.
 */
public class AdminShowtimeView extends View{

	/** The movie object. */
	private Movie movieIn;
	
	/** The show time list. */
	private ArrayList<ShowTime> showTimeList;
	
	/** The scanner object. */
	private Scanner sc = new Scanner(System.in);

	/**
	 * Instantiates a new admin show time view.
	 *
	 * @param movieIn the movie in
	 */
	public AdminShowtimeView(Movie movieIn)
	{
		this.setInputMovie(movieIn);
		showTimeList = getShowTimeList(movieIn);
	}
	
	/**
	 * Instantiates a new admin show time view.
	 */
	public AdminShowtimeView()
	{
	}

	/**
	 * Starter to allow the menu to be displayed.
	 */
	protected void starter()
	{
		displayMenu();
	}

	/**
	 * Display menu for changing the show times.
	 */
	private void displayMenu() {
		Date dateIn = null;
		Cinema cinemaIn;
		ShowTime showTimeIn;
		Scanner sc = new Scanner(System.in);
		this.setInputMovie(movieIn);
		System.out.println("Showtime");
		System.out.println();
		System.out.println("(1) Display Showtimes\n"
							+ "(2) Add Showtime\n"
							+ "(3) Remove Showtime\n"
							+ "(4) Return\n");
		System.out.println();
		System.out.println("Enter the number of your choice: ");
		
		int choice = sc.nextInt();
		if (verifyChoiceNumber(choice, 1, 4)) { 
			switch (choice) {
		        case 1:
		        	displayShowtime(this.getInputMovie()); 
		            break;
		        case 2:
		        	dateIn = parseStringToDate("Enter showtime in the following format (dd/mm/yyyy hh:mm):");
		        	cinemaIn = getCinema();
		        	showTimeIn = new ShowTime(cinemaIn, movieIn, dateIn); 
					addShowtimeSequence(movieIn, showTimeIn);
		            break;
				case 3:
					int inputString = passChoiceInt("Enter showtime index: ");
		        	//showTimeIn = new ShowTime(cinemaIn, movieIn, dateIn); 
		        	deleteShowtime(movieIn, showTimeList.get(inputString)); 
		        	break;
				case 4:
					end();
		        	break;
			}
		}
		else 
		{
			displayMenu();
		}
	}
	
	/**
	 * Display showtime.
	 *
	 * @param movieIn the movie in
	 */
	@SuppressWarnings({ "null", "unused" })
	private void displayShowtime(Movie movieIn) {		
		if(showTimeList.isEmpty())
		{
			System.out.println("The movie " + movieIn.getTitle() + " does not have showtimes currently");
		}
		for(ShowTime st: showTimeList)
			{
				System.out.println(st.getCinema().getCinemaName() + " " + st.getTime());
			}
		displayMenu();
	}
	
	/**
	 * Delete show time based on movie and the show time associated with the movie.
	 *
	 * @param movieIn the movie in
	 * @param showTimeIn the show time in
	 */
	private void deleteShowtime(Movie movieIn, ShowTime showTimeIn) 
	{
		System.out.println("Are You sure you want to remove showtime "+ showTimeIn.getTime() +
						   " for " + movieIn.getTitle() +
						   " Y/N");
		String choice = sc.next();
		if(confirmChoice(choice))
		{
			try {
				removeShowtime(showTimeIn);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(showTimeIn.getTime() + " showtime has been removed from " + movieIn.getTitle());
		}
		else 
		{
			System.out.println("Failed to remove showtime " + showTimeIn.getTime() + " from " + movieIn.getTitle());
		}
		displayMenu();
	}

	/**
	 * Adds the show time sequence.
	 *
	 * @param movieIn the movie in
	 * @param showTimeIn the show time in
	 */
	private void addShowtimeSequence(Movie movieIn, ShowTime showTimeIn) {
		try {
			addShowtime(showTimeIn);
		} catch (IOException e) {
			System.out.println("Fail to store the showtime");
		}
		System.out.println("Added showtime "+ showTimeIn.getTime() +
				   " for " + movieIn.getTitle());
		displayMenu();
	}

	/**
	 * Gets the input movie.
	 *
	 * @return the input movie
	 */
	private Movie getInputMovie() {
		return this.movieIn;
	}

	/**
	 * Sets the input movie.
	 *
	 * @param movieIn the new input movie
	 */
	private void setInputMovie(Movie movieIn) {
		this.movieIn = movieIn;
	}
	
	/**
	 * Gets the cinema from the list of cinema operators.
	 *
	 * @return the cinema
	 */
	private Cinema getCinema() {
		ArrayList<CinemaOperator> cinemaOperatorList;
		cinemaOperatorList = getCinemaOperators();
		int numCinemaOperator = 0;
		for(CinemaOperator cinemaOperator: cinemaOperatorList)
		{
			System.out.println(numCinemaOperator + " " + cinemaOperator.getOperatorName());
			numCinemaOperator++;
		}

		int choice = passChoiceInt("Choose Cinema Operator: ");
		CinemaOperator cinemaOperator = cinemaOperatorList.get(choice);
		
		ArrayList<Cinema> cinemaList = getCinemaList(cinemaOperator);
		int numCinema =0;
		for(Cinema cinema: cinemaList)
		{
			System.out.println(numCinema + " "+ cinema.getCinemaName());
			numCinema++;
		}

		choice = passChoiceInt("Choose Cinema: ");
		Cinema cinema = cinemaList.get(choice);
		
		return cinema;
	}
}