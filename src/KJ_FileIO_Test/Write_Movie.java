package KJ_FileIO_Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Write_Movie {
	final static int MAX = 12;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ArrayList<Movie> lister = new ArrayList<Movie>();
		String fileName = "C:\\Users\\tkjie\\eclipse-workspace\\scse.cz2002.tkj.first\\moviesListFile_Serialise.txt";
		int j, num;
		Scanner sc = new Scanner(System.in);
		
		FileOutputStream fileOut = new FileOutputStream(fileName, true);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
//		System.out.println("Input how many movies?");
//		num = sc.nextInt();
		
//		for (j=0; j<num; j++) {
//			Movie m = new Movie();
//			lister.add(m);
//			
//			System.out.println("Name: ");
//			m.movieName = sc.next();
//			System.out.println("Runtime: ");
//			m.runtime = sc.nextInt();
//			System.out.println("Classification: ");
//			m.classification = sc.next();
//			System.out.println("Sypnosis: ");
//			m.sypnosis = sc.next();
//		}
//		Movie(String title, String opening, String director, String runtime, String synopsis, Boolean blockBuster)
		
		Movie m1 = new Movie("X-Men: Dark Phoenix", "2019-05-15", "Teo K. J.", "114 mins", "Blockbuster of the century", true);
		lister.add(m1);
		Movie m2 = new Movie("The Gangster, the Cop, the Devil", "2018-09-07", "Wilson T. T.", "110 minutes", "One of the worst movies.", false);
		lister.add(m2);
		Movie m3 = new Movie("Midsommar", "2019-01-02", "Song YM", "138 minutes", "A movie on a lonely man", false);
		lister.add(m3);
		
		out.writeObject(lister);
		
		System.out.println("Done");
		out.close();
		
		
	}
}
