package View.admin;

import View.View;
import static Presenter.Query.*;
import static Presenter.AdminManager.confirmChoice;
import static Presenter.CinemaOperatorManager.*;
import static Presenter.Presenter.*;

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
	private Scanner sc = new Scanner(System.in);


	public AdminShowtimeView(Movie movieIn)
	{
		this.setInputMovie(movieIn);
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
		String inputString;
		
		Scanner sc = new Scanner(System.in);
		this.setInputMovie(movieIn);
		
		System.out.println("(1) Display Showtimes\n"
							+ "(2) Add Showtime\n"
							+ "(3) Update Showtime List\n"
							+ "(4) Remove Showtime\n"
							+ "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { 
			switch (choice) {
		        case 1:
		        	displayShowtime(this.getInputMovie()); 
		            break;
		        case 2:
		        	dateIn = parseStringToDate("Enter showtime in the following format (dd/mm/yyyy hh:mm):");
		        	cinemaIn = getCinema();
		        	
		        	showTimeIn = new ShowTime(cinemaIn, movieIn, dateIn); 
		        	addShowtime(this.getInputMovie(), showTimeIn); 
		            break;
		        case 3:
		        	updateShowTime(); 
		        	break;
		        case 4:
		        	System.out.println("Enter showtime: ");
		        	inputString = sc.next();
		        	dateIn = parseStringToDate(inputString);
		        	cinemaIn = getCinema();
		        	
		        	showTimeIn = new ShowTime(cinemaIn, movieIn, dateIn); 
		        	removeShowtime(this.getInputMovie(), showTimeIn); 
		        	break;
		        case 5:
		        	break;
			}
		}
	}
	
	@SuppressWarnings({ "null", "unused" })
	private void displayShowtime(Movie movieIn) {
		Cinema cinema = getCinema();
		
		ArrayList<ShowTime> showTimeList = movieIn.getShowTimes();
		Map<Date, String> hashMap_Date_Time = new HashMap<Date, String>();  
		String date, time;
		Date now = Calendar.getInstance().getTime();
		ArrayList<String> dates = null;
		
		for (ShowTime st : showTimeList) {
			if(st.getTime().after(now) && st.getCinema()==cinema) {
				date = st.getShowTimeString("yyyy/mm/dd"); 
				time = st.getShowTimeString("hh:mm");
				dates.add(date);
				hashMap_Date_Time.put(st.getTime(), time);
			}
		}
		
		if (dates==null) {
			return;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
		for (String d : dates) {
			System.out.println("---[" + d + "]---");
			for (Map.Entry<Date, String> entry : hashMap_Date_Time.entrySet()) {
				if (formatter.format(entry.getKey()) == d) {
					System.out.print(entry.getValue() + "\t");
				}
			}
			System.out.println("\n");
		}
	}
	
	private void removeShowtime(Movie movieIn, ShowTime showTimeIn) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		System.out.println("Are You sure you want to remove showtime "+ (String)(formatter.format(showTimeIn)) +
						   " for " + movieIn.getTitle() +
						   " Y/N");
		String choice = sc.next();
		if(confirmChoice(choice))
		{
			removeShowtime(movieIn, showTimeIn);
			System.out.println((String)(formatter.format(showTimeIn)) + " showtime has been removed from " + movieIn.getTitle());
		}
		else 
		{
			System.out.println("Failed to remove showtime " + (String)(formatter.format(showTimeIn)) + " from " + movieIn.getTitle());
		}
		displayMenu();
	}

	private void addShowtime(Movie movieIn, ShowTime showTimeIn) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		addShowtime(movieIn, showTimeIn);
		System.out.println("Added showtime "+ (String)(formatter.format(showTimeIn)) +
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
			System.out.println(numCinemaOperator + " " + cinemaOperator.getOperatorID() + cinemaOperator.getOperatorName());
			numCinemaOperator++;
		}

		int choice = passChoiceInt("Choose Cinema Operator: ");
		ArrayList<CinemaOperator> cinemaOperatorsList = getCinemaOperators();
		CinemaOperator cinemaOperator = cinemaOperatorsList.get(choice);
		
		ArrayList<Cinema> cinemaList = getCinemaList(cinemaOperator);
		int numCinema =0;
		for(Cinema cinema: cinemaList)
		{
			System.out.println(numCinema + " "+ cinema.getCinemaID() + cinema.getCinemaName());
		}

		choice = passChoiceInt("Choose Cinema: ");
		Cinema cinema = cinemaList.get(choice);
		
		return cinema;
	}
}