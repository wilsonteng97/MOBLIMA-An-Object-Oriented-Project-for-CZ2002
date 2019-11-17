package KJ_FileIO_Test;

import java.io.*;
import java.util.ArrayList;

public class Readfile_with_Serial_4Movie {
	public static void main (String[] args) {
		int i=1;
		try {
			String fileName = "C:\\Users\\tkjie\\eclipse-workspace\\scse.cz2002.tkj.first\\moviesListFile_Serialise.txt";
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
