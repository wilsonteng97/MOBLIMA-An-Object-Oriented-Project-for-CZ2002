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

public class AdminShowtimeView extends View{

	private Movie movieIn;
	private ArrayList<ShowTime> showTimeList;
	private Scanner sc = new Scanner(System.in);

	public AdminShowtimeView(Movie movieIn)
	{
		this.setInputMovie(movieIn);
		showTimeList = getShowTimeList(movieIn);
	}
	
	public AdminShowtimeView()
	{
	}

	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Date dateIn = null;
		Cinema cinemaIn;
		ShowTime showTimeIn;
	//	ArrayList<ShowTime> showTimes = getShowTimeList(movieIn);
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
	
	@SuppressWarnings({ "null", "unused" })
	private void displayShowtime(Movie movieIn) {
	//	Cinema cinema = getCinema();
		
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

	private void addShowtimeSequence(Movie movieIn, ShowTime showTimeIn) {
		try {
			addShowtime(showTimeIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to store the showtime");
		}
		System.out.println("Added showtime "+ showTimeIn.getTime() +
				   " for " + movieIn.getTitle());
		displayMenu();
	}

	private Movie getInputMovie() {
		return this.movieIn;
	}

	private void setInputMovie(Movie movieIn) {
		this.movieIn = movieIn;
	}
	
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
	//	ArrayList<CinemaOperator> cinemaOperatorsList = getCinemaOperators();
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