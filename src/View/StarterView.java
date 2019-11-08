package View;

public class StarterView implements View{
	public StarterView() {
		System.out.println("============================\n"
				+ "|          MOBLIMA         |\n"
				+ "|   BY CZ2002 SS8 Group5   |\n"
				+ "============================");
	} 
	private void displayMenu() {
		System.out.println("Menu\n"
				+ "----\n"
				+ "(1) Staff\n"
				+ "(2) MovieGoer\n"
				+ "(3) Showtime\n"
				+ "(4) CinemaList\n"
				+ "Please enter choice");
	}
}
