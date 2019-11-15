package CZ2002_Mini_Project;

import java.io.*;
import java.util.ArrayList;

public class ReadFile_4Cust {
	public static void main (String[] args) {
		int i=1;
		try {
			String fileName = "C:\\Users\\tkjie\\eclipse-workspace\\scse.cz2002.tkj.first\\CustListFile_Serialise.txt";
			FileInputStream fwStream = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fwStream);
			
			ArrayList<Customer> lister = (ArrayList<Customer>) in.readObject();
			
			System.out.println("The list of movies are: \n");
			for (Customer c : lister) {
				System.out.println(i + "\tID: " +  c.getCustomerID());
				System.out.println("\tName: " + c.getName());
				System.out.println("\tContact Number: " + c.getMobileNo());
				System.out.println("\tEmail Address: " + c.getEmail() + "\n");
				i++;
			}
			
			in.close();
		}
		catch (IOException e) {
			System.out.println("Error :( " + e.getMessage());
			e.printStackTrace();
			return;
	    }
		catch (ClassNotFoundException e) {
			System.out.println("Error :( " + e.getMessage());
			e.printStackTrace();
	         return;
	    }
	}
}
