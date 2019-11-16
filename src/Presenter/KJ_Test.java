package Presenter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Model.*;
import Model.Enums.*;
import Presenter.DataManager;
import Data_Initializer.*;


public class KJ_Test {
    public static void main(String [] arg) throws IOException, ParseException, ClassNotFoundException{
//    	ArrayList<Movie> cust = new ArrayList<Movie>();
    	
//    	Movie a = new Movie()    	
    	String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt";
    	DataManager.readDataFile_List(fileName);
    	ArrayList<Movie> print_movies = new ArrayList<Movie>();
//    	CinemaOperatorManager.updateMovieListing();
//    	print_movies = (ArrayList<Movie>) DataManager.readDataFile_List(fileName);
    	
    	for (Movie m : print_movies) {
    		System.out.println(m.getTitle() + " " + m.getDirector());
    	}
    	
    }
}
