package View.admin;

import View.View;

import Presenter.Query;
import Presenter.AdminManager;
import Model.Enums.*;
import static Presenter.Presenter.*;
import static Presenter.Query.*;
import static Presenter.AdminManager.*;
import static Presenter.CinemaOperatorManager.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Cinema;
import Model.CinemaOperator;
import static Model.Enums.CinemaClass.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CinemaListView shows the list of cinemas.
 */
public class CinemaListView extends View {
	
	/** The sc. */
	Scanner sc = new Scanner(System.in);

	/**
	 * Starter to display the menu.
	 */
	protected void starter() {
		displayMenu();
	}

	/**
	 * Display menu interface for the changing the list of cinemas.
	 */
	private void displayMenu() {
		System.out.println("Cinema Listing");
		System.out.println();
		System.out.println("(1) Display Cinemas\n" + "(2) Add Cinema\n" + "(3) Remove Cinema\n"
				+ "(4) Change Base Price of cinema\n" + "(5) Return\n");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt();
		if (verifyChoiceNumber(choice, 1, 5)) {
			switch (choice) {
			case 1:
				displayCinemaOperator();
				break;
			case 2:
				newCinema();
				break;
			case 3:
				deleteCinema();
				break;
			case 4:
				setMoviePrice();
				break;
		    case 5:
					end();
		     		break;
			}
		}
		else 
		{
			displayMenu();
		}
	}

	/**
	 * Sets the movie price.
	 */
	private void setMoviePrice() {
		Cinema cinema = getCinema();
		System.out.println("Enter Base Price to set for " + cinema.getCinemaName() + ": ");
		Double basePrice = sc.nextDouble();
		cinema.setBasePrice(basePrice);
		displayMenu();
	}

	/**
	 * Display cinema operators.
	 */
	protected void displayCinemaOperator()
	{
		ArrayList<CinemaOperator> cinemaOperatorList;
		cinemaOperatorList = getCinemaOperators();
		for(CinemaOperator cinemaOperator: cinemaOperatorList)
		{
			System.out.println(cinemaOperator.getOperatorID() + " " + cinemaOperator.getOperatorName());
		}

		int choice = passChoiceInt("Enter which cinema operator's cinema to view");
		displayCinemaList(cinemaOperatorList.get(choice));
	}

	/**
	 * Display cinema list based on the cinema operator.
	 *
	 * @param cinemaOperator the cinema operator
	 */
	protected void displayCinemaList(CinemaOperator cinemaOperator)
	{
		ArrayList<Cinema> cinemaList = getCinemaList(cinemaOperator);
		for(Cinema cinema: cinemaList)
		{
			System.out.println(cinema.getCinemaID() + " " + cinema.getCinemaName());
		}
		displayMenu();
	}

	/**
	 * New cinema.
	 */
	protected void newCinema()
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
			cinemaClass = getValueCinemaClass(cinemaClassIn);
		}
		
		Double basePrice = null;
		while(basePrice == null || basePrice<0)
		{
			System.out.println("Enter base price for a movie ticket in this Cinema");
			basePrice = sc.nextDouble();
		}
		Cinema cinema = new Cinema(cinemaID, cinemaName, cinemaClass, cinemaOperator, basePrice);
		try {
			addCinema(cinema);
		} catch (IOException e) {
			System.out.println("Fail to add the cinema");
		}
		displayMenu();
	}

	/**
	 * Delete cinema.
	 */
	private void deleteCinema()
	{
		System.out.println("Remove Cinema");
		ArrayList<CinemaOperator> cinemaOperatorList = getCinemaOperators();
		for(CinemaOperator cinemaOperator: cinemaOperatorList)
		{
			System.out.println(cinemaOperator.getOperatorID() + " " + cinemaOperator.getOperatorName());
		}
		int choiceOperator = passChoiceInt("Choice a cinema operator from which remove cinema");

		CinemaOperator cinemaOperator = cinemaOperatorList.get(choiceOperator);
		System.out.println(cinemaOperator.getOperatorName());
		
		ArrayList<Cinema> cinemaList = getCinemaList(cinemaOperator);
		for(Cinema cinema: cinemaList)
		{
			System.out.println(cinema.getCinemaID() + " " + cinema.getCinemaName());
		}

		int choiceCinema = passChoiceInt("Choice a cinema you want to remove");
		String choice = passChoiceString("Are You sure You want to remove cinema "+ cinemaList.get(choiceCinema).getCinemaName() + "Y/N");
		if(confirmChoice(choice))
		{
			try {
				removeCinema(cinemaList.get(choiceCinema));
			} catch (IOException e) {
				System.out.println("Fail to delete the cinema");
			}
			System.out.println("The cinema has been removed");
		}
		else 
		{
			System.out.println("Failed to remove listing");
		}
		displayMenu();
	}
	
	/**
	 * Gets the cinema.
	 *
	 * @return the cinema
	 */
	private Cinema getCinema() {
		ArrayList<CinemaOperator> cinemaOperatorList;
		cinemaOperatorList = getCinemaOperators();
		int numCinemaOperator = 0;
		for(CinemaOperator cinemaOperator: cinemaOperatorList)
		{
			System.out.println(numCinemaOperator + " " + cinemaOperator.getOperatorName());
			numCinemaOperator++;
		}

		int choice = passChoiceInt("Choose Cinema Operator: ");
		ArrayList<CinemaOperator> cinemaOperatorsList = getCinemaOperators();
		CinemaOperator cinemaOperator = cinemaOperatorsList.get(choice);
		
		ArrayList<Cinema> cinemaList = getCinemaList(cinemaOperator);
		int numCinema =0;
		for(Cinema cinema: cinemaList)
		{
			System.out.println(numCinema + " "+ cinema.getCinemaName());
			numCinema++;
		}

		choice = passChoiceInt("Choose Cinema: ");
		Cinema cinema = cinemaList.get(choice);
		
		return cinema;
	}
}