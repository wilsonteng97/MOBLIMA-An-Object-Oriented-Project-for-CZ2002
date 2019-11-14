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
//			System.out.print("Enter number of new records ");
//			int n = sc.nextInt();
//			
			FileWriter fwStream = new FileWriter(fileName, true);
			BufferedWriter bwStream = new BufferedWriter(fwStream);
			PrintWriter pwStream = new PrintWriter(bwStream);
			
			int i;
//			doStream.writeBytes("\n");
			for (i=0; i<1; i++) {
				System.out.print("Enter name ");
				movie_name = sc.nextLine();
				System.out.print("Enter runtime ");
				runtime = sc.next();
				System.out.print("Enter classfication ");
				classification = sc.next();
//				
//				doStream.writeBytes(movie_name);
//				doStream.writeBytes(" ");
//				doStream.writeBytes(runtime);
//				doStream.writeBytes(" ");
//				doStream.writeBytes(classification);
//				doStream.writeBytes("\n");
				pwStream.flush();
				pwStream.write(movie_name + " " + runtime + " mins "  + classification + "\n");
			}
			System.out.println("Writing completed!");
			pwStream.close();
		}
//		catch (FileNotFoundException e) {
//			System.out.println("Error leh" + e.getMessage());
//			System.exit(0);
//		}
		catch (IOException e) {
			System.out.println("Error leh" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
}
