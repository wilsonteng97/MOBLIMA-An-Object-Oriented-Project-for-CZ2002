package Presenter;

import java.io.IOException;
import Model.Admin;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Movie;
import Model.Review;
import Model.ShowTime;
import java.util.ArrayList;
import java.util.HashMap;

public class CinemaOperatorManager extends DataManager {   
    private final static String adminAccountListFile = "../../datafiles/adminAccountListFile.txt";
    private final static String showtimeListFile = "../../datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "../../datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "../../datafiles/cinemaListFile.txt";
    private final static String movieListFile = "../../datafiles/movieListFile.txt";

    private static ArrayList<CinemaOperator> cinemaOperators;
    private static ArrayList<Admin> adminAccountList;
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    private static HashMap<Movie, ArrayList<Review>> reviewList;
    private static HashMap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    private static ArrayList<Movie> movieList;


    public static boolean readTheData()
    {
        try {
            readShowtime();
            readCinemaList();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    // =======================Showtime=======================
    private static void readShowtime(){
        if(readDataFile_HashMap(showtimeListFile) == null)
            showtimeList = new HashMap<Movie, ArrayList<ShowTime>>();
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
            cinemaList = new HashMap<CinemaOperator, ArrayList<Cinema>>();
        else
            cinemaList = (HashMap<CinemaOperator, ArrayList<Cinema>>) readDataFile_HashMap(cinemaListFile);
    }

    public static void addCinema(Cinema cinema){
        if(cinemaList.get(cinema.getCinemaOperator()) == null)
        cinemaList.put(cinema.getCinemaOperator(), new ArrayList<>());
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
   
    public static ArrayList<CinemaOperator> getCinemaOperators()
    {
        return cinemaOperators;
    }

    public static ArrayList<Cinema> getCinemaList (CinemaOperator cinemaOperator)
    {
        return cinemaList.get(cinemaOperator);
    }
    
    
    // ========================Movie========================
    public static void addMovie(Movie movie) throws IOException {
    	movieList.add(movie);
        updateMovieListing(movieList);
    }

    public static void removeMovie(Movie movie) throws IOException
    {
    	try {
    		movieList.remove(movie);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	updateMovieListing(movieList);
    }

    public static ArrayList<Movie> getMovieList()
    {
        return movieList;
    }
    
    public static void updateMovieListing(ArrayList<Movie> movieList) {
	    try {
			writeDataFile(movieList, movieListFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}