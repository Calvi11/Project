package OFFOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AdminMenuClass {

    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton showUsersBtn;
    Connection con;
	PreparedStatement pst;
	private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminMenuClass window = new AdminMenuClass();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdminMenuClass() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(211, 211, 211));
        frame.setBounds(100, 100, 600, 434);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel Admin = new JLabel("Customers Personal Records");
        Admin.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
        Admin.setBounds(264, 11, 226, 30);
        frame.getContentPane().add(Admin);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(170, 52, 393, 317);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Customer Fname", "Lname", "Address", "Username", "Password"
        	}
        ));
        
        showUsersBtn = new JButton("Show Users");
        showUsersBtn.setBackground(new Color(255, 255, 255));
        showUsersBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/offos","root","");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from registrationcustomerclass");
					while(rs.next()) {
				
						String first_name = rs.getString("c_fname");
						String last_name = rs.getString("c_lname");
						String address = rs.getString("c_address");
						String username = rs.getString("c_username");
						String password = rs.getString("c_password");
						
						String tbData[] = {first_name,last_name,address,username,password};
						DefaultTableModel tb1Model = (DefaultTableModel)table.getModel();
						
						
						
						tb1Model.addRow(tbData);
						
						
						
				}
					// Disable the button after clicking show users
                    showUsersBtn.setEnabled(false);
                    
						con.close();
						
					}catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
        	}
        });
        showUsersBtn.setBounds(31, 219, 106, 23);
        frame.getContentPane().add(showUsersBtn);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		AdminClass obj=new AdminClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
        	}
        });
        btnBack.setBackground(new Color(255, 255, 255));
        btnBack.setBounds(31, 346, 106, 23);
        frame.getContentPane().add(btnBack);
        
        JButton btnDeleteRecord = new JButton("Delete");
        btnDeleteRecord.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                	
                	
                	
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    // Get the data from the selected row to construct the DELETE statement
                    // You will need to adjust this part based on your table structure
                    String nameToDelete = table.getValueAt(selectedRow, 0).toString(); // Assuming ID is in the first column

                    
                    
                 
                   try {
                    
                	  
   					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/offos","root","");
                    String deleteQuery = "DELETE FROM `registrationcustomerclass` WHERE c_fname = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
                    preparedStatement.setString(1, nameToDelete);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    con.close();
                  
                    
                    
                    JOptionPane.showMessageDialog(frame, "Button Clicked!", "DELETED", JOptionPane.INFORMATION_MESSAGE);

                    

		}catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error deleting row: " + ex.getMessage());
        }
    } else {
        
        JOptionPane.showMessageDialog(frame, "Please select a row to delete in the Table List!");
        JOptionPane.showMessageDialog(frame, "Click 'SHOW USERS' too see records");


        
    try {
		             
		int rowsUpdated = pst.executeUpdate();
			    
			    if (rowsUpdated > 0) {
			        JOptionPane.showMessageDialog(null, "Record Deleted Completely");
			    } else {
			        JOptionPane.showMessageDialog(null, "");
			    }

			    pst.close();
			    con.close();
			} catch (Exception e1) {
			    JOptionPane.showMessageDialog(null, e1);
        	}}}
        });
        btnDeleteRecord.setBackground(new Color(255, 255, 255));
        btnDeleteRecord.setBounds(31, 300, 106, 23);
        frame.getContentPane().add(btnDeleteRecord);
        
        btnNewButton_1 = new JButton("Clear");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				// Enable the button after clicking clear
                showUsersBtn.setEnabled(true);
        	}
        });
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setBounds(31, 258, 106, 23);
        frame.getContentPane().add(btnNewButton_1);
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		
				DefaultTableModel tb1Model=(DefaultTableModel)table.getModel();
				
				String tb1first_name = tb1Model.getValueAt(table.getSelectedRow(), 0). toString();
				String tb1last_name =tb1Model.getValueAt(table.getSelectedRow(), 1). toString();
				String tb1address =tb1Model.getValueAt(table.getSelectedRow(), 2). toString();
				String tb1username =tb1Model.getValueAt(table.getSelectedRow(), 3). toString();
				String tb1password =tb1Model.getValueAt(table.getSelectedRow(), 4). toString();
				
				




        	}
        });
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
