package Presenter;

import java.io.FileWriter;

import javax.lang.model.util.ElementScanner6;

import Model.Cinema;
import Model.CinemaOperator;

public class AdminManager
{
    public static void updateTop5Movies()
    {
        // Probably not necessary
    }

    public static void updateAdminAccount()
    {
        readAdminAccount();
        for(String str: adminAccountList)
        {
            adminAccountListFile.write(str + System.lineSeparator());
        }
        adminaccountListFile.close();
    }

    public static void updateShowtime()
    {
        for(String str: movieShowtime)
        {
            showtimeListFile.write(str + System.lineSeparator());
        }
        showtimeListFile.close();
    }

    public static void updateReviewList()
    {
        for(String str: reviewlist)
        {
            reviewListFile.write(str + System.lineSeparator());
        }
        reviewListFile.close();
    }

    public static void updateCinemaList()
    {
        for(String str: cinemaList)
        {
            cinemaListFile.write(str + System.lineSeparator());
        }
        cinemaListFile.close();
    }

    public static void updateMovieListing()
    {
        for(String str: movieList)
        {
            movieListFile.write(str + System.lineSeparator());
        }
        movieListFile.close();
    }

    public static void readTop5Movies()
    {
        // Probably not necessary
    }

    public static void readAdminAccount()
    {
        FileWriter adminAccountListFile = new FileWriter("adminaccountlist.txt");
        /*
        if(readSerializedObject(FILENAME_ADMINACCOUNT) == NULL)
        {
            adminAccount = new Hashmap<>();
        }
        adminAccount = (HashMap<String, String>) readSerializedObject(FILENAME_ADMINACCOUNT);
        */
    }


    public static void addCinema(Cinema cinema)
    {
        if(cinemaList.get(cinema.getCinemaOperator()) == NULL)
        {
            cinemaList.put(cinema, new ArrayList<>());
        }
        cinemaList.get(cinema.getCinemaOperator().add(cinema));
        updateCinemaList();
    }

    public static void removeCinema(Cinema cinema)
    {
        cinemaList.get(cinema.getCinemaOperator().remove(cinema));
        updateCinemaList();
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

    public static void addShowtime(Showtime showtime)
    {
        movieShowtime.get(showtime.getMovie()).add(showtime);
        updateShowtime();
    }

    public static void removeShowtime(Showtime showtime)
    {
        movieShowtime.get(showtime.getMovie()).remove(showtime);
        updateShowtime();
    }

    public String [] getReviewList()
    {
        return reviewList;
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
        while(top5sales.size() > 5)
        {
            top5sales.remove(5);
        }

        return top5sales;
    }

    public int getMovieSales(Movie movie)
    {
        return movie.getTotalSales();
    }


}