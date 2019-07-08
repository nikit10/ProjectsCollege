package Delivery_Page;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import AdminPage.Admin_Page;
import Database_Classes.ConnectDB;
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

public class Delivery_Items extends JPanel {
	static int cust_id = 1;
	static String[] type = {"Hello","World"};
	
	public Delivery_Items() throws SQLException {
        initializeUI();    
        
    }

    private void initializeUI() throws SQLException {
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
        		DeliveryPage d = new DeliveryPage();
        		d.setVisible(true);
				JComponent comp = (JComponent) e.getSource();
      		  Window win = SwingUtilities.getWindowAncestor(comp);
      		  win.dispose();
        	}
        });
        button.setBounds(84, 97, 111, 40);
        add(button);
        
        JButton btnGenerate = new JButton("Generate Items List");
      
        btnGenerate.setFont(new Font("Arial", Font.BOLD, 14));
        btnGenerate.setBounds(253, 97, 199, 40);
        add(btnGenerate);
        
        JButton btnPrintDockets = new JButton("Print Items ");
        btnPrintDockets.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        
        		int count= table.getModel().getRowCount();
        		if (count ==0)
        		{
        			DialogMessage.showInfoDialog("First Select Area and View List");
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
		//			e1.printStackTrace();
				}
        		}
        			
        		  }
        	
        });
        btnPrintDockets.setFont(new Font("Arial", Font.BOLD, 12));
        btnPrintDockets.setBounds(522, 97, 162, 40);
        add(btnPrintDockets);
        
        JComboBox comboBox = new JComboBox();
        type = ConnectDB.getDeliveryAreas();
		comboBox.setModel(new DefaultComboBoxModel<>(type));
        comboBox.setBounds(362, 28, 137, 22);
        add(comboBox);
        
        JLabel lblYourDeliveryArea = new JLabel("Your Delivery Area");
        lblYourDeliveryArea.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblYourDeliveryArea.setBounds(148, 29, 191, 19);
        add(lblYourDeliveryArea);
        
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String b = comboBox.getSelectedItem().toString();
				int a = Integer.parseInt(b);
				
				
				
				try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.generateItemsInfo(a);
					table.setModel(tableModel);	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
        	}
        });
    }

    public static void showFrame() throws SQLException {
        JPanel panel = new Delivery_Items();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Delivery Items Information");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

  /*  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					Delivery_Items.showFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }*/
}