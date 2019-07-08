package olympics;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Vector;
import java.util.concurrent.Callable;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.CallableStatement;

import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
@SuppressWarnings("serial")
public class GUI implements ActionListener {

	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JFrame frmJdbcassignment;
	private JComboBox medal,gender;
	private JTextField id;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	private JTextField country;
	private JTextField sport;
	private JTextField weight;
	private Vector modelData;;
	private static QueryTableModel TableModel =new QueryTableModel();
	private JTable DBtable;
	private JButton btnInsert, btnExport, btnDelete, btnUpdate, btnClear, btnNewButton;
	private JLabel ageLabel;
	private JLabel weightLabel;
	private JTextField no;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmJdbcassignment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		initiate_db_conn();
		frmJdbcassignment = new JFrame();
		frmJdbcassignment.setTitle("JDBC_Assignment");
		frmJdbcassignment.setBounds(100, 100, 1241, 808);
		frmJdbcassignment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJdbcassignment.getContentPane().setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setToolTipText("");
		panel.setBounds(12, 13, 439, 441);
		frmJdbcassignment.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel idLabel = new JLabel("");
		idLabel.setForeground(Color.RED);
		idLabel.setBackground(new Color(240, 240, 240));
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idLabel.setBounds(147, 49, 97, 16);
		panel.add(idLabel);
		
		ageLabel = new JLabel("");
		ageLabel.setForeground(Color.RED);
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ageLabel.setBackground(SystemColor.menu);
		ageLabel.setBounds(147, 207, 86, 16);
		panel.add(ageLabel);
		
