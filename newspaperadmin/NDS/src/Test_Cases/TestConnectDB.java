package Test_Cases;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import Database_Classes.ConnectDB;

public class TestConnectDB {

	
	/***
	 * Test No.1
	 * Objective: To test the insert customer method
	 * Inputs: Insert Valid Details in Customer
	 * Expected Output: The function should return 1 if it run successfully.
	 
	 ***/
	/*@Test
	public void testInsert_customer() {
		String a = "Ed";
		String b = "958746";
		String c = "Dublin";
		int d = 3;
		int e = 4;
		String f = "Irish Times";
		int num = ConnectDB.Insert_customer(a, b, c, d,e,f);
		assertEquals(num,1);
		
	}*/
	
	
	/***
	 * Test No.2
	 * Objective: To test the login method
	 * Inputs: set correct username and set password
	 * Expected Output: The function should return 0 if it run successfully.
	 
	 ***/
	@Test
	public void testLogin() throws NoSuchAlgorithmException, SQLException {
		String a = "admin";
		String b = "abcd1234";
		assertEquals(ConnectDB.Login(a, b),0);
	}
	
	
	/***
	 * Test No.3
	 * Objective: To test the generateDocket() Method
	 * Inputs: Generate Dockets runs Select Query
	 * Expected Output: The function should return column count 7 as there are 7 columns in the table
	 
	 ***/
	@Test
	public void testgenerateDocket() throws SQLException {
		DefaultTableModel model = ConnectDB.generateDocket(1);
		int num = model.getColumnCount();
	
		 assertEquals(7,num);
		 
	}


	/***
	 * Test No.4
	 * Objective: To test the registerUser() Method
	 * Inputs: Enter correct details
	 * Expected Output: The function should return 1 if successful
	/*
	 */
/*	public void testRegister_user() {
	
		int num = 0;
		String a = "abcd";
			String b = "aslhnd";
		int c = ConnectDB.Register_user(a, b);
		assertEquals(c,1);
	}*/


	
	/***
	 * Test No.5
	 * Objective: To test the getStockInfo() Method
	 * Inputs: Get Stock runs Select Query
	 * Expected Output: The function should return column count 4 as there are 4 columns in the table
	 
	 ***/
	@Test
	public void testGetStockInfo() throws SQLException {
		
		DefaultTableModel model = ConnectDB.getLowStockInfo();
		int num = model.getColumnCount();
		 assertEquals(4,num);
		}

	
	/***
	 * Test No.6
	 * Objective: To test the LowStockInfo() Method
	 * Inputs: LOw STOCK Info runs Select Query
	 * Expected Output: The function should return column count 4 as there are 4 columns in the table
	 
	 ***/
	@Test
	public void testGetLowStockInfo() throws SQLException {
		DefaultTableModel model = ConnectDB.getLowStockInfo();
		int num = model.getColumnCount();
	
		 assertEquals(4,num);
		}


	/***
	 * Test No.7
	 * Objective: To test the getDeliveryAgentInfo() Method
	 * Inputs: DeliveryAgent Info runs Select Query
	 * Expected Output: The function should return column count 5 as there are 5 columns in the table
	 
	 ***/
	@Test
	public void testGetDeliveryAgentInfo() throws SQLException {
	
		DefaultTableModel model = ConnectDB.getDeliveryAgentInfo();
		int num = model.getColumnCount();
		 assertEquals(5,num);
		}
	
	
	
	/***
	 * Test No.8
	 * Objective: To test the getCustomerInfor Method
	 * Inputs: Customer Info Info runs Select Query
	 * Expected Output: The function should return column count 6 as there are 6 columns in the table
	 
	 ***/
	@Test
	public void testGetCustomerInfo() throws SQLException {
		DefaultTableModel model = ConnectDB.getCustomerInfor();
		int num = model.getColumnCount();
		 assertEquals(6,num);
	}
	
	
	/***
	 * Test No.9
	 * Objective: To test the setDeliveryStatus() Method
	 * Inputs: Set customer ID and delivery status
	 * Expected Output: The function should return 1 if successful
	 
	 ***/
	@Test
	public void testSetDeliveryStatus() throws SQLException {
		int a = 1;
		int b = 1;
		assertEquals(ConnectDB.setDeliveryStatus(a, b),1);
	}
	
	
	
