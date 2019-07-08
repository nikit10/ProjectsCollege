package Validation;

public class verifyAddDeliveryArea {
	public static boolean DeliveryAreaNo(int AddDeliveryArea) {
		// more than 1 number
		if (AddDeliveryArea >= 0 && AddDeliveryArea <= 20) {
			return true;
		}
		return false;
	}

	public static boolean AreaName(String AreaName) {
		//letters, numbers and spaces 
		String regex="[0-9a-zA-Z\\s+]{2,50}";
		return AreaName.matches(regex);
	}
}
