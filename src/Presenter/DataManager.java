package Presenter;

import java.io.*;
import java.util.ArrayList;
import Model.Movie;

public class DataManager {

  // =================================Movie Class=================================
  public static void writeMovieFile(ArrayList<Movie> lister2) throws IOException{
    ArrayList<Movie> lister = new ArrayList<Movie>();
	String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt";
		
	FileOutputStream fileOut = new FileOutputStream(fileName, true);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);

	lister.addAll(lister2);
    out.writeObject(lister);
	System.out.println("Done");
	out.close();
  }

  public static void readMovieFile(){
    int i=1;
		try {
			String fileName = "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt";
			FileInputStream fwStream = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fwStream);
			
			ArrayList<Movie> lister = (ArrayList<Movie>) in.readObject();
			
			System.out.println("The list of movies are: \n");
			for (Movie m : lister) {
				System.out.println(i + "\tName: " +  m.getTitle());
				System.out.println("\tRuntime: " + m.getRunTime());
				System.out.println("\tDirected by: " + m.getDirector());
				System.out.println("\tSypnosis: " + m.getSynopsis() + "\n");
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