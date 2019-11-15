package Presenter;

import java.io.*;
import java.util.ArrayList;
import Model.Movie;

public abstract class DataManager {

	public static void writeFile(Object lister, String fileName) throws IOException{
		new FileOutputStream(fileName).close(); //make a clean slate of data file first then add
		FileOutputStream fileOut = new FileOutputStream(fileName);
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	
	    out.writeObject(lister);
		System.out.println("Writing Done");
		out.close();
  }

	public static Object readFile(String fileName){
		try {
			FileInputStream fwStream = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fwStream);
			ArrayList<Object> lister = (ArrayList<Object>) in.readObject();

			in.close();
			return lister;
		}
		catch (IOException e) {
			System.out.println("Error occured: " + e.getMessage());
			e.printStackTrace();
			return null;
	    }
		catch (ClassNotFoundException e) {
			System.out.println("Error occured: " + e.getMessage());
			e.printStackTrace();
	        return null;
	    }
  }

  // public static List<String> readFileInList(String fileName) { 
  
  //   List<String> lines = Collections.emptyList(); 
    
  //   try    { 
  //     lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
  //   } 
  
  //   catch (IOException e) { // do something 
  //     e.printStackTrace(); 
  //   } 
  //       return lines; 
  // } 

  // public static void writeDataFile(String filename, Object data)    {
  //     FileOutputStream adminAccountListFile = new FileInputStream(filename);
  //     ObjectOutputStream objectOutputStream = new ObjectOutputStream(adminAccountListFile);
  //     objectOutputStream.writeObject(data);
  //     objectOutputStream.close();
  // }
}