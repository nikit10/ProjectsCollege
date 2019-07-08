import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Search {

	private JFrame frmSearch;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	LinkList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, LinkList l) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search(l);
					window.frmSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search(LinkList list) {
		initialize();
		this.list = list;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setTitle("Search");
		frmSearch.setBounds(100, 100, 442, 350);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Parking no. :");
		label.setBounds(79, 71, 113, 22);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmSearch.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Car Number:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(77, 166, 100, 16);
		frmSearch.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Car:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(145, 120, 32, 16);
		frmSearch.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(211, 73, 116, 22);
		frmSearch.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(211, 119, 116, 22);
		frmSearch.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(211, 165, 116, 22);
		frmSearch.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(211, 210, 116, 43);
		frmSearch.getContentPane().add(btnSearch);
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = Integer.parseInt(textField.getText());
				System.out.println(n);
				String c = list.search(n);
				String cn = list.searchcn(n);
				
				textField_1.setText(c);
				textField_2.setText(cn);
			}
		});
	}

}
