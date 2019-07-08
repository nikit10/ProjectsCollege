package Delivery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Delivery_Page.DeliveryPage;
import Misc.DialogMessage;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Delivery_Status extends JFrame {

	private JPanel contentPane;
	private JLabel lblCustomer;
	String[] type = {"1","2"};

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delivery_Status frame = new Delivery_Status();
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
	public Delivery_Status() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerid = new JLabel("Order ID");
		lblCustomerid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCustomerid.setBounds(64, 69, 113, 13);
		contentPane.add(lblCustomerid);
		
		lblCustomer = new JLabel("Delivery Status");
		lblCustomer.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCustomer.setBounds(64, 120, 132, 13);
		contentPane.add(lblCustomer);
		
		JButton btnNewButton = new JButton("SET STATUS");
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(265, 178, 156, 21);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Delivered", "Not Delivered"}));
		comboBox.setBounds(246, 118, 96, 21);
		contentPane.add(comboBox);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryPage dp = new DeliveryPage();
				dp.setVisible(true);
				setVisible(false);
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(74, 178, 127, 21);
		contentPane.add(btnBack);
		
		JComboBox comboBox_1 = new JComboBox();
		type = ConnectDB.getOrderIds();
		comboBox_1.setModel(new DefaultComboBoxModel<>(type));
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_1.setBounds(246, 69, 96, 21);
		contentPane.add(comboBox_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 try {
				 int a = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				 int b = 0;
				 String c = comboBox.getSelectedItem().toString();
				if(c.equals("Delivered"))
				{
					b = 1;
				}
				int num = ConnectDB.setDeliveryStatus(a,b);
				 if(num>0)
				 {
				DialogMessage.showInfoDialog("Updated Successfully");
				 }
				 else
				 {
					 DialogMessage.showWarningDialog("Status Not Updated");
				 }
				 } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
	}
}
