package View.admin;

import View.View;
import Model.Movie;
import Model.Enums.AgeRestriction;
import Model.Enums.MovieType;
import Model.Enums.ShowingStatus;
import Presenter.AdminManager;

import static Presenter.CinemaOperatorManager.*;
import static Presenter.Presenter.*;
import static Presenter.AdminManager.*;
import static Presenter.Query.*;
import static Model.Enums.CinemaClass.*;
import static Model.Enums.AgeRestriction.*;
import static Model.Enums.BookingStatus.*;
import static Model.Enums.ShowingStatus.*;
import static Model.Enums.MovieType.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieListView extends View{

	private ArrayList<Movie> movieList;
	private int num =0;
	private Scanner sc = new Scanner(System.in);
	

	@Override
	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Boolean isInitialize = false;
		
		System.out.println("Movie Listing");
		System.out.println();
		System.out.println("(1) Display Movies\n"

				+ "(2) Add new Movie\n"
				+ "(3) Edit Movie Listing\n"
				+ "(4) Remove Movie\n"
				+ "(5) Initizialize Movies\n"
				+ "(6) Return\n");
		System.out.println();
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		if(verifyChoiceNumber(choice, 1, 6)) { 
			switch (choice) {
				case 1:
					displayMovieList();
		            break;
		        case 2:
		        	newMovie();
		            break;
		        case 3:
					System.out.println("Enter the index of the movie you want to edit: ");
					displayMovieList();
					int movie = sc.nextInt();
					displayMovieEditingMenu(movieList.get(movie));
		        	break;
		        case 4:
					System.out.println("Enter the index of the movie you want to remove: ");
					int deletemovie = sc.nextInt();
					deleteMovie(movieList.get(deletemovie));
		        	break;
				case 5:
					try {
						initialiseMovies();
						isInitialize = true;
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					displayMenu();
					break;
				case 6:
					end();
					break;
			}
		}
		else 
		{
			displayMenu();
		}

	}


	private void newMovie()
	{
		String title;
		AgeRestriction ageRestriction = null;
		MovieType type = null;
		ShowingStatus status = null;
		String opening;
		String director;
		String runtime;
		String synopsis;
		Boolean blockBuster;
		ArrayList<String> cast = new ArrayList<String>();

		System.out.println("Add new Movie");

		title = passChoiceString("Enter the title");

		while (ageRestriction == null)
		{
			String ageIn = passChoiceString("Enter the age restriction from the following: \n"
			+ "G, PG, PG13, NC16, M18, R21, NAR");
			ageRestriction = getValueAgeRestriction(ageIn);
		}

		while (type == null)
		{
			String typeIn = passChoiceString("Enter the movie type from the following: \n"
			+ "MOVIE3D, DIGITAL");
			type = getValueMovieType(typeIn);
		}

		while(status == null)
		{
			String statusIn = passChoiceString("Enter the status of the movie from the following: \n"
			+ "COMING_SOON, PREVIEW, NOW_SHOWING, NO_LONGER_AVAILABLE");
			status = getValueShowingStatus(statusIn);
		}

		opening = passChoiceString("Enter the opening");
		director = passChoiceString("Enter the director");
		runtime = passChoiceString("Enter the runtime");
		synopsis = passChoiceString("Enter the synopsis");

		System.out.println("Is it a blockbuster? Y/N ");
		String isBlockBuster = sc.next();
		if(isBlockBuster == "Y" || isBlockBuster == "y")
		{
			blockBuster = true;
		}
		else
		{
			blockBuster = false;
		} 
			
		System.out.println("Enter how many casts you would like to add: ");
		int castAmount = sc.nextInt();

		for(int i =0; i<castAmount; i++)
		{
			String castName = passChoiceString("Enter the name of cast");
			cast.add(castName);
		}

		Movie movie = new Movie(title, ageRestriction, type, status, opening, director, runtime, synopsis, blockBuster, cast);
		try {
			addMovie(movie);
		} catch (IOException e) {
			System.out.println("Failed to add the movie");
		}
		displayMenu();
	}

	private void displayMovieList()
	{
		movieList = getMovieList();
		num = 0;
		if(movieList.isEmpty())
		{
			System.out.println("List of movie is currently empty\n");
		}
		else
		{
			System.out.println("The list of all movies.\n");
			for(Movie movie: movieList)
			{
				System.out.println(num + "\t" + movie.getTitle() + "\n\t" + movie.getRunTime() + "\n\t" + movie.getStatus());
				System.out.print("\n");
				num++;
			}
		}
		displayMenu();
	}

	private void displayMovieEditingMenu(Movie movie)
	{
		System.out.println("Movie editor");
		System.out.println(movie.toString());
		System.out.println("(1) Update Movie details\n"
				+ "(2) Delete the Movie\n"
				+ "(3) Add or delete showtime\n"
				+ "(4) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		if(verifyChoiceNumber(choice, 1, 4)) 
		{ 
			switch (choice) 
			{
				case 1:
					updateMovieDetails(movie);
					break;
				case 2:
					deleteMovie(movie);
					break;
				case 3:
					intent(this, new AdminShowtimeView(movie));
					break;
				case 4:
					displayMenu();
					break;
			}
		}
		else 
		{
			displayMovieEditingMenu(movie);
		}
	}

	private void updateMovieDetails(Movie movie)
	{
		System.out.println("UpdateMovieDetails");
		System.out.println("(1) Change title\n"
		+ "(2) Change age restriction\n"
		+ "(3) Change movie type\n"
		+ "(4) Change showing status\n"
		+ "(5) Change opening\n"
		+ "(6) Change director\n"
		+ "(7) Change runtime\n"
		+ "(8) Change synopsis\n"
		+ "(9) Change blockbuster status\n"
		+ "(10) Change cast\n"
		+ "(11) Come back to previous page\n");

		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		if(verifyChoiceNumber(choice, 1, 11)) 
			{ 
				switch (choice) 
				{
					case 1:
						movie.setTitle(passChoiceString("Enter the title"));
						System.out.println("You changed the title correctly");
						break;
					case 2:
						AgeRestriction ageRestriction = null;
						while (ageRestriction == null)
						{
							String ageIn = passChoiceString("Enter the age restriction from the following: \n"
							+ "G, PG, PG13, NC16, M18, R21, NAR");
							ageRestriction = getValueAgeRestriction(ageIn);
						}
						movie.setAgeRestriction(ageRestriction);
						System.out.println("You changed age restriction correctly");
						break;
					case 3:
						MovieType type = null;
						while (type == null)
						{
							String typeIn = passChoiceString("Enter the movie type from the following: \n"
							+ "MOVIE3D, DIGITAL");
							type = getValueMovieType(typeIn);
						}
						System.out.println("You changed movie type correctly");
						break;
					case 4:
						ShowingStatus showingStatus = null;
						while(showingStatus == null)
						{
							String showIn = passChoiceString("Enter the movie status from the following: \n"
							+"COMING_SOON, PREVIEW, NOW_SHOWING, NO_LONGER_AVAILABLE");
							showingStatus = getValueShowingStatus(showIn);
						}
						System.out.println("You changed showing status correctly");
						break;
					case 5:
						movie.setOpening(passChoiceString("Enter the opening"));
						System.out.println("You changed the opening correctly");
						break;
					case 6:
						movie.setDirector(passChoiceString("Enter the director"));
						System.out.println("You changed the director correctly");
						break;
					case 7:
						movie.setRunTime(passChoiceString("Enter the runtime"));
						System.out.println("You changed the showtime correctly");
						break;
					case 8:
						movie.setSynopsis(passChoiceString("Enter the synopsis"));
						System.out.println("You changed the synopsis correctly");
						break;
					case 9:
						System.out.println("Is it a blockbuster? Y/N ");
						String isBlockBuster = sc.next();
						if(isBlockBuster == "Y" || isBlockBuster == "y")
						{
							movie.setBlockBuster(true);
						}
						else
						{
							movie.setBlockBuster(false);
						} 
						break;
					case 10:
						System.out.println("Enter how many casts you would like to add: ");
						ArrayList<String> cast = new ArrayList<String>();
						int castAmount = sc.nextInt();
						for(int i =0; i<castAmount; i++)
						{
							String castName = passChoiceString("Enter the name of cast");
							cast.add(castName);
						}
						movie.setCast(cast);
						break;
					case 11:
					//	try
					//	{
						//	updateMovieListing();
							System.out.println("Changes applied!");	
							displayMenu();	
					//	}
					//	catch(IOException e)
					//	{
					//		System.out.println("Fail to applied changes, try again");
					//	}
						break;
				}
			}
			else 
			{
				updateMovieDetails(movie);
			}
		updateMovieDetails(movie);
	}

	private void deleteMovie(Movie movie)
	{
		String choice = passChoiceString("Are You sure you want to delete "+ movie.getTitle() +  " Y/N");
		if(confirmChoice(choice))
		{
			try {
				removeMovie(movie);
				removeAllShowtimes(movie);
				System.out.println("The movie has been removed");
			} catch (IOException e) {
				System.out.println("Failed to remove listing");
			}
		}
		else 
		{
			System.out.println("Failed to remove listing");
		}
		displayMenu();
	}

}