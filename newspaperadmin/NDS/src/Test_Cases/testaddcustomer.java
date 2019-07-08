package Test_Cases;

import static org.junit.Assert.*;

import org.junit.Test;

import Validation.Verifycustomer;

public class testaddcustomer {
	@Test
	public void testVerifyPaymentdue1() {
		assertEquals(true, Verifycustomer.verifyPaymentdue(18));
	}
	@Test
	public void testVerifyPaymentdue2() {
		assertEquals(false, Verifycustomer.verifyPaymentdue(-1));
	}
	@Test
	public void testVerifyPaymentdue3() {
		assertEquals(false, Verifycustomer.verifyPaymentdue(500000000));
	}
	
	@Test
	public void testVerifyName1() {
		assertEquals(true, Verifycustomer.verifyName("adxcdfcglsdksls"));
	}	@Test
	public void testVerifyName2() {
		assertEquals(false, Verifycustomer.verifyName("ac"));
	}	@Test
	public void testVerifyName3() {
		assertEquals(false, Verifycustomer.verifyName("adxcasadadsadfcglsdksls"));
	}

	
	@Test
	public void testVerifyAddress1() {
		assertEquals(true, Verifycustomer.verifyAddress("Wellmount student village"));
	}
	@Test
	public void testVerifyAddress2() {
		assertEquals(false, Verifycustomer.verifyAddress("123"));
	}

	@Test
	public void testVerifycontact1() {
		assertEquals(true, Verifycustomer.verifycontact("123456789"));
	}
	@Test
	public void testVerifycontact2() {
		assertEquals(false, Verifycustomer.verifycontact("123asdasdaf"));
	}
	@Test
	public void testVerifycontact3() {
		assertEquals(false, Verifycustomer.verifycontact("132"));
	}	
	@Test
	public void testVerifycontact4() {
		assertEquals(false, Verifycustomer.verifycontact("1234564987978"));
	}
/*
	@Test
	public void testVerifyPasswordFormat() {
		assertEquals(true, Verifycustomer.verifyPasswordFormat("123456"));
	}*/

}
