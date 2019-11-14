package Presenter;

import Model.*;
import static Presenter.Query.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class CinemaOperatorManager {   
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt";
    private final static String showtimeListFile = "datafiles/showtimeListFile.txt";
    private final static String reviewListFile = "datafiles/reviewListFile.txt";
    private final static String cinemaListFile = "datafiles/cinemaListFile.txt";

    FileReader movieListFile = new FileReader("MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt.txt");
    BufferedReader movieStream = new BufferedReader(movieListFile);

    private static ArrayList<Admin> adminAccountList;
    private static HashMap<Movie, ArrayList<ShowTime>> showtimeList;
    private static HashMap<Movie, ArrayList<Review>> reviewList;
    private static HashMap<CinemaOperator, ArrayList<Cinema>> cinemaList;
    private static ArrayList<Movie> movieList;

    // Path path_Showtime = Paths.get(showtimeListFile);
    // List<String> showtimeList = Files.readAllLines(path_Showtime, StandardCharsets.UTF_8);

    // Path path_Cinema = Paths.get(cinemaListFile);
    // List<String> cinemaList = Files.readAllLines(path_Cinema, StandardCharsets.UTF_8);

    // Path path_Movie = Paths.get(movieListFile);
    // List<String> movieList = Files.readAllLines(path_Movie, StandardCharsets.UTF_8);

    static String inputLine;
    static int i, j;

    public static void readTheData()
    {
        readShowtime();

    }
    // =======================Showtime=======================
    private static void readShowtime(){
        if(readDataFile(showtimeListFile) == null)
            showtimeList = new HashMap<>();
        else
            showtimeList = (HashMap<Movie, ArrayList<ShowTime>>) readDataFile(showtimeListFile);
    }


    public static void addShowtime(Movie movie, ShowTime showTime)
    {
        showtimeList.get(movie).add(showTime);
        updateShowtime();
    }

    public static void removeShowtime(String moviename, double showTime){
    	Movie movie = passStringMovie(moviename);
    	ShowTime showtime = passDoubleShowtime(showTime);
    	// for (String showtimeToBeRemoved : showtimeList){
        //     System.out.println(showtimeToBeRemoved);
        // }
        // showtimeList.get(ShowTime.getMovie()).remove(ShowTime);
        showtimeList.get(movie).remove(showTime);
        updateShowtime();
    }

    public static void updateShowTime(){
        writeDataFile(showtimeListFile, showtimeList);
    }
    
    // ========================Cinema========================
    private static void readCinemaList() {
        // for (String cinema : cinemaList){
        //     System.out.println(cinema);
        // }
        if(readDataFile(cinemaListFile) == null)
            cinemaList = new HashMap<>();
        else
            cinemaList = (HashMap<CinemaOperator, ArrayList<Cinema>>) readDataFile(cinemaListFile);
    }

    public static void addCinema(Cinema cinema){
        if(cinemaList.get(cinema.getCinemaOperator()) == null)
        cinemaList.put(cinema.getCinemaOperator(), new ArrayList<>());
        cinemaList.get(cinema.getCinemaOperator()).add(cinema);
        updateCinemaList();
    }

    public static void removeCinema(String cinemaname){
    	Cinema cinema = passStringCinema(cinemaname);
    	// for (String cinemaToBeRemoved : cinemaList){
        //     System.out.println(cinemaToBeRemoved);
        // }
        cinemaList.get(cinema.getCinemaOperator()).remove(cinema);
        updateCinemaList();
    }

    public static void updateCinemaList() {
        writeDataFile(cinemaListFile, cinemaList);
    }

    // ========================Movie========================
    public static void readMovieListing(){
        // for (String ShowTime : showtimeList){
        //     System.out.println(ShowTime);
        // }
        // if(readDataFile(movieListFile) == null)
        //     movieList = new ArrayList<>();
        // else
            // movieList = (ArrayList<Movie>) readDataFile(movieListFile);
        try {                
            for (i=0; i<12; i++) {
                System.out.print(i+1 + ". ");
                for (j=0; j<3; j++) {
                    inputLine = brStream.readLine();
                    System.out.println("\t" + inputLine);
                }
                System.out.print("\n");
            }
            brStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error message " + e.getMessage());
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("Error message " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }   
    }


    public static void addMovie(String movieIn){
        movieList.add(movie);
        updateMovieListing();
    }

    public static void removeMovie(String movieIn){
    	Movie movie = passStringMovie(movieIn);
    	// for (String movieToBeRemoved : movieList){
        //     System.out.println(movieToBeRemoved);
        // }
        movieList.remove(movie);
        updateMovieListing();
    }

    public static void updateMovieListing(){
        // for (String movie : movieList){
        //     System.out.println(movie);
        // }
        writeDataFile(movieListFile, movieList);
    }
}