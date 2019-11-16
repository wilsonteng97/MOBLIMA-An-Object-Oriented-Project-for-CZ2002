package Presenter;

import java.io.IOException;
import Model.Admin;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Holiday;
import Model.Movie;
import Model.Review;
import Model.ShowTime;
import java.util.ArrayList;
import java.util.HashMap;

public class CinemaOperatorManager extends DataManager {   
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    private final static String movieListFile = "datafiles/movieListFile.txt";
    private final static String holidayListFile = "datafiles/holidayListFile.txt";
//    private final static String movieListFile = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt";
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


    public static void addShowtime(Movie movie, ShowTime showTime)
    {
        showtimeList.get(movie).add(showTime);
        updateShowTime();
    }

    public static void removeShowtime(Movie movie, ShowTime showTime){
    	// for (String showtimeToBeRemoved : showtimeList){
        //     System.out.println(showtimeToBeRemoved);
        // }
        // showtimeList.get(ShowTime.getMovie()).remove(ShowTime);
        showtimeList.get(movie).remove(showTime);
        updateShowTime();
    }

    public static void removeAllShowtimes(Movie movie)
    {
        showtimeList.remove(movie);
        updateShowTime();
    }

    public static void updateShowTime(){
        try {
			writeDataFile(showtimeList, showtimeListFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

    public static void addCinema(Cinema cinema){
        if(cinemaList.get(cinema.getCinemaOperator()) == null)
        {
            cinemaList.put(cinema.getCinemaOperator(), new ArrayList<Cinema>());
        }
        cinemaList.get(cinema.getCinemaOperator()).add(cinema);
        updateCinemaList();
    }

    public static void removeCinema(Cinema cinema){

        cinemaList.get(cinema.getCinemaOperator()).remove(cinema);
        updateCinemaList();
    }

    public static void updateCinemaList() {
        try {
            writeDataFile(cinemaList, cinemaListFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void addCinemaOperator(CinemaOperator cinemaOperator) throws IOException
    {
        cinemaOperators.add(cinemaOperator);

    }
    public static void updateCinemaOperators() {
	    try {
			writeDataFile(cinemaOperators, cinemaOperatorListFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static ArrayList<CinemaOperator> getCinemaOperators()
    {
        return cinemaOperators;
    }

    public static ArrayList<Cinema> getCinemaList (CinemaOperator cinemaOperator)
    {
        return cinemaList.get(cinemaOperator);
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
    	movieList.add(movie);
        updateMovieListing();
    }

    

    public static void removeMovie(Movie movie) throws IOException{
    	try {
    		movieList.remove(movie);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	updateMovieListing();
    }

    public static ArrayList<Movie> getMovieList(){
    	readMovieList();
        return movieList;
    }
    
    public static void updateMovieListing() {
	    try {
			writeDataFile(movieList, movieListFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    // ========================Holiday========================
    private static void readHolidayList() {
        if(readDataFile_HashMap(holidayListFile) == null)
        	holidayList = new HashMap<>();
        else
        	holidayList = (HashMap<String, Holiday>) readDataFile_HashMap(holidayListFile);
    }
    
    public static void updateHolidayList(){
        try {
 		writeDataFile(holidayList, holidayListFile);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
     }

}