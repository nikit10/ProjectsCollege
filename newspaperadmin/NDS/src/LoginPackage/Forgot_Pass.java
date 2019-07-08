package LoginPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.awt.event.ActionEvent;

public class Forgot_Pass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot_Pass frame = new Forgot_Pass();
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
	public Forgot_Pass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(215, 40, 96, 19);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		passwordField.setBounds(215, 82, 96, 19);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("Enter Password");
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label.setBounds(71, 84, 120, 13);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Re Enter Password");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setBounds(71, 120, 132, 13);
		contentPane.add(label_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setEditable(false);
		passwordField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		passwordField_1.setBounds(215, 118, 96, 19);
		contentPane.add(passwordField_1);
		
		JLabel label_2 = new JLabel("Enter USERID");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_2.setBounds(71, 42, 113, 13);
		contentPane.add(label_2);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LoginFrame l = new LoginFrame();
			l.setVisible(true);
			setVisible(false);
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button.setBounds(72, 162, 119, 29);
		contentPane.add(button);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String encoded_password;
				String password = new String(passwordField.getPassword());
				String password1 = new String(passwordField_1.getPassword());
				String username = textField.getText();
				if(password1.equals(password))
				{
		
					try {
					
						encoded_password = encodePwd(password);
					int num =	ConnectDB.update_password(username,encoded_password);
					if(num>0)
					{
					setVisible(false);
						DialogMessage.showInfoDialog("Password Updated");
						LoginFrame lf = new LoginFrame();
						lf.setVisible(true);
					}
					else
					{
						DialogMessage.showInfoDialog("Error in Updating Password");
					}
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
				{
					DialogMessage.showWarningDialog("Passwords Dont Match");
				
			}
			}
		});
		btnChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnChangePassword.setBounds(225, 162, 177, 29);
		contentPane.add(btnChangePassword);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = ConnectDB.checkUserID(textField.getText());
					if(n==1)
					{
						textField.setEditable(false);
						DialogMessage.showInfoDialog("Enter new Password");
						passwordField.setEditable(true);
						passwordField_1.setEditable(true);
					}
					else if(n==0)
					{
						DialogMessage.showWarningDialog("Enter Correct User ID");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
	//				e1.printStackTrace();
				}
			}
		});
		btnCheck.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCheck.setBounds(328, 37, 96, 29);
		contentPane.add(btnCheck);
	}
	
	private static String encodePwd(String value) throws NoSuchAlgorithmException {
		byte[] sBytes = value.getBytes() ;
		String encodedString = Base64.getEncoder().encodeToString(sBytes);
		return encodedString;
	
	}
}
