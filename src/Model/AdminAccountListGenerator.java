package Model;

import Model.Admin;
import java.io.IOException;
import java.util.ArrayList;
import static Presenter.CinemaOperatorManager.*;
import Presenter.DataManager;


public class AdminAccountListGenerator extends DataManager {
	public static void AdminAccounts() throws IOException {
		ArrayList<Admin> admin_list = new ArrayList<Admin>();
		
//		Admin(String username, String password)
		Admin a1 = new Admin("teoKJ", "Password123");
		admin_list.add(a1);
		
		Admin a2 = new Admin("wilsonteng97", "GrandpaTeng");
		admin_list.add(a2);
		
		Admin a3 = new Admin("boon", "Password-Boon");
		admin_list.add(a3);
		
		Admin a4 = new Admin("taoyuanyuan", "Password-TY");
		admin_list.add(a4);
		
		Admin a5 = new Admin("piotr", "Password-Piotr");
		admin_list.add(a5);
		
		Admin a6 = new Admin("yiming", "Password-Yiming");
		admin_list.add(a6);
		
		String fileName = "datafiles\\adminAccountListFile.txt";
		writeDataFile(admin_list, fileName);
	}
}
