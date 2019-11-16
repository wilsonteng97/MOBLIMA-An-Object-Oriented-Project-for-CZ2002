package View;

import java.util.Scanner;
import static Presenter.CinemaOperatorManager.*;

public class StarterView extends View
{
	public StarterView() {
	} 

	@Override
	public void starter()
	{
		System.out.println("============================\n"
				+ "|          MOBLIMA         |\n"
				+ "|   BY CZ2002 SS8 Group5   |\n"
				+ "============================");
		readTheData();
		displayMenu();

	}

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
