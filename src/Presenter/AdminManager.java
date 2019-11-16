package Presenter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.lang.model.util.ElementScanner6;

import Data_Initializer.*;
import Model.Admin;
import Model.Cinema;
import Model.CinemaOperator;
import Model.Holiday;
import Model.Movie;
import Model.Review;
import Model.ShowTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
  private final static String holidayListFile = "datafiles/holidayListFile.txt";
    
    private static ArrayList<Admin> adminAccountList;
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    private static HashMap<Movie, ArrayList<Review>> reviewList;
    private static ArrayList<Movie> movieList;
    private static HashMap<String, Holiday> holidayList;

    // =========================Movie Price=========================
//    public double setMoviePrice(){
//        System.out.println("How much do you want to charge?");
//        return ticket_price = sc.nextDouble();
//    }



    // =======================Admin Account=======================
    public static void readAdminAccount()
    {
        if(readDataFile_List(adminAccountListFile) == null)
        {
            adminAccountList = new ArrayList<Admin>();
        }
        else
        {
            adminAccountList = (ArrayList<Admin>) readDataFile_List(adminAccountListFile);
        }
    }

    public static void updateAdminAccount(){
       try {
		writeDataFile(adminAccountList, adminAccountListFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    // =======================System Setting=======================
    
    public static void initialiseMovies() throws IOException {
    	MovieListGenerator.MovieList();
    }

    
 // =======================Holiday=======================
    public static void addHoliday(Holiday holiday) {
    	String key = holiday.getDate().toString();
    	holidayList.put(key, holiday);
    }
    
    public static void removeHoliday(Date holidayDate) throws IOException{
    	String key = holidayDate.toString();
    	holidayList.remove(key);
    }
    
    public static HashMap<String, Holiday> getHolidayList() {
    	return holidayList;
    }
    
//    public static void readHolidayList()
//    {
//        if(readDataFile_List(adminAccountListFile) == null)
//        {
//        	holidayList = new HashMap<String, Holiday>();
//        }
//        else
//        {
//        	holidayList = (HashMap<String, Holiday>) readDataFile_List(holidayListFile);
//        }
//    }
//
//    public static void updateHolidayList(){
//       try {
//		writeDataFile(holidayList, holidayListFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//    }

    public static void initialiseCinemaOperators() throws IOException
    {
        CinemaOperatorGenerator.CinemaOperatorList();
    }
    public static void initialiseAdminAccounts() throws IOException
    {
        AdminAccountListGenerator.AdminAccounts();
    }

    public static void initialiseCinemas() throws IOException
    {
        CinemaListGenerator.CinemaList();
    }

    // =========================Top 5 Movies=========================
    public static ArrayList<Movie> getTop5RankingRating(){
        ArrayList<Movie> top5rating = new ArrayList<Movie>();
        int count = 0;
        for(Movie movie: movieList)
            top5rating.add(movie);
        
        Collections.sort(top5rating, Model.Movie.reviewRatingAvgComparator);

//        Collections.sort(top5rating, new Comparator<Movie>()
//        {
//            public int compare(Movie m1, Movie m2)
//            {
//                if(getMovieRating(m1) > getMovieRating(m2))
//                {
//                    return 1;
//                }
//                else if(getMovieRating(m1) < getMovieRating(m2))
//                {
//                    return -1;
//                }
//                else
//                {
//                    return 0;
//                }  
//            }
//        });
//        while(top5rating.size() > 5)
//        {
//            top5rating.remove(5);
//        }
        ArrayList<Movie> final_list = new ArrayList<Movie>();
        for (Movie a: top5rating) {
        	final_list.add(a);
        	if (count == 5) break;
        	count++;
        }
        return final_list;
    }

    // =========================Review Lists=========================
	public static void readReviewList()
    {
        if(readDataFile_HashMap(reviewListFile) == null)
        {
            reviewList = new HashMap<>();
        }
        else
        {
            reviewList = (HashMap<Movie, ArrayList<Review>>) readDataFile_HashMap(reviewListFile);
        }
    }

    public static void updateReviewList() 
    {
        try {
			writeDataFile(reviewList, reviewListFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
    public static ArrayList<ShowTime> getShowtimeList(Movie movie)
    {
        return showtimeList.get(movie);
    }

    public static boolean confirmChoice(String choice)
    {
        if (choice.equals("Y") || choice.equals("y"))

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
        movieList = CinemaOperatorManager.getMovieList();

        for(Movie movie: movieList){
            top5sales.add(movie);            
        }
        Collections.sort(top5sales, Model.Movie.movieSalesComparator);
        
//        Collections.sort(top5sales, new Comparator<Movie>(){
//            public int compare(Movie m1, Movie m2)
//            {
//                if(m1.getTotalSales() > m2.getTotalSales())
//                {
//                    return 1;
//                }
//                else if(m1.getTotalSales() < m2.getTotalSales())
//                {
//                    return -1;
//                }
//                else
//                {
//                    return 0;
//                }  
//            }
//        });
//        while(top5sales.size() > 5)
//        {
//            top5sales.remove(5);
//        }
        ArrayList<Movie> final_list = new ArrayList<Movie>();

        int counter = 0;
        for (Movie a: top5sales) {
        	final_list.add(a);
            if (counter == 5) break;
            counter++;
        }
        return final_list;
    }
}