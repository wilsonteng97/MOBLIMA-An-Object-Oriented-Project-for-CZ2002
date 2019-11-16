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
import Presenter.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

public class CinemaOperatorManager extends DataManager {   
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    private final static String movieListFile = "datafiles/movieListFile.txt";
    private final static String holidayListFile = "datafiles/holidayListFile.txt";
    private final static String cinemaOperatorListFile = "datafiles/cinemaOperatorListFile.txt";

    private static ArrayList<CinemaOperator> cinemaOperators;
    private static ArrayList<Admin> adminAccountList;
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    private static HashMap<Movie, ArrayList<Review>> reviewList;
    private static HashMap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    private static ArrayList<Movie> movieList;
    private static HashMap<String, Holiday> holidayList;
    
    public static void readTheData()
    {
            readCinemaList();
            readAdminAccount();
            readMovieList();
            readHolidayList();
            readCinemaOperator();

    }
//    public static boolean readTheData()
//    {
//        try {
//         //   readShowtime();
//            readCinemaList();
//            readAdminAccount();
//            readMovieList();
//            readHolidayList();
//            readCinemaOperator();
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }

    private static void readCinemaOperator()
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

    public static void addCinemaOperator(CinemaOperator cinemaOperator) throws IOException
    {
        cinemaOperators.add(cinemaOperator);
        updateCinemaOperator();
    }

    public static void updateCinemaOperator() throws IOException
    {
		writeDataFile(cinemaOperators, cinemaOperatorListFile);
    } 

    private static void readAdminAccount()
    {
        if(readDataFile_List(adminAccountListFile) == null)
        {
            adminAccountList = new ArrayList<>();
        }
        else 
        {
            adminAccountList = (ArrayList<Admin>) readDataFile_List(adminAccountListFile);
        }
    }

    // =======================Showtime=======================
    private static void readShowtime(){
        if(readDataFile_HashMap(showtimeListFile) == null)
            showtimeList = new HashMap<>();
        else
            showtimeList = (HashMap<Movie, ArrayList<ShowTime>>) readDataFile_HashMap(showtimeListFile);
    }


    public static void addShowtime(Movie movie, ShowTime showTime) throws IOException
    {
        showtimeList.get(movie).add(showTime);
        updateShowTime();
    }

    public static void removeShowtime(Movie movie, ShowTime showTime) throws IOException {
        showtimeList.get(movie).remove(showTime);
        updateShowTime();
    }

    public static void removeAllShowtimes(Movie movie) throws IOException
    {
        showtimeList.remove(movie);
        updateShowTime();
    }

    public static void updateShowTime() throws IOException
    {
		writeDataFile(showtimeList, showtimeListFile);
    }
    
    // ========================Cinema========================
    private static void readCinemaList() {
        // for (String cinema : cinemaList){
        //     System.out.println(cinema);
        // }
        if(readDataFile_HashMap(cinemaListFile) == null)
            cinemaList = new HashMap<>();
        else
            cinemaList = (HashMap<CinemaOperator, ArrayList<Cinema>>) readDataFile_HashMap(cinemaListFile);
    }

    public static void addCinema(Cinema cinema) throws IOException {
    	ArrayList<Cinema> tempCinemaList = cinemaList.get(cinema.getCinemaOperator());
    	if (tempCinemaList.contains(cinema)) {
    		return;
    	}
    	
        cinemaList.get(cinema.getCinemaOperator()).add(cinema);
        updateCinemaList();
    }

    public static void removeCinema(Cinema cinema) throws IOException {

        cinemaList.get(cinema.getCinemaOperator()).remove(cinema);
        updateCinemaList();
    }

    public static void updateCinemaList() throws IOException {
		writeDataFile(cinemaList, cinemaListFile);
    }
   
    public static ArrayList<CinemaOperator> getCinemaOperators()
    {
        return cinemaOperators;
    }

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
    
    public static ArrayList<ShowTime> getShowTimeList (Movie movie)
    {
    	Map<Movie, ArrayList<ShowTime>> map = (Map<Movie, ArrayList<ShowTime>>) showtimeList; // new HashMap<CinemaOperator, ArrayList<Cinema>>();
        for (Entry<Movie, ArrayList<ShowTime>> entry : map.entrySet()) {
        	Movie key = entry.getKey();
        	if (key.getTitle()==movie.getTitle()) {
               ArrayList<ShowTime> value = entry.getValue();
               return value;
           }
        }
		return null;
    }
    
    // ========================Movie========================
    public static void readMovieList()
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

    public static void addMovie(Movie movie) throws IOException {
    	if (movieList.contains(movie)) {
    		return;
    	}
    	movieList.add(movie);
        updateMovieListing();
    }

    public static void removeMovie(Movie movie) throws IOException{
    	readMovieList();
    	try {
    		movieList.remove(movie);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	updateMovieListing();
    }

    public static ArrayList<Movie> getMovieList(){
        return movieList;
    }
    
    public static void updateMovieListing() throws IOException {
		writeDataFile(movieList, movieListFile);
    }
    
    // ========================Holiday========================
    private static void readHolidayList() {
        if(readDataFile_HashMap(holidayListFile) == null)
        	holidayList = new HashMap<>();
        else
        	holidayList = (HashMap<String, Holiday>) readDataFile_HashMap(holidayListFile);
    }
    
    public static void updateHolidayList() throws IOException {
 		writeDataFile(holidayList, holidayListFile);
     }

}