package Orders;
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

public class Orders_Infor extends JPanel {
	private JTextField txt_EnterId;
	static int order_id = 1;
	public static String item_type;
	
	public Orders_Infor() {
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
        
        JButton btnGenerate = new JButton("Order Info");
        btnGenerate.setFont(new Font("Arial", Font.BOLD, 14));
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					/*StringBuilder str;
					str = ConnectDB.getCustomerInfo();
					//textArea.setText(str.toString());
					 *
*/				
        			DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getOrdersInfo();
					table.setModel(tableModel);	
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        btnGenerate.setBounds(337, 10, 147, 21);
        add(btnGenerate);
        add(pane);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
       
        btnDelete.setBounds(74, 51, 111, 21);
        add(btnDelete);
        
        txt_EnterId = new JTextField();
        txt_EnterId.setFont(new Font("Arial", Font.BOLD, 12));
        txt_EnterId.setBounds(337, 53, 147, 19);
        add(txt_EnterId);
        txt_EnterId.setColumns(10);
        
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
        button.setBounds(74, 10, 111, 21);
        add(button);
        
        JButton btnAddCustomers = new JButton("Add Orders");
        btnAddCustomers.setFont(new Font("Arial", Font.BOLD, 12));
        btnAddCustomers.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		try {
        			JComponent comp = (JComponent) e.getSource();
          		  Window win = SwingUtilities.getWindowAncestor(comp);
          		  win.dispose();
					Add_Orders add_cust;
					add_cust = new Add_Orders();
					add_cust.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				}
        	}
        });
        btnAddCustomers.setBounds(607, 10, 131, 21);
        add(btnAddCustomers);
    
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int id = Integer.parseInt(txt_EnterId.getText());
        		int num = ConnectDB.deleteOrder(id);
				
				if(num>0)
				{
					DialogMessage.showInfoDialog("DELETED");
					txt_EnterId.setText("");
				}
				else
				{
					DialogMessage.showWarningDialog("ERROR");
				}
        	}
        });
    }

    public static void showFrame() {
        JPanel panel = new Orders_Infor();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Customer Information");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

 /*   public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Customer_Infor.showFrame();
            }
        });
    }*/
}