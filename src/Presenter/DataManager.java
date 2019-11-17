package Presenter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import Model.Movie;

// TODO: Auto-generated Javadoc
/**
 * The Class DataManager is used to perform read and write operations in handling the txt files.
 */
public class DataManager {

	/**
	 * Write data file by reading the arraylist and the filename to store the data.
	 *
	 * @param lister the lister
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void writeDataFile(Object lister, String fileName) throws IOException{
		FileOutputStream fileOut = new FileOutputStream(fileName);
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	
	    out.writeObject(lister);
		System.out.println("Writing Done");
		out.close();
	}

	/**
	 * Read data file and return the arraylist.
	 *
	 * @param fileName the file name
	 * @return the object
	 */
	public static Object readDataFile_List(String fileName){
		try {
			FileInputStream fwStream = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fwStream);
			Object lister = in.readObject();

			in.close();
			return lister;
		}
		catch (IOException e) {
			System.out.println(fileName + " initially empty");
			return null;
	    }
		catch (ClassNotFoundException e) {
			System.out.println(fileName + "initially empty");
	        return null;
	    }
	}
		
		/**
		 * Read data file and return the hash map.
		 *
		 * @param fileName the file name
		 * @return the object
		 */
		public static Object readDataFile_HashMap(String fileName){
			try {
				FileInputStream fwStream = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fwStream);
				Object hashmap = in.readObject();

				in.close();
				return hashmap;
			}
			catch (IOException e) {
				System.out.println(fileName + " initially empty");
				return null;
		    }
			catch (ClassNotFoundException e) {
				System.out.println(fileName + " initially empt");
		        return null;
		    }
		}
}