		weightLabel = new JLabel("");
		weightLabel.setForeground(Color.RED);
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		weightLabel.setBackground(SystemColor.menu);
		weightLabel.setBounds(147, 322, 97, 16);
		panel.add(weightLabel);
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(84, 31, 30, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 72, 76, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(36, 116, 78, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(58, 158, 56, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(84, 187, 30, 24);
		panel.add(lblAge);
		
		JLabel lblCounrty = new JLabel("Counrty:");
		lblCounrty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounrty.setBounds(58, 224, 56, 16);
		panel.add(lblCounrty);
		
		JLabel lblSport = new JLabel("Sport:");
		lblSport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSport.setBounds(75, 260, 39, 16);
		panel.add(lblSport);
		
		JLabel lblNewLabel_4 = new JLabel("Weight:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(64, 299, 50, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Medal:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(64, 342, 50, 16);
		panel.add(lblNewLabel_5);
		
		medal = new JComboBox();
		medal.setModel(new DefaultComboBoxModel(new String[] {"gold", "silver", "bronze", "none"}));
		medal.setBounds(147, 340, 116, 22);
		panel.add(medal);
		
		
		id = new JTextField();
		id.setBounds(147, 29, 116, 22);
		panel.add(id);
		id.setColumns(10);
		
		
		
		fname = new JTextField();
		fname.setBounds(147, 70, 116, 22);
		panel.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(147, 114, 116, 22);
		panel.add(lname);
		lname.setColumns(10);
		
		gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gender.setBounds(147, 156, 116, 22);
		panel.add(gender);
		
		age = new JTextField();
		age.setBounds(147, 189, 116, 22);
		panel.add(age);
		age.setColumns(10);
		
		country = new JTextField();
		country.setBounds(147, 222, 116, 22);
		panel.add(country);
		country.setColumns(10);
		
		sport = new JTextField();
		sport.setBounds(147, 258, 116, 22);
		panel.add(sport);
		sport.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(147, 297, 116, 22);
		panel.add(weight);
		weight.setColumns(10);
		
		btnInsert = new JButton("Insert");
		btnInsert.setBounds(298, 69, 97, 25);
		panel.add(btnInsert);
		btnInsert.addActionListener(this);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(298, 113, 97, 25);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(298, 155, 97, 25);
		panel.add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnExport = new JButton("Export");
		btnExport.setBounds(298, 198, 97, 25);
		panel.add(btnExport);
		btnExport.addActionListener(this);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(298, 236, 97, 25);
		panel.add(btnClear);
		
		
		btnClear.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(508, 13, 703, 469);
		frmJdbcassignment.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		DBtable = new JTable(TableModel);
		DBtable.setBounds(22, 13, 669, 443);
		panel_1.add(DBtable);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(38, 501, 276, 108);
		frmJdbcassignment.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnNewButton = new JButton("No. of medals with country");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(12, 44, 247, 51);
		panel_2.add(btnNewButton);
		
		no = new JTextField();
		no.setBounds(72, 13, 116, 22);
		panel_2.add(no);
		no.setColumns(10);
		btnNewButton.addActionListener(this);
		
		TableModel.refreshFromDB(stmt);
	}


public void initiate_db_conn()
{
	try
	{
		// Load the JConnector Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Specify the DB Name
		String url="jdbc:mysql://localhost:3306/beng_assign";
		// Connect to DB using DB URL, Username and password
		con = DriverManager.getConnection(url, "root", "admin");
		//Create a generic statement which is passed to the TestInternalFrame1
		stmt = con.createStatement();
		
	}
	catch(Exception e)
	{
		System.out.println("Error: Failed to connect to database\n"+e.getMessage());
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String cmd=null;
	Object target=e.getSource();
	String gen = (String) gender.getSelectedItem();
	if(gen == "Female") {
		gen = "F";
	}
	else {
		gen = "M";
	}
	String med  = (String) medal.getSelectedItem();
	
	if(target== btnInsert) {
		try
		{
			String updateTemp ="INSERT INTO olympics VALUES("+
			null +",'"+fname.getText()+"','"+lname.getText()+"','"+gen+"','"+age.getText()+"','"
			+country.getText()+"','"+sport.getText()+"','"+weight.getText()+"','"+med+"');";

			stmt.executeUpdate(updateTemp);

		}
		catch (SQLException sqle)
		{
			System.err.println("Error with  insert:\n"+sqle.toString());
		}
		finally
		{
			TableModel.refreshFromDB(stmt);
		}
	}
	
	else if (target == btnClear)
	{
		id.setText("");
		fname.setText("");
		lname.setText("");
		age.setText("");
		gender.setSelectedIndex(0);
		weight.setText("");
		country.setText("");
		sport.setText("");
		medal.setSelectedIndex(0);

	}
	
	else if (target == btnDelete)
	{

		try
		{
			String updateTemp ="DELETE FROM olympics WHERE id = "+id.getText()+";"; 
			stmt.executeUpdate(updateTemp);

		}
		catch (SQLException sqle)
		{
			System.err.println("Error with delete:\n"+sqle.toString());
		}
		finally
		{
			TableModel.refreshFromDB(stmt);
		}
	}
	
	else if (target == btnUpdate)
	{	 	
		try
		{ 			
			String updateTemp ="UPDATE olympics SET " +
			"FirstName = '"+fname.getText()+
			"', LastName = '"+lname.getText()+
			"', Gender ='"+gen+
			"', Age = '"+age.getText()+
			"', Country = '"+country.getText()+
			"', Sport = '"+sport.getText()+
			"', Weight = '"+weight.getText()+
			"', Medal = '"+med +
			"' where id = '"+id.getText() +"'";


			stmt.executeUpdate(updateTemp);
			//these lines do nothing but the table updates when we access the db.
			rs = stmt.executeQuery("SELECT * from olympics ");
			rs.next();
			rs.close();	
		}
		catch (SQLException sqle){
			System.err.println("Error with  update:\n"+sqle.toString());
		}
		finally{
			TableModel.refreshFromDB(stmt);
		}
	}
	
	else if(target == btnExport) {

		cmd = "select * from olympics;";

		try{					
			rs= stmt.executeQuery(cmd); 	
			writeToFile(rs);
		}
		catch(Exception e1){e1.printStackTrace();}
	}
	
	else if(target == btnNewButton){
		String deptName = no.getText();
    try {
		 CallableStatement st =  (CallableStatement) con.prepareCall("{call count11(?)}");
		 st.setString(1, deptName);
		 rs = st.executeQuery();
		 writeToFile(rs);
	}
    catch(Exception e1) {
    	System.out.println("Enter Valid Country");
    }}	
}

private void writeToFile(ResultSet rs){
	try{
		System.out.println("In writeToFile");
		FileWriter outputFile = new FileWriter("Assignemnt.csv");
		PrintWriter printWriter = new PrintWriter(outputFile);
		ResultSetMetaData rsmd = rs.getMetaData();
		int numColumns = rsmd.getColumnCount();

		for(int i=0;i<numColumns;i++){
			printWriter.print(rsmd.getColumnLabel(i+1)+",");
		}
		printWriter.print("\n");
		while(rs.next()){
			for(int i=0;i<numColumns;i++){
				printWriter.print(rs.getString(i+1)+",");
			}
			printWriter.print("\n");
			printWriter.flush();
		}
		printWriter.close();
	}
	catch(Exception e){e.printStackTrace();}
}
}