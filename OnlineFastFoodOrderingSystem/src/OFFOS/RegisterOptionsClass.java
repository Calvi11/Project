package OFFOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterOptionsClass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterOptionsClass window = new RegisterOptionsClass();
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
	public RegisterOptionsClass() {
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
		
		JButton btnLoginAsCustomer_1 = new JButton("Register as Customer");
		btnLoginAsCustomer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationCustomerClass obj=new RegistrationCustomerClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnLoginAsCustomer_1.setBounds(27, 145, 156, 38);
		frame.getContentPane().add(btnLoginAsCustomer_1);
		
		JButton btnRegisterAsAdmin = new JButton("Register as Admin");
		btnRegisterAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationAdminClass obj=new RegistrationAdminClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnRegisterAsAdmin.setBounds(27, 194, 156, 38);
		frame.getContentPane().add(btnRegisterAsAdmin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginClass obj=new LoginClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(264, 194, 135, 38);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\Logic and design\\449898841_1145151959935063_5138438074324463048_n.png"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		// TODO Auto-generated method stub
		
	}

}
