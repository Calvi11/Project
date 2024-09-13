package OFFOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminClass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminClass window = new AdminClass();
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
	public AdminClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 14));
		lblNewLabel.setBounds(145, 25, 129, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JButton cusRecBtn = new JButton("Customers Records");
		cusRecBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminMenuClass obj=new AdminMenuClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		cusRecBtn.setBounds(20, 178, 157, 28);
		frame.getContentPane().add(cusRecBtn);
		
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int a=JOptionPane.showConfirmDialog(frame,"Are you sure, you want to log-out?");
				if(a==JOptionPane.YES_OPTION){  
					LoginClass obj=new LoginClass();
					obj.setVisible(true);
					
					frame.setVisible(false);}
				
				if(a==JOptionPane.NO_OPTION){  
					AdminClass obj=new AdminClass();
					obj.setVisible(true);
					
					frame.setVisible(false);
				}
				
				
			}
		});
		logOutBtn.setBounds(252, 181, 136, 28);
		frame.getContentPane().add(logOutBtn);
		
		JButton btnTransactionHistory = new JButton("Transaction History");
		btnTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminTransactionHistoryClass obj=new AdminTransactionHistoryClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnTransactionHistory.setBounds(20, 127, 157, 28);
		frame.getContentPane().add(btnTransactionHistory);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\Logic and design\\449898841_1145151959935063_5138438074324463048_n.png"));
		lblNewLabel_1.setBounds(-46, 3, 480, 258);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);

		// TODO Auto-generated method stub
		
	}
}
