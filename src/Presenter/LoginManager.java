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

    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt"; //file that stores the login data belonging to staff
    private final static String userAccountListFile = "datafiles/adminAccountListFile.txt"; //file that stores the login data belonging to customer
    
    public LoginManager()  {
        
    }

    public boolean verifyStaff(String username, String password) {
        Path path = Paths.get(adminAccountListFile);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String login_username : lines) {
            if ((login_username == userID) && (login_username == password))
                return true;
            else return false;
        }
    }

    public boolean verifyCustomer(String username, String password) {
        Path path = Paths.get(userAccountListFile);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String login_username : lines) {
            if ((login_username == userID) && (login_username == password))
                return true;
            else return false;
        }
    }
}