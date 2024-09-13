package OFFOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginOptionsClass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginOptionsClass window = new LoginOptionsClass();
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
	public LoginOptionsClass() {
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
		
		JButton btnLoginAsCustomer_1 = new JButton("Login as Customer");
		btnLoginAsCustomer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginCustomerClass obj=new LoginCustomerClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnLoginAsCustomer_1.setBounds(29, 147, 150, 38);
		frame.getContentPane().add(btnLoginAsCustomer_1);
		
		JButton btnLoginAsAdmin = new JButton("Login as Admin");
		btnLoginAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginAdminClass obj=new LoginAdminClass();
				obj.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnLoginAsAdmin.setBounds(29, 196, 150, 38);
		frame.getContentPane().add(btnLoginAsAdmin);
		
		JButton btnLoginAsCustomer_1_1 = new JButton("Back");
		btnLoginAsCustomer_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginClass obj=new LoginClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
				
			}
		});
		btnLoginAsCustomer_1_1.setBounds(259, 196, 124, 38);
		frame.getContentPane().add(btnLoginAsCustomer_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\Logic and design\\449898841_1145151959935063_5138438074324463048_n.png"));
		lblNewLabel.setBounds(10, 0, 424, 261);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
