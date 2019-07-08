package Billing;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import AdminPage.Admin_Page;
import Database_Classes.ConnectDB;
import Delivery_Page.DeliveryPage;
import Misc.DialogMessage;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DefaulterList extends JPanel {
	static int cust_id = 1;
	static String[] type = {"Hello","World"};
	
	public DefaulterList() throws SQLException {
        initializeUI();    
    }

    public void initializeUI() throws SQLException {
        setPreferredSize(new Dimension(801, 465));
        setLayout(null);

        JTable table = new JTable(0,0);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(84, 198, 653, 186);
        add(pane);
        
        JButton button = new JButton("Back");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Admin_Page ap = new Admin_Page();
				ap.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
      		  Window win = SwingUtilities.getWindowAncestor(comp);
      		  win.dispose();
        	}
        });
        button.setBounds(84, 97, 111, 40);
        add(button);
        
        JButton btnGenerate = new JButton("Generate");
      
        btnGenerate.setFont(new Font("Arial", Font.BOLD, 14));
        btnGenerate.setBounds(290, 97, 147, 40);
        add(btnGenerate);
        
        JButton btnPrintDockets = new JButton("Print List");
        btnPrintDockets.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        
        		int count= table.getModel().getRowCount();
        		if (count ==0)
        		{
        			DialogMessage.showInfoDialog("First Generate Dockets");
        		}
        		else if(count>0)
        		{
        			try {
        	
					boolean res = table.print();
					if(res == true)
					{
						DialogMessage.showInfoDialog("Printed Succesfully");
					}
					else
					{
						DialogMessage.showWarningDialog("Not Printed");
					}
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
        		}
        			
        		  }
        	
        });
        btnPrintDockets.setFont(new Font("Arial", Font.BOLD, 12));
        btnPrintDockets.setBounds(522, 97, 162, 40);
        add(btnPrintDockets);
        type = ConnectDB.getDeliveryAreas();
        
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				
				
				
				try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getDefaulterInfor();
					table.setModel(tableModel);	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
        	}
        });
    }

    public static void showFrame() throws SQLException {
        JPanel panel = new DefaulterList();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Generate Dockets");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

  /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					DefaulterList.showFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
*/}