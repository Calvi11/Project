package OFFOS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginClass {

    private JFrame frame;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginClass window = new LoginClass();
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
    public LoginClass() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Welcome to Leveroma");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 14));
        lblLogin.setBounds(22, 21, 76, 27);
        frame.getContentPane().add(lblLogin);

       

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		LoginOptionsClass obj=new LoginOptionsClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
        	}
        });
        btnLogin.setBounds(10, 250, 124, 38);
        frame.getContentPane().add(btnLogin);

        JButton btnSignup = new JButton("Sign-up");
        btnSignup.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegisterOptionsClass obj=new RegisterOptionsClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
        	}
        });
        btnSignup.setBounds(10, 299, 124, 38);
        frame.getContentPane().add(btnSignup);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Desktop\\Logic and design\\449898841_1145151959935063_5138438074324463048_n.png"));
        lblNewLabel.setBounds(0, 0, 484, 361);
        frame.getContentPane().add(lblNewLabel);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
