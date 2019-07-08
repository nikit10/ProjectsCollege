package Validation;

public class VerifyAdd_DeliveryAgent {
	public static boolean verifyName(String name) {
		String regex="[a-zA-Z]{3,15}";
		return name.matches(regex);
	}



	public static boolean verifyAddress(String address) {
		//letters, numbers and spaces 
		String regex="[0-9a-zA-Z\\s+]{5,50}";
		return address.matches(regex);
	}

	public static boolean verifycontact(String contact) {
		// 9 digits phone number
		String regex = "[0-9]{9}";
		return contact.matches(regex);
	}


}
