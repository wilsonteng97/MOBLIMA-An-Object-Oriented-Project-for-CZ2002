package View;

import java.util.Scanner;
import static Presenter.CinemaOperatorManager.*;

// TODO: Auto-generated Javadoc
/**
 * The Class StarterView is the first interface of the system.
 */
public class StarterView extends View
{
	
	/**
	 * Instantiates a new starter view.
	 */
	public StarterView() {
	} 

	/**
	 * Starter prints the first interface view.
	 */
	@Override
	public void starter()
	{
		readTheData();
		System.out.println("============================\n"
				+ "|          MOBLIMA         |\n"
				+ "|   BY CZ2002 SS8 Group5   |\n"
				+ "============================");
		displayMenu();

	}

	/**
	 * Display menu is at the first inerface, prompting the user to select staff or moviegoer.
	 * If it is a staff, it will lead to AdminView() and if it is moviegoer, MovieGoerView().
	 */
	private void displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Hello, Welcome to MOBLIMA!");
		System.out.println();
		System.out.println("Menu\n"
				+ "----\n"
				+ "(1) Staff\n"
				+ "(2) Movie Goer\n");
		System.out.println("Please enter your choice");
		int choice = sc.nextInt();
		switch (choice) 
		{
        case 1:
            intent(this, new AdminView());
            break;
        case 2:
            intent(this, new MovieGoerView());
            break;
		}
}
}
