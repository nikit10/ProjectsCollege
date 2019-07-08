package Validation;

public class Verifyloginframe {
	
	public static boolean verifycustomer_id(String customer_id) {
	//	int i=Integer.parseInt(customer_id);
		String regex="[a-z]{3,16}$";
		return customer_id.matches(regex);
	}
	public static boolean verifyPasswordFormat(String password) {
		String regex="[0-9a-zA-Z]{6,18}";
		return password.matches(regex);
	}
}
