package Presenter;

import Model.Customer;
import Model.Movie;
import Model.Cinema;

import java.io.IOException;
import java.util.ArrayList;
import static Presenter.AdminManager.*;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomerManager is used for the customers in performing operations specific to the customers only.
 */
public class CustomerManager {
    
    /** The cinema list. */
    private static ArrayList<Cinema> cinemaList;
    
    /** The movie list. */
    private static ArrayList<Movie> movieList;
    
    /** The customer list. */
    private static ArrayList<Customer> customerList;
    
    /** The Constant customerListFile is txt file. */
    private final static String customerListFile = "datafiles/userAccountListFile.txt";

    /**
     * Instantiates a new customer manager.
     */
    public CustomerManager() {

    }

    /**
     * Read customer list from txt file.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void readCustomerList() throws IOException{
    	
    	if(readDataFile_List(customerListFile) == null)
    		customerList = new ArrayList<>();
        else 
        	customerList = (ArrayList<Customer>) readDataFile_List(customerListFile);
    }

    /**
     * Update customer list.
     */
    public static void updateCustomerList()
    {
        try {
            writeDataFile(customerList, customerListFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the cinema list.
     *
     * @return the cinema list
     */
    public static ArrayList<Cinema> getCinemaList()
    {
        return cinemaList;
    }

    /**
     * Gets the customer list.
     *
     * @return the customer list
     */
    public static ArrayList<Customer> getCustomerList()
    {
        return customerList;
    }

    /**
     * Gets the cinema by ID.
     *
     * @param id the id
     * @return the cinema by ID
     */
    public String getCinemaByID(String id) 
    {
        for(Cinema cinema: cinemaList)
        {
            if(cinema.getCinemaID() == id)
            {
                return cinema.getCinemaName();
            }
        }
        return "empty";
    }

    /**
     * Gets the top 5 movies based on its average rating.
     *
     * @return the top 5 rating
     */
    public ArrayList<Movie> getTop5Rating()
    {
        return getTop5RankingRating();
    }

    /**
     * Gets the movie rating.
     *
     * @param movie the movie
     * @return the movie rating
     */
    public double getMovieRating(Movie movie){
        return movie.getReviewRatingAverage();
    }
}