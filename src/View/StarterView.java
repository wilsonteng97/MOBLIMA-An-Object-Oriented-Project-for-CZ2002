package View;

public class StarterView implements View{
	public StarterView() {
		System.out.println("Welcome!");
	} 
	private void displayMenu() {
		System.out.println("(1) Staff\n"
				+ "(2) MovieGoer\n"
				+ "(3) Showtime\n"
				+ "(4) CinemaList");
	}
}
