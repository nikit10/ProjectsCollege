package AdminPage;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_Classes.ConnectDB;
import Delivery.Delivery_Infor;
import Misc.DialogMessage;

public class Admin_status implements ActionListener{

	 JFrame frmMyAvailability;
	private JTextField textField;
	private JComboBox comboBox;
	private JButton btnSetStatus;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_status window = new Admin_status();
					window.frmMyAvailability.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Admin_status() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyAvailability = new JFrame();
		frmMyAvailability.setTitle("My Availability");
		frmMyAvailability.setBounds(100, 100, 450, 300);
		frmMyAvailability.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyAvailability.getContentPane().setLayout(null);
		
		JLabel lblSetStatus = new JLabel("Current Status:");
		lblSetStatus.setBounds(68, 55, 95, 16);
		frmMyAvailability.getContentPane().add(lblSetStatus);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Available", "Unavailable"}));
		comboBox.setBounds(68, 109, 95, 22);
		frmMyAvailability.getContentPane().add(comboBox);
		
		
		btnSetStatus = new JButton("Set Status");
		btnSetStatus.setBounds(197, 108, 97, 25);
		frmMyAvailability.getContentPane().add(btnSetStatus);
		btnSetStatus.addActionListener(this);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(178, 52, 116, 22);
		frmMyAvailability.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMyAvailability.dispose();
				Admin_Page ap = new Admin_Page();
				ap.setVisible(true);
			}
		});
		btnBack.setBounds(126, 174, 97, 25);
		frmMyAvailability.getContentPane().add(btnBack);
		
		int stat = ConnectDB.getAdminStatus();
		if(stat==1) {
			textField.setText("Available");
		}
		else {
			textField.setText("Unavailable");

		}
	}

	public void changeStatus() {
		int stat = ConnectDB.getAdminStatus();
		if(stat==1) {
			textField.setText("Available");
		}
		else {
			textField.setText("Unavailable");
			performActions();
		}
	}

	public static int calcCount(int[] arr) {
		int l = 0;
		for (int i = 0; i < arr.length; i ++) {
		    if (arr[i]!=0)l++;
		}
		return l;
	}
	//This function assigns the areas to agents
	public static void performActions() {
		int[] agentIds,areaIds,asArea;
		agentIds = ConnectDB.getUnassignedAgentIds();
		areaIds = ConnectDB.getAreaIds();
		asArea = ConnectDB.getAssignedAreaIds();
		int temp;
		int i=calcCount(areaIds);
		int l=calcCount(agentIds);
		if(l<i) {
			temp = l;
			l = i;
			i = temp;
		}
			
			temp=0;
			System.out.println(areaIds[0]);
			while(i>temp) {
				ConnectDB.updateForUnassigned(agentIds[temp], areaIds[temp]);
				//System.out.println("in while");
				temp++;
			}
			DialogMessage.showInfoDialog("Delivery Persons are assigned their Areas");
		
		//System.out.println(calcCount(agentIds));
		//System.out.println(calcCount(areaIds));
	}

			

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if(target==btnSetStatus) {
			int i = comboBox.getSelectedIndex();
			if(i==1) {
				ConnectDB.setAdminStatus(0);
			}
			else {
				ConnectDB.setAdminStatus(1);
			}
			changeStatus();
		}
	}
}



