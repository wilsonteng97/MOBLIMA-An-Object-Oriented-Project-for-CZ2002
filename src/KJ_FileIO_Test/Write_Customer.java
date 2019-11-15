package CZ2002_Mini_Project;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Write_Customer {
	final static int MAX = 12;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {

		ArrayList<Customer> lister = new ArrayList<Customer>();
		String fileName = "C:\\Users\\tkjie\\eclipse-workspace\\scse.cz2002.tkj.first\\CustListFile_Serialise.txt";

		FileOutputStream fileOut = new FileOutputStream(fileName, true);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
//		Customer(String customerID, String name, String mobile, String email, Date DOB)
		SimpleDateFormat simpleDateFormat_DDMMyyyy = new SimpleDateFormat("DD/MM/yyyy");
		Date first_nov = simpleDateFormat_DDMMyyyy.parse("01/11/1996");
		Customer c1 = new Customer("10552", "KJ Teo", "888889999", "genius@alwaysintellligent.com", first_nov);
		lister.add(c1);
		
		Date christmas = simpleDateFormat_DDMMyyyy.parse("25/12/2011");
		Customer c2 = new Customer("10553", "Hehe Lin", "81000000", "santa@christmas.com", christmas);
		lister.add(c2);
		
		out.writeObject(lister);
		
		System.out.println("Done");
		out.close();
		
		
	}
}
