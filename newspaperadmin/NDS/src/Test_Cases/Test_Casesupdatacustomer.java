package Test_Cases;

import static org.junit.Assert.*;

import org.junit.Test;

import Validation.Verifycustomer;
import Validation.VerifyupdateCustomer;

public class Test_Casesupdatacustomer {
	@Test
	public void testVerifyPaymentdue1() {
		assertEquals(true, VerifyupdateCustomer.verifyPaymentdue(18));
	}
	@Test
	public void testVerifyPaymentdue2() {
		assertEquals(false, VerifyupdateCustomer.verifyPaymentdue(-1));
	}
	@Test
	public void testVerifyPaymentdue3() {
		assertEquals(false, VerifyupdateCustomer.verifyPaymentdue(500000000));
	}
	
	@Test
	public void testVerifyName1() {
		assertEquals(true, VerifyupdateCustomer.verifyName("adxcdfcglsdksls"));
	}	@Test
	public void testVerifyName2() {
		assertEquals(false, VerifyupdateCustomer.verifyName("ac"));
	}	@Test
	public void testVerifyName3() {
		assertEquals(false, VerifyupdateCustomer.verifyName("adxcasadadsadfcglsdksls"));
	}

	
	@Test
	public void testVerifyAddress1() {
		assertEquals(true, VerifyupdateCustomer.verifyAddress("Wellmount student village"));
	}
	@Test
	public void testVerifyAddress2() {
		assertEquals(false, VerifyupdateCustomer.verifyAddress("123"));
	}

	@Test
	public void testVerifycontact1() {
		assertEquals(true, VerifyupdateCustomer.verifycontact("0123456789"));
	}
	@Test
	public void testVerifycontact2() {
		assertEquals(false, VerifyupdateCustomer.verifycontact("123asdasdaf"));
	}
	@Test
	public void testVerifycontact3() {
		assertEquals(false, VerifyupdateCustomer.verifycontact("132"));
	}	
	@Test
	public void testVerifycontact4() {
		assertEquals(false, VerifyupdateCustomer.verifycontact("1234564987978"));
	}

}
