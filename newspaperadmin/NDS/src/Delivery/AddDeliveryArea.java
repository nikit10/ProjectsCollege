package Delivery;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;
import Validation.Verifycustomer;
import Validation.verifyAddDeliveryArea;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AddDeliveryArea implements ActionListener{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnAddArea,btnDeleteArea;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDeliveryArea window = new AddDeliveryArea();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public AddDeliveryArea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 245);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeliveryAreaNo = new JLabel("Delivery Area No.");
		lblDeliveryAreaNo.setBounds(30, 50, 150, 20);
		frame.getContentPane().add(lblDeliveryAreaNo);
		
		textField = new JTextField();
		textField.setBounds(200, 50, 150, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 100, 150, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAreaName = new JLabel("Area Name:");
		lblAreaName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreaName.setBounds(30, 100, 150, 20);
		frame.getContentPane().add(lblAreaName);
		
		btnAddArea = new JButton("Add Area");
		btnAddArea.setBounds(58, 136, 97, 25);
		frame.getContentPane().add(btnAddArea);
		btnAddArea.addActionListener(this);
		
		btnDeleteArea = new JButton("Delete Area");
		btnDeleteArea.setBounds(210, 136, 113, 25);
		frame.getContentPane().add(btnDeleteArea);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Delivery_Infor r = new Delivery_Infor();
				r.showFrame();
			}
		});
		btnBack.setBounds(355, 136, 97, 25);
		frame.getContentPane().add(btnBack);
		btnDeleteArea.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(textField_1.getText().trim().equals("") || 
				textField.getText().trim().equals("")  ) {
			DialogMessage.showWarningDialog("Empty register info!");
			return;
		}
		
		
		Object target=e.getSource();
		int id = Integer.parseInt(textField.getText());
		String nam = textField_1.getText();
		
		
	if(!verifyAddDeliveryArea.DeliveryAreaNo(id)) {
			DialogMessage.showWarningDialog("Invalid  id format!(0-20)");
			return;
		}			
		
		if(!verifyAddDeliveryArea.AreaName(nam)) {
			DialogMessage.showWarningDialog("Invalid  nam format!");
			return;
		}	
		
		
		
		
		
		if(target==btnAddArea) {
			try {
				int num = ConnectDB.addDeliveryArea(id, nam);
				if(num > 0) {
					DialogMessage.showInfoDialog("Delivery Area Added!");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			
			
			
			
			
			
		}
		else {
			try {
				ConnectDB.deleteDeliveryArea(id);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
	}
}
