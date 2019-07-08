package Stocks;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import AdminPage.Admin_Page;
import Database_Classes.ConnectDB;
import Misc.DialogMessage;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Stocks_Infor extends JPanel {
	static int cust_id = 1;
	
	public Stocks_Infor() {
        initializeUI();    
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(588, 316));
        setLayout(null);

        JTable table = new JTable(0,0);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(64, 63, 458, 186);
        
        JButton btnGenerate = new JButton("Stocks");
        btnGenerate.setFont(new Font("Arial", Font.BOLD, 14));
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
	   			DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getStockInfo();
					table.setModel(tableModel);	
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        btnGenerate.setBounds(188, 13, 147, 25);
        add(btnGenerate);
        add(pane);
        
        JButton button = new JButton("Back");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JComponent comp = (JComponent) e.getSource();
        		  Window win = SwingUtilities.getWindowAncestor(comp);
        		  win.dispose();
        		  Admin_Page ad = new Admin_Page();
      			ad.setVisible(true);
        	}
        });
        button.setBounds(34, 13, 111, 25);
        add(button);
        
        JButton btnAddCustomers = new JButton("Low Stocks");
        btnAddCustomers.setFont(new Font("Arial", Font.BOLD, 12));
        btnAddCustomers.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
    	   			DefaultTableModel tableModel = new DefaultTableModel();
    					tableModel = ConnectDB.getLowStockInfo();
    					table.setModel(tableModel);	
            		} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
        		
        	}
        });
        btnAddCustomers.setBounds(381, 13, 162, 25);
        add(btnAddCustomers);
    }

    public static void showFrame() {
        JPanel panel = new Stocks_Infor();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Stocks");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Stocks_Infor.showFrame();
            }
        });
    }*/
}