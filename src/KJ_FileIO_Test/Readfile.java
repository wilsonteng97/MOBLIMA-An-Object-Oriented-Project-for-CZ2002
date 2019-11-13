package CZ2002_Mini_Project;

import java.io.*;

public class Readfile {
	public static void main(String[] args) {
		try {
			FileReader frStream = new FileReader("C:\\Users\\tkjie\\Desktop\\Notes_for_meeting.txt");
			BufferedReader brStream = new BufferedReader(frStream);
			
			String inputLine;
			int i;
			System.out.println("The file contains: ");
			
			for (i=0; i<12; i++) {
				inputLine = brStream.readLine();
				System.out.println(inputLine);
			}
			brStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error leh" + e.getMessage());
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Error leh" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
}
