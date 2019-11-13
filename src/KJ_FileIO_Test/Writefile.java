package CZ2002_Mini_Project;

import java.io.*;
import java.util.Scanner;

public class Writefile {
	public static void main (String[] args) {
		String fileName = " ";
		
		try {
			String movie_name;
			String runtime;
			String classification;
			
			System.out.println("Enter the file name: ");
			Scanner sc = new Scanner(System.in);
			fileName = sc.nextLine();
			
			FileOutputStream foStream = new FileOutputStream(fileName);
			BufferedOutputStream boStream = new BufferedOutputStream(foStream);
			ObjectOutputStream doStream = new ObjectOutputStream(boStream);
			
			int i;
			doStream.writeBytes("\n");
			for (i=0; i<3; i++) {
				System.out.print("Enter name ");
				movie_name = sc.next();
				System.out.print("Enter runtime ");
				runtime = sc.next();
				System.out.print("Enter classfication ");
				classification = sc.next();
				
				doStream.writeBytes(movie_name);
				doStream.writeBytes(" ");
				doStream.writeBytes(runtime);
				doStream.writeBytes(" ");
				doStream.writeBytes(classification);
				doStream.writeBytes("\n");
			}
			System.out.println("Writing completed!");
			doStream.close();
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
