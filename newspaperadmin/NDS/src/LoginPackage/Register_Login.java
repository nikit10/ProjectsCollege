package LoginPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;
import Validation.VeriftRegister_Login;
import Validation.Verifycustomer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.awt.event.ActionEvent;

public class Register_Login extends JFrame {

	private JPanel contentPane;
	private JTextField uid;
	private JPasswordField pwd1;
	private JPasswordField reenterpwd;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Login frame = new Register_Login();
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
	public Register_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter USERID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(87, 46, 113, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(87, 88, 120, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Re Enter Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(87, 124, 132, 13);
		contentPane.add(lblNewLabel_2);
		
		uid = new JTextField();
		uid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		uid.setColumns(10);
		uid.setBounds(231, 44, 96, 19);
		contentPane.add(uid);
		
		JButton btnReg = new JButton("Register");
		
		btnReg.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnReg.setBounds(208, 166, 119, 29);
		contentPane.add(btnReg);
		
		pwd1 = new JPasswordField();
		pwd1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pwd1.setBounds(231, 86, 96, 19);
		contentPane.add(pwd1);
		
		reenterpwd = new JPasswordField();
		reenterpwd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		reenterpwd.setBounds(231, 122, 96, 19);
		contentPane.add(reenterpwd);
		
		JButton btn_back = new JButton("BACK");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame l = new LoginFrame();
				setVisible(false);
				l.setVisible(true);	
			}
		});
		btn_back.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_back.setBounds(71, 166, 119, 29);
		contentPane.add(btn_back);
		
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(reenterpwd.getText().trim().equals("") || 
						pwd1.getText().trim().equals("") || uid.getText().trim().equals("") ) {
					DialogMessage.showWarningDialog("Empty register info!");
					return;
				}	
				
				
			String username = uid.getText();
			String encoded_password;
			String password = new String(pwd1.getPassword());
			String password1 = new String(reenterpwd.getPassword());

			if(!password.equals(password1)) {
				DialogMessage.showWarningDialog("Invalid  the same password!");
				return;
			}
			if(!VeriftRegister_Login.verifyuserid(username)) {
				DialogMessage.showWarningDialog("Invalid  uid format!");
				return;
			}			
			
			if(!VeriftRegister_Login.verifyPasswordFormat(password)) {
				DialogMessage.showWarningDialog("Invalid  Password format!");
				return;
			}			
			
			if(!VeriftRegister_Login.verifyRenterPasswordFormat(password1)) {
				DialogMessage.showWarningDialog("Invalid Password format!");
				return;
			}
			
			
			
			
			if(password1.equals(password))
			{
	
				try {
					encoded_password = encodePwd(password);
					ConnectDB.Register_user(username,encoded_password);
					setVisible(false);
					DialogMessage.showInfoDialog("Registered");
					LoginFrame lf = new LoginFrame();
					lf.setVisible(true);
				
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
		//			e1.printStackTrace();
				}
				
			}
			else
			{
				DialogMessage.showWarningDialog("Passwords Dont Match");
			}
			
			
			}
		});
	}
	
	
	
	private static String encodePwd(String value) throws NoSuchAlgorithmException {
		byte[] sBytes = value.getBytes() ;
		String encodedString = Base64.getEncoder().encodeToString(sBytes);
		return encodedString;
	
	}
	
	private static String decodePwd(String value) throws NoSuchAlgorithmException {
		byte[] decodedBytes = Base64.getDecoder().decode(value);
		String decodedString = new String(decodedBytes);
		return decodedString;
	
	}
}
