import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Delivery {

	private JFrame frmDelivery;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public LinkList list;
	/**
	 * Launch the application.
	 * @param list 
	 */
	public static void main(String[] args, LinkList l) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delivery window = new Delivery(l);
					window.frmDelivery.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param list 
	 */
	public Delivery(LinkList l) {
		initialize();
		list = l;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDelivery = new JFrame();
		frmDelivery.setTitle("Delivery");
		frmDelivery.setBounds(100, 100, 443, 350);
		frmDelivery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDelivery.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Car:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(146, 76, 32, 16);
		frmDelivery.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("Car Number:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(77, 113, 100, 16);
		frmDelivery.getContentPane().add(label_2);
		
		JLabel lblParkingTime = new JLabel("Parking Time:");
		lblParkingTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblParkingTime.setBounds(77, 145, 115, 22);
		frmDelivery.getContentPane().add(lblParkingTime);
		
		JLabel lblDeliveryTime = new JLabel("Delivery Time:");
		lblDeliveryTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeliveryTime.setBounds(64, 183, 115, 16);
		frmDelivery.getContentPane().add(lblDeliveryTime);
		
		JLabel label_1 = new JLabel("Parking no. :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(80, 39, 113, 22);
		frmDelivery.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(204, 40, 116, 22);
		frmDelivery.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(204, 75, 116, 22);
		frmDelivery.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(204, 112, 116, 22);
		frmDelivery.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(204, 147, 116, 22);
		frmDelivery.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(204, 182, 116, 22);
		frmDelivery.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnDeliver = new JButton("Deliver");
		btnDeliver.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeliver.setBounds(204, 247, 116, 43);
		frmDelivery.getContentPane().add(btnDeliver);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCost.setBounds(135, 218, 46, 16);
		frmDelivery.getContentPane().add(lblCost);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(204, 217, 116, 22);
		frmDelivery.getContentPane().add(textField_5);
		
		btnDeliver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = Integer.parseInt(textField.getText());
				String c =list.search(n);
				String cn =list.searchcn(n);
				String pd =list.dat(n);
				String cost = list.cost(n);
				Date d = new Date();
				textField_1.setText(c);
				textField_2.setText(cn);
				textField_3.setText(pd);
				textField_4.setText(d.toString());
				textField_5.setText(cost);
			}
		});
	}

}
