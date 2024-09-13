package OFFOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class RegistrationCustomerClass {

	private JFrame frame;
	private JTextField cusFnameTF;
	private JTextField cusLnameTF;
	private JTextField custAddressTF;
	private JTextField cusUsernameTF;
	private JPasswordField cusPasswordTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationCustomerClass window = new RegistrationCustomerClass();
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
	public RegistrationCustomerClass() {
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
		
		JLabel lblNewLabel = new JLabel("Register as Customer");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 24, 145, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(51, 92, 91, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(51, 117, 91, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel cusAddressTF = new JLabel("Address");
		cusAddressTF.setFont(new Font("Tahoma", Font.BOLD, 11));
		cusAddressTF.setBounds(51, 149, 91, 14);
		frame.getContentPane().add(cusAddressTF);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1.setBounds(51, 184, 91, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1_1.setBounds(51, 213, 91, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		cusFnameTF = new JTextField();
		cusFnameTF.setBounds(111, 89, 137, 20);
		frame.getContentPane().add(cusFnameTF);
		cusFnameTF.setColumns(10);
		
		cusLnameTF = new JTextField();
		cusLnameTF.setColumns(10);
		cusLnameTF.setBounds(111, 117, 137, 20);
		frame.getContentPane().add(cusLnameTF);
		
		custAddressTF = new JTextField();
		custAddressTF.setColumns(10);
		custAddressTF.setBounds(111, 146, 137, 20);
		frame.getContentPane().add(custAddressTF);
		
		cusUsernameTF = new JTextField();
		cusUsernameTF.setColumns(10);
		cusUsernameTF.setBounds(111, 181, 137, 20);
		frame.getContentPane().add(cusUsernameTF);
		
		cusPasswordTF = new JPasswordField();
		cusPasswordTF.setBounds(111, 210, 137, 20);
		frame.getContentPane().add(cusPasswordTF);
		
		JButton RegisterCustomerButton = new JButton("Register");
		RegisterCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try {
					
					
					String c_fname =cusFnameTF.getText();
					String c_lname = cusLnameTF.getText();
					String c_address = custAddressTF.getText();
					String c_username = cusUsernameTF.getText();
					String c_password = cusPasswordTF.getText();
					
					
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/offos", "root", "");


		            
		            String registerCustomerQuery = "INSERT INTO registrationcustomerclass(c_fname,c_lname,c_address, c_username, c_password) VALUES(?, ?, ?, ?, ?)";
		            
		            
		            PreparedStatement preparedStatement = con.prepareStatement(registerCustomerQuery, Statement.RETURN_GENERATED_KEYS);
		            preparedStatement.setString(1, c_fname);
		            preparedStatement.setString(2, c_lname);
		            preparedStatement.setString(3, c_address);
		            preparedStatement.setString(4, c_username);
		            preparedStatement.setString(5, c_password);

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                // Retrieve the auto-generated order_id
		                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
		                if (generatedKeys.next()) {
		                    int a_id = generatedKeys.getInt(1); // Assuming order_id is an integer
		                    String msg = "Welcome, " + c_fname+ " " +c_lname + "! You Successfully Registered Your Account .";
		                    JOptionPane.showMessageDialog(RegisterCustomerButton, msg);
		                }
		            } else {
		                JOptionPane.showMessageDialog(RegisterCustomerButton, "Insertion failed. Record might already exist.");
		            }

		            con.close();
				

				 } catch (Exception exception) {
	                    exception.printStackTrace();
			        

				
					
	                }	
					
					
					
					
			
			}
		});
		RegisterCustomerButton.setBounds(290, 180, 89, 23);
		frame.getContentPane().add(RegisterCustomerButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterOptionsClass obj=new RegisterOptionsClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(290, 213, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\Logic and design\\449898841_1145151959935063_5138438074324463048_n.png"));
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_2);
	}
		
		public void setVisible(boolean b) {
			frame.setVisible(b);
			// TODO Auto-generated method stub
		
		
		
		
	}
}
