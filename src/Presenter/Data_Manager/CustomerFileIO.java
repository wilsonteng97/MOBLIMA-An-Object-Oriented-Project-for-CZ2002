package Presenter.Data_Manager;

import java.io.*;
import java.util.ArrayList;
import Model.Customer;

public abstract class CustomerFileIO {

  // =================================Customer Class=================================
  public static void writeCustomerFile(ArrayList<Customer> customer_list) throws IOException{
    ArrayList<Customer> lister = new ArrayList<Customer>();
	String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\cinemaListFile.txt";
		
	FileOutputStream fileOut = new FileOutputStream(fileName, true);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);

	lister.addAll(customer_list);
    out.writeObject(lister);
	System.out.println("Writing Done!");
	out.close();
  }

  public static void readCustomerFile(){
    int i=1;
		try {
			String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\cinemaListFile.txt";
			FileInputStream fwStream = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fwStream);
			
			ArrayList<Customer> lister = (ArrayList<Customer>) in.readObject();
			
			System.out.println("The list of customers: \n");
			for (Customer cust : lister) {
				System.out.println(i + "\tID: " +  cust.getCustomerID());
				System.out.println("\tName: " + cust.getName());
				System.out.println("\tMobile Number: " + cust.getMobileNo());
				System.out.println("\tEmail: " + cust.getEmail() + "\n");
				i++;
			}
			
			in.close();
		}
		catch (IOException e) {
			System.out.println("Error occured: " + e.getMessage());
			e.printStackTrace();
			return;
	    }
		catch (ClassNotFoundException e) {
			System.out.println("Error occured: " + e.getMessage());
			e.printStackTrace();
	         return;
	    }
  }
}