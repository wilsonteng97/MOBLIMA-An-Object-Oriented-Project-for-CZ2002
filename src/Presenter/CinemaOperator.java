package Presenter;

import Model.Cinema;
import java.io.FileInputStream;
import java.io.FileWriter;

public class CinemaOperator{
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    Path path_Showtime = Paths.get(showtimeListFile);
    List<String> showtimeList = Files.readAllLines(path_Showtime, StandardCharsets.UTF_8);

    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";
    Path path_Cinema = Paths.get(cinemaListFile);
    List<String> cinemaList = Files.readAllLines(path_Cinema, StandardCharsets.UTF_8);

    private final static String movieListFile = "datafiles/movieListFile.txt";
    Path path_Movie = Paths.get(movieListFile);
    List<String> movieList = Files.readAllLines(path_Movie, StandardCharsets.UTF_8);

    public CinemaOperator(){

    }
    
    private void readMovieListing(){
        for (String showtime : showtimeList){
            System.out.println(showtime);
        }
    }

    private void readShowtime(){

    }

    private void readCinemaList() {
        for (String cinema : cinemaList){
            System.out.println(cinema);
        }
    }

    public void updateShowTime(){

    }

    public void addCinema(Cinema cinema){

    }

    public void removeCinema(Cinema cinema){
        for (String cinemaToBeRemoved : cinemaList){
            System.out.println(cinemaToBeRemoved);
        }
    }

    public void addMovie(Movie Movie){

    }

    public void removeMovie(Movie movie){
        for (String movieToBeRemoved : movieList){
            System.out.println(movieToBeRemoved);
        }
    }

    public void updateCinemaList() {

    }

    public void updateMovieListing(){
        for (String movie : movieList){
            System.out.println(movie);
        }
    }

    public void addShowtime(Showtime showtime){

    }

    public void removeShowtime(Showtime showtime){
        for (String showtimeToBeRemoved : showtimeList){
            System.out.println(showtimeToBeRemoved);
        }
    }
}