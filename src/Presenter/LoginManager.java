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

// TODO: Auto-generated Javadoc
/**
 * The Class LoginManager is used to verify the login credentials of existing staff and moviegoer users.
 */
public class LoginManager {
    
    /** The scanner object for scanning the username and password. */
    Scanner sc = new Scanner(System.in);
    
    /** The user ID. */
    static int userID;
    
    /** The password. */
    static String password;

    /** The Constant adminAccountListFile is the txt file . */
    private final static String adminAccountListFile = "datafiles/adminAccountListFile.txt"; // file that stores the
                                                                                             // login data belonging to
                                                                                             
    /** The Constant userAccountListFile is the txt file. */
                                                                                             // staff
    private final static String userAccountListFile = "datafiles/userAccountListFile.txt"; // file that stores the
                                                                                            // login data belonging to
                                                                                            // customer
    
    /**                                                                                         
     * Verify staff.
     * @param username the username
     * @param password the password
     * @return true, if successful
     * */
    public static boolean verifyStaff(String username, String password) {
        List<Admin> all_accounts = (List<Admin>) DataManager.readDataFile_List(adminAccountListFile);

        for (Admin account : all_accounts) {
            if ((account.getUsername().equals(username)) && (account.getPassword().equals(password)))
                return true;
        }
        return false;
    }

    /**
     * Verify customer.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    public static boolean verifyCustomer(String username, String password) {
        List<Customer> all_accounts = (List<Customer>) DataManager.readDataFile_List(userAccountListFile);

        for (Customer user_Account : all_accounts) {
            if ((user_Account.getEmail().equals(username)) && (user_Account.getPassword().equals(password)))
                return true;
        }
        return false;
    }
}