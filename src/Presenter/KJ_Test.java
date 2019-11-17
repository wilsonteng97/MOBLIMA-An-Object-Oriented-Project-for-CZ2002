package Presenter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static Presenter.CustomerManager.*;

import Data_Initializer.UserAccountListGenerator;
import Model.*;
import Model.Enums.*;
import Presenter.DataManager;
import static Data_Initializer.UserAccountListGenerator.*;


public class KJ_Test {
    public static void main(String [] arg) throws IOException, ParseException, ClassNotFoundException{
//    	ArrayList<Movie> cust = new ArrayList<Movie>();
    	
//    	Movie a = new Movie()    	
//    	String fileName = "datafiles/userAccountListFile.txt";
    	ArrayList<Customer> print = getCustomerList();
//    	DataManager.writeDataFile(print, fileName);
//    	DataManager.readDataFile_List(fileName);
//    	ArrayList<Customer> print_movies = new ArrayList<Customer>();
//    	CinemaOperatorManager.updateMovieListing();
//    	print_movies = (ArrayList<Movie>) DataManager.readDataFile_List(fileName);
    	
    	for (Customer m : print) {
    		System.out.println(m.getName() + " " + m.getEmail());
    	}
    	
    }
}
