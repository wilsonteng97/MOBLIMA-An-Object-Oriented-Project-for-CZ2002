package Presenter;

import Model.Customer;
import Model.Movie;
import Model.Cinema;

import java.io.IOException;
import java.util.ArrayList;
import static Presenter.AdminManager.*;


public class CustomerManager {
    private static ArrayList<Cinema> cinemaList;
    private static ArrayList<Movie> movieList;
    private static ArrayList<Customer> customerList;
    private final static String customerListFile = "datafiles/userAccountListFile.txt";


    String cinema, movieName;
    double averageRating;

    public CustomerManager() {

    }

    public static void readCustomerList() throws IOException{
    	
    	if(readDataFile_List(customerListFile) == null)
    		customerList = new ArrayList<>();
        else 
        	customerList = (ArrayList<Customer>) readDataFile_List(customerListFile);
    }

    public static void updateCustomerList()
    {
        try {
            writeDataFile(customerList, customerListFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ArrayList<Cinema> getCinemaList()
    {
        return cinemaList;
    }

    public static ArrayList<Customer> getCustomerList()
    {
        return customerList;
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

    public double getMovieRating(Movie movie){
        return movie.getReviewRatingAverage();
    }

    
}