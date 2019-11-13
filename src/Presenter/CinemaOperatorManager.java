package Presenter;

import Model.Cinema;
import Model.Movie;
import Model.ShowTime;

import java.io.FileInputStream;
import java.io.FileWriter;

public class CinemaOperatorManager {   
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    private final static String movieListFile = "datafiles/movieListFile.txt";

    private static ArrayList<Staff> adminAccountList;
    private static Hashmap<Movie, ArrayList<Showtime>> showtimeList;
    private static Hashmap<Movie, ArrayList<ReviewList>> reviewList;
    private static Hashmap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    private static Hashmap<Movie> movieList;

    // Path path_Showtime = Paths.get(showtimeListFile);
    // List<String> showtimeList = Files.readAllLines(path_Showtime, StandardCharsets.UTF_8);

    // Path path_Cinema = Paths.get(cinemaListFile);
    // List<String> cinemaList = Files.readAllLines(path_Cinema, StandardCharsets.UTF_8);

    // Path path_Movie = Paths.get(movieListFile);
    // List<String> movieList = Files.readAllLines(path_Movie, StandardCharsets.UTF_8);

    public CinemaOperator(){

    }
    // =======================Showtime=======================
    private void readShowtime(){
        if(readDataFile(showtimeListFile) == null)
            showtimeList = new Hashmap<>();
        else
            showtimeList = (Hashmap<Movie, ArrayList<Showtime>>) readDataFile(showtimeListFile);
    }

    public static void addShowtime(Movie movie, ShowTime showtime){
        // showtimeList.get(showtime.getMovie()).add(showtime);
        showtimeList.get(movie.add(showtime));
        updateShowtime();
    }

    public static void removeShowtime(Movie movie, ShowTime showtime){
        // for (String showtimeToBeRemoved : showtimeList){
        //     System.out.println(showtimeToBeRemoved);
        // }
        // showtimeList.get(showtime.getMovie()).remove(showtime);
        showtimeList.get(movie.remove(showtime));
        updateShowtime();
    }

    public static void updateShowTime(){
        writeDataFile(showtimeListFile, showtimeList);
    }
    
    // ========================Cinema========================
    public static void readCinemaList() {
        // for (String cinema : cinemaList){
        //     System.out.println(cinema);
        // }
        if(readDataFile(cinemaListFile) == null)
            cinemaList = new Hashmap<>();
        else
            cinemaList = (Hashmap<CinemaOperator, ArrayList<Cinema>>) readDataFile(cinemaListFile);
    }

    public static void addCinema(Cinema cinema){
        if(cinemaList.get(cinema.getCinemaOperator()) == NULL)
            cinemaList.put(cinema.getCinemaOperator(), new ArrayList<>());
        cinemaList.get(cinema.getCinemaOperator().add(cinema));
        updateCinemaList();
    }

    public static void removeCinema(Cinema cinema){
        // for (String cinemaToBeRemoved : cinemaList){
        //     System.out.println(cinemaToBeRemoved);
        // }
        cinemaList.get(cinema.getCinemaOperator().remove(cinema));
        updateCinemaList();
    }

    public void updateCinemaList() {
        writeDataFile(cinemaListFile, cinemaList);
    }

    // ========================Movie========================
    public static void readMovieListing(){
        // for (String showtime : showtimeList){
        //     System.out.println(showtime);
        // }
        if(readDataFile(movieListFile) == null)
            movieList = new ArrayList<>();
        else
            movieList = (ArrayList<Movie>) readDataFile(movieListFile);
    }

    public static void addMovie(Movie Movie){
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