package Presenter;

import Model.Movie;
import java.io.*;

public class initialiseMovie {
    public initialiseMovie(){
        String title;
        AgeRestriction ageRestriction;
        MovieType type;
        ShowingStatus status;
        String opening;
        String runtime;
        String synopsis;
        Boolean blockBuster;

        try {
            FileReader frStream = new FileReader(
            "C:\\Users\\tkjie\\Documents\\GitHub\\MOBLIMA-An-Object-Oriented-Project-for-CZ2002\\datafiles\\movieListFile.txt.txt");
            BufferedReader brStream = new BufferedReader(frStream);
            
            String inputLine;
            int i, j;
            
            for (i=0; i<2; i++) {
                System.out.print(i+1 + ". ");
                for (j=0; j<3; j++) {
                    inputLine = brStream.readLine();
                    switch (j){
                        case 0: title = inputLine;
                        case 1: runtime = inputLine;
                        case 3: ageRestriction = inputLine;
                    }
                }
                System.out.print("\n");
            }
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

        Movie movie = new Movie(title, ageRestriction, type, status, opening, runtime, synopsis, blockBuster);

    }
}