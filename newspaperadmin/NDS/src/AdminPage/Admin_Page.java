package AdminPage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Billing.DefaulterList;
import Billing.Generate_Bills;
import Customer.Customer_Infor;
import Delivery.AssignDeliveryAreas;
import Delivery.Delivery_Dockets_Info;
import Delivery.Delivery_Infor;
import LoginPackage.LoginFrame;
import Orders.Orders_Infor;
import Stocks.Stocks_Infor;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Admin_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Page frame = new Admin_Page();
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
	public Admin_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddCustomers = new JButton("Customers Info");
		btnAddCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			Customer_Infor r = new Customer_Infor();
			r.showFrame();
			
			}
		});
		btnAddCustomers.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddCustomers.setBounds(73, 87, 221, 29);
		contentPane.add(btnAddCustomers);
		
		JButton btnStocksInfo = new JButton("Stocks Info");
		btnStocksInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stocks_Infor r = new Stocks_Infor();
				r.showFrame();
				setVisible(false);
			}
		});
		btnStocksInfo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnStocksInfo.setBounds(350, 87, 207, 29);
		contentPane.add(btnStocksInfo);
		
		JButton btnDeliveryPersonInfo = new JButton("Delivery Person Info");
		btnDeliveryPersonInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delivery_Infor r = new Delivery_Infor();
				r.showFrame();
				setVisible(false);
				
			}
		});
		btnDeliveryPersonInfo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeliveryPersonInfo.setBounds(73, 174, 221, 29);
		contentPane.add(btnDeliveryPersonInfo);
		
		JButton btnDeliveryDockets = new JButton("Delivery Dockets");
		btnDeliveryDockets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					
					try {
						Delivery_Dockets_Info r;
						r = new Delivery_Dockets_Info();
						r.showFrame();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
					setVisible(false);
				
				
			}
		});
		btnDeliveryDockets.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeliveryDockets.setBounds(350, 174, 207, 29);
		contentPane.add(btnDeliveryDockets);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 119, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmLogout = new JMenuItem("LogOut");
		mntmLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame l = new LoginFrame();
				setVisible(false);
				l.setVisible(true);
			}
		});
		mnNewMenu.add(mntmLogout);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Orders_Infor r;
				r = new Orders_Infor();
				r.showFrame();
				setVisible(false);
			}
		});
		btnOrder.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnOrder.setBounds(73, 244, 221, 29);
		contentPane.add(btnOrder);
		
		JButton btnBilling = new JButton("Billing");
		btnBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {

					Generate_Bills r;
					r = new Generate_Bills();
					r.showFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnBilling.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBilling.setBounds(350, 244, 221, 29);
		contentPane.add(btnBilling);
		
		JButton btnPaymentStatus = new JButton("Payment Status");
		btnPaymentStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Payment_state a;
				try {
					a = new Admin_Payment_state();
					a.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPaymentStatus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnPaymentStatus.setBounds(73, 315, 221, 29);
		contentPane.add(btnPaymentStatus);
		
		JButton btnDefaulters = new JButton("Defaulters");
		btnDefaulters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaulterList r;
				
				try {
					r = new DefaulterList();
					r.showFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnDefaulters.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDefaulters.setBounds(350, 315, 221, 29);
		contentPane.add(btnDefaulters);
		
		JButton btnAdminStatus = new JButton("Admin Status");
		btnAdminStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_status window;
				window = new Admin_status();
			window.frmMyAvailability.setVisible(true);
			setVisible(false);
			}
		});
		btnAdminStatus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdminStatus.setBounds(219, 378, 221, 29);
		contentPane.add(btnAdminStatus);
	}
}
