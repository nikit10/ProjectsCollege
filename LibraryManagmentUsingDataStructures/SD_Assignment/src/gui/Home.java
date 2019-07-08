package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Home implements ActionListener{

	private JFrame frmLms;
	private JButton btnBinarySearchTree,btnHash;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmLms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLms = new JFrame();
		frmLms.setTitle("LMS");
		frmLms.setBounds(100, 100, 400, 400);
		frmLms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLms.getContentPane().setLayout(null);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLibraryManagementSystem.setBounds(75, 44, 200, 16);
		frmLms.getContentPane().add(lblLibraryManagementSystem);
		
		btnBinarySearchTree = new JButton("Binary Search Tree");
		btnBinarySearchTree.setBounds(110, 113, 156, 62);
		frmLms.getContentPane().add(btnBinarySearchTree);
		btnBinarySearchTree.addActionListener(this);
		
		btnHash = new JButton("Hash Table");
		btnHash.setBounds(110, 205, 156, 62);
		frmLms.getContentPane().add(btnHash);
		btnHash.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if(target==btnBinarySearchTree) {
			Bst o = new Bst();
			try {
				o.main(null);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(target==btnHash) {
			Hash k = new Hash();
			k.main(null);
		}
	}
}
