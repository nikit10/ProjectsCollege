package Orders;
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

public class Customers_Orders_Infor extends JPanel {
	public static String item_id;
	public static String item_name;
	public static String item_price;
	public static String item_quantity;
	public static String item_type;
	
	public Customers_Orders_Infor() {
        initializeUI();    
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(801, 316));
        setLayout(null);

        JTable table = new JTable(0,0);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(84, 85, 653, 186);
        
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
				//	e1.printStackTrace();
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
        		  DeliveryPage dp = new DeliveryPage();
      			dp.setVisible(true);
        	}
        });
        button.setBounds(108, 13, 111, 40);
        add(button);
        
        JButton btnAddCustomers = new JButton("Customer Orders");
        btnAddCustomers.setFont(new Font("Arial", Font.BOLD, 12));
        btnAddCustomers.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
    	   			DefaultTableModel tableModel = new DefaultTableModel();
    					tableModel = ConnectDB.getOrdersInfo();
    					table.setModel(tableModel);	
            		} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    				//	e1.printStackTrace();
    				}
        		
        	}
        });
        btnAddCustomers.setBounds(546, 13, 162, 40);
        add(btnAddCustomers);
    }

    public static void showFrame() {
        JPanel panel = new Customers_Orders_Infor();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Customer Information");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

  /*  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Customers_Orders_Infor.showFrame();
            }
        });
    }*/
}