package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Return implements ActionListener {

	private JFrame frmReturn;
	private JTextField textField_1;
	private JTextField textField_3;
	private JButton btnReturn;
	public int flag = 0;
	public static BSTree bstree= BSTree.getInstance();
	public static HashTable htable=HashTable.getInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return window = new Return(i);
					window.frmReturn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Return(int i) {
		flag = i;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReturn = new JFrame();
		frmReturn.setTitle("Return");
		frmReturn.setBounds(100, 100, 450, 400);
		frmReturn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReturn.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("Book ID:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(95, 141, 63, 16);
		frmReturn.getContentPane().add(label_1);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReturnBook.setBounds(146, 59, 100, 16);
		frmReturn.getContentPane().add(lblReturnBook);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 142, 116, 22);
		frmReturn.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFine = new JLabel("Fine:");
		lblFine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFine.setBounds(128, 208, 35, 16);
		frmReturn.getContentPane().add(lblFine);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setEnabled(false);
		textField_3.setBounds(181, 206, 116, 22);
		frmReturn.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnReturn = new JButton("Return");
		btnReturn.setBounds(123, 266, 138, 42);
		frmReturn.getContentPane().add(btnReturn);
		btnReturn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if(target==btnReturn) {
			if(flag==1) {
				int i = Integer.parseInt(textField_1.getText());
				Node x = bstree.search(i);
				if(x == null) {
					System.out.println("Book not found!!");
				}
				else {
				try {
					String yo = bstree.cost(x);
					textField_3.setText(yo);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
			else if(flag==2) {
				int i = Integer.parseInt(textField_1.getText());
				HNode x = htable.search(i);
				if(x == null) {
					System.out.println("Book not found!!");
				}
				else {
				try {
					String yo = htable.cost(x);
					textField_3.setText(yo);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		}
	}

}
