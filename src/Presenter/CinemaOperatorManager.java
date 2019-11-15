package Presenter;

import Model.*;
import static Presenter.Query.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CinemaOperatorManager {   
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    private final static String movieListFile = "datafiles/movieListFile.txt";

    private static ArrayList<CinemaOperator> cinemaOperators;
    private static ArrayList<Admin> adminAccountList;
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    private static HashMap<Movie, ArrayList<Review>> reviewList;
    private static HashMap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    private static ArrayList<Movie> movieList;

    public static void readTheData()
    {
        readShowtime();

    }
    // =======================Showtime=======================
    private static void readShowtime(){
        if(readDataFile(showtimeListFile) == null)
            showtimeList = new HashMap<>();
        else
            showtimeList = (HashMap<Movie, ArrayList<ShowTime>>) readDataFile(showtimeListFile);
    }


    public static void addShowtime(Movie movie, ShowTime showTime)
    {
        showtimeList.get(movie).add(showTime);
        updateShowtime();
    }

    public static void removeShowtime(Movie movie, ShowTime showTime){
    	// for (String showtimeToBeRemoved : showtimeList){
        //     System.out.println(showtimeToBeRemoved);
        // }
        // showtimeList.get(ShowTime.getMovie()).remove(ShowTime);
        showtimeList.get(movie).remove(showTime);
        updateShowtime();
    }

    public static void removeAllShowtimes(Movie movie)
    {
        showtimeList.remove(movie);
    }

    public static void updateShowTime(){
        writeDataFile(showtimeListFile, showtimeList);
    }
    
    // ========================Cinema========================
    private static void readCinemaList() {
        // for (String cinema : cinemaList){
        //     System.out.println(cinema);
        // }
        if(readDataFile(cinemaListFile) == null)
            cinemaList = new HashMap<>();
        else
            cinemaList = (HashMap<CinemaOperator, ArrayList<Cinema>>) readDataFile(cinemaListFile);
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
        writeDataFile(cinemaListFile, cinemaList);
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
        ArrayList<Movie> movieList = new ArrayList<Movie>();
    	movieList = Model.MovieListGenerator.MovieList();
    	
    	for (Movie m : movieList) {
    		if (m == movie)
    			movieList.add(movie);
    	}
        updateMovieListing(movieList);
    }

    public static void removeMovie(Movie movie) throws IOException
    {
    	ArrayList<Movie> movieList = new ArrayList<Movie>();
    	movieList = Model.MovieListGenerator.MovieList();
    	
    	for (Movie m : movieList) {
    		if (m == movie)
    			movieList.remove(m.getTitle());
    	}
        updateMovieListing(movieList);
    }

    public static ArrayList<Movie> getMovieList()
    {
    	ArrayList<Movie> movieList = new ArrayList<Movie>();
    	movieList = Model.MovieListGenerator.MovieList();
        return movieList;
    }
    public static void updateMovieListing(ArrayList<Movie> movieList) throws IOException
    {
        DataManager.writeDataFile(movieList, movieListFile);
    }
}