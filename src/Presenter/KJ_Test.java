package Presenter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Model.*;
import Model.Enums.*;
import Presenter.DataManager;

public class KJ_Test {
    public static void main(String [] arg) throws IOException, ParseException, ClassNotFoundException{
    	ArrayList<Movie> our_movies = new ArrayList<Movie>();
    	our_movies = Model.MovieListGenerator.MovieList();
    	
//    	Movie a = new Movie()
    	our_movies.remove(1);
    	
    	String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt";
    	DataManager.writeDataFile(our_movies, fileName);
    	ArrayList<Movie> print_movies = new ArrayList<Movie>();
    	print_movies = (ArrayList<Movie>) DataManager.readDataFile_List(fileName);
    	
    	for (Movie m : print_movies) {
    		System.out.println(m.getTitle() + m.getDirector());
    	}
    	
    }
}
