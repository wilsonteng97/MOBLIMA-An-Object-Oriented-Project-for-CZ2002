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
    	ArrayList<Customer> cust = new ArrayList<Customer>();
    	cust = Model.UserAccountListGenerator.CustomerList();
    	
//    	Movie a = new Movie()    	
    	String fileName = "datafiles/userAccountListFile.txt";
    	DataManager.writeDataFile(cust, fileName);
    	ArrayList<Customer> print_movies = new ArrayList<Customer>();
    	print_movies = (ArrayList<Customer>) DataManager.readDataFile_List(fileName);
    	
    	for (Customer m : print_movies) {
    		System.out.println(m.getName() + " " + m.getEmail());
    	}
    	
    }
}
