package Presenter;

import java.io.IOException;
import java.util.ArrayList;
import static Presenter.DataManager.*;
import Model.Booking;
import Model.Customer;

public class BookingManager {
    private final static String userBookingListFile = "datafiles/userBookingFile.txt";
    private static ArrayList<Booking> userBookingList;

    public BookingManager(){
        
    }
    
    public static void addBooking(Booking history) throws IOException {
    	userBookingList.add(history);
        updateBookingListing();
    }

    public static void updateBookingListing() throws IOException{
        writeDataFile(userBookingList, userBookingListFile);
    }

    
    public static void getBookingHistory(Customer customer){
    	
    	if (userBookingList == null || userBookingList.isEmpty()) {
            System.out.println("No history to show.");
        }
        else {
            for (Booking history : userBookingList) {
            	if (history.getCustomer() == customer)
            		System.out.println(history);
            }
        }
    }
}