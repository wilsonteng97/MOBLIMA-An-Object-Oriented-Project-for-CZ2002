package Presenter;

import java.io.IOException;
import Model.Admin;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Holiday;
//import Model.Holiday;
import Model.Movie;
import Model.Review;
import Model.ShowTime;
import Model.Enums.ShowingStatus;
import Presenter.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import static Presenter.AdminManager.*;
import static Presenter.CustomerManager.*;
import static Presenter.ReviewManager.*;
import static Presenter.BookingManager.*;
// TODO: Auto-generated Javadoc

/**
 * The Class CinemaOperatorManager is used in handling the cineplexes, cinemas and movies.
 */
public class CinemaOperatorManager extends DataManager {   
    
    /** The Constant showtimeListFile is the txt file. */
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    
    /** The Constant reviewListFile is the txt file. */
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    
    /** The Constant cinemaListFile is the txt file. */
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    
    /** The Constant movieListFile is the txt file. */
    private final static String movieListFile = "datafiles/movieListFile.txt";
    
    /** The Constant cinemaOperatorListFile is the txt file. */
    private final static String cinemaOperatorListFile = "datafiles/cinemaOperatorListFile.txt";
    
    /** The Constant adminAccountListFile is the txt file. */
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";

    /** The cinema operators list. */
    private static ArrayList<CinemaOperator> cinemaOperators;
    
    /** The showtime list. */
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    
    /** The cinema list. */
    private static HashMap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    
    /** The movie list. */
    private static ArrayList<Movie> movieList;
    
    /** The admin account list. */
    private static ArrayList<Admin> adminAccountList;

    /**
     * Read the data to read all the exisiting data stored in the txt files.
     */
    public static void readTheData()
    {
        try 
        {
            readCinemaList();
            readAdminAccount();
            readMovieList();
            readHolidayList();
            readCinemaOperator();
            readShowtime();
            readCustomerList();
            readReviewList();
            readShowtime();
            readHolidayList();
            readBookingListing();
        }
        catch (IOException e)
        {
            System.out.println("Data are not initialised");
        }
    }

