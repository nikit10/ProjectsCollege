package Validation;

public class VerifyRegister_login {
	public static boolean verifycustomer_id(int customer_id) {
		if (customer_id >= 0 && customer_id <= 500000000) {
			return true;
		}
		return false;
	}
	public static boolean verifyPasswordFormat(String password) {
		//It consists of Numbers and letters, and it should contain both Numbers and letters,
		//and the length should be between 8-16 bits
		String regex="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		return password.matches(regex);
	}
	public static boolean verifyRenterPasswordFormat(String password) {
		//It consists of Numbers and letters, and it should contain both Numbers and letters,
		//and the length should be between 8-16 bits
		String regex="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		return password.matches(regex);
	}
}
