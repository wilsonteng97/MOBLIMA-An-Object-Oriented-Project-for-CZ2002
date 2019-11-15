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
    public static void main(String [] arg) throws IOException, ParseException{
//        ArrayList<String> some_str = new ArrayList<String>();
//        some_str.add("Joaquin Phoenix, Robert De Niro, Zazie Beetz, Bill Camp, Frances Conroy, Brett Cullen, Glenn Fleshler, Douglas Hodge");

//        ArrayList<Customer> lister = new ArrayList<Customer>();
//        
//        SimpleDateFormat simpleDateFormat_DDMMyyyy = new SimpleDateFormat("DD/MM/yyyy");
//		Date some_date = simpleDateFormat_DDMMyyyy.parse("05/12/1985");
//		int randId = (int)Math.random()*10000;
//        Customer a = new Customer(Integer.toString(randId), "Donald John Trump", "88889999", "impresident@mail.com", some_date);
//       
//        lister.add(a);
//        CustomerFileIO.writeCustomerFile(lister);
    	CustomerFileIO.readCustomerFile();
    }
}