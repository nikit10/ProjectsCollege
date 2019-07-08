package Delivery;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import javax.swing.JButton;

public class AssignDeliveryAreas {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignDeliveryAreas window = new AssignDeliveryAreas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public AssignDeliveryAreas() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 401, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ResultSet rs;
		rs = ConnectDB.getDeliveryAreasID();
		int ident;
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 56, 123, 22);
		frame.getContentPane().add(comboBox);
		while(rs.next()) {
			ident = rs.getInt("delivery_area_id");
			comboBox.addItem(ident);
		}
		
		JLabel lblDeliveryArea = new JLabel("Delivery Area:");
		lblDeliveryArea.setBounds(35, 59, 88, 16);
		frame.getContentPane().add(lblDeliveryArea);
		rs = null;
		rs = ConnectDB.getDeliveryAgentID();
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(158, 115, 123, 22);
		frame.getContentPane().add(comboBox_1);
		while(rs.next()) {
			/*System.out.println(rs);*/
			ident = rs.getInt("agent_id");
			comboBox_1.addItem(ident);
		}
		JLabel lblDeliveryAgentId = new JLabel("Delivery Agent Id:");
		lblDeliveryAgentId.setBounds(12, 118, 111, 16);
		frame.getContentPane().add(lblDeliveryAgentId);
		
		JButton btnNewButton = new JButton("Assig Area");
		btnNewButton.setBounds(112, 186, 97, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Delivery_Infor r = new Delivery_Infor();
				r.showFrame();
			}
		});
		btnBack.setBounds(243, 186, 97, 38);
		frame.getContentPane().add(btnBack);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ai = Integer.parseInt(comboBox.getSelectedItem().toString());
				int di = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				ConnectDB.assignArea(ai, di);
				DialogMessage.showInfoDialog("Delivery Area Assigned!");
			}
		});
	}
}
