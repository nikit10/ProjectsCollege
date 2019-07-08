package Delivery_Page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Customer.Customer_Infor;
import Delivery.Agent_Generate_Dockets;
import Delivery.Delivery_Dockets_Info;
import Delivery.Delivery_Status;
import LoginPackage.LoginFrame;
import Orders.Customers_Orders_Infor;
import Orders.Payment_Status;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class DeliveryPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryPage frame = new DeliveryPage();
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
	public DeliveryPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeliveryStatus = new JButton("Delivery Status");
		btnDeliveryStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Delivery_Status ds;
			try {
				ds = new Delivery_Status();
				ds.setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}
		});
		btnDeliveryStatus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeliveryStatus.setBounds(313, 104, 178, 29);
		contentPane.add(btnDeliveryStatus);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers_Orders_Infor r = new Customers_Orders_Infor();
				r.showFrame();
			setVisible(false);
			}
		});
		btnOrders.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOrders.setBounds(50, 104, 178, 29);
		contentPane.add(btnOrders);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 119, 26);
		contentPane.add(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmLogout = new JMenuItem("LogOut");
		mntmLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame l = new LoginFrame();
				l.setVisible(true);
				setVisible(false);
			}
		});
		mnOptions.add(mntmLogout);
		
		JButton btnGenerateDockets = new JButton("Generate Dockets");
		btnGenerateDockets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Agent_Generate_Dockets r;
					r = new Agent_Generate_Dockets();
					r.showFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				}
				
			setVisible(false);
			}
		});
		btnGenerateDockets.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnGenerateDockets.setBounds(50, 167, 178, 29);
		contentPane.add(btnGenerateDockets);
		
		JButton btnItemsRequired = new JButton("Items Required");
		btnItemsRequired.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Delivery_Items r;
					r = new Delivery_Items();
					r.showFrame();
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		btnItemsRequired.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnItemsRequired.setBounds(313, 167, 178, 29);
		contentPane.add(btnItemsRequired);
		
		JButton btnPaymentStatus = new JButton("Payment Status");
		btnPaymentStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment_Status p;
				try {
					p = new Payment_Status();
					p.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnPaymentStatus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnPaymentStatus.setBounds(50, 221, 178, 29);
		contentPane.add(btnPaymentStatus);
	}
}
