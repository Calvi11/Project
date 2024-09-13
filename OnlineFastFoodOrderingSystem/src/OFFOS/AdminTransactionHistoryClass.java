package OFFOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AdminTransactionHistoryClass {

	private JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTransactionHistoryClass window = new AdminTransactionHistoryClass();
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
	public AdminTransactionHistoryClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1155, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(42, 118, 1045, 287);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"orderID", "name", "address", "h.burger", "f.fries", "r/FChicken", "fish_sandwich", "cheese_sandwhich", "chick.sandwich", "cola", "coffee", "lemonjuice", "strawberryiceCream", "vanilla_shake", "choco_milkShake", "qty", "price", "order_date"
			}
		));
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Show Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/offos", "root", "");
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");

		            DefaultTableModel tb1Model = (DefaultTableModel) table.getModel();
		            tb1Model.setRowCount(0); // Clear existing rows

		            while (rs.next()) {
		                String order_id = rs.getString("order_id");
		                String customer_name = rs.getString("customer_name");
		                String customer_address = rs.getString("customer_address");
		                String ham_burger = rs.getString("ham_burger");
		                String french_fries = rs.getString("french_fries");
		                String rice_withFriedChicken = rs.getString("rice_withFriedChicken");
		                String fish_sandwich = rs.getString("fish_sandwich");
		                String cheese_sandwich = rs.getString("cheese_sandwich");
		                String chicken_sandwich = rs.getString("chicken_sandwich");
		                String cola = rs.getString("cola");
		                String coffee = rs.getString("coffee");
		                String lemon_juice = rs.getString("lemon_juice");
		                String strawberry_iceCream = rs.getString("strawberry_iceCream");
		                String vanilla_shake = rs.getString("vanilla_shake");
		                String choco_milkShake = rs.getString("choco_milkShake");
		                String quantity = rs.getString("quantity");
		                String price = rs.getString("price");
		                String order_date = rs.getString("order_date");

		                String tbData[] = {
		                    order_id, customer_name, customer_address, ham_burger, french_fries, 
		                    rice_withFriedChicken, fish_sandwich, cheese_sandwich, chicken_sandwich, 
		                    cola, coffee, lemon_juice, strawberry_iceCream, vanilla_shake, 
		                    choco_milkShake, quantity, price, order_date
		                };

		                tb1Model.addRow(tbData);
		            }
		            
		            rs.close();
		            stmt.close();
		            con.close();
		        } catch (Exception e1) {
		            System.out.println(e1.getMessage());
		        }
			}
		});
		btnNewButton.setBounds(53, 437, 107, 37);
		frame.getContentPane().add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminClass obj=new AdminClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(199, 437, 107, 37);
		frame.getContentPane().add(btnBack);
		
		lblNewLabel = new JLabel("TRANSACTION HISTORY");
		lblNewLabel.setFont(new Font("MingLiU-ExtB", Font.BOLD, 15));
		lblNewLabel.setBounds(471, 33, 296, 30);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
