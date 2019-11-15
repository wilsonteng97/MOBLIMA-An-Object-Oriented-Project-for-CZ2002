package Presenter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

import Model.Enums.AgeRestriction;
import Model.Enums.CinemaClass;
import Model.Enums.MovieType;
import Model.Enums.ShowingStatus;
import Model.Cinema;
import Model.Customer;
import Model.Movie;
import Model.ShowTime;

public class Query {
    private final static String movieListFile = "datafiles/movieListFile.txt";
//    Path path_Movie = Paths.get(movieListFile);
//    List<String> movieList = Files.readAllLines(path_Movie, StandardCharsets.UTF_8);

    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
//    Path path_Cinema = Paths.get(cinemaListFile);
//    List<String> cinemaList = Files.readAllLines(path_Cinema, StandardCharsets.UTF_8);

    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
//    Path path_Showtime = Paths.get(showtimeListFile);
//    List<String> showtimeList = Files.readAllLines(path_Showtime, StandardCharsets.UTF_8);

    private final static String customerListFile = "datafiles/userAccountListFile.txt";
//    Path path_customer = Paths.get(customerListFile);
//    List<String> customerList = Files.readAllLines(path_customer, StandardCharsets.UTF_8);

//    public Date passSearchMovieTime(String string)
//    {
//        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        try
//        {
//            String input = passChoiceString(string);
//            Date date = sim.parse(input);
//            return date;
//        }
//        catch(ParseException e)
//        {
//            System.out.println("Error, incorrect format");
//            return passSearchMovieTime(string);
//        }
//    }

//    public static Movie passStringMovie(String name_of_movie){
//        for (String movie : movieList){
//            if (movie == name_of_movie) return movie;
//        }
//        System.out.println("Sorry, the name of movie that you are looking for does not exist.");
//    }

//    public static Cinema passStringCinema(String cinema_ID){
//        for (String cinema : cinemaList){
//            if (cinema == cinema_ID) return cinema;
//        }
//        System.out.println("Sorry, the cinema that you are looking for does not exist.");
//    }

//    public static ShowTime passDoubleShowtime(double showtimeIn){
//        for (String showtime : showtimeList){
//            if (showtime == showtimeIn) return showtime;
//        }
//        System.out.println("Sorry, the Showtime that you are looking for does not exist.");
//    }

//    public Customer passStringCustomer (Customer customer_name) {
//        for (String customer : customerList){
//            if (customer == customer_name) return customer;
//        }
//    }

//    public static ShowTime displayShowtime(String movie_name){
//    	Movie movieIn = passStringMovie(movie_name);
//    	for (String showtime : showtimeList){
//            if (movie == movieIn) return showtime;
//        }
//        System.out.println("Sorry, the Showtime that you are looking for does not exist.");
//    }

    public static ShowingStatus passShowingStatus(String status)
    {
        status = status.toUpperCase();
        if(status == "COMING_SOON")
        {
            return ShowingStatus.COMING_SOON;
        }
        else if(status == "PREVIEW")
        {
            return ShowingStatus.PREVIEW;
        }
        else if(status == "NOW_SHOWING")
        {
            return ShowingStatus.NOW_SHOWING;
        }
        else if(status == "NO_LONGER_AVAILABLE")
        {
            return ShowingStatus.NO_LONGER_AVAILABLE;
        }
        else 
        {
            return null;
        }            
    }

    public static MovieType passMovieType(String movieType)
    {
        movieType = movieType.toUpperCase();
        if(movieType == "MOVIE3D")
        {
            return MovieType.MOVIE3D;
        }
        else if(movieType == "DIGITAL")
        {
            return MovieType.DIGITAL;
        }
        else 
        {
            return null;
        }
    }

    public static CinemaClass passCinemaClass(String cinemaclass)
    {
        cinemaclass = cinemaclass.toUpperCase();
        
        if(cinemaclass == "NORMAL")
        {
            return CinemaClass.NORMAL;
        }
        else if(cinemaclass == "PLATINUM")
        {
            return CinemaClass.PLATINUM;
        }
        else 
        {
            return null;
        }
        
    }

//    public static void searchMovie(String movie_name) {
//        Movie searched_movie = new Movie();
//        searched_movie = passStringMovie(movie_name);
//
//        // then proceed to print out the details
//    }
}