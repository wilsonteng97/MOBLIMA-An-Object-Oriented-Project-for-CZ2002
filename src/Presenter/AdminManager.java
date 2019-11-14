package Presenter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.lang.model.util.ElementScanner6;

import Model.Admin;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Movie;
import Model.Review;
import Model.ShowTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.HashMap;

public class AdminManager extends DataManager
{
    Scanner sc = new Scanner(System.in);
    double ticket_price;
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

    // =========================Movie Price=========================
    public double setMoviePrice(){
        System.out.println("How much do you want to charge?");
        return ticket_price = sc.nextDouble();
    }

    public static void setHoliday(){
        System.out.println("Please set the dates that will charge at holiday rates.");
    }

    // =======================Admin Account=======================
    public static void readAdminAccount()
    {
        if(readDataFile(adminAccountListFile) == null)
        {
            adminAccountList = new ArrayList<>();
        }
        else
        {
            adminAccountList = (ArrayList<Admin>) readDataFile(adminAccountListFile);
        }
    }

    public static void updateAdminAccount(){
       writeDataFile(adminAccountListFile, adminAccountList);
    }

    // =======================System Setting=======================

    // =========================Top 5 Movies=========================
    public static ArrayList<Movie> getTop5RankingRating(){
        ArrayList<Movie> top5rating = new ArrayList<Movie>();

        for(Movie movie: movieList)
        {
            top5rating.add(movie);
        }

        Collections.sort(top5rating, new Comparator<Movie>()
        {
            public int compare(Movie m1, Movie m2)
            {
                if(getMovieRating(m1) > getMovieRating(m2))
                {
                    return 1;
                }
                else if(getMovieRating(m1) < getMovieRating(m2))
                {
                    return -1;
                }
                else
                {
                    return 0;
                }  
            }
        });
        while(top5rating.size() > 5)
        {
            top5rating.remove(5);
        }

        return top5rating;
    }

    // =========================Review Lists=========================
    public static void readReviewList()
    {
        if(readDataFile(reviewListFile) == null)
        {
            reviewList = new HashMap<>();
        }
        else
        {
            reviewList = (Hashmap<Movie, ArrayList<Review>>) readDataFile(reviewListFile);
        }
    }

    public static void updateReviewList() 
    {
        writeDataFile(reviewListFile, reviewList);
    }

    public static ArrayList<Review> getReviewList(Movie movie)
    {
        return reviewList.get(movie);
    }
    public static double getMovieRating(Movie movie)
    {
        ArrayList<Review> reviewList = getReviewList(movie);
        double sum = 0;
        double rating = 0;
        if(reviewList == null)
        {
            return 0;
        }
        else 
        {
            for(Review review: reviewList)
            {
                sum = sum + review.getRating();
            }
            rating = sum / reviewList.size();
            return rating;
        }
    }

    // =========================Movie Sales=========================
    public Double getMovieSales(Movie movie)
    {
        return movie.getTotalSales();
    }

    
    // ====================Get Lists of Entitites====================  
    public static ArrayList<Cinema> getCinemaList(CinemaOperator cinemaOperator)
    {
        return cinemaList.get(cinemaOperator);
    }

    public static ArrayList<ShowTime> getShowtimeList(Movie movie)
    {
        return showtimeList.get(movie);
    }

    public static boolean confirmChoice(String choice)
    {
        if(choice == "y" || choice =="Y")
        {
            return true;
        }
        else 
        {
            return false;
        }
    }


    public static ArrayList<Movie> getTop5RankingSales()
    {
        ArrayList<Movie> top5sales = new ArrayList<Movie>();

        for(Movie movie: movieList)
        {
            top5sales.add(movie);
        }

        Collections.sort(top5sales, new Comparator<Movie>()
        {
            public int compare(Movie m1, Movie m2)
            {
                if(m1.getTotalSales() > m2.getTotalSales())
                {
                    return 1;
                }
                else if(m1.getTotalSales() < m2.getTotalSales())
                {
                    return -1;
                }
                else
                {
                    return 0;
                }  
            }
        });
        while(top5sales.size() > 5)
        {
            top5sales.remove(5);
        }

        return top5sales;
    }
}