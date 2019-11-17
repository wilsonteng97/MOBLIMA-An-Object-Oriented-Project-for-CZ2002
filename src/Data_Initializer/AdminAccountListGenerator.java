package Data_Initializer;

import Model.Admin;
import java.io.IOException;
import java.util.ArrayList;
import static Presenter.CinemaOperatorManager.*;
import Presenter.DataManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminAccountListGenerator implements dummy records of admin accounts to the system.
 */
public class AdminAccountListGenerator extends DataManager {
	
	/**
	 * Admin accounts to be generated. The object is created based on the attributes in the constructor.
	 * These accounts will be used for logging into the system.
	 * Accounts details are saved into the txt file.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
