package Presenter;

import Model.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class CinemaOperatorManager {   
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    private final static String movieListFile = "datafiles/movieListFile.txt";

    private static ArrayList<Admin> adminAccountList;
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    private static HashMap<Movie, ArrayList<Review>> reviewList;
    private static HashMap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    private static ArrayList<Movie> movieList;

    // Path path_Showtime = Paths.get(showtimeListFile);
    // List<String> showtimeList = Files.readAllLines(path_Showtime, StandardCharsets.UTF_8);

    // Path path_Cinema = Paths.get(cinemaListFile);
    // List<String> cinemaList = Files.readAllLines(path_Cinema, StandardCharsets.UTF_8);

    // Path path_Movie = Paths.get(movieListFile);
    // List<String> movieList = Files.readAllLines(path_Movie, StandardCharsets.UTF_8);

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

    public static void addShowtime(Movie movie, ShowTime ShowTime){
        // showtimeList.get(ShowTime.getMovie()).add(ShowTime);
        showtimeList.get(movie.add(ShowTime));
        updateShowtime();
    }

    public static void removeShowtime(Movie movie, ShowTime showTime){
        // for (String showtimeToBeRemoved : showtimeList){
        //     System.out.println(showtimeToBeRemoved);
        // }
        // showtimeList.get(ShowTime.getMovie()).remove(ShowTime);
        showtimeList.get(movie.removeShowTime(showTime);
        updateShowtime();
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
        if(cinemaList.get(cinema.getCinemaID()) == null)
            cinemaList.put(cinema.getCinemaID(), new ArrayList<>());
        cinemaList.get(cinema.getCinemaID().add(cinema));
        updateCinemaList();
    }

    public static void removeCinema(Cinema cinema){
        // for (String cinemaToBeRemoved : cinemaList){
        //     System.out.println(cinemaToBeRemoved);
        // }
        cinemaList.get(cinema.getOperatorID().remove(cinema));
        updateCinemaList();
    }

    public static void updateCinemaList() {
        writeDataFile(cinemaListFile, cinemaList);
    }

    // ========================Movie========================
    public static void readMovieListing(){
        // for (String ShowTime : showtimeList){
        //     System.out.println(ShowTime);
        // }
        if(readDataFile(movieListFile) == null)
            movieList = new ArrayList<>();
        else
            movieList = (ArrayList<Movie>) readDataFile(movieListFile);
    }

    public void addMovie(Movie Movie){
        movieList.add(movie);
        updateMovieListing();
    }

    public static void removeMovie(Movie movie){
        // for (String movieToBeRemoved : movieList){
        //     System.out.println(movieToBeRemoved);
        // }
        movieList.remove(movie);
        updateMovieListing();
    }

    public static void updateMovieListing(){
        // for (String movie : movieList){
        //     System.out.println(movie);
        // }
        writeDataFile(movieListFile, movieList);
    }
}