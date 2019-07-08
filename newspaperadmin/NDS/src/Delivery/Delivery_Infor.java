package Delivery;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import AdminPage.Admin_Page;
import Database_Classes.ConnectDB;
import Delivery_Page.DeliveryPage;
import Misc.DialogMessage;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Delivery_Infor extends JPanel {
	static int cust_id = 1;
	public Delivery_Infor() {
        initializeUI();    
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(801, 407));
        setLayout(null);

        JTable table = new JTable(0,0);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(84, 171, 653, 186);
        
        JButton btnGenerate = new JButton("Delivery Info");
        btnGenerate.setFont(new Font("Arial", Font.BOLD, 14));
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
	   			DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getDeliveryAgentInfo();
					table.setModel(tableModel);	
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        btnGenerate.setBounds(314, 13, 147, 40);
        add(btnGenerate);
        add(pane);
        
        JButton button = new JButton("Back");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JComponent comp = (JComponent) e.getSource();
        		  Window win = SwingUtilities.getWindowAncestor(comp);
        		  win.dispose();
        		 Admin_Page dp = new Admin_Page();
      			dp.setVisible(true);
        	}
        });
        button.setBounds(108, 13, 111, 40);
        add(button);
        
        JButton btnAddCustomers = new JButton("Add Delivery Agent");
        btnAddCustomers.setFont(new Font("Arial", Font.BOLD, 12));
        btnAddCustomers.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Add_DeliveryAgent a = new Add_DeliveryAgent();
				a.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
      		  Window win = SwingUtilities.getWindowAncestor(comp);
      		  win.dispose();
        	}
        });
        btnAddCustomers.setBounds(546, 13, 162, 40);
        add(btnAddCustomers);
        
        JButton btnAssignDeliveryArea = new JButton("Assign Delivery Area");
        btnAssignDeliveryArea.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				try {
					AssignDeliveryAreas window;
					window = new AssignDeliveryAreas();
					window.frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				JComponent comp = (JComponent) e.getSource();
	      		  Window win = SwingUtilities.getWindowAncestor(comp);
	      		  win.dispose();
        	}
        });
        btnAssignDeliveryArea.setFont(new Font("Arial", Font.BOLD, 12));
        btnAssignDeliveryArea.setBounds(416, 78, 162, 40);
        add(btnAssignDeliveryArea);
        
        JButton btnAddDeliveryArea = new JButton("Add Delivery Area");
        btnAddDeliveryArea.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		AddDeliveryArea window = new AddDeliveryArea();
        		window.frame.setVisible(true);
        	
			JComponent comp = (JComponent) e.getSource();
      		  Window win = SwingUtilities.getWindowAncestor(comp);
      		  win.dispose();
        	}
        });
        btnAddDeliveryArea.setFont(new Font("Arial", Font.BOLD, 12));
        btnAddDeliveryArea.setBounds(132, 78, 162, 40);
        add(btnAddDeliveryArea);
    }

    public static void showFrame() {
        JPanel panel = new Delivery_Infor();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Delivery Information");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

  /*  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Delivery_Infor.showFrame();
            }
        });
    }*/
}