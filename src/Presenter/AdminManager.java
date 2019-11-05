package Presenter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.lang.model.util.ElementScanner6;

import Model.Cinema;
import Model.CinemaOperator;

public class AdminManager extends DataManager
{
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

    public static void updateAdminAccount()
    {
       writeDataFile(adminAccountListFile, adminAccountList);
    }

    public static void updateShowtime() 
    {
       writeDataFile(showtimeListFile, showtimeList);
    }

    public static void updateReviewList() 
    {
        writeDataFile(reviewListFile, reviewList);
    }

    public static void updateCinemaList() 
    {
        writeDataFile(cinemaListFile, cinemaList);
    }

    public static void updateMovieListing() 
    {
        writeDataFile(movieListFile, movieList);
    }

    public static void readAdminAccount()
    {
        if(readDataFile(adminAccountListFile) == null)
        {
            adminAccountList = new ArrayList<>();
        }
        else
        {
            adminAccountList = (ArrayList<Staff>) readDataFile(adminAccountListFile);
        }
    }

    public static void readShowtime()
    {
        if(readDataFile(showtimeListFile) == null)
        {
            showtimeList = new Hashmap<>();
        }
        else
        {
            showtimeList = (Hashmap<Movie, ArrayList<Showtime>>) readDataFile(showtimeListFile);
        }
    }

    public static void readReviewList()
    {
        if(readDataFile(reviewListFile) == null)
        {
            reviewList = new Hashmap<>();
        }
        else
        {
            reviewList = (Hashmap<Movie, ArrayList<ReviewList>>) readDataFile(reviewListFile);
        }
    }

    public static void readCinemaList()
    {
        if(readDataFile(cinemaListFile) == null)
        {
            cinemaList = new Hashmap<>();
        }
        else
        {
            cinemaList = (Hashmap<CinemaOperator, ArrayList<Cinema>>) readDataFile(cinemaListFile);
        }
    }

    public static void readMovieList()
    {
        if(readDataFile(movieListFile) == null)
        {
            movieList = new ArrayList<>();
        }
        else
        {
            movieList = (ArrayList<Movie>) readDataFile(movieListFile);
        }
    }

    public static void addCinema(Cinema cinema)
    {
        if(cinemaList.get(cinema.getCinemaOperator()) == NULL)
        {
            cinemaList.put(cinema.getCinemaOperator(), new ArrayList<>());
        }
        cinemaList.get(cinema.getCinemaOperator().add(cinema));
        updateCinemaList();
    }

    public static void removeCinema(Cinema cinema)
    {
        cinemaList.get(cinema.getCinemaOperator().remove(cinema));
        updateCinemaList();
    }

    public static ArrayList<Cinema> getCinemaList(CinemaOperator cinemaOperator)
    {
        return cinemaList.get(cinemaOperator);
    }

    public static void addMovie(Movie movie)
    {
        movieList.add(movie);
        updateMovieListing();
    }

    public static void removeMovie(Movie movie)
    {
        movieList.remote(movie);
        updateMovieListing();
    }

    public static ArrayList<Movie> getMovieList()
    {
        return movieList;
    }


    public static void addShowtime(Showtime showtime)
    {
        showtimeList.get(showtime.getMovie()).add(showtime);
        updateShowtime();
    }

    public static void removeShowtime(Showtime showtime)
    {
        showtimeList.get(showtime.getMovie()).remove(showtime);
        updateShowtime();
    }

    public static ArrayList<Showtime> getShowtimeList(Movie movie)
    {
        return showtimeList.get(movie);
    }

    public static void addReview(Movie movie, Review review)
    {
        reviewList.get(movie).add(review);
        updateReviewList();
    }

    public static void removeReview(Movie movie, Review review)
    {
        reviewList.get(movie).remove(review);
        updateReviewList();
    }

    public static ArrayList<Review> getReviewList(Movie movie)
    {
        return reviewList.get(movie);
    }

    public static ArrayList<Movie> getTop5RankingSales()
    {
        ArrayList<Movie> top5sales = new ArrayList();

        for(Movie movie: movieList)
        {
            top5sales.add(movie);
        }

        Collections.sort(top5sales, new Comparator<Movie>()
        {
            public int compare(Movie m1, Movie m2)
            {
                if(m1.getMovieSales() > m2.getMovieSales())
                {
                    return 1;
                }
                else if(m1.getMovieSales() < m2.getMovieSales())
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

    public static ArrayList<Movie> getTop5RankingRating()
    {
        ArrayList<Movie> top5rating = new ArrayList();

        for(Movie movie: movieList)
        {
            top5rating.add(movie);
        }

        Collections.sort(top5rating, new Comparator<Movie>()
        {
            public int compare(Movie m1, Movie m2)
            {
                if(m1.getMovieRating() > m2.getMovieRating())
                {
                    return 1;
                }
                else if(m1.getMovieRating() < m2.getMovieRating())
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



    public int getMovieSales(Movie movie)
    {
        return movie.getTotalSales();
    }

    public double getMovieRating(Movie movie)
    {
        return movie.getMovieRating();
    }


}