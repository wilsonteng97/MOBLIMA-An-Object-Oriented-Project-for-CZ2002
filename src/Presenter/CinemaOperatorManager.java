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
public class CinemaOperatorManager extends DataManager {   
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    private final static String movieListFile = "datafiles/movieListFile.txt";
    private final static String cinemaOperatorListFile = "datafiles/cinemaOperatorListFile.txt";
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";

    private static ArrayList<CinemaOperator> cinemaOperators;
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    private static HashMap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    private static ArrayList<Movie> movieList;
    private static ArrayList<Admin> adminAccountList;

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

public static void updateAdminAccount()
{
   try {
        writeDataFile(adminAccountList, adminAccountListFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

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

    public static void addCinemaOperator(CinemaOperator cinemaOperator) throws IOException
    {
        cinemaOperators.add(cinemaOperator);
        updateCinemaOperator();
    }

    public static void updateCinemaOperator() throws IOException
    {
		writeDataFile(cinemaOperators, cinemaOperatorListFile);
    } 

    // =======================Showtime=======================
    private static void readShowtime() throws IOException
    {
        if(readDataFile_HashMap(showtimeListFile) == null)
            showtimeList = new HashMap<>();
        else
            showtimeList = (HashMap<Movie, ArrayList<ShowTime>>) readDataFile_HashMap(showtimeListFile);
    }


    public static void addShowtime(ShowTime showTime) throws IOException
    {
        if (showtimeList.get(showTime.getMovie()) == null) 
        {
            showtimeList.put(showTime.getMovie(), new ArrayList<>());
        }
        showtimeList.get(showTime.getMovie()).add(showTime);
        updateShowTime();
    }

    public static void removeShowtime(ShowTime showTime) throws IOException {
        showtimeList.get(showTime.getMovie()).remove(showTime);
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
    private static void readCinemaList() throws IOException {
        // for (String cinema : cinemaList){
        //     System.out.println(cinema);
        // }
        if(readDataFile_HashMap(cinemaListFile) == null)
            cinemaList = new HashMap<>();
        else
            cinemaList = (HashMap<CinemaOperator, ArrayList<Cinema>>) readDataFile_HashMap(cinemaListFile);
    }

    public static void addCinema(Cinema cinema) throws IOException {
        if (cinemaList.get(cinema.getCinemaOperator()) == null) 
        {
            cinemaList.put(cinema.getCinemaOperator(), new ArrayList<>());
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
        	if (key.getTitle().equals(movie.getTitle())) {
               ArrayList<ShowTime> value = entry.getValue();
               return value;
           }
        }
		return null;
    }
    
    public static ArrayList<ShowTime> getShows(Movie movie)
    {
        return showtimeList.get(movie);
    }

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

    public static void addMovie(Movie movie) throws IOException {
    	movieList.add(movie);
        updateMovieListing();
    }

    public static void removeMovie(Movie movie) throws IOException{
    	movie.setStatus(ShowingStatus.NO_LONGER_AVAILABLE);
    	updateMovieListing();
    }

    public static ArrayList<Movie> getMovieList(){
        return movieList;
    }
    
    public static void updateMovieListing() throws IOException {
		writeDataFile(movieList, movieListFile);
    }
    
}