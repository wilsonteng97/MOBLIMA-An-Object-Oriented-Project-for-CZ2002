package Presenter;

import Model.Customer;
import java.io.FileInputStream;
import java.io.FileWriter;

public class LoginManager {
    Scannner sc = new Scanner(System.in);
    
    Customer randCust = new Customer();
    String password = randCust.getBookings();
    int userID = randCust.getEmail(); //temp code, need to get the user's username and password

    public LoginManager()  {
        
    }

    public void verifyUser(int userID, String password) {
        
    }
}