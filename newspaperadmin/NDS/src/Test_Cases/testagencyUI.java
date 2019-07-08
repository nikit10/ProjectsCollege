/*package Test_Cases;
import static org.junit.Assert.*;

import org.junit.Test;

import Validation.VerifyAgency;
import Validation.VerifyRegister_login;

import static org.junit.Assert.*;


class testagencyUI {

	@Test
	public void testVerifyName1() {
		assertEquals(true, VerifyAgency.verifyName("adxcdfcglsdksls"));
	}
	@Test
	public void testVerifyName2() {
		assertEquals(false, VerifyAgency.verifyName("132"));
	}
	@Test
	public void testVerifyName3() {
		assertEquals(false, VerifyAgency.verifyName("asljd-_adasffj"));
	}
	@Test
	public void testVerifyName4() {
		assertEquals(false, VerifyAgency.verifyName("fasfsdafasdasdfweqtreyerfwef"));
	}

	
	@Test
	public void testVerifyAddress1() {
		assertEquals(true, VerifyAgency.verifyAddress("Wellmount student village"));
	}
	@Test
	public void testVerifyAddress2() {
		assertEquals(false, VerifyAgency.verifyAddress("132"));
	}

	@Test
	public void testVerifycontact1() {
		assertEquals(true, VerifyAgency.verifycontact("123456789"));
	}
	@Test
	public void testVerifycontact2() {
		assertEquals(false, VerifyAgency.verifycontact("123"));
	}
	@Test
	public void testVerifycontact3() {
		assertEquals(false, VerifyAgency.verifycontact("gsgsfg"));
	}
	@Test
	public void testVerifycontact4() {
		assertEquals(false, VerifyAgency.verifycontact("1324564798798"));
	}

	@Test
	public void testVerifyPasswordFormat1() {
		assertEquals(false, VerifyAgency.verifyPasswordFormat("123456"));
	}
	@Test
	public void testVerifyPasswordFormat2() {
		assertEquals(true, VerifyAgency.verifyPasswordFormat("abcd1234"));
	}
	

}
*/