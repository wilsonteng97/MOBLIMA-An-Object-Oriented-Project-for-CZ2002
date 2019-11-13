package Presenter;

import Model.Customer;
import java.io.FileInputStream;
import java.io.FileWriter;

public class LoginManager {
    Scannner sc = new Scanner(System.in);
    
    // Customer randCust = new Customer();
    // String password = randCust.getBookings();
    // int userID = randCust.getEmail(); //temp code, need to get the user's username and password
    int userID;
    String password;

    private final static String userAccountListFile = "datafiles/adminAccountListFile.txt";
    
    public LoginManager()  {
        
    }

    public void verifyUser() {
        Path path = Paths.get(userAccountListFile);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String username : lines) {
            if ((username == userID) && (username == password)){

            }
            else{
                System.out.println("Your username or password could be incorrect. Please try again.");
            }
        }

    }
}