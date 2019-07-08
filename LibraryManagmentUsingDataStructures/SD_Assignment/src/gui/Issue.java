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

public class Issue implements ActionListener{

	private JFrame frmIssueBook;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnIssue,btnSearch;
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
					Issue window = new Issue(i);
					window.frmIssueBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Issue(int i) {
		flag = i;
		initialize();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIssueBook = new JFrame();
		frmIssueBook.setTitle("Issue Book");
		frmIssueBook.setBounds(100, 100, 450, 400);
		frmIssueBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIssueBook.getContentPane().setLayout(null);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIssueBook.setBounds(145, 57, 100, 16);
		frmIssueBook.getContentPane().add(lblIssueBook);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentId.setBounds(69, 105, 82, 16);
		frmIssueBook.getContentPane().add(lblStudentId);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookName.setBounds(64, 166, 87, 16);
		frmIssueBook.getContentPane().add(lblBookName);
		
		JLabel lblBookId = new JLabel("Book ID:");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookId.setBounds(88, 137, 63, 16);
		frmIssueBook.getContentPane().add(lblBookId);
		
		textField = new JTextField();
		textField.setBounds(184, 103, 116, 22);
		frmIssueBook.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 135, 116, 22);
		frmIssueBook.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 164, 116, 22);
		frmIssueBook.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnIssue = new JButton("Issue");
		btnIssue.setBounds(69, 234, 138, 42);
		frmIssueBook.getContentPane().add(btnIssue);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(264, 234, 116, 42);
		frmIssueBook.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
		btnIssue.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		int k,i;
		
		String nm = textField_2.getText();
		if(flag==1) {
			
			try { 

				if(target==btnIssue) {
					i = Integer.parseInt(textField.getText());
					k = Integer.parseInt(textField_1.getText());
					//obj.insert(k, i, nm);	
					bstree.insert(k, i, nm);
			}
			else if(target==btnSearch) {
				k = Integer.parseInt(textField_1.getText());	
				Node x = bstree.search(k);
				if(x == null) {
					System.out.println("Book not found!!");
				}
				else {
			//	System.out.println(k);
			//	System.out.println(x.bname);
				int id = x.readId();
				textField.setText(""+id);
				textField_2.setText(x.bname);
				}
			}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
		}
		else if(flag==2) {
			if(target==btnIssue) {
				i = Integer.parseInt(textField.getText());
				k = Integer.parseInt(textField_1.getText());

				String nm1 = textField_2.getText();
				try {
					htable.insert(k, i, nm1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(target==btnSearch) {
				k = Integer.parseInt(textField_1.getText());
				HNode l = htable.search(k);
				if(l == null) {
					System.out.println("Book not found!!");
				}
				else {
				int id = l.readId();
				textField.setText(""+id);
				textField_2.setText(l.bname);
				}
			}
		}
	}
}