	/***
	 * Test No.10
	 * Objective: To test the getDeliveryArea() Method
	 * Inputs: getDeliveryArea Info runs Select Query
	 * Expected Output: The function should return column count 5 as there are 5 columns in the table
	 
	 ***/
	@Test
	public void testgetDeliveryArea() throws SQLException {
	
		String[] data = ConnectDB.getDeliveryAreas();
		int num = data.length;
		 assertEquals(5,num);
	}
	
	
	
	/***
	 * Test No.11
	 * Objective: To test the getStockValues() Method
	 * Inputs: getStock runs Select Query
	 * Expected Output: The function should return column count 6 as there are 6 columns in the table
	 
	 ***/
	@Test
	public void testgetStockValues() throws SQLException {
	
		String[] data = ConnectDB.getStocksValues();
		int num = data.length;
		 assertEquals(6,num);
	}
	
	/***
	 * Test No.12
	 * Objective: To test the getStockHeading() Method
	 * Inputs: StockHeading Info runs Select Query
	 * Expected Output: The function should return 4 as there are 4 columns in the table
	 
	 ***/
	@Test
	public void testgetStockHeading() throws SQLException {
	
		String[] data = ConnectDB.getStocksHeading();
		int num = data.length;
		 assertEquals(4,num);
	}
	
	
	/***
	 * Test No.13
	 * Objective: To test the getCustomerUpdateInfo() Method
	 * Inputs: Set Customer ID
	 * Expected Output: The function should return ArrayList whose 1st element is Matthew
	 
	 ***/
	@Test
	public void testgetCustomerUpdateInfo() throws SQLException, NoSuchAlgorithmException {
	
		int id = 1;
		ArrayList<String> data = ConnectDB.getCustomerUpdateInfo(id);
		String name = data.get(0).toString();
		 assertEquals("Matthew",name);
	}
	
	
	/***
	 * Test No.14
	 * Objective: To test the UpdateCustomer() Method
	 * Inputs: set ID and all customer details to update
	 * Expected Output: The function should return 1 if successful
	 
	 ***/
	@Test
	public void testUpdateInfo() throws SQLException, NoSuchAlgorithmException {
	
		int id = 2;
		int data = ConnectDB.UpdateCustomer(id, "Felix", "0789546321", "Well Mount", 0);
		 assertEquals(1,data);
	}
	
	
	/***
	 * Test No.15
	 * Objective: To test the getDeliveryAgentHeading() Method
	 * Inputs: getDeliveryAgentHeading Info runs Select Query
	 * Expected Output: The function should return column count 5 as there are 5 columns in the table
	 
	 ***/
	@Test
	public void testgetDeliveryAgentHeading() throws SQLException {
	
		String[] data = ConnectDB.getDeliveryAgentHeading();
		int num = data.length;
		 assertEquals(5,num);
	}
	
	
	/***
	 * Test No.16
	 * Objective: To test the getCustomerHeading() Method
	 * Inputs: getCustomerHEading Info runs Select Query
	 * Expected Output: The function should return column count 6 as there are 6 columns in the table
	 
	 ***/
	@Test
	public void testgetCustomerHeading() throws SQLException {
	
		
		String[] data = ConnectDB.getCustomerHeading();
		int num = data.length;
		 assertEquals(6,num);
	}
	
	
	
	/***
	 * Test No.17
	 * Objective: To test the generateItemsInfo() Method
	 * Inputs: generateItems Info runs Select Query enter delivery area
	 * Expected Output: The function should return column count 2 as there are 2 columns that are called
	 
	 ***/
	@Test
	public void testgenerateItemsInfo() throws SQLException, NoSuchAlgorithmException {
	
		DefaultTableModel model = ConnectDB.generateItemsInfo(2);
		int num = model.getColumnCount();
		 assertEquals(2,num);	}
	
	
	
	/***
	 * Test No.18
	 * Objective: To test the checkUserID() Method
	 * Inputs: you need to give a valid user id present in the table login
	 * Expected Output: The function should return 1 if successful
	 
	 ***/
	@Test
	public void testcheckUserId() throws SQLException, NoSuchAlgorithmException {
	
		int model = ConnectDB.checkUserID("admin");
		 assertEquals(1,model);	}
	
	
	
	/***
	 * Test No.19
	 * Objective: To test the getCustomerID() Method
	 * Inputs: getCustomerID Info runs Select Query
	 * Expected Output: The function should return 1 as the first customer id would always be 1
	 
	 ***/
	@Test
	public void testgetCustomerID() throws SQLException
	{
		String[] type = ConnectDB.getCustomerID();
		assertEquals("1",type[0]);
	}
	
	
	/***
	 * Test No.20
	 * Objective: To test the generateBills() Method
	 * Inputs: generateBills runs Select Query
	 * Expected Output: The function should return column count 9 as there are 9 columns in the table
	 * @throws SQLException 
	 
	 ***/
	@Test
	public void testgenerateBills() throws SQLException
	{
		DefaultTableModel model = ConnectDB.generateBill(2);
		int num = model.getColumnCount();
		assertEquals(9,num);
	}
	
	
	/***
	 * Test No.21
	 * Objective: To test the OrdersInfo() Method
	 * Inputs: Orders STOCK Info runs Select Query
	 * Expected Output: The function should return column count 7 as there are 7 columns in the table
	 
	 ***/
	@Test
	public void testOrdersInfo() throws SQLException
	{
		DefaultTableModel model = ConnectDB.getOrdersInfo();
		int num = model.getColumnCount();
		assertEquals(7, num);
	}
	
	
	/***
	 * Test No.22
	 * Objective: To test the generateOldBills() Method
	 * Inputs: generateOldBills runs Select Query
	 * Expected Output: The function should return column count 7 as there are 7 columns in the table
	 
	 ***/
	@Test
	public void testgenerateOldBills() throws SQLException
	{
		DefaultTableModel model = ConnectDB.generateOldsBill();
		int num = model.getColumnCount();
		assertEquals(9, num);
	}
	
	
	/***
	 * Test No.23
	 * Objective: To test the generateDefaulter() Method
	 * Inputs: generateDefaulter runs Select Query
	 * Expected Output: The function should return column count 7 as there are 7 columns in the table
	 
	 ***/
	@Test
	public void testgenerateDefaulter() throws SQLException
	{
		DefaultTableModel model = ConnectDB.generateDefaulterList();
		int num = model.getColumnCount();
		assertEquals(6, num);
	}
	
	/***
	 * Test No.24
	 * Objective: To test the updatePayment Method
	 * Inputs: UpdatePayment enter payment status and cust id
	 * Expected Output: The function should return 1 if successful
	 
	 ***/
	@Test
	public void testUpdatePayment() throws SQLException
	{
		int num = ConnectDB.updatePaymentStatus(1, 3);
		assertEquals(1, num);
	}
	
	
	
	/***
	 * Test No.25
	 * Objective: To test the getStockInfo() Method
	 * Inputs: getStockInfo runs Select Query
	 * Expected Output: The function should return column count 4 as there are 4 columns in the table
	 
	 ***/
	@Test
	public void testgetStockInfo() throws SQLException
	{
		DefaultTableModel model = ConnectDB.getStockInfo();
		int num = model.getColumnCount();
		assertEquals(4, num);
	}
	
	
	
	
	/***
	 * Test No.26
	 * Objective: To test the getOrderIds() Method
	 * Inputs: getOrderIds runs Select Query
	 * Expected Output: The function should return 1 if successful
	 
	 ***/
	@Test
	public void testgetOrderIds() throws SQLException
	{
		String[] model = ConnectDB.getOrderIds();
		String num = model[0];
		assertEquals("1", num);
	}
	
	
	
	/***
	 * Test No.27
	 * Objective: To test the getOrderIds() Method
	 * Inputs: getOrderIds runs Select Query
	 * Expected Output: The function should return 1 if successful
	 
	 ***/
	@Test
	public void testgetDeliveryAgentsId() throws SQLException
	{
		ResultSet model = ConnectDB.getDeliveryAgentID();
		int num = model.getFetchSize();
		assertEquals(0, num);
	}
	
	
	
	
}
