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
import javax.swing.ImageIcon;

public class RegistrationAdminClass {

	private JFrame frame;
	private JTextField admFnameTF;
	private JTextField admLnameTF;
	private JTextField admAddressTF;
	private JTextField admUsernameTF;
	private JPasswordField admPasswordTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationAdminClass window = new RegistrationAdminClass();
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
	public RegistrationAdminClass() {
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
		
		JLabel lblNewLabel = new JLabel("Register as Admin");
		lblNewLabel.setBounds(161, 41, 108, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(33, 89, 108, 27);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(33, 124, 108, 27);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(33, 156, 108, 27);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(33, 185, 108, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(33, 212, 108, 27);
		frame.getContentPane().add(lblPassword);
		
		admFnameTF = new JTextField();
		admFnameTF.setText("");
		admFnameTF.setBounds(88, 92, 129, 20);
		frame.getContentPane().add(admFnameTF);
		admFnameTF.setColumns(10);
		
		admLnameTF = new JTextField();
		admLnameTF.setText("");
		admLnameTF.setColumns(10);
		admLnameTF.setBounds(88, 127, 129, 20);
		frame.getContentPane().add(admLnameTF);
		
		admAddressTF = new JTextField();
		admAddressTF.setText("");
		admAddressTF.setColumns(10);
		admAddressTF.setBounds(88, 159, 129, 20);
		frame.getContentPane().add(admAddressTF);
		
		admUsernameTF = new JTextField();
		admUsernameTF.setText("");
		admUsernameTF.setColumns(10);
		admUsernameTF.setBounds(88, 188, 129, 20);
		frame.getContentPane().add(admUsernameTF);
		
		admPasswordTF = new JPasswordField();
		admPasswordTF.setBounds(88, 215, 129, 20);
		frame.getContentPane().add(admPasswordTF);
		
		JButton RegisterAdminButton = new JButton("Register");
		RegisterAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
try {
					
					
					String a_fname =admFnameTF.getText();
					String a_lname = admLnameTF.getText();
					String a_address = admAddressTF.getText();
					String a_username = admUsernameTF.getText();
					String a_password = admPasswordTF.getText();
					
					
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/offos", "root", "");


		            
		            String registerAdminQuery = "INSERT INTO registrationadminclass(a_fname,a_lname,a_address, a_username, a_password) VALUES(?, ?, ?, ?, ?)";
		            
		            
		            PreparedStatement preparedStatement = con.prepareStatement(registerAdminQuery, Statement.RETURN_GENERATED_KEYS);
		            preparedStatement.setString(1, a_fname);
		            preparedStatement.setString(2, a_lname);
		            preparedStatement.setString(3, a_address);
		            preparedStatement.setString(4, a_username);
		            preparedStatement.setString(5, a_password);

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                // Retrieve the auto-generated order_id
		                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
		                if (generatedKeys.next()) {
		                    int a_id = generatedKeys.getInt(1); // Assuming order_id is an integer
		                    String msg = "Welcome, " + a_fname+ " " +a_lname + "! You Successfully Registered Your Account .";
		                    JOptionPane.showMessageDialog(RegisterAdminButton, msg);
		                }
		            } else {
		                JOptionPane.showMessageDialog(RegisterAdminButton, "Insertion failed. Record might already exist.");
		            }

		            con.close();
				
				 } catch (Exception exception) {
	                    exception.printStackTrace();
			        

				
					
	                }	
					
					
					
					
			}
		});
		RegisterAdminButton.setBounds(299, 187, 89, 23);
		frame.getContentPane().add(RegisterAdminButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterOptionsClass obj=new RegisterOptionsClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(299, 216, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\449898841_1145151959935063_5138438074324463048_n.png"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		// TODO Auto-generated method stub
		
	

		
	}
}
