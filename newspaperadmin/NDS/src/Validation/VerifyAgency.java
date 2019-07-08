/*package Validation;

public class VerifyAgency {


	public static boolean verifyName(String name) {
		String regex="[a-zA-Z]{3,15}";
		return name.matches(regex);
	}



	public static boolean verifyAddress(String address) {
		//letters, numbers and spaces 
		String regex="[0-9a-zA-Z\\s+]{10,50}";
		return address.matches(regex);
	}

	public static boolean verifycontact(String contact) {
		// 9 digits phone number
		String regex = "[0-9]{9}";
		return contact.matches(regex);
	}



	public static boolean verifyPasswordFormat(String password) {
		//It consists of Numbers and letters, and it should contain both Numbers and letters,
	    //and the length should be between 8-16 bits
		String regex="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		return password.matches(regex);
	}

}
*/