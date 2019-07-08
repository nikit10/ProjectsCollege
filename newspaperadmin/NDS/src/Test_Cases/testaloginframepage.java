/*package Test_Cases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import Validation.VerifyAgency;
import Validation.Verifyloginframe;

class testaloginframepage {
	@Test
	public void testVerifycontact() {
		assertEquals(true, Verifyloginframe.verifycustomer_id(1));
	}
	@Test
	public void testVerifycontact2() {
		assertEquals(false, Verifyloginframe.verifycustomer_id(-1));
	}
	@Test
	public void testVerifycontact3() {
		assertEquals(false, Verifyloginframe.verifycustomer_id(500000000));
	}

	@Test
	public void testVerifyPasswordFormat() {
		assertEquals(false, Verifyloginframe.verifyPasswordFormat("123456"));
	}
	@Test
	public void testVerifyPasswordFormat2() {
		assertEquals(true, Verifyloginframe.verifyPasswordFormat("abcd1234"));
	}
}
*/