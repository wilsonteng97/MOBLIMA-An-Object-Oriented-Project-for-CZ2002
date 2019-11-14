package CZ2002_Mini_Project;

import java.io.*;
import java.util.Scanner;

public class Writefile {
	public static void main (String[] args) {
		String fileName = "C:\\Users\\tkjie\\eclipse-workspace\\scse.cz2002.tkj.first\\hehe.txt";
		
		try {
			String movie_name;
			String runtime;
			String classification;

			Scanner sc = new Scanner(System.in);
	
			FileWriter fwStream = new FileWriter(fileName, true);
			BufferedWriter bwStream = new BufferedWriter(fwStream);
			PrintWriter pwStream = new PrintWriter(bwStream);
			
			int i;
			for (i=0; i<1; i++) {
				System.out.print("Name: ");
				movie_name = sc.nextLine();
				System.out.print("Runtime: ");
				runtime = sc.next();
				System.out.print("Classfication ");
				classification = sc.next();
				sc.next();
				pwStream.flush();
				pwStream.write(movie_name + "\n" + runtime + " mins\n"  + classification);
			}
			System.out.println("Writing completed!");
			pwStream.close();
		}

		catch (IOException e) {
			System.out.println("Error leh" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
}
