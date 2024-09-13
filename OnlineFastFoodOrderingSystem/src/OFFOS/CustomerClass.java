package OFFOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CustomerClass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerClass window = new CustomerClass();
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
	public CustomerClass() {
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
		
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setFont(new Font("Elephant", Font.PLAIN, 14));
		lblWelcome.setBounds(181, 28, 129, 28);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerMenuClass obj=new CustomerMenuClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnPlaceOrder.setBounds(29, 177, 136, 28);
		frame.getContentPane().add(btnPlaceOrder);
		
		JButton btnPlaceOrder_1_1 = new JButton("Logout");
		btnPlaceOrder_1_1.addActionListener(new ActionListener() {
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
		btnPlaceOrder_1_1.setBounds(244, 177, 136, 28);
		frame.getContentPane().add(btnPlaceOrder_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\449898841_1145151959935063_5138438074324463048_n.png"));
		lblNewLabel.setBounds(0, 0, 434, 266);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);

		// TODO Auto-generated method stub
		
	}
}
