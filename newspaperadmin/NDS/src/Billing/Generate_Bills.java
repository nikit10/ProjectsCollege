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

public class Generate_Bills extends JPanel {
	static int cust_id = 1;
	static String[] type = {"Hello","World"};
	
	public Generate_Bills() throws SQLException {
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
        
        JButton btnPrintDockets = new JButton("Print Dockets");
        btnPrintDockets.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        
        		int count= table.getModel().getRowCount();
        		if (count ==0)
        		{
        			DialogMessage.showInfoDialog("First Generate Dockets");
        		}
        		else if(count==1)
        		{
        			DialogMessage.showInfoDialog("No Orders for this ID");
        		}
        		else if(count>1)
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
        
        JComboBox comboBox = new JComboBox();
        type = ConnectDB.getCustomerID();
		comboBox.setModel(new DefaultComboBoxModel<>(type));
        comboBox.setBounds(362, 28, 137, 22);
        add(comboBox);
        
        JLabel lblCustomerId = new JLabel("Customer ID");
        lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblCustomerId.setBounds(207, 29, 132, 19);
        add(lblCustomerId);
        
        JButton btnOldBills = new JButton("Old Bills");
        btnOldBills.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
					try {
						OldBills r;
						r = new OldBills();
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
        btnOldBills.setFont(new Font("Arial", Font.BOLD, 12));
        btnOldBills.setBounds(551, 13, 162, 40);
        add(btnOldBills);
        
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String b = comboBox.getSelectedItem().toString();
				int a = Integer.parseInt(b);
				
				
				
				try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.generateBill(a);
					int row = tableModel.getRowCount();
					int total = 0;
					ArrayList ar = new ArrayList();
					for(int i=0;i<row;i++)
					{
					int p = (int) tableModel.getValueAt(i, 6);
					ar.add(p);
					}
					for(int j=0;j<ar.size();j++)
					{
						int a1 = (int) ar.get(j);
						total = a1+total;
					}
					Vector<String> v = new Vector();
					v.add("Total: "+total);
					tableModel.addRow(v);
					table.setModel(tableModel);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
        	}
        });
    }

    public static void showFrame() throws SQLException {
        JPanel panel = new Generate_Bills();
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
					Generate_Bills.showFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }*/
}