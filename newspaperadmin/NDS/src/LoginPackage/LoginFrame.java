package LoginPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AdminPage.Admin_Page;
import Database_Classes.ConnectDB;
import Delivery_Page.DeliveryPage;
import Misc.DialogMessage;
import Validation.Verifycustomer;
import Validation.Verifyloginframe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_userid;
	private JPasswordField txt_pwd;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginId = new JLabel("Login ID:");
		lblLoginId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLoginId.setBounds(74, 31, 73, 34);
		contentPane.add(lblLoginId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(74, 75, 73, 34);
		contentPane.add(lblPassword);
		
		txt_userid = new JTextField();
		txt_userid.setText("admin");
		txt_userid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txt_userid.setBounds(197, 39, 96, 19);
		contentPane.add(txt_userid);
		txt_userid.setColumns(10);
		
		txt_pwd = new JPasswordField();
		txt_pwd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txt_pwd.setBounds(197, 83, 96, 19);
		txt_pwd.setText("abcd1234");
		contentPane.add(txt_pwd);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt_pwd.getText().trim().equals("") || 
						txt_userid.getText().trim().equals("") ) {
					DialogMessage.showWarningDialog("Wrong Credentials!");
					return;
				}
				
				
				String uid = txt_userid.getText();
				String password = new String(txt_pwd.getPassword());
				
				
				if(!Verifyloginframe.verifycustomer_id(uid)) {
					DialogMessage.showWarningDialog("Invalid  User ID format!");
					return;
				}			
				
				if(!Verifyloginframe.verifyPasswordFormat(password)) {
					DialogMessage.showWarningDialog("Invalid  Password format!");
					return;
				}
				
				
				
				try {
					int a = ConnectDB.Login(uid,password);
					if(a==0)
					{
						setVisible(false);
						DialogMessage.showInfoDialog("Logged IN as Admin");
						Admin_Page admin = new Admin_Page();
						admin.setVisible(true);
					}
					else if(a==2)
					{
						DialogMessage.showInfoDialog("Logged IN as Delivery Person");
						DeliveryPage dp = new DeliveryPage();
						dp.setVisible(true);
						setVisible(false);
					}
					else 
					{
						DialogMessage.showWarningDialog("Wrong Credentials");
					}
				} catch (NoSuchAlgorithmException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogin.setBounds(51, 135, 96, 29);
		contentPane.add(btnLogin);
		
		JButton btnForgot = new JButton("FORGOT");
		btnForgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Forgot_Pass f = new Forgot_Pass();
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnForgot.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnForgot.setBounds(174, 135, 119, 29);
		contentPane.add(btnForgot);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Register_Login r = new Register_Login();
			r.setVisible(true);
			setVisible(false);
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnRegister.setBounds(105, 186, 119, 29);
		contentPane.add(btnRegister);
		
		
	}
	
	}

