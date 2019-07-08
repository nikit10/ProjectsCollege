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
import java.util.Vector;
import java.awt.event.ActionEvent;

public class OldBills extends JPanel {
	static int cust_id = 1;
	static String[] type = {"Hello","World"};
	
	public OldBills() throws SQLException {
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
        pane.setBounds(84, 129, 653, 255);
        add(pane);
        
        JButton button = new JButton("Back");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Generate_Bills r;
				try {
					r = new Generate_Bills();
					r.showFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JComponent comp = (JComponent) e.getSource();
      		  Window win = SwingUtilities.getWindowAncestor(comp);
      		  win.dispose();
        	}
        });
        button.setBounds(84, 46, 111, 40);
        add(button);
        
        JButton btnGenerate = new JButton("Generate");
      
        btnGenerate.setFont(new Font("Arial", Font.BOLD, 14));
        btnGenerate.setBounds(451, 46, 147, 40);
        add(btnGenerate);
        type = ConnectDB.getCustomerID();
        
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.generateOldsBill();
					table.setModel(tableModel);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
        	}
        });
    }

    public static void showFrame() throws SQLException {
        JPanel panel = new OldBills();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Generate Dockets");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

/*   public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					OldBills.showFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }*/
}