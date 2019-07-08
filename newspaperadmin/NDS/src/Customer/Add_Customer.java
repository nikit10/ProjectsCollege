package Customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;
import Validation.Verifycustomer;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Add_Customer extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static String[] type = {"Hello","World"};
	static String[] type1 = {"Hello","World"};

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Customer frame = new Add_Customer();
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
	 */
	public Add_Customer() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add a customer");
		lblNewLabel_1.setBackground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("ËÎÌå", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(205, 13, 501, 100);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name         :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		lblName.setBounds(204, 126, 150, 50);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(354, 126, 200, 50);
		contentPane.add(textField_1);
		
		JLabel lblContactno = new JLabel("Contact_no \uFF1A");
		lblContactno.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactno.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		lblContactno.setBounds(204, 189, 150, 50);
		contentPane.add(lblContactno);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(354, 189, 200, 50);
		contentPane.add(textField_2);
		
		JLabel lblAddress = new JLabel("Address      \uFF1A");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		lblAddress.setBounds(204, 259, 150, 50);
		contentPane.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(354, 259, 200, 50);
		contentPane.add(textField_3);
		
		JLabel lblPaymentdue = new JLabel("Paymentdue:");
		lblPaymentdue.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentdue.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		lblPaymentdue.setBounds(204, 329, 150, 50);
		contentPane.add(lblPaymentdue);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(354, 329, 200, 50);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("REGISTER");
		
		btnNewButton.setBounds(146, 481, 200, 50);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Infor r = new Customer_Infor();
				r.showFrame();
				setVisible(false);
				
			}
		});
		btnExit.setBounds(406, 481, 200, 50);
		contentPane.add(btnExit);
		
		JLabel lblOrderArea = new JLabel("Order Area");
		lblOrderArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderArea.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblOrderArea.setBounds(204, 392, 150, 50);
		contentPane.add(lblOrderArea);
		
		JComboBox comboBox = new JComboBox();
		type1 = ConnectDB.getDeliveryAreas();
		comboBox.setModel(new DefaultComboBoxModel<>(type1));
		comboBox.setBounds(354, 410, 200, 22);
		contentPane.add(comboBox);
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//textField.getText().trim().equals("") ||
				if(textField_1.getText().trim().equals("") || 
						textField_2.getText().trim().equals("") || textField_3.getText().trim().equals("") || 
						textField_4.getText().trim().equals("") ) {
					DialogMessage.showWarningDialog("Empty register info!");
					return;
				}
							
				String addr=textField_3.getText();
				String ph=textField_2.getText().trim();
			    String uname = textField_1.getText();			  
				int Paymentdue=Integer.parseInt(textField_4.getText().trim());
				   
				 int order_area = Integer.parseInt(comboBox.getSelectedItem().toString());
				

					if(!Verifycustomer.verifyName(uname)) {
						DialogMessage.showWarningDialog("Invalid  name format!");
						return;
					}			
					
					if(!Verifycustomer.verifyPaymentdue(Paymentdue)) {
						DialogMessage.showWarningDialog("Invalid  Paymentdue format!");
						return;
					}			
					
					if(!Verifycustomer.verifyAddress(addr)) {
						DialogMessage.showWarningDialog("Invalid address format!");
						return;
					}
					if(!Verifycustomer.verifycontact(ph)) {
						DialogMessage.showWarningDialog("Invalid contact format!");
						return;
					}
					
				
					
					int num = ConnectDB.Insert_customer(uname ,ph,addr,Paymentdue,order_area);
					
					if (num > 0) {
						DialogMessage.showInfoDialog("Registered successfully!!!");
						setVisible(false);
						Customer_Infor r = new Customer_Infor();
						r.showFrame();
					}
				
			}
		});
	}
}
