package Presenter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Customer;
import Model.Enums.*;
import Presenter.DataManager;

public class KJ_Test {
    public static void main(String [] arg) throws IOException, ParseException, ClassNotFoundException{
    	ArrayList<Customer> lister = new ArrayList<Customer>();
    	
//        SimpleDateFormat simpleDateFormat_DDMMyyyy = new SimpleDateFormat("DD/MM/yyyy");
//		Date some_date = simpleDateFormat_DDMMyyyy.parse("19/07/1963");
//		Integer intg = new Integer(101582);
//    	
//        Customer a = new Customer(intg, "KJ Teo", "95212543", "KJ@genius.com", some_date);
//        lister.add(a);
//        
//        Customer b = new Customer(intg, "John", "84125369", "president@inpeached.com", some_date);
//        lister.add(b);
//        
//        Customer c = new Customer(intg, "May", "84125369", "president@inpeached.com", some_date);
//        lister.add(c);
//        
        String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\userAccountListFile.txt";
//        DataManager.writeFile(lister, fileName);
        
        lister = (ArrayList<Customer>) DataManager.readFile(fileName);
        
        for (Customer a: lister) {
        	System.out.println(a.getCustomerID());
        	System.out.println(a.getName());
        	System.out.println(a.getMobileNo());
        	System.out.println(" ");
        }
    }
    
//  ArrayList<String> some_str = new ArrayList<String>();
//  some_str.add("Joaquin Phoenix, Robert De Niro, Zazie Beetz, Bill Camp, Frances Conroy, Brett Cullen, Glenn Fleshler, Douglas Hodge");

}