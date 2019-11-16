package Presenter;

import java.io.IOException;
import java.util.ArrayList;

import static Presenter.DataManager.*;
import static Presenter.Query.*;
import Model.Booking;
import Model.Customer;

public class BookingManager {
    private final static String userBookingListFile = "datafiles/userBookingFile.txt";
    private static ArrayList<Booking> userBookingList;

    public BookingManager(){
        
    }

    private static void readBookingListing() throws IOException, ClassNotFoundException {
        if (readDataFile_List(userBookingListFile) == null) 
        	userBookingList = new ArrayList<>();
        else userBookingList = (ArrayList<Booking>) readDataFile_List(userBookingListFile);
    }

    
    public static void saveBooking(Booking history) throws IOException {
    	userBookingList.add(history);
        updateBookingListing();
    }

    public static void updateBookingListing() throws IOException{
        writeDataFile(userBookingList, userBookingListFile);
    }

    
    public static void getBookingHistory(String customerName){
    	
    	Customer customer = passStringCustomer(customerName);
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