package Presenter;

import Model.Customer;
import Model.Movie;
import Model.Cinema;

import java.util.ArrayList;
import static Presenter.AdminManager.*;


public class CustomerManager {
    ArrayList<Cinema> cinemaList;
    ArrayList<Movie> movieList;
    static ArrayList<Customer> customerList;

    private final static String customerListFile = "datafiles/userAccountListFile.txt";
    
    String cinema, movieName;
    double averageRating;

    public CustomerManager() {

    }

    public ArrayList<Cinema> getCinemaList()
    {
        return cinemaList;
    }

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

    public ArrayList<Movie> getTop5Rating()
    {
        return getTop5RankingRating();
    }

    public int getMovieRating(String movieName){
        return averageRating;
    }

    public static ArrayList<Customer> getCustomerList(){
    	
    	if(readDataFile_List(customerListFile) == null)
    		customerList = new ArrayList<>();
        else 
        	customerList = (ArrayList<Customer>) readDataFile_List(customerListFile);
    	return customerList;
    }
}