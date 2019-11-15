package CZ2002_Mini_Project;

import java.io.*;

public class ReadFile {
	public static void main(String[] args) {
		try {
			FileReader frStream = new FileReader(
			"C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt.txt");
			BufferedReader brStream = new BufferedReader(frStream);
			
			String inputLine;
			int i, j;
			System.out.println("The file contains: ");
			
			for (i=0; i<12; i++) {
				System.out.print(i+1 + ". ");
				for (j=0; j<4; j++) {
					inputLine = brStream.readLine();
					System.out.println("\t" + inputLine);
				}
				System.out.print("\n");
			}
			brStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error leh " + e.getMessage());
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Error leh " + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
}
