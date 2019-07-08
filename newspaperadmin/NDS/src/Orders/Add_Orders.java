package Orders;

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

public class Add_Orders extends JFrame {

	private JPanel contentPane;
	static String[] type1 = {"Hello","World"};
	static String[] type2 = {"Hello","World"};

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Orders frame = new Add_Orders();
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
	public Add_Orders() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add a Order");
		lblNewLabel_1.setBackground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(205, 13, 501, 100);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("REGISTER");
		
		btnNewButton.setBounds(132, 346, 200, 50);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders_Infor r = new Orders_Infor();
				r.showFrame();
				setVisible(false);
				
			}
		});
		btnExit.setBounds(389, 346, 200, 50);
		contentPane.add(btnExit);
		type1 = ConnectDB.getDeliveryAreas();
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblCustomerId.setBounds(196, 147, 150, 50);
		contentPane.add(lblCustomerId);
		
		JComboBox customer_id_combo = new JComboBox();
		customer_id_combo.setBounds(355, 165, 200, 22);
		contentPane.add(customer_id_combo);
		
		type2 = ConnectDB.getCustomerID();
		customer_id_combo.setModel(new DefaultComboBoxModel<>(type2));
		
		JComboBox comboBox_1 = new JComboBox();
		type1 = ConnectDB.getStocksValues();
		comboBox_1.setModel(new DefaultComboBoxModel<>(type1));
		comboBox_1.setBounds(354, 258, 200, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblOrderItem = new JLabel("Order Item");
		lblOrderItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderItem.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblOrderItem.setBounds(196, 240, 150, 50);
		contentPane.add(lblOrderItem);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
									
				int custid = Integer.parseInt(customer_id_combo.getSelectedItem().toString());
				String order = comboBox_1.getSelectedItem().toString();
					int num = ConnectDB.insertOrder(custid, order);
					
					if (num > 0) {
						DialogMessage.showInfoDialog("Registered successfully!!!");
						setVisible(false);
						Orders_Infor r = new Orders_Infor();
						r.showFrame();
					}
				
			}
		});
	}
}
