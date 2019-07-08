package Test_Cases;

import static org.junit.Assert.*;

import org.junit.Test;

import Validation.VerifyRegister_login;
import Validation.Verifyloginframe;

public class testRegister_Login {
	@Test
	public void testVerifycontact() {
		assertEquals(true, VerifyRegister_login.verifycustomer_id(1));
	}
	@Test
	public void testVerifycontact2() {
		assertEquals(false, VerifyRegister_login.verifycustomer_id(-1));
	}
	@Test
	public void testVerifycontact3() {
		assertEquals(false, VerifyRegister_login.verifycustomer_id(500000000));
	}

	@Test
	public void testVerifyPasswordFormat() {
		assertEquals(false, VerifyRegister_login.verifyPasswordFormat("654321"));
	}
	@Test
	public void testVerifyPasswordFormat2() {
		assertEquals(true, VerifyRegister_login.verifyPasswordFormat("abcd1234"));
	}
	@Test
	public void verifyRenterPasswordFormat() {
		assertEquals(false, VerifyRegister_login.verifyRenterPasswordFormat("123456"));
	}
	@Test
	public void verifyRenterPasswordFormat2() {
		assertEquals(true, VerifyRegister_login.verifyRenterPasswordFormat("abcd1234"));
	}
}
