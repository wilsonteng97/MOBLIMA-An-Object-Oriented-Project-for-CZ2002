package Presenter;

import Model.Customer;
import Model.Movie;
import Model.Cinema;

import java.util.ArrayList;
import static Presenter.AdminManager.*;


public class CustomerManager {
    ArrayList<Cinema> cinemaList;
    ArrayList<Movie> movieList;
  //  Cinema CustCheckID = new Cinema();
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

}