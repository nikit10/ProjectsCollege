package Validation;

public class VeriftRegister_Login {
	public static boolean verifyuserid(String userid) {
		//int i=Integer.parseInt(userid);
		String regex="[a-z]{3,16}$";
		return userid.matches(regex);
		
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
