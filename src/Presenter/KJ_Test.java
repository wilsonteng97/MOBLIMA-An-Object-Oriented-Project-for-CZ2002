package Presenter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Customer;
import Model.Enums.*;
import Presenter.Data_Manager.CustomerFileIO;
import Presenter.Data_Manager.MovieFileIO;

public class KJ_Test {
    public static void main(String [] arg) throws IOException, ParseException, ClassNotFoundException{
<<<<<<< Updated upstream
//    	ArrayList<Customer> lister = new ArrayList<Customer>();
=======
    	ArrayList<Customer> lister = new ArrayList<Customer>();
>>>>>>> Stashed changes
    	
        SimpleDateFormat simpleDateFormat_DDMMyyyy = new SimpleDateFormat("DD/MM/yyyy");
		Date some_date = simpleDateFormat_DDMMyyyy.parse("19/07/1963");
		Integer intg = new Integer((int)Math.random()*10000);
<<<<<<< Updated upstream
        Customer a = new Customer(intg, "me tooo", "84125369", "president@inpeached.com", some_date);
//        lister.add(a);
        CustomerFileIO.writeCustomerFile(a);
    	CustomerFileIO.readCustomerFile(a);
=======
        Customer a = new Customer(intg, "Rachel", "84125369", "president@inpeached.com", some_date);
        lister.add(a);
        
        Customer b = new Customer(intg, "John", "84125369", "president@inpeached.com", some_date);
        lister.add(b);
        
        Customer c = new Customer(intg, "May", "84125369", "president@inpeached.com", some_date);
        lister.add(c);
        
        CustomerFileIO.writeCustomerFile(lister);
    	CustomerFileIO.readCustomerFile();
>>>>>>> Stashed changes
    }
    
//  ArrayList<String> some_str = new ArrayList<String>();
//  some_str.add("Joaquin Phoenix, Robert De Niro, Zazie Beetz, Bill Camp, Frances Conroy, Brett Cullen, Glenn Fleshler, Douglas Hodge");

}