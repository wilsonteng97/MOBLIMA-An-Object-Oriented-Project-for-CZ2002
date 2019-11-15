package Presenter.Data_Manager;

import java.io.*;
import java.util.ArrayList;
import Model.Customer;

public abstract class CustomerFileIO {

	public static final String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\userAccountListFile.txt";
  // =================================Customer Class=================================
<<<<<<< Updated upstream
	public static void writeCustomerFile(Customer customer) throws IOException, ClassNotFoundException, EOFException{
=======
	public static void writeCustomerFile(ArrayList<Customer> lister2) throws IOException, ClassNotFoundException, EOFException{
>>>>>>> Stashed changes
		  
		  
		  FileInputStream fwStream = new FileInputStream(fileName);
		  ObjectInputStream in = new ObjectInputStream(fwStream);
<<<<<<< Updated upstream
		  ArrayList<Customer> lister = (ArrayList<Customer>) in.readObject();
		  
		  if (lister == null) {
			  FileOutputStream fileOut = new FileOutputStream(fileName, true);
			  ObjectOutputStream out = new ObjectOutputStream(fileOut);
			  lister.add(customer);
		  	  out.writeObject(lister);
		  }
		  else {
			  ArrayList<Customer> newCust = new  ArrayList<Customer>();
			  FileOutputStream fileOut = new FileOutputStream(fileName, true);
			  ObjectOutputStream out = new ObjectOutputStream(fileOut);
			  out.writeObject(newCust);
			  System.out.println("Writing Done!");
			  out.close();
		  }
=======
		  ArrayList<Customer> lister2 = (ArrayList<Customer>) in.readObject();

	  	  in.writeObject(lister2);
	  	  in.close();
		  
//		  if (lister == null) {
//			  FileOutputStream fileOut = new FileOutputStream(fileName, true);
//			  ObjectOutputStream out = new ObjectOutputStream(fileOut);
//			  lister.add(lister2);
//		  	  out.writeObject(lister);
//		  }
//		  else {
//			  ArrayList<Customer> newCust = new  ArrayList<Customer>();
//			  FileOutputStream fileOut = new FileOutputStream(fileName, true);
//			  ObjectOutputStream out = new ObjectOutputStream(fileOut);
//			  out.writeObject(newCust);
//			  System.out.println("Writing Done!");
//			  out.close();
//		  }
>>>>>>> Stashed changes
  }
  
//  public static void saveNewCustomer(Customer customer) throws IOException, ClassNotFoundException {
//	  String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\userAccountListFile.txt";
//	  FileInputStream fwStream = new FileInputStream(fileName);
//	  ObjectInputStream in = new ObjectInputStream(fwStream);
//	  ArrayList<Customer> existingCust = (ArrayList<Customer>) in.readObject();
//	  existingCust.add(customer);
//	  in.close();
//	  writeCustomerFile(existingCust);
//  }

  public static void readCustomerFile(Customer customer){
    int i=1;
		try {
			ObjectInputStream in = new ObjectInputStream(fwStream);
			
			ArrayList<Customer> lister = (ArrayList<Customer>) in.readObject();
			
			System.out.println("The list of customers: \n");
			for (Customer c : lister) {
				if (c == customer) {
					System.out.println(i + "\tID: " +  c.getCustomerID());
					System.out.println("\tName: " + c.getName());
					System.out.println("\tContact Number: " + c.getMobileNo());
					System.out.println("\tEmail Address: " + c.getEmail() + "\n");
				}
				else
					System.out.println("No such customer");
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