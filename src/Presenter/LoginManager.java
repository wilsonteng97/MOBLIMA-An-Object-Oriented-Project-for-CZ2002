package Presenter;

import Model.Admin;
import Model.Customer;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LoginManager {
    Scanner sc = new Scanner(System.in);
    
    // Customer randCust = new Customer();
    // String password = randCust.getBookings();
    // int userID = randCust.getEmail(); //temp code, need to get the user's username and password
    static int userID;
    static String password;

    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt"; // file that stores the
                                                                                             // login data belonging to
                                                                                             // staff
    private final static String userAccountListFile = "datafiles/adminAccountListFile.txt"; // file that stores the
                                                                                            // login data belonging to
                                                                                            // customer

    public static boolean verifyStaff(String username, String password) {
//        Path path = Paths.get(adminAccountListFile);
        List<Admin> all_accounts = (List<Admin>) DataManager.readDataFile_List(adminAccountListFile);

        for (Admin account : all_accounts) {
            if ((account.getUsername() == username) && (account.getPassword() == password))
                return true;
        }
        return false;
    }

    public static boolean verifyCustomer(String username, String password) {
//        Path path = Paths.get(userAccountListFile);
        List<Customer> all_accounts = (List<Customer>) DataManager.readDataFile_List(userAccountListFile);

        for (Customer user_Account : all_accounts) {
            if ((user_Account.getEmail() == username) && (user_Account.getPassword() == password))
                return true;
        }
        return false;
    }
}