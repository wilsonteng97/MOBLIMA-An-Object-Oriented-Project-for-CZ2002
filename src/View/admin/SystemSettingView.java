package View.admin;

import View.View;

import static Presenter.AdminManager.*;
import static Presenter.Presenter.*;

import Model.Holiday;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SystemSettingView extends View{
	
	Scanner sc = new Scanner(System.in);
	private ArrayList<Holiday> holidayList;

	protected void starter()
	{
		displayMenu();
	}
	
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSystem Setting");
		System.out.println("(1) Configure Holidays\n"
							+ "(2) Configure Top 5 Ranking by Rating\n"
							+ "(3) Configure Top 5 Ranking by Sales\n"
							+ "(4) Return\n");
		System.out.println();
		System.out.println("Enter the number of your choice: ");

		int choice = sc.nextInt();
		while (verifyChoiceNumber(choice, 1, 4)) { 
			switch (choice) {
		        case 1:
		            configureHoliday();  
		            break;
		        case 2:
		        	getTop5RankingRating();
		        	break;
		        case 3:
		        	getTop5RankingSales();
		        	break;
				case 4:
					end();
		        	break;
			}
		}
	}

	public void configureHoliday() {
		displayHolidayList();
		System.out.print("(1) Add a holiday\n" + 
						 "(2) Remove a holiday\n" + 
						 "(3) Go back\n");
		System.out.println("Enter the number of your choice: ");
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
		holidayList = getHolidayList();
		if(holidayList.isEmpty())
		{
			System.out.println("There are no Holidays to display.");
        	return;
		}
		else 
		{
			System.out.print("Holiday list\n");
        	for (Holiday h: holidayList) {
			System.out.println(h.getDate() + h.getName() + h.getRate());
        }
		}  
		
        System.out.println();
	}

	private void addHolidaySequence() {
		String name;
		Date date;
		Double rate;
		
		displayHolidayList();
		name = passChoiceString("Input Holiday Name: ");
    	date = parseStringToDate_ddMMyyyy("Input Holiday Date (dd/mm/yyyy): ");
    	System.out.print("Input Holiday Rate (float): ");
    	rate = sc.nextDouble();
    	Holiday holiday = new Holiday(name, date, rate);
    	addHoliday(holiday);        
	}
	
	private void removeHolidaySequence() {
		String choice;
		int index = passChoiceInt("Input Holiday index You want to delete");    	
    	if (holidayList.get(index)==null) {
    		System.out.println("Holiday not found");
    		return;
		} 
		else 
		{
    		choice = passChoiceString("Are you sure you want to remove the Holiday: " + 
									  holidayList.get(index).getName() + " (Y or N)");
    	}
		
    	if (confirmChoice(choice)) {
    		try {
				removeHoliday(holidayList.get(index));
				configureHoliday();
			} catch (IOException e) {
				System.out.println("Fail to remove holiday");
				configureHoliday();
			}
    	}
    	else {
    		return;
    	}
    	
	}
}



