package View.admin;

import View.View;

import static Presenter.AdminManager.*;
import static Presenter.Presenter.*;

import Model.Holiday;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SystemSettingView extends View{
	
	Scanner sc = new Scanner(System.in);

	protected void starter()
	{
		displayMenu();
	}
	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSystem Setting");
		System.out.println("(1) Configure Holidays\n"
							+ "(2) Update Admin Account\n"
							+ "(3) Configure Top 5 Ranking by Rating\n"
							+ "(4) Configure Top 5 Ranking by Sales\n"
							+ "(5) Return\n");
		System.out.println();
		System.out.println("Enter the number of your choice: ");

		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 5)) { 
			switch (choice) {
		        case 1:
		            configureHoliday();  
		            break;
		        case 2:
		        	updateAdminAccount();
		        	break;
		        case 3:
		        	getTop5RankingRating();
		        	break;
		        case 4:
		        	getTop5RankingSales();
		        	break;
				case 5:				
		        	break;
			}
		}
	}

	public void configureHoliday() {
		System.out.print("(1) Add a holiday" + 
						 "(2) Remove a holiday" + 
						 "(3) Go back");
		System.out.println();
		System.out.println("Enter the number of your choice: ");
		displayHolidayList();
		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 3)) { 
			switch (choice) {
		        case 1:
		        	addHolidaySequence();
		            break;
		        case 2:
		        	displayHolidayList();
		        	removeHolidaySequence();
		            break;
		        case 3:
		        	end();
		            break;
			}
			displayMenu();
		}
	}

	private void displayHolidayList() {
        Map<String, Holiday> map = getHolidayList();
        int count = 0;
        String nameOfHoliday;
        
        if (map.size() == 0) {
        	System.out.println("There are no Holidays to display.");
        	return;
        }
        
		System.out.print("Holiday list");
        for (Map.Entry<String, Holiday> entry : map.entrySet()) {
            String key = entry.getKey();
            Holiday value = entry.getValue();
            nameOfHoliday = value.getName();
            System.out.print("(" + count + ")");
            System.out.println(nameOfHoliday + "\t" + key);
        }
        System.out.println();
	}

	private void addHolidaySequence() {
		String name, dateString;
		Date date;
		Double rate;
		
		displayHolidayList();
    	System.out.print("Input Holiday Name: ");
    	name = sc.nextLine();
    	System.out.print("Input Holiday Date (dd/mm/yyyy): ");
    	dateString = sc.nextLine();
    	date = parseStringToDate_ddMMyyyy(dateString);
    	System.out.print("Input Holiday Rate (float): ");
    	rate = sc.nextDouble();
    	Holiday holiday = new Holiday(name, date, rate);
    	addHoliday(holiday);        
	}
	
	private void removeHolidaySequence() {
		String name, dateString, choice;
		Date date;
		
		System.out.print("Input Holiday Date (dd/mm/yyyy): ");
    	dateString = sc.nextLine();
    	date = parseStringToDate_ddMMyyyy(dateString);
    	
    	HashMap<String, Holiday> holidayList = getHolidayList();
    	if (holidayList.get(date)==null) {
    		System.out.println("Holiday not found");
    		return;
    	} else {
    		name  =holidayList.get(date).getName();
    		choice = passChoiceString("Are you sure you want to remove the Holiday: " + 
									  name + " (Y or N)");
    	}
    	
    	if (confirmChoice(choice)) {
    		try {
				removeHoliday(date);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	else {
    		return;
    	}
    	
	}
}



