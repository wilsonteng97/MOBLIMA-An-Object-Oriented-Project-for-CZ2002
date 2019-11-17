package Presenter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import javax.lang.model.util.ElementScanner6;

import Data_Initializer.*;
import Model.Admin;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Holiday;
import Model.Movie;
import Model.Review;
import Model.ShowTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminManager is used by the admin staff to perform operations specific to staff only.
 */
public class AdminManager extends DataManager
{
    
    /** The sc. */
    Scanner sc = new Scanner(System.in);

    /** The Constant adminAccountListFile is the txt file. */
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";
    
    /** The Constant showtimeListFile is the txt file. */
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    
    /** The Constant reviewListFile is the txt file. */
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    
    /** The Constant cinemaListFile is the txt file. */
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    
    /** The Constant movieListFile is the txt file. */
    private final static String movieListFile = "datafiles/movieListFile.txt";
    
    /** The Constant holidayListFile is the txt file. */
    private final static String holidayListFile = "datafiles/holidayListFile.txt";

    /** The admin account list. */
    private static ArrayList<Admin> adminAccountList;
    
    /** The showtime list. */
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    
    /** The review list. */
    private static HashMap<Movie, ArrayList<Review>> reviewList;
    
    /** The movie list. */
    private static ArrayList<Movie> movieList;
    
    /** The holiday list. */
    private static ArrayList<Holiday> holidayList;

    // =======================System Setting=======================
    
    /**
     * Initialise movies objects for the system.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void initialiseMovies() throws IOException {
    	MovieListGenerator.MovieList();
    }

    
 /**
  * Adds the holiday into the system for charging of price due to the holiday.
  *
  * @param holiday the holiday
  */
 // =======================Holiday=======================
    public static void addHoliday(Holiday holiday) {
        holidayList.add(holiday);
        updateHolidayList();
    }
    
    /**
     * Removes the holiday.
     *
     * @param holiday the holiday
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void removeHoliday(Holiday holiday) throws IOException{
        holidayList.remove(holiday);
        updateHolidayList();
    }
    
    /**
     * Gets the holiday list.
     *
     * @return the holiday list
     */
    public static ArrayList<Holiday> getHolidayList() {
    	return holidayList;
    }

    /**
     * Read the holiday list from the txt file.
     */
    public static void readHolidayList()
    {
       if(readDataFile_List(holidayListFile) == null)
       {
       	holidayList = new ArrayList<>();
       }
       else
       {
       	holidayList = (ArrayList<Holiday>) readDataFile_HashMap(holidayListFile);
       }
    }

    /**
     * Update holiday list.
     */
    public static void updateHolidayList()
    {
        try {
            writeDataFile(holidayList, holidayListFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/**
 * Initialise admin accounts into the system.
 *
 * @throws IOException Signals that an I/O exception has occurred.
 */

    public static void initialiseAdminAccounts() throws IOException
     {
         AdminAccountListGenerator.AdminAccounts();
     }

/**
 * Initialiser the dummy accounts created in Data_Initializer.
 *
 * @throws IOException Signals that an I/O exception has occurred.
 */
    public static void initialiser() throws IOException {
        MovieListGenerator.MovieList();
        CinemaOperatorGenerator.CinemaOperatorList();
        CinemaListGenerator.CinemaList();
        try {
            ShowTimeGenerator.Showtimes();
            UserAccountListGenerator.CustomerList();
            ReviewListGenerator.ReviewList();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Gets the top 5 ranking based on rating.
     *
     * @return the top 5 ranking rating
     */
    // =========================Top 5 Movies=========================
    public static ArrayList<Movie> getTop5RankingRating(){
        ArrayList<Movie> top5rating = new ArrayList<Movie>();
        int count = 0;
        for(Movie movie: movieList)
            top5rating.add(movie);
        
        Collections.sort(top5rating, Model.Movie.reviewRatingAvgComparator);

        ArrayList<Movie> final_list = new ArrayList<Movie>();
        for (Movie a: top5rating) {
        	final_list.add(a);
        	if (count == 5) break;
        	count++;
        }
        return final_list;
    }
    
    /**
     * Gets the top 5 ranking based on sales.
     *
     * @return the top 5 ranking sales
     */
    public static ArrayList<Movie> getTop5RankingSales()
    {
        ArrayList<Movie> top5sales = new ArrayList<Movie>();
        movieList = CinemaOperatorManager.getMovieList();

        for(Movie movie: movieList){
            top5sales.add(movie);            
        }
        Collections.sort(top5sales, Model.Movie.movieSalesComparator);
        
        ArrayList<Movie> final_list = new ArrayList<Movie>();

        int counter = 0;
        for (Movie a: top5sales) {
        	final_list.add(a);
            if (counter == 5) break;
            counter++;
        }
        return final_list;
    }

    // =========================Review Lists=========================
	
    /**
     * Gets the review list.
     *
     * @param movie the movie
     * @return the review list
     */
    public static ArrayList<Review> getReviewList(Movie movie){
        return movie.getReviewList();
    }
    
    /**
     * Gets the movie rating.
     *
     * @param movie the movie
     * @return the movie rating
     */
    public static double getMovieRating(Movie movie){
        ArrayList<Review> reviewList = getReviewList(movie);
    	return movie.getReviewRatingAverage();
    }

    /**
     * Gets the movie sales.
     *
     * @param movie the movie
     * @return the movie sales
     */
    // =========================Movie Sales=========================
    public Double getMovieSales(Movie movie)
    {
        return movie.getTotalSales();
    }

    
    /**
     * Gets the showtime list.
     *
     * @param movie the movie
     * @return the showtime list
     */
    // ====================Get Lists of Entitites====================  
    public static ArrayList<ShowTime> getShowtimeList(Movie movie)
    {
        return showtimeList.get(movie);
    }

    /**
     * Confirm choice by the user for boolean inputs.
     *
     * @param choice the choice
     * @return true, if successful
     */
    public static boolean confirmChoice(String choice)
    {
        if (choice.equals("Y") || choice.equals("y"))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}