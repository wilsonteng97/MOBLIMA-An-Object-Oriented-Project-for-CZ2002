package Presenter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.lang.model.util.ElementScanner6;
import static Presenter.CustomerManager.*;
import Model.Enums.AgeRestriction;
import Model.Enums.CinemaClass;
import Model.Enums.MovieType;
import Model.Enums.ShowingStatus;
import Model.Cinema;
import Model.Customer;
import Model.Movie;
import Model.ShowTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Query.
 */
public class Query {
	
	/** The movie list which is generated from the dummy records of movies prepared. */
	static ArrayList<Movie> movieList = CinemaOperatorManager.getMovieList();

    /** The Constant cinemaListFile is the txt file. */
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";

    /** The Constant showtimeListFile is the txt file. */
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    
   /** The customer list which is generated from the dummy records of customer list prepared. */
   public static ArrayList<Customer> customerList = getCustomerList();

    /**
     * Pass string movie is used to convert the name of the movie to the movie object.
     *
     * @param name_of_movie the name of movie
     * @return the movie
     */
    public static Movie passStringMovie(String name_of_movie){
        for (Movie movie : movieList){
            if (movie.getTitle().equalsIgnoreCase(name_of_movie)) return movie;
        }
		return null;
    }

    /**
     * Pass string customer is used to convert the name of the customer to the customer object.
     *
     * @param customer_name the customer name
     * @return the customer
     */
    public static Customer passStringCustomer (String customer_name) {
        for (Customer customer : customerList){
            if (customer.getName().equals(customer_name)) 
            {            
                return customer;
            }
        }
		return null;
    }
}