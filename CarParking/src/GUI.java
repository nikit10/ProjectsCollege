import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

public class GUI {

	private JFrame frmValetCarParking;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUI window = new GUI();
					window.frmValetCarParking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmValetCarParking = new JFrame();
		frmValetCarParking.setTitle("Valet Car Parking");
		frmValetCarParking.setBounds(100, 100, 442, 350);
		frmValetCarParking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmValetCarParking.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 574, 26);
		frmValetCarParking.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Action");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Search");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delivery");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("Car:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(129, 65, 32, 16);
		frmValetCarParking.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(246, 64, 116, 22);
		frmValetCarParking.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Car Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(64, 100, 100, 16);
		frmValetCarParking.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 99, 116, 22);
		frmValetCarParking.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Parking no. :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(64, 135, 116, 21);
		frmValetCarParking.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(246, 134, 116, 22);
		frmValetCarParking.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Park");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(246, 187, 116, 43);
		frmValetCarParking.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show all Cars");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(45, 187, 135, 43);
		frmValetCarParking.getContentPane().add(btnNewButton_1);
		LinkList list = new LinkList();
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String c = textField.getText();
				String cn = textField_1.getText();
				System.out.println(cn);
				Date d = new Date();
				list.insert(c, cn, d);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				list.printlist();
			}
		});
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Search.main(null, list);
			}
		});
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Delivery.main(null, list);
			}
		});
	}
}
