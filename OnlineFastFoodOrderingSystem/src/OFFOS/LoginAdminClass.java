package OFFOS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

public class LoginAdminClass {

    private JFrame frame;
    private JPasswordField admPasswordLoginTF;
    private JTextField admUsernameLoginTF;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginAdminClass window = new LoginAdminClass();
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
    public LoginAdminClass() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(Color.WHITE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(39, 95, 99, 25);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(39, 133, 99, 25);
        frame.getContentPane().add(lblPassword);

        admPasswordLoginTF = new JPasswordField();
        admPasswordLoginTF.setBounds(106, 135, 126, 20);
        frame.getContentPane().add(admPasswordLoginTF);

        admUsernameLoginTF = new JTextField();
        admUsernameLoginTF.setBounds(106, 97, 126, 20);
        frame.getContentPane().add(admUsernameLoginTF);
        admUsernameLoginTF.setColumns(10);

        JLabel lblNewLabel = new JLabel("Login as Admin");
        lblNewLabel.setBounds(133, 30, 99, 25);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = admUsernameLoginTF.getText();
                String pa = new String(admPasswordLoginTF.getPassword());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/offos", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from registrationadminclass");
                    boolean loggedIn = false;
                    while (rs.next()) {
                        String a_username = rs.getString(5);
                        String a_password = rs.getString(6);

                        if (user.equals(a_username) && pa.equals(a_password)) {
                            JOptionPane.showMessageDialog(null, "Logged in!");
                            loggedIn = true;
                            break;
                        }
                    }
                    con.close();

                    if (loggedIn) {
                        // Proceed to AdminMenuClass
                        frame.setVisible(false); // Hide the login frame
                        AdminClass adminMenu = new AdminClass();
                        adminMenu.setVisible(true); // Show the AdminMenuClass frame
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is incorrect");
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        });
        btnNewButton.setBounds(87, 186, 89, 23);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginClass obj=new LoginClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
        	}
        });
        btnCancel.setBounds(186, 186, 89, 23);
        frame.getContentPane().add(btnCancel);
        
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
