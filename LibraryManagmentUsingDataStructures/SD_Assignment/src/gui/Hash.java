package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Hash implements ActionListener{

	private JFrame frmHashTree;
	private JButton button,button_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hash window = new Hash();
					window.frmHashTree.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHashTree = new JFrame();
		frmHashTree.setTitle("Hash Table");
		frmHashTree.setBounds(100, 100, 450, 400);
		frmHashTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHashTree.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Library Management System");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(107, 54, 200, 16);
		frmHashTree.getContentPane().add(label);
		
		 button = new JButton("Issue Book");
		button.setBounds(131, 117, 138, 42);
		frmHashTree.getContentPane().add(button);
		button.addActionListener(this);
		 button_1 = new JButton("Return Book");
		button_1.setBounds(131, 213, 138, 42);
		frmHashTree.getContentPane().add(button_1);
		button.addActionListener(this);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if(target==button) {
			Issue p = new Issue(2);
			p.main(null, 2);
		}
		else if(target==button_1) {
			Return r = new Return(2);
			r.main(null, 2);
		}
	}

}
