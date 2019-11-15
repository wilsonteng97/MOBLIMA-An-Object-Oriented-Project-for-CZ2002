package CZ2002_Mini_Project;

import java.io.*;
import java.util.Scanner;

public class WriteFile {
	public static void main(String [] args) {
		String fileName = "C:\\Users\\tkjie\\eclipse-workspace\\scse.cz2002.tkj.first\\movieListFile.ser";
		
		Movie a = new Movie();
		
		try {
			Scanner sc = new Scanner(System.in);

			FileWriter fwStream = new FileWriter(fileName, true);
			BufferedWriter bwStream = new BufferedWriter(fwStream);
			PrintWriter pwStream = new PrintWriter(bwStream);
			
			int i;
			for (i=0; i<2; i++) {
				System.out.print("Name: ");
				a.movieName = sc.nextLine();
				System.out.print("Classfication ");
				a.classification = sc.nextLine();
				System.out.print("Sypnosis ");
				a.sypnosis = sc.nextLine();
				System.out.print("Runtime: ");
				a.runtime = sc.nextInt();
				pwStream.write(a.movieName + "\n" + a.runtime + " mins\n"  + a.classification +
						"\n" + a.sypnosis + "\n");
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
