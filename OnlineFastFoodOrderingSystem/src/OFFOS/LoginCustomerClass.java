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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginCustomerClass {

	private JFrame frame;
	private JTextField cusUsernameLoginTF;
	private JPasswordField cusPasswordLoginTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCustomerClass window = new LoginCustomerClass();
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
	public LoginCustomerClass() {
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
		
		JLabel lblNewLabel = new JLabel("Login as Customer");
		lblNewLabel.setBounds(151, 31, 99, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(44, 86, 99, 25);
		frame.getContentPane().add(lblUsername);
		
		JLabel cus = new JLabel("Password");
		cus.setBounds(44, 122, 99, 25);
		frame.getContentPane().add(cus);
		
		cusUsernameLoginTF = new JTextField();
		cusUsernameLoginTF.setBounds(104, 88, 146, 20);
		frame.getContentPane().add(cusUsernameLoginTF);
		cusUsernameLoginTF.setColumns(10);
		
		cusPasswordLoginTF = new JPasswordField();
		cusPasswordLoginTF.setBounds(104, 122, 146, 20);
		frame.getContentPane().add(cusPasswordLoginTF);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = cusUsernameLoginTF.getText();
                String pa = new String(cusPasswordLoginTF.getPassword());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/offos", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from registrationcustomerclass");
                    boolean loggedIn = false;
                    while (rs.next()) {
                        String c_username = rs.getString(5);
                        String c_password = rs.getString(6);

                        if (user.equals(c_username) && pa.equals(c_password)) {
                            JOptionPane.showMessageDialog(null, "Logged in!");
                            loggedIn = true;
                            break;
                        }
                    }
                    con.close();

                    if (loggedIn) {
                        // Proceed to CustomerMenuClass
                        frame.setVisible(false); // Hide the login frame
                        CustomerMenuClass customerMenu = new CustomerMenuClass();
                        customerMenu.setVisible(true); // Show the CustomerMenuClass frame
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is incorrect");
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            
			}
		});
		btnNewButton.setBounds(104, 183, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginOptionsClass obj=new LoginOptionsClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnCancel.setBounds(198, 183, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\Logic and design\\449898841_1145151959935063_5138438074324463048_n.png"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void setVisible(boolean b) {
		frame.setVisible(b);
		// TODO Auto-generated method stub
		
	}

}