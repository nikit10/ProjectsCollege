package Customer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;
import Validation.Verifycustomer;
import Validation.VerifyupdateCustomer;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UpdateCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField txt_cust_payment;
	private JTextField txt_cust_addr;
	private JTextField txt_cust_contact;
	private JTextField txt_cust_name;
	private JTextField txt_cust_id;
	static String[] type = {"Hello","World"};

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws NoSuchAlgorithmException 
	 * @throws NumberFormatException 
	 */
	public UpdateCustomer() throws NumberFormatException, NoSuchAlgorithmException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_cust_payment = new JTextField();
		txt_cust_payment.setColumns(10);
		txt_cust_payment.setBounds(316, 334, 200, 50);
		contentPane.add(txt_cust_payment);
		
		JLabel label_2 = new JLabel("Paymentdue:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		label_2.setBounds(166, 334, 150, 50);
		contentPane.add(label_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblAddress.setBounds(166, 264, 150, 50);
		contentPane.add(lblAddress);
		
		txt_cust_addr = new JTextField();
		txt_cust_addr.setColumns(10);
		txt_cust_addr.setBounds(316, 264, 200, 50);
		contentPane.add(txt_cust_addr);
		
		txt_cust_contact = new JTextField();
		txt_cust_contact.setColumns(10);
		txt_cust_contact.setBounds(316, 194, 200, 50);
		contentPane.add(txt_cust_contact);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblContact.setBounds(166, 194, 150, 50);
		contentPane.add(lblContact);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblName.setBounds(166, 131, 150, 50);
		contentPane.add(lblName);
		
		txt_cust_name = new JTextField();
		txt_cust_name.setColumns(10);
		txt_cust_name.setBounds(316, 131, 200, 50);
		contentPane.add(txt_cust_name);
		
		txt_cust_id = new JTextField();
		txt_cust_id.setEditable(false);
		txt_cust_id.setColumns(10);
		txt_cust_id.setText(String.valueOf(Customer_Infor.cust_id));
		txt_cust_id.setBounds(316, 54, 200, 50);
		contentPane.add(txt_cust_id);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblId.setBounds(166, 54, 150, 50);
		contentPane.add(lblId);
		
		JButton btn_Update_Customer = new JButton("Update Customer");
		btn_Update_Customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(		txt_cust_name.getText().trim().equals("") || txt_cust_contact.getText().trim().equals("") || 
					txt_cust_addr.getText().trim().equals("") || 
					txt_cust_payment.getText().trim().equals("") ) {
				DialogMessage.showWarningDialog("Empty register info!");
				return;
			}
				
				int id = Integer.parseInt(txt_cust_id.getText());
				String name = txt_cust_name.getText();
				String contact = txt_cust_contact.getText();
			String addr = txt_cust_addr.getText();
			int payment = Integer.parseInt(txt_cust_payment.getText());
			
			
		
			

			if(!VerifyupdateCustomer.verifyName(name)) {
				DialogMessage.showWarningDialog("Invalid  name format!");
				return;
			}			
			
			if(!VerifyupdateCustomer.verifyPaymentdue(payment)) {
				DialogMessage.showWarningDialog("Invalid  Paymentdue format!");
				return;
			}			
			
			if(!VerifyupdateCustomer.verifyAddress(addr)) {
				DialogMessage.showWarningDialog("Invalid address format!");
				return;
			}
			if(!VerifyupdateCustomer.verifycontact(contact)) {
				DialogMessage.showWarningDialog("Invalid contact format!");
				return;
			}
			
			
			
			
			
			int num = ConnectDB.UpdateCustomer(id,name,contact,addr,payment);
			if(num==1)
			{
				DialogMessage.showInfoDialog("Updated");
				setVisible(false);
				Customer_Infor r = new Customer_Infor();
				r.showFrame();
			/*	CustomerInfo c = new CustomerInfo();
				c.setVisible(true);*/
			}
			else if(num==0)
			{
				DialogMessage.showWarningDialog("Error");
			}
			
			}
		});
		
		ArrayList<String> a = ConnectDB.getCustomerUpdateInfo(Integer.parseInt(txt_cust_id.getText()));
		txt_cust_name.setText(a.get(0).toString());
		txt_cust_contact.setText(a.get(1).toString());
		txt_cust_payment.setText(a.get(3).toString());
		txt_cust_addr.setText(a.get(2).toString());
		type = ConnectDB.getStocksValues();
		
		btn_Update_Customer.setBounds(246, 409, 192, 59);
		contentPane.add(btn_Update_Customer);
	}

}
