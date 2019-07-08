package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Bst implements ActionListener {

	private JFrame frmBst;
	private JButton btnNewButton,btnReturnBook;
	
	
	/**
	 * Launch the application.
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		BSTree bstree= BSTree.getInstance();
		HashTable htable=HashTable.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bst window = new Bst();
					window.frmBst.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bst() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmBst = new JFrame();
		frmBst.setTitle("BST");
		frmBst.setBounds(100, 100, 450, 400);
		frmBst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBst.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("Issue Book");
		btnNewButton.setBounds(131, 110, 138, 42);
		frmBst.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		JLabel label = new JLabel("Library Management System");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(105, 37, 200, 16);
		frmBst.getContentPane().add(label);
		
		btnReturnBook = new JButton("Return Book");
		btnReturnBook.setBounds(131, 184, 138, 42);
		frmBst.getContentPane().add(btnReturnBook);
		btnReturnBook.addActionListener(this);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if(target==btnNewButton) {
			Issue p = new Issue(1);
			p.main(null, 1);
		}
		else if(target==btnReturnBook){
			Return r = new Return(1);
			r.main(null, 1);
		}
	}
}
