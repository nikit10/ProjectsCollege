package Orders;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Delivery_Page.DeliveryPage;
import Misc.DialogMessage;
import Validation.Verifycustomer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Payment_Status extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String[] type = {"Hello","World"};
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment_Status frame = new Payment_Status();
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
	public Payment_Status() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Customer ID");
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setBounds(130, 101, 132, 19);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(285, 100, 137, 22);
		type = ConnectDB.getCustomerID();
		comboBox.setModel(new DefaultComboBoxModel<>(type));
		contentPane.add(comboBox);
		
		JLabel lblPaymentStatus = new JLabel("Payment Status");
		lblPaymentStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPaymentStatus.setBounds(130, 183, 132, 19);
		contentPane.add(lblPaymentStatus);
		
		textField = new JTextField();
		textField.setBounds(285, 182, 137, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryPage d = new DeliveryPage();
				d.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(87, 269, 111, 40);
		contentPane.add(button);
		
		JButton btnSet = new JButton("SET");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField.getText().trim().equals("")  ) {
					DialogMessage.showWarningDialog("Empty register info!");
					return;
				}
				
				String id = comboBox.getSelectedItem().toString();
				int cust_id = Integer.parseInt(id);
				int payment_status = Integer.parseInt(textField.getText());
				int num;

				
				if(!Verifycustomer.verifyPaymentStatus(payment_status)) {
					DialogMessage.showWarningDialog("Invalid  payment_status format!");
					return;
				}	
				
				
				
				try {
					
					num = ConnectDB.updatePaymentStatus(payment_status, cust_id);
					if(num>0)
					{
						DialogMessage.showInfoDialog("Updated");
						textField.setText("");
					}
					else
					{
						DialogMessage.showWarningDialog("Not Updated");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
			}
		});
		btnSet.setFont(new Font("Arial", Font.BOLD, 14));
		btnSet.setBounds(293, 269, 147, 40);
		contentPane.add(btnSet);
	}
}
