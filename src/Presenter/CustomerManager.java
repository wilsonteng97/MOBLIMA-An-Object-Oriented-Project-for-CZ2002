package Presenter;

public class CustomerManager {
    String [] cinemaList = new String();
    String [] top5 = new String();
    String [] movieList = new String();
    String cinema, movieName;
    double averageRating;

    public CustomerManager() {

    }

    public String[] getCinemaList(){
        return cinemaList;
    }

    public String getCinemaByID(int cinemaID) {
        return cinema;
    }

    public String [] getTop5RankingRating (){
        return top5;
    }

    public int getMovieRating(String movieName){
        return averageRating;
    }

    public String [] getMovie(){
        return movieList;
    }
}