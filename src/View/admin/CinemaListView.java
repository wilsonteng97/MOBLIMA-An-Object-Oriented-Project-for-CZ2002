package View.admin;

import View.View;

import Presenter.Query;
import Presenter.AdminManager;

import static Presenter.Presenter.*;
import static Presenter.Query.*;
import static Presenter.CinemaOperatorManager.*;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Cinema;
import Model.CinemaOperator;
import Model.ShowTime;
import Model.Enums.CinemaClass;

public class CinemaListView extends View
{
	protected void starter()
	{
		displayMenu();
	}

	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Display Cinemas\n"
				+ "(2) Add Cinema\n"
				+ "(3) Remove Cinema\n"
				+ "(3) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		if (verifyChoiceNumber(choice, 1, 3)) { 
			switch (choice) {
		        case 1:
					displayCinemaOperator(); //[presenter: displayCinema()] actual method is getCinemaList instead of displayCinema, done by KJ
		            break;
		        case 2:
		        	newCinema(); 
		            break;
				case 3:
					int removecinema = passChoiceInt("Enter the index of the cinema You want to remove ");
		        	removeCinema(removecinema); 
		            break;
		        case 4:
		            break;
			}
		}
		else 
		{
			displayMenu();
		}
	}

	private void displayCinemaOperator()
	{
		ArrayList<CinemaOperator> cinemaOperatorList;
		cinemaOperatorList = getCinemaOperators();
		int numCinemaOperator = 0;
		for(CinemaOperator cinemaOperator: cinemaOperatorList)
		{
			System.out.println(numCinemaOperator + " " + cinemaOperator.getOperatorID() + cinemaOperator.getOperatorName());
			numCinemaOperator++;
		}

		int choice = passChoiceInt("Enter which cinema operator's cinema to view");
		displayCinemaList(cinemaOperatorList.get(choice));
	}

	private void displayCinemaList(CinemaOperator cinemaOperator)
	{
		ArrayList<Cinema> cinemaList = getCinemaList(cinemaOperator);
		int numCinema =0;
		for(Cinema cinema: cinemaList)
		{
			System.out.println(numCinema + " "+ cinema.getCinemaID() + cinema.getCinemaName());
		}
		displayMenu();
	}

	private void newCinema()
	{
		System.out.println("New Cinema");
		int choice = passChoiceInt("Choice a cinema operator to which add cinema");
		ArrayList<CinemaOperator> cinemaOperatorsList = getCinemaOperators();
		CinemaOperator cinemaOperator = cinemaOperatorsList.get(choice);

		String cinemaID = passChoiceString("Enter the cinemaID");
		String cinemaName = passChoiceString("Enter the cinema name");
		CinemaClass cinemaClass = null;
		while(cinemaClass == null)
		{
			String cinemaClassIn = passChoiceString("Enter cinema class from the following: \n"
			+ "NORMAL, PLATINUM");
			cinemaClass = passCinemaClass(cinemaClassIn);
		}
		Cinema cinema = new Cinema(cinemaID, cinemaName, cinemaClass, cinemaOperator);
		addCinema(cinema);

	}

	private void removeCinema()
	{
		System.out.println("Remove Cinema");
		int choiceOperator = passChoiceInt("Choice a cinema operator from which remove cinema");
		ArrayList<CinemaOperator> cinemaOperatorsList = getCinemaOperators();
		CinemaOperator cinemaOperator = cinemaOperatorsList.get(choiceOperator);
		displayCinemaList(cinemaOperator);
		ArrayList<Cinema> cinemaList = getCinemaList(cinemaOperator);
		int choiceCinema = passChoiceInt("Choice a cinema you want to remove");
		String choice = passChoiceString("Are You sure You want to remove cinema "+ cinemaList.get(choiceCinema).getCinemaName() + "Y/N");

		ShowTime showtime = new Showtime(3, cinema, movie, time);
		showtime.getCinema();

	}
}