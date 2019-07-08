package Database_Classes;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Misc.DialogMessage;

public class ConnectDB {

	static Connection conn = MySQLAccess.getConnection();
	static PreparedStatement st = null;
	static ResultSet rs = null;
	
	
	public static  String[] getDeliveryAreas() throws SQLException {
		
		
		   String sql = "SELECT DISTINCT(Delivery_Area_id) from delivery_area";
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		
		//STEP 5: Extract data from result set
		ArrayList<String> types = new ArrayList<String>();

		while (rs.next()) { 
		    String a = rs.getString(1);
		    types.add(a);
		}

		// finally turn the array lists into arrays - if really needed
		String[] type = new String[types.size()];
		return type = types.toArray(type); 
		}
	
	
	public static  String[] getCustomerID() throws SQLException {
		
		
		   String sql = "SELECT DISTINCT(Customer_id) from customer";
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		
		//STEP 5: Extract data from result set
		ArrayList<String> types = new ArrayList<String>();

		while (rs.next()) { 
		    String a = rs.getString(1);
		    types.add(a);
		}

		// finally turn the array lists into arrays - if really needed
		String[] type = new String[types.size()];
		return type = types.toArray(type); 
		}
	
	public static  String[] getStocksValues() throws SQLException {
		
		
	   String sql = "SELECT DISTINCT(Item_Name) from stocks";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	//STEP 5: Extract data from result set
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    String a = rs.getString(1);
	    types.add(a);
	}

	// finally turn the array lists into arrays - if really needed
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}
	

	
	
	public static int Register_user(String a,String b)
	{
	
	int num = 0;
	int c = 1;
	try
	{
		String sql = "insert into login_table(login_id,password,login_type) values(?,?,?)";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setInt(3,c);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
		System.out.println("DONE");
	}
	catch(Exception e)
	{
		//e.printStackTrace();
	}
	
	return num;
	}
	
	public static int Login(String a,String b) throws SQLException, NoSuchAlgorithmException
	{
		
	
		   String sql = "SELECT login_id,password,login_type FROM login_table";
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		     
		int num = 1;
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		          String id  = rs.getString("login_id");
		         String pwd = rs.getString("password");
		        String pwds = decodePwd(pwd);
		          int type = rs.getInt("login_type");
		          
		          if(a.equals(id)&&b.equals(pwds))
		          {
		        	  if(type==0)
		        	  {
		        	num = 0;  
		          }
		        	  else if(type==1)
		        	  {
		        		  num=2;
		        	  }
		          }
		
		      }
			return num;
		}
	
	private static String decodePwd(String value) throws NoSuchAlgorithmException {
		byte[] decodedBytes = Base64.getDecoder().decode(value);
		String decodedString = new String(decodedBytes);
		return decodedString;
	
	}

	public static DefaultTableModel getStockInfo() throws SQLException {
		// TODO Auto-generated method stub
		

	/*String sql = "insert into agent(name,contact,address) values('Saksham','77','Apt no. 15')";*/

	   String sql = "SELECT Item_ID,Item_Name,Quantity,Price FROM stocks";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getStocksHeading());
	//STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	          int id  = rs.getInt("Item_ID");
	         String name = rs.getString("Item_Name");
	         int quantity = rs.getInt("Quantity");
	         int price = rs.getInt("Price");
	         
	         model.addRow(new Object[]{id,name,quantity,price});
	      }
		return model;
	      
	}
	
	public static String[] getStocksHeading() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		   String sql = "SHOW COLUMNS FROM newsagency.stocks";
		   
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			ArrayList<String> types = new ArrayList<String>();

			while (rs.next()) { 
			    types.add(rs.getString(1));
			}
			
			String[] type = new String[types.size()];
			return type = types.toArray(type); 
			}

	public static ArrayList<String> getCustomerUpdateInfo(int id) throws SQLException, NoSuchAlgorithmException
	{
		
			
	

		   String sql = "SELECT Name,Contact_No,Address,Payment_due FROM customer where customer_id = ?";
		st = conn.prepareStatement(sql);
		st.setInt(1, id);
		rs = st.executeQuery();
		     
		int num = 1;
		 ArrayList<String> alist=new ArrayList<String>();  
	     
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		          String name = rs.getString("Name");
		         String addr = rs.getString("Address");
		        String contact = rs.getString("contact_no");
		        int payment = rs.getInt("Payment_due");
		        alist.add(name);
		        alist.add(contact);
		        alist.add(addr);
		        alist.add(String.valueOf(payment));
		      }
		     
			return alist;
		}
	
	
	public static int UpdateCustomer(int id, String name, String contact, String addr, int payment)
	{
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		int num = 0;
		try
		{
			String sql = "UPDATE customer SET Name = ?,Contact_no = ?,Address = ?,Payment_Due = ? WHERE Customer_id = ? ";
			st = conn.prepareStatement(sql);
			// index starts from 1
			st.setString(1, name);
			st.setString(2, contact);
			st.setString(3, addr);
			st.setInt(4, payment);
			st.setInt(5, id);
			// execute and return number of rows that take effect
			num = st.executeUpdate();
		}
		catch(Exception e1)
		{
		//	e1.printStackTrace();
		}
		return num;
	}
	
	
	public static DefaultTableModel getLowStockInfo() throws SQLException {
		// TODO Auto-generated method stub

	/*String sql = "insert into agent(name,contact,address) values('Saksham','77','Apt no. 15')";*/

	   String sql = "SELECT Item_ID,Item_Name,Quantity,price FROM stocks";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getStocksHeading());
	//STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("Item_ID");
	         String name = rs.getString("Item_Name");
	         int quantity = rs.getInt("Quantity");
	         int price = rs.getInt("Price");
	         if(quantity<20)
	         {
	        	 model.addRow(new Object[]{id,name,quantity,price});
	         }
	      }
		return model;
	      
	}
	
	public static DefaultTableModel getDeliveryAgentInfo() throws SQLException {
		// TODO Auto-generated method stub

	/*String sql = "insert into agent(name,contact,address) values('Saksham','77','Apt no. 15')";*/

	   String sql = "SELECT agent_id,name,contact,address,agentArea FROM agent";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getDeliveryAgentHeading());
	//STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("agent_id");
	         String name = rs.getString("name");
	         int contact = rs.getInt("contact");
	         String addr = rs.getString("address");
	         int agentArea = rs.getInt("agentArea");
	         model.addRow(new Object[]{id,name,contact,addr,agentArea});
	         }
	      
		return model;
	      
	}
	
	public static String[] getDeliveryAgentHeading() throws SQLException {
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SHOW COLUMNS FROM newsagency.agent";
	   
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));
	}
	
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}

	/*public static DefaultTableModel getCustomerInfo() throws SQLException {
		// TODO Auto-generated method stub

	   String sql = "SELECT customer.customer_id,name,contact_no,address,payment_due,order_area from customer inner join billingbackup where billingbackup.payment_status = customer.payment_due";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getCustomerHeading());
	//STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("customer_id");
	         String name = rs.getString("name");
	         String contact = rs.getString("contact_no");
	         String addr = rs.getString("address");
	         int payment = rs.getInt("payment_due");
	         int order_area = rs.getInt("order_area");
	         //sb1.append("\nID: "+String.valueOf(id)+" Name: "+name+" Contact: "+String.valueOf(contact)+" Address: "+addr+" Payment Due: "+payment);
	         
	         model.addRow(new Object[]{id,name,contact,addr,payment,order_area});
	      }
	      System.out.println(model.getRowCount());
		return model;
	      
	}*/
	
	
	public static DefaultTableModel getCustomerInfor() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "SELECT * from customer";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery(); 
			DefaultTableModel model = new DefaultTableModel();
			String[] head = {"Cust_ID","Cust_Name","Cust_Cont","Cust_Addr","Payment","Area"};
			model.setColumnIdentifiers(head);
			//STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			    	  int id  = rs.getInt("customer_id");
				         String name = rs.getString("name");
				         String contact = rs.getString("contact_no");
				         String addr = rs.getString("address");
				         int payment = rs.getInt("payment_due");
				         int order_area = rs.getInt("order_area");
			      
				         model.addRow(new Object[]{id,name,contact,addr,payment,order_area});
			      
			      }
				return model;
	      
	}
	

	public static String[] getCustomerHeading() throws SQLException {
		
	   String sql = "SHOW COLUMNS FROM newsagency.customer";
	   
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));
	}
	
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}
	
	
	public static String[] getOrderIds() throws SQLException
	{
		String sql = "Select order_table.order_id from order_table;";
		   
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		ArrayList<String> types = new ArrayList<String>();

		while (rs.next()) {
			int id = rs.getInt("order_id");
		    String i = String.valueOf(id);
			types.add(i);
		}
		
		String[] type = new String[types.size()];
		return type = types.toArray(type); 
	}
	

	public static int setDeliveryStatus(int a,int b) throws SQLException {
		// TODO Auto-generated method stub
	   String sql = "update order_table set delivery_status = ? where order_id=?";
	st = conn.prepareStatement(sql);
	st.setInt(1,b);
	st.setInt(2,a);
	int a1 = st.executeUpdate();
	
	return a1;
	      }
	
/*	public static DefaultTableModel getCustomerOrderInfo() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;

	   String sql = "SELECT customer_id,order_area,delivery_status,order_d FROM customer";
		//String sql = "SELECT order_area,delivery_status,order FROM customer";
		st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getCustomerHeading());
	//STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("customer_id");
	         int area = rs.getInt("order_area");
	         String order = rs.getString("order_d");
	         int delivery_st = rs.getInt("delivery_status");
	         model.addRow(new Object[]{id,area,order,delivery_st});
	         }
	      
		return model;
	      
	}
	
*/	
	
	public static DefaultTableModel generateDocket(int a) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "SELECT order_table.order_id,Customer.name,Order_table.customer_id,customer.address,order_table.order_desc,order_table.order_area,order_table.delivery_status from customer inner join order_table where customer.customer_id = order_table.customer_id and order_table.order_area = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, a);
			rs = st.executeQuery(); 
			DefaultTableModel model = new DefaultTableModel();
			String[] head = {"OrderID","Cust_Name","Cust_ID","Cust_Addr","Order_Desc","Area","Delivery_Status"};
			model.setColumnIdentifiers(head);
			//STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			          int id  = rs.getInt("Order_Id");
			         String name = rs.getString("Name");
			         int custid = rs.getInt("customer_id");
			         String custadd = rs.getString("Address");
			         String order_d = rs.getString("Order_desc");
			         int order_area = rs.getInt("order_area");
			         int delivery = rs.getInt("delivery_status");
			      
			         model.addRow(new Object[]{id,name,custid,custadd,order_d,order_area,delivery});
			      
			      }
				return model;
	      
	}
	
	 
	public static int Insert_customer(String a,String b,String c,int d, int order_area)
	{
	int num = 0;
	try
	{
		
	
		
		String sql = "insert into customer(Name,Contact_no,Address,Payment_due,order_area) values(?,?,?,?,?)";
		
		
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setString(3, c);
		st.setInt(4, d);
		st.setInt(5, order_area);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e)
	{
		//e.printStackTrace();
	}

	return num;
	}
	
	public static int Insert_agent(String a,String b,String c)
	{
	int num = 0;
	try
	{
		
		
		String sql = "insert into agent(name,contact,address) values(?,?,?)";
		
		
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setString(3, c);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e)
	{
		//e.printStackTrace();
	}

	return num;
	}
	
	public static int insertOrder(int custid,String order)
	{
		int num = 0;
		try
		{
			
			int order_area = getOrderArea(custid);
			
			String sql = "insert into order_table(customer_id,order_desc,order_area,delivery_status) values(?,?,?,?)";
			
			st = conn.prepareStatement(sql);
			// index starts from 1
			st.setInt(1, custid);
			st.setString(2, order);
			st.setInt(3, order_area);
			st.setInt(4,0);
			// execute and return number of rows that take effect
			num = st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return num;
		
	}
	public static int getOrderArea(int custid) throws SQLException
	{
		String sql = "Select order_area from customer where customer_id=?";
	int order_area = 1;
		st = conn.prepareStatement(sql);
	st.setInt(1, custid);
	rs = st.executeQuery();
	while(rs.next())
	{
	 order_area = rs.getInt("order_area");
	}
	return order_area;
	}
	
	public static int addDeliveryArea(int ai, String nam) throws SQLException{
		int num = 0;
		try {
			String sql = "INSERT INTO delivery_area (delivery_area_id, delivery_area_name) VALUES (?,?);";
			st = conn.prepareStatement(sql);
			st.setInt(1, ai);
			st.setString(2, nam);
			num  = st.executeUpdate();
		}
		catch(Exception e) {
		//	e.printStackTrace();
		}
		return num;
		
	}
	
	public static void deleteDeliveryArea(int ai) throws SQLException{		
			String sql = "DELETE FROM delivery_area where delivery_area_id = ?;";
			st = conn.prepareStatement(sql);
			st.setInt(1, ai);
		    int num = st.executeUpdate();
		    if(num>0)
		    {
		    DialogMessage.showInfoDialog("Delivery Area Deleted!!.");
		    }
		    else
		    {
		    DialogMessage.showInfoDialog("Delivery Area number not found.");
		}
	}
	public static ResultSet getDeliveryAreasID() {
		try {
		String sql = "SELECT * FROM delivery_area;";
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getDeliveryAgentID() {
		try {
			String sql = "SELECT * FROM agent;";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			}
			catch(Exception e) {
				//e.printStackTrace();
			}
		return rs;
	}
	public static void assignArea(int ai,int di) {
		int num;
		try {
			String sql = "UPDATE agent SET agentArea = ? WHERE agent_id = ? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, ai);
			st.setInt(2, di);
			num = st.executeUpdate();
			}
			catch(Exception e) {
				//e.printStackTrace();
			}
	}
	public static int getAdminStatus() {
		int stat = 0;
		try {
			String sql = "SELECT status FROM newsagency.`admin status` where id = 1; ";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
			stat = rs.getInt("status");
			}
		}
		catch(Exception e) {
			System.out.println("A default value for admin status is selected. Exception occured!!");
		}
		return stat;
	}
	
	public static void setAdminStatus(int s) {
		int num;
		try {
			String sql = "UPDATE `newsagency`.`admin status` SET `status` = ? WHERE (`id` = '1'); ";
			st = conn.prepareStatement(sql);
			st.setInt(1, s);
			num = st.executeUpdate();
			}
			catch(Exception e) {
				
			}

	}
	public static int deleteCustomer(int id) {
		// TODO Auto-generated method stub
		int num = 0;
		try {
			
			String sql = "DELETE FROM customer WHERE customer_id=? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			num  = st.executeUpdate();
		}
		catch(Exception e) {
		//	e.printStackTrace();
		}
		return num;
	}

	public static DefaultTableModel generateItemsInfo(int a) throws SQLException {
		// TODO Auto-generated method stub

			   String sql = "SELECT order_table.order_desc, COUNT(order_table.order_desc) FROM order_table where order_area = ? GROUP BY order_table.order_desc;";
				st = conn.prepareStatement(sql);
				st.setInt(1, a);
				rs = st.executeQuery();
				DefaultTableModel model = new DefaultTableModel();
				String header[] = {"Item Name", "Quantity"};
				model.setColumnIdentifiers(header);
				//STEP 5: Extract data from result set
				      while(rs.next()){
				         //Retrieve by column name
				         String name = rs.getString("order_desc");
				         int count = rs.getInt("COUNT(order_table.order_desc)");
		        
		         model.addRow(new Object[]{name,count});
		         
		      }
					return model;
	}

	public static int checkUserID(String userid) throws SQLException {
		   String sql = "SELECT login_id FROM login_table";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			     
			int num = 0;
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			          String id  = rs.getString("login_id");
			          
			          if(userid.equals(id))
			          {
			        	return 1; 
			          }
			        	  
			      }
				return num;
		
	}

	public static int update_password(String username, String encoded_password) {
		// TODO Auto-generated method stub
		int num = 0;
		try {
			String sql = "UPDATE login_table SET password = ? WHERE login_id = ? ";
			st = conn.prepareStatement(sql);
			st.setString(1, encoded_password);
			st.setString(2, username);
			num = st.executeUpdate();
			}
			catch(Exception e) {
			//	e.printStackTrace();
			}
		return num;
		
	}
	
	
	public static DefaultTableModel getOrdersInfo() throws SQLException {
		// TODO Auto-generated method stub
		

	/*String sql = "insert into agent(name,contact,address) values('Saksham','77','Apt no. 15')";*/

	   String sql = "SELECT order_table.order_id,Customer.name,Order_table.customer_id,customer.address,order_table.order_desc,order_table.order_area,order_table.delivery_status from customer inner join order_table where customer.customer_id = order_table.customer_id";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	DefaultTableModel model = new DefaultTableModel();
	String[] head = {"OrderID","Cust_Name","Cust_ID","Cust_Addr","Order_Desc","Area","Delivery_Status"};
	model.setColumnIdentifiers(head);
	//STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	          int id  = rs.getInt("Order_Id");
	         String name = rs.getString("Name");
	         int custid = rs.getInt("customer_id");
	         String custadd = rs.getString("Address");
	         String order_d = rs.getString("Order_desc");
	         int order_area = rs.getInt("order_area");
	         int delivery = rs.getInt("delivery_status");
	         model.addRow(new Object[]{id,name,custid,custadd,order_d,order_area,delivery});
	      }
		return model;
	      
	}


	public static int deleteOrder(int id) {
		// TODO Auto-generated method stub
		int num = 0;
		try {
			
			String sql = "DELETE FROM order_table WHERE order_id=? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			num  = st.executeUpdate();
		}
		catch(Exception e) {
		//	e.printStackTrace();
		}
		return num;
	}


	public static DefaultTableModel generateBill(int a) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT order_table.order_id,Customer.name,Order_table.customer_id,customer.address,order_table.order_desc,order_table.order_area,order_table.delivery_status from customer inner join order_table where customer.customer_id = order_table.customer_id and order_table.customer_id = ?";
		st = conn.prepareStatement(sql);
		st.setInt(1, a);
		rs = st.executeQuery(); 
		InsertInBill(rs);
		DefaultTableModel model = new DefaultTableModel();
		String sql1 = "Select * from billing";
		st = conn.prepareStatement(sql1);
		ResultSet rs1 = st.executeQuery();
		String[] head = {"Billing ID","OrderID","Cust_ID","Cust_Name","Cust_Addr","Order_Item","Price","Payment_Status","VAT"};
		model.setColumnIdentifiers(head);
		while(rs1.next())
		{
			int billing_id = rs1.getInt("billing_id");
			int order_id = rs1.getInt("order_id");
			int customer_id = rs1.getInt("customer_id");
			String customer_name = rs1.getString("customer_name");
			String addr = rs1.getString("customer_addr");
			String order_item = rs1.getString("order_item");
			int price = rs1.getInt("price");
			int payment_status = rs1.getInt("payment_status");
			String vat = rs1.getString("vat");
		         model.addRow(new Object[]{billing_id,order_id,customer_id,customer_name,addr,order_item,price,payment_status,vat});
		}     
		      
			return model;
	}
	
	
	
	public static void InsertInBill(ResultSet rs) throws SQLException {
		String sql2 = "truncate billing";
		st = conn.prepareStatement(sql2);
		st.executeUpdate();
		
		while(rs.next())
		{
			int id = rs.getInt("order_id");
			int customerid = rs.getInt("customer_id");
			String customer_name = rs.getString("Name");
			String addr = rs.getString("Address");
			String orderitem = rs.getString("order_desc");
			int price = getPrice(orderitem);
			int payment = 0;
			String vat = "10%";
			int bill = price*10;
			InsertBillBackup(id,customerid,customer_name,addr,orderitem,bill,payment,vat);
			String sql = "INSERT INTO billing (order_id,customer_id,customer_name,customer_addr,order_item,price,payment_status,vat) VALUES (?,?,?,?,?,?,?,?);";
			st = conn.prepareStatement(sql);
			st.setInt(1,id);
			st.setInt(2,customerid);
			st.setString(3,customer_name);
			st.setString(4, addr);
			st.setString(5,orderitem);
			st.setInt(6, bill);
			st.setInt(7,payment);
			st.setString(8,vat);
			st.executeUpdate();
			
		}
		
	}
	
	private static void InsertBillBackup(int id, int customerid, String customer_name, String addr, String orderitem,
			int bill, int payment, String vat) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO billingbackup (order_id,customer_id,customer_name,customer_addr,order_item,price,payment_status,vat) VALUES (?,?,?,?,?,?,?,?);";
		st = conn.prepareStatement(sql);
		st.setInt(1,id);
		st.setInt(2,customerid);
		st.setString(3,customer_name);
		st.setString(4, addr);
		st.setString(5,orderitem);
		st.setInt(6, bill);
		st.setInt(7,payment);
		st.setString(8,vat);
		st.executeUpdate();
	}


	public static int getPrice(String item) throws SQLException
	{
		int price = 0;
		String sql = "Select price from stocks where Item_Name=?";
		st = conn.prepareStatement(sql);
		st.setString(1, item);
		rs = st.executeQuery();
		while(rs.next())
		{
			price = rs.getInt("price");
		}
		return price;
	}


	public static DefaultTableModel generateOldsBill() throws SQLException {
		// TODO Auto-generated method stub
		DefaultTableModel model = new DefaultTableModel();
		String sql1 = "Select * from billingbackup";
		st = conn.prepareStatement(sql1);
		ResultSet rs1 = st.executeQuery();
		String[] head = {"Billing ID","OrderID","Cust_ID","Cust_Name","Cust_Addr","Order_Item","Price","Payment_Status","VAT"};
		model.setColumnIdentifiers(head);
		while(rs1.next())
		{
			int billing_id = rs1.getInt("billing_id");
			int order_id = rs1.getInt("order_id");
			int customer_id = rs1.getInt("customer_id");
			String customer_name = rs1.getString("customer_name");
			String addr = rs1.getString("customer_addr");
			String order_item = rs1.getString("order_item");
			int price = rs1.getInt("price");
			int payment_status = rs1.getInt("payment_status");
			String vat = rs1.getString("vat");
		         model.addRow(new Object[]{billing_id,order_id,customer_id,customer_name,addr,order_item,price,payment_status,vat});
		}     
		      
			return model;
	}
	public static int updatePaymentStatus(int pay,int cust) throws SQLException
	{
		custPaymentUpdate(pay, cust);
		 String sql = "update billingbackup set billingbackup.payment_status = ? where billingbackup.customer_id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1,pay);
			st.setInt(2,cust);
			int a1 = st.executeUpdate();
			
			return a1;
		
	}
	
	public static void custPaymentUpdate(int pay,int cust) throws SQLException
	{
		 String sql = "update customer set payment_due = ? where customer.customer_id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1,pay);
			st.setInt(2,cust);
			int a1 = st.executeUpdate();
		
	}
	 public static int[] getUnassignedAgentIds() {
		 int i = 0;
		int[] agentIds = new int[15];
		
		try{
		String sql = "SELECT agent_id FROM agent;";		
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		while(rs.next()) {
		agentIds[i] = rs.getInt("agent_id");
		i++;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 return agentIds;
	 }
	public static int[] getAreaIds() {
			int i = 0;
			int[] areaIds = new int[15];
			
			try{
			String sql = "SELECT delivery_area_id FROM delivery_area;";		
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
			areaIds[i] = rs.getInt("delivery_area_id");
			i++;
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return areaIds;		
	}

	public static int[] getAssignedAreaIds() {
		int i = 0;
		int[] areaIds = new int[15];		
		try{
		String sql = "SELECT agentArea FROM agent WHERE agentArea is not null;";		
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		while(rs.next()) {
		areaIds[i] = rs.getInt("agentArea");
		i++;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	return areaIds;
	}
	public static void updateForUnassigned(int ai, int area) {
		String sql = "UPDATE `newsagency`.`agent` SET `agentArea` = ? WHERE (`agent_id` = ?);";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, area);
			st.setInt(2, ai);
			int i = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static DefaultTableModel generateDefaulterList() throws SQLException {
		// TODO Auto-generated method stub
		DefaultTableModel model = new DefaultTableModel();
		String sql1 = "Select Customer_Id,customer.Name,Contact_no,Address,Payment_Due,order_area from customer where payment_due>3;";
		st = conn.prepareStatement(sql1);
		ResultSet rs1 = st.executeQuery();
		String[] head = {"Customer ID","Name","Contact No","Address","Payment_Due","Order_Area"};
		model.setColumnIdentifiers(head);
		while(rs1.next())
		{
			int billing_id = rs1.getInt("customer_id");
			String customer_name = rs1.getString("customer_name");
			int contact = rs1.getInt("contact_no");
			String addr = rs1.getString("customer.address");
			int payment = rs1.getInt("payment_due");
			int area = rs1.getInt("order_area");
		         model.addRow(new Object[]{billing_id,customer_name,contact,addr,payment,area});
		}     
		      System.out.println(model.getRowCount());
			return model;
	}
	
	
	public static DefaultTableModel getDefaulterInfor() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "SELECT * from customer where payment_due>3";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery(); 
			DefaultTableModel model = new DefaultTableModel();
			String[] head = {"Cust_ID","Cust_Name","Cust_Cont","Cust_Addr","Payment","Area"};
			model.setColumnIdentifiers(head);
			//STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			    	  int id  = rs.getInt("customer_id");
				         String name = rs.getString("name");
				         String contact = rs.getString("contact_no");
				         String addr = rs.getString("address");
				         int payment = rs.getInt("payment_due");
				         int order_area = rs.getInt("order_area");
			      
				         model.addRow(new Object[]{id,name,contact,addr,payment,order_area});
			      
			      }
				return model;
	      
	}


	 
}
	

	



