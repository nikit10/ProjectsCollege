import Database_Classes.MySQLAccess;
import LoginPackage.LoginFrame;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginFrame l = new LoginFrame();
		l.setVisible(true);
		MySQLAccess.getConnection();
	}

}