	/**
	 * Read admin accounts stored in txt file.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void readAdminAccount() throws IOException
	{
	    if(readDataFile_List(adminAccountListFile) == null)
	    {
	        adminAccountList = new ArrayList<Admin>();
	    }
	    else
	    {
	        adminAccountList = (ArrayList<Admin>) readDataFile_List(adminAccountListFile);
	    }
	}
	
	/**
	 * Update admin account.
	 */
	public static void updateAdminAccount()
	{
	   try {
	        writeDataFile(adminAccountList, adminAccountListFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

    /**
     * Read cinema operator stored in txt file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void readCinemaOperator() throws IOException
    {
        if(readDataFile_List(cinemaOperatorListFile) == null)
        {
            cinemaOperators = new ArrayList<>();
        }
        else 
        {
            cinemaOperators = (ArrayList<CinemaOperator>) readDataFile_List(cinemaOperatorListFile);
        }
    }

    /**
     * Adds the cinema operator to list.
     *
     * @param cinemaOperator the cinema operator
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void addCinemaOperator(CinemaOperator cinemaOperator) throws IOException
    {
        cinemaOperators.add(cinemaOperator);
        updateCinemaOperator();
    }

    /**
     * Update cinema operator list.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void updateCinemaOperator() throws IOException
    {
		writeDataFile(cinemaOperators, cinemaOperatorListFile);
    } 

    /**
     * Read show time from txt file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    // =======================Showtime=======================
    private static void readShowtime() throws IOException
    {
        if(readDataFile_HashMap(showtimeListFile) == null)
            showtimeList = new HashMap<>();
        else
            showtimeList = (HashMap<Movie, ArrayList<ShowTime>>) readDataFile_HashMap(showtimeListFile);
    }


    /**
     * Adds the show time for the particular movie.
     *
     * @param showTime the show time
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void addShowtime(ShowTime showTime) throws IOException
    {
        if (showtimeList.get(showTime.getMovie()) == null) 
        {
            showtimeList.put(showTime.getMovie(), new ArrayList<>());
        }
        showtimeList.get(showTime.getMovie()).add(showTime);
        updateShowTime();
    }

    /**
     * Removes the show time.
     *
     * @param showTime the show time
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void removeShowtime(ShowTime showTime) throws IOException {
        showtimeList.get(showTime.getMovie()).remove(showTime);
        updateShowTime();
    }

    /**
     * Remove all show times.
     *
     * @param movie the movie
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void removeAllShowtimes(Movie movie) throws IOException
    {
        showtimeList.remove(movie);
        updateShowTime();
    }

    /**
     * Update show time.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void updateShowTime() throws IOException
    {
		writeDataFile(showtimeList, showtimeListFile);
    }
    
    /**
     * Read cinema list.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    // ========================Cinema========================
    private static void readCinemaList() throws IOException {
        if(readDataFile_HashMap(cinemaListFile) == null)
            cinemaList = new HashMap<>();
        else
            cinemaList = (HashMap<CinemaOperator, ArrayList<Cinema>>) readDataFile_HashMap(cinemaListFile);
    }

    /**
     * Adds the cinema.
     *
     * @param cinema the cinema
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void addCinema(Cinema cinema) throws IOException {
        if (cinemaList.get(cinema.getCinemaOperator()) == null) 
        {
            cinemaList.put(cinema.getCinemaOperator(), new ArrayList<>());
        }
        cinemaList.get(cinema.getCinemaOperator()).add(cinema);
        updateCinemaList();
    }

    /**
     * Removes the cinema.
     *
     * @param cinema the cinema
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void removeCinema(Cinema cinema) throws IOException {

        cinemaList.get(cinema.getCinemaOperator()).remove(cinema);
        updateCinemaList();
    }

    /**
     * Update cinema list.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void updateCinemaList() throws IOException {
		writeDataFile(cinemaList, cinemaListFile);
    }
   
    /**
     * Gets the cinema operators.
     *
     * @return the cinema operators
     */
    public static ArrayList<CinemaOperator> getCinemaOperators()
    {
        return cinemaOperators;
    }

    /**
     * Gets the cinema list.
     *
     * @param cinemaOperator the cinema operator
     * @return the cinema list
     */
    public static ArrayList<Cinema> getCinemaList (CinemaOperator cinemaOperator)
    {
    	Map<CinemaOperator, ArrayList<Cinema>> map = (Map<CinemaOperator, ArrayList<Cinema>>) cinemaList; // new HashMap<CinemaOperator, ArrayList<Cinema>>();
        for (Entry<CinemaOperator, ArrayList<Cinema>> entry : map.entrySet()) {
        	CinemaOperator key = entry.getKey();
        	if (key.getOperatorID()==cinemaOperator.getOperatorID()) {
               ArrayList<Cinema> value = entry.getValue();
               return value;
           }
        }
		return null;
    }
    
    /**
     * Gets the show time list.
     *
     * @param movie the movie
     * @return the show time list
     */
    public static ArrayList<ShowTime> getShowTimeList (Movie movie)
    {
    	Map<Movie, ArrayList<ShowTime>> map = (Map<Movie, ArrayList<ShowTime>>) showtimeList; // new HashMap<CinemaOperator, ArrayList<Cinema>>();
        for (Entry<Movie, ArrayList<ShowTime>> entry : map.entrySet()) {
        	Movie key = entry.getKey();
        	if (key.getTitle().equals(movie.getTitle())) {
               ArrayList<ShowTime> value = entry.getValue();
               return value;
           }
        }
		return null;
    }
    
    /**
     * Gets the shows.
     *
     * @param movie the movie
     * @return the shows
     */
    public static ArrayList<ShowTime> getShows(Movie movie)
    {
        return showtimeList.get(movie);
    }

    /**
     * Read movie list from txt file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    // ========================Movie========================
    public static void readMovieList() throws IOException
    {
        if(readDataFile_List(movieListFile) == null)
        {
            movieList = new ArrayList<>();
        }
        else 
        {
            movieList = (ArrayList<Movie>) readDataFile_List(movieListFile);
        }
    }

    /**
     * Adds the movie to the list.
     *
     * @param movie the movie
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void addMovie(Movie movie) throws IOException {
    	movieList.add(movie);
        updateMovieListing();
    }

    /**
     * Removes the movie.
     *
     * @param movie the movie
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void removeMovie(Movie movie) throws IOException{
    	movie.setStatus(ShowingStatus.NO_LONGER_AVAILABLE);
    	updateMovieListing();
    }

    /**
     * Gets the movie list.
     *
     * @return the movie list
     */
    public static ArrayList<Movie> getMovieList(){
        return movieList;
    }
    
    /**
     * Update movie listing.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void updateMovieListing() throws IOException {
		writeDataFile(movieList, movieListFile);
    }
}