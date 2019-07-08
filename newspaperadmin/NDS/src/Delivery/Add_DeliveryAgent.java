package Delivery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AdminPage.Admin_Page;
import Customer.Customer_Infor;
import Database_Classes.ConnectDB;
import Misc.DialogMessage;
import Validation.VerifyAdd_DeliveryAgent;
import Validation.Verifycustomer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_DeliveryAgent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_DeliveryAgent frame = new Add_DeliveryAgent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Add_DeliveryAgent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(327, 308, 200, 50);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Address      \uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 22));
		label.setBounds(177, 308, 150, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Contact_no \uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		label_1.setBounds(177, 238, 150, 50);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(327, 238, 200, 50);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(327, 168, 200, 50);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("Name         :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		label_2.setBounds(177, 168, 150, 50);
		contentPane.add(label_2);
		
		JLabel lblAddAAgent = new JLabel("Add a Agent");
		lblAddAAgent.setFont(new Font("Dialog", Font.PLAIN, 50));
		lblAddAAgent.setBackground(Color.MAGENTA);
		lblAddAAgent.setBounds(156, 44, 501, 100);
		contentPane.add(lblAddAAgent);
		
		JButton button = new JButton("REGISTER");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(textField_1.getText().trim().equals("") || 
						textField_2.getText().trim().equals("")  ||
						textField.getText().trim().equals("") ) {
					DialogMessage.showWarningDialog("Empty register info!");
					return;
				}
				String addr= textField.getText();
				String ph=textField_1.getText().trim();
			    String name = textField_2.getText();
			    
			    

				if(!VerifyAdd_DeliveryAgent.verifyName(name)) {
					DialogMessage.showWarningDialog("Invalid  name format!");
					return;
				}		
				
				if(!VerifyAdd_DeliveryAgent.verifyAddress(addr)) {
					DialogMessage.showWarningDialog("Invalid address format!");
					return;
				}
				if(!VerifyAdd_DeliveryAgent.verifycontact(ph)) {
					DialogMessage.showWarningDialog("Invalid contact format!");
					return;
				}
				 
			    
			    
			    
			    
			    
			    int num = ConnectDB.Insert_agent(name, ph, addr);
			    if (num > 0) {
					DialogMessage.showInfoDialog("Registered successfully!!!");
					Delivery_Infor r = new Delivery_Infor();
					r.showFrame();
					setVisible(false);
			    }
			    
			}
		});
		button.setBounds(156, 402, 200, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("BACK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delivery_Infor r = new Delivery_Infor();
				r.showFrame();
				setVisible(false);
			}
		});
		button_1.setBounds(380, 402, 200, 50);
		contentPane.add(button_1);
	}
}
