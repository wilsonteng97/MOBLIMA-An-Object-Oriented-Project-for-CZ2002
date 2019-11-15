package Presenter;

import Model.Customer;
import Model.Booking;
import java.io.FileInputStream;
import java.io.FileWriter;

public class BookingManager {
    // private final static String userBookingListFile = "datafiles/userBookingFile.txt";
    // private static ArrayList<Admin> userBookingList;

    public BookingManager(){
        
    }

    public static void addBooking(Booking new_booking){
        // userBookingList.add(new_booking);
        // updateBookingListing();
    }

    public void removeBooking(){
        // userBookingList.remove(movie);
        // updateBookingListing();
    }

    public void updateBookingListing(){
        // writeDataFile(userBookingListFile, userBookingList);
    }

    public static void getBookingHistory(String customerName){
    	//Customer customer = passStringCustomer(customerName);
    	// for (String booking : userBookingList){
        //     if (booking == customer){
        //         System.out.println(booking);
        //     }
        // }
    	
    	/*
    	 ArrayList<BookingHistory> bookingHistory = getBookingHistory();

        if (bookingHistory == null || bookingHistory.isEmpty()) {
            readString("No history to show.",
                    "Press ENTER to go back.", "");
        }
        else {
            for (BookingHistory record : bookingHistory) {
                System.out.println(record);
            }
        }
    	 */
    }
}