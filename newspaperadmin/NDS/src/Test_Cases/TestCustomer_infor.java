package Test_Cases;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import Database_Classes.ConnectDB;
import junit.framework.TestCase;

public class TestCustomer_infor extends TestCase {


	@Test
	public void TestCustomer_info() throws SQLException {
		/*String a = "Ed";
		String b = "958746";
		String c = "Dublin";
		int d = 3;
		int e = 4;
		String f = "Irish Times";*/
		DefaultTableModel model = new DefaultTableModel();
		model=ConnectDB.getCustomerInfor();
		
		int num = model.getRowCount();
		if(num == 0)
		{
			System.out.println("Failed");
		}
		else
		{
			System.out.println("Success");
		}
		
		
		
	}
	
}
