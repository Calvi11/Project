package OFFOS;

import java.awt.EventQueue;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.awt.Font;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;

public class CustomerMenuClass {

	private JFrame frame;
	private JTextField txtPhp;
	private JTextField totalAmountTF;
	private static JTextField numberOfItemsTF;
	private JTextField hbCBTotal;
	private JTextField ffCBTotal;
	private JTextField rfcCBTotal;
	private JTextField fsCBTotal;
	private JTextField csCBTotal;
	private JTextField chickCBTotal;
	private JTextField cCBTotal;
	private JTextField cofCBTotal;
	private JTextField ljCBTotal;
	private JTextField sicCBTotal;
	private JTextField vsCBTotal;
	private JTextField cmsCBTotal;
	private int ffCBamount;
	private int hbCBamount;
	private JTextField hbCBq;
	private JTextField ffCBq;
	private JTextField rfcCBq;
	private JTextField fsCBq;
	private JTextField csCBq;
	private JTextField chickCBq;
	private JTextField cCBq;
	private JTextField cofCBq;
	private JTextField ljCBq;
	private JTextField sicCBq;
	private JTextField vsCBq;
	private JTextField cmsCBq;
	private JTextField customerNameTF;
	private JTextField addressTF;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenuClass window = new CustomerMenuClass();
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
	public CustomerMenuClass() {
		initialize();
		
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1125, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(376, 21, 350, 42);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("LEVEROMA Fast Food Ordering System");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(21, 93, 505, 360);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel hbCBlabel = new JLabel("Hamburger");
		hbCBlabel.setBounds(20, 121, 68, 22);
		panel_1.add(hbCBlabel);
		
		JLabel lblFastMeals = new JLabel("Fast Meals");
		lblFastMeals.setBounds(194, 11, 79, 22);
		lblFastMeals.setFont(new Font("Gadugi", Font.BOLD, 16));
		panel_1.add(lblFastMeals);
		
		JLabel ffCBlabel = new JLabel("French Fries");
		ffCBlabel.setBounds(20, 154, 68, 22);
		panel_1.add(ffCBlabel);
		
		JLabel rfcCBlabel = new JLabel("Rice w/ Fried Chicken");
		rfcCBlabel.setBounds(20, 187, 117, 22);
		panel_1.add(rfcCBlabel);
		
		JLabel fsCBlabel = new JLabel("Fish Sandwich");
		fsCBlabel.setBounds(20, 220, 68, 22);
		panel_1.add(fsCBlabel);
		
		JLabel csCBlabel = new JLabel("Cheese Sandwich");
		csCBlabel.setBounds(20, 253, 92, 22);
		panel_1.add(csCBlabel);
		
		JLabel chicksCBlabel = new JLabel("Chicken Sandwich");
		chicksCBlabel.setBounds(20, 286, 92, 22);
		panel_1.add(chicksCBlabel);
		
		
		
		
		JComboBox hbCB = new JComboBox();
		hbCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				////for total amount
				double selectedOption1 = Double.parseDouble((String) hbCB.getSelectedItem());
				double hbCBamount = selectedOption1 * 55;
				hbCBTotal.setText(String.format("%.2f", hbCBamount)); 
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);
                
                
            ///for per and total quantity
                int selectedOption1int=(int)selectedOption1;
                hbCBq.setText(String.valueOf(selectedOption1int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

           
			}
			
		});
		hbCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		hbCB.setBounds(211, 121, 62, 22);
		panel_1.add(hbCB);
		
		JComboBox ffCB = new JComboBox();
		ffCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				////for total amount
				double selectedOption2 = Double.parseDouble((String) ffCB.getSelectedItem());
				double ffCBamount = selectedOption2 * 35;
                ffCBTotal.setText(String.format("%.2f", ffCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                int selectedOption2int=(int)selectedOption2;
                ffCBq.setText(String.valueOf(selectedOption2int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

              
			}
		});
		ffCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		ffCB.setBounds(211, 154, 62, 22);
		panel_1.add(ffCB);
		
		JComboBox rfcCB = new JComboBox();
		rfcCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double selectedOption3 = Double.parseDouble((String) rfcCB.getSelectedItem());
				double rfcCBamount = selectedOption3 * 75;
                rfcCBTotal.setText(String.format("%.2f", rfcCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                
                int selectedOption3int=(int)selectedOption3;
                rfcCBq.setText(String.valueOf(selectedOption3int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

			}
		});
		rfcCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		rfcCB.setBounds(211, 187, 62, 22);
		panel_1.add(rfcCB);
		
		JComboBox fsCB = new JComboBox();
		fsCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption4 = Double.parseDouble((String) fsCB.getSelectedItem());
				double fsCBamount = selectedOption4 * 35;
                fsCBTotal.setText(String.format("%.2f", fsCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                
                
                int selectedOption4int=(int)selectedOption4;
                fsCBq.setText(String.valueOf(selectedOption4int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

			}
		});
		fsCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		fsCB.setBounds(211, 220, 62, 22);
		panel_1.add(fsCB);
		
		JComboBox csCB = new JComboBox();
		csCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption5 = Double.parseDouble((String) csCB.getSelectedItem());
				double csCBamount = selectedOption5 * 40;
                csCBTotal.setText(String.format("%.2f", csCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                int selectedOption5int=(int)selectedOption5;
                csCBq.setText(String.valueOf(selectedOption5int));
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

			}
		});
		csCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		csCB.setBounds(211, 253, 62, 22);
		panel_1.add(csCB);
		
		JComboBox chickCB = new JComboBox();
		chickCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption6 = Double.parseDouble((String) chickCB.getSelectedItem());
				double chickCBamount = selectedOption6 * 55;
		        chickCBTotal.setText(String.format("%.2f", chickCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);
                
                int selectedOption6int=(int)selectedOption6;
                chickCBq.setText(String.valueOf(selectedOption6int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

				
			}
		});
		chickCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		chickCB.setBounds(211, 286, 62, 22);
		panel_1.add(chickCB);
		
		JLabel lblNewLabel_2 = new JLabel("Item");
		lblNewLabel_2.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2.setBounds(20, 85, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price");
		lblNewLabel_2_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(136, 85, 65, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Select Quantity");
		lblNewLabel_2_1_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(201, 86, 94, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Php 55");
		lblNewLabel_3.setBounds(137, 125, 54, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Php 35");
		lblNewLabel_3_1.setBounds(137, 158, 54, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Php 75");
		lblNewLabel_3_1_1.setBounds(137, 191, 54, 14);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Php 35");
		lblNewLabel_3_1_1_1.setBounds(136, 224, 54, 14);
		panel_1.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Php 40");
		lblNewLabel_3_1_1_1_1.setBounds(136, 257, 54, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Php 55");
		lblNewLabel_3_1_1_1_1_1.setBounds(136, 290, 54, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Amount");
		lblNewLabel_2_1_1_2.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1_1_2.setBounds(418, 85, 65, 14);
		panel_1.add(lblNewLabel_2_1_1_2);
		
		hbCBTotal = new JTextField();
		hbCBTotal.setEditable(false);
		hbCBTotal.setBounds(404, 121, 79, 22);
		panel_1.add(hbCBTotal);
		hbCBTotal.setColumns(10);
		
		ffCBTotal = new JTextField();
		ffCBTotal.setEditable(false);
		ffCBTotal.setColumns(10);
		ffCBTotal.setBounds(404, 154, 79, 22);
		panel_1.add(ffCBTotal);
		
		rfcCBTotal = new JTextField();
		rfcCBTotal.setEditable(false);
		rfcCBTotal.setColumns(10);
		rfcCBTotal.setBounds(404, 187, 79, 22);
		panel_1.add(rfcCBTotal);
		
		fsCBTotal = new JTextField();
		fsCBTotal.setEditable(false);
		fsCBTotal.setColumns(10);
		fsCBTotal.setBounds(404, 220, 79, 22);
		panel_1.add(fsCBTotal);
		
		csCBTotal = new JTextField();
		csCBTotal.setEditable(false);
		csCBTotal.setColumns(10);
		csCBTotal.setBounds(404, 253, 79, 22);
		panel_1.add(csCBTotal);
		
		chickCBTotal = new JTextField();
		chickCBTotal.setEditable(false);
		chickCBTotal.setColumns(10);
		chickCBTotal.setBounds(404, 286, 79, 22);
		panel_1.add(chickCBTotal);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("Quantity");
		lblNewLabel_2_1_1_3.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1_1_3.setBounds(314, 85, 94, 14);
		panel_1.add(lblNewLabel_2_1_1_3);
		
		hbCBq = new JTextField();
		hbCBq.setEditable(false);
		hbCBq.setColumns(10);
		hbCBq.setBounds(302, 121, 79, 22);
		panel_1.add(hbCBq);
		
		ffCBq = new JTextField();
		ffCBq.setEditable(false);
		ffCBq.setColumns(10);
		ffCBq.setBounds(302, 155, 79, 22);
		panel_1.add(ffCBq);
		
		rfcCBq = new JTextField();
		rfcCBq.setEditable(false);
		rfcCBq.setColumns(10);
		rfcCBq.setBounds(302, 188, 79, 22);
		panel_1.add(rfcCBq);
		
		fsCBq = new JTextField();
		fsCBq.setEditable(false);
		fsCBq.setColumns(10);
		fsCBq.setBounds(302, 221, 79, 22);
		panel_1.add(fsCBq);
		
		csCBq = new JTextField();
		csCBq.setEditable(false);
		csCBq.setColumns(10);
		csCBq.setBounds(302, 254, 79, 22);
		panel_1.add(csCBq);
		
		chickCBq = new JTextField();
		chickCBq.setEditable(false);
		chickCBq.setColumns(10);
		chickCBq.setBounds(302, 287, 79, 22);
		panel_1.add(chickCBq);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1_1.setBounds(580, 93, 505, 360);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cola");
		lblNewLabel_1_2.setBounds(20, 121, 68, 22);
		panel_1_1.add(lblNewLabel_1_2);
		
		JLabel lblDrinksDes = new JLabel("Drinks & Desserts");
		lblDrinksDes.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblDrinksDes.setBounds(201, 11, 134, 22);
		panel_1_1.add(lblDrinksDes);
		
		JLabel cofCBlabel = new JLabel("Coffee");
		cofCBlabel.setBounds(20, 154, 68, 22);
		panel_1_1.add(cofCBlabel);
		
		JLabel ljCBlabel = new JLabel("Lemon Juice");
		ljCBlabel.setBounds(20, 187, 117, 22);
		panel_1_1.add(ljCBlabel);
		
		JLabel sicCBlabel = new JLabel("Strawberry Ice Cream");
		sicCBlabel.setBounds(20, 220, 117, 22);
		panel_1_1.add(sicCBlabel);
		
		JLabel vsCBlabel = new JLabel("Vanilla Shake");
		vsCBlabel.setBounds(20, 253, 92, 22);
		panel_1_1.add(vsCBlabel);
		
		JLabel cmsCBlabel = new JLabel("Choco Milk Shake");
		cmsCBlabel.setBounds(20, 286, 92, 22);
		panel_1_1.add(cmsCBlabel);
		
		JComboBox cCB = new JComboBox();
		cCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption7 = Double.parseDouble((String) cCB.getSelectedItem());
				double cCBamount = selectedOption7 * 30;
		        cCBTotal.setText(String.format("%.2f", cCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                
                int selectedOption7int=(int)selectedOption7;
                cCBq.setText(String.valueOf(selectedOption7int));
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

				
			}
		});
		cCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		cCB.setBounds(216, 121, 62, 22);
		panel_1_1.add(cCB);
		
		JComboBox cofCB = new JComboBox();
		cofCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double selectedOption8 = Double.parseDouble((String) cofCB.getSelectedItem());
				double cofCBamount = selectedOption8 * 30;
		        cofCBTotal.setText(String.format("%.2f", cofCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);
                
                
                int selectedOption8int=(int)selectedOption8;
                cofCBq.setText(String.valueOf(selectedOption8int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

				
			}
		});
		cofCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		cofCB.setBounds(216, 154, 62, 22);
		panel_1_1.add(cofCB);
		
		JComboBox ljCB = new JComboBox();
		ljCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption9 = Double.parseDouble((String) ljCB.getSelectedItem());
				double ljCBamount = selectedOption9 * 30;
		        ljCBTotal.setText(String.format("%.2f", ljCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                
                
                int selectedOption9int=(int)selectedOption9;
                ljCBq.setText(String.valueOf(selectedOption9int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

			}
		});
		ljCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		ljCB.setBounds(216, 187, 62, 22);
		panel_1_1.add(ljCB);
		
		JComboBox sicCB = new JComboBox();
		sicCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption10 = Double.parseDouble((String) sicCB.getSelectedItem());
				double  sicCBamount = selectedOption10 * 45;
		        sicCBTotal.setText(String.format("%.2f", sicCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                
                int selectedOption10int=(int)selectedOption10;
                sicCBq.setText(String.valueOf(selectedOption10int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

			}
		});
		sicCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		sicCB.setBounds(216, 220, 62, 22);
		panel_1_1.add(sicCB);
		
		JComboBox vsCB = new JComboBox();
		vsCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption11 = Double.parseDouble((String) vsCB.getSelectedItem());
				double vsCBamount = selectedOption11 * 50;
		        vsCBTotal.setText(String.format("%.2f", vsCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                
                int selectedOption11int=(int)selectedOption11;
                vsCBq.setText(String.valueOf(selectedOption11int)); 
                updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

			}
		});
		vsCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		vsCB.setBounds(216, 253, 62, 22);
		panel_1_1.add(vsCB);
		
		JComboBox cmsCB = new JComboBox();
		cmsCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double selectedOption12 = Double.parseDouble((String) cmsCB.getSelectedItem());
				double cmsCBamount = selectedOption12 * 50;
		        cmsCBTotal.setText(String.format("%.2f", cmsCBamount));
                updateTotal(hbCBTotal, ffCBTotal, rfcCBTotal, fsCBTotal, csCBTotal, chickCBTotal, cCBTotal, cofCBTotal, ljCBTotal, sicCBTotal, vsCBTotal, cmsCBTotal, totalAmountTF);

                
                int selectedOption12int=(int)selectedOption12;
               cmsCBq.setText(String.valueOf(selectedOption12int)); 
               updateQuantity(hbCBq, ffCBq, rfcCBq, fsCBq, csCBq, chickCBq, cCBq, cofCBq, ljCBq, sicCBq, vsCBq, cmsCBq, numberOfItemsTF);

			}
		});
		cmsCB.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		cmsCB.setBounds(216, 286, 62, 22);
		panel_1_1.add(cmsCB);
		
		JLabel lblNewLabel_2_2 = new JLabel("Item");
		lblNewLabel_2_2.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(20, 85, 46, 14);
		panel_1_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Price");
		lblNewLabel_2_1_2.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1_2.setBounds(136, 85, 65, 14);
		panel_1_1.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Select Quantity");
		lblNewLabel_2_1_1_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(201, 85, 99, 14);
		panel_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Php 30");
		lblNewLabel_3_2.setBounds(137, 125, 54, 14);
		panel_1_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Php 30");
		lblNewLabel_3_1_2.setBounds(137, 158, 54, 14);
		panel_1_1.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Php 30");
		lblNewLabel_3_1_1_2.setBounds(137, 191, 54, 14);
		panel_1_1.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("Php 45");
		lblNewLabel_3_1_1_1_2.setBounds(136, 224, 54, 14);
		panel_1_1.add(lblNewLabel_3_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("Php 50");
		lblNewLabel_3_1_1_1_1_2.setBounds(136, 257, 54, 14);
		panel_1_1.add(lblNewLabel_3_1_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Php 50");
		lblNewLabel_3_1_1_1_1_1_1.setBounds(136, 290, 54, 14);
		panel_1_1.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Amount");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1_1_2_1.setBounds(411, 85, 65, 14);
		panel_1_1.add(lblNewLabel_2_1_1_2_1);
		
		cCBTotal = new JTextField();
		cCBTotal.setEditable(false);
		cCBTotal.setColumns(10);
		cCBTotal.setBounds(397, 121, 79, 22);
		panel_1_1.add(cCBTotal);
		
		cofCBTotal = new JTextField();
		cofCBTotal.setEditable(false);
		cofCBTotal.setColumns(10);
		cofCBTotal.setBounds(397, 154, 79, 22);
		panel_1_1.add(cofCBTotal);
		
		ljCBTotal = new JTextField();
		ljCBTotal.setEditable(false);
		ljCBTotal.setColumns(10);
		ljCBTotal.setBounds(397, 187, 79, 22);
		panel_1_1.add(ljCBTotal);
		
		sicCBTotal = new JTextField();
		sicCBTotal.setEditable(false);
		sicCBTotal.setColumns(10);
		sicCBTotal.setBounds(397, 220, 79, 22);
		panel_1_1.add(sicCBTotal);
		
		vsCBTotal = new JTextField();
		vsCBTotal.setEditable(false);
		vsCBTotal.setColumns(10);
		vsCBTotal.setBounds(397, 253, 79, 22);
		panel_1_1.add(vsCBTotal);
		
		cmsCBTotal = new JTextField();
		cmsCBTotal.setEditable(false);
		cmsCBTotal.setColumns(10);
		cmsCBTotal.setBounds(397, 286, 79, 22);
		panel_1_1.add(cmsCBTotal);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_1_1_1_1.setBounds(310, 85, 65, 14);
		panel_1_1.add(lblNewLabel_2_1_1_1_1);
		
		cCBq = new JTextField();
		cCBq.setEditable(false);
		cCBq.setColumns(10);
		cCBq.setBounds(296, 122, 79, 22);
		panel_1_1.add(cCBq);
		
		cofCBq = new JTextField();
		cofCBq.setEditable(false);
		cofCBq.setColumns(10);
		cofCBq.setBounds(296, 155, 79, 22);
		panel_1_1.add(cofCBq);
		
		ljCBq = new JTextField();
		ljCBq.setEditable(false);
		ljCBq.setColumns(10);
		ljCBq.setBounds(296, 188, 79, 22);
		panel_1_1.add(ljCBq);
		
		sicCBq = new JTextField();
		sicCBq.setEditable(false);
		sicCBq.setColumns(10);
		sicCBq.setBounds(296, 221, 79, 22);
		panel_1_1.add(sicCBq);
		
		vsCBq = new JTextField();
		vsCBq.setEditable(false);
		vsCBq.setColumns(10);
		vsCBq.setBounds(296, 254, 79, 22);
		panel_1_1.add(vsCBq);
		
		cmsCBq = new JTextField();
		cmsCBq.setEditable(false);
		cmsCBq.setColumns(10);
		cmsCBq.setBounds(296, 287, 79, 22);
		panel_1_1.add(cmsCBq);
		
		JLabel lblNewLabel_2_3 = new JLabel("Total Amount");
		lblNewLabel_2_3.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_3.setBounds(584, 558, 86, 14);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Payment Method");
		lblNewLabel_2_3_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_3_1.setBounds(584, 478, 115, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Delivery Fee");
		lblNewLabel_2_3_2.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_3_2.setBounds(584, 533, 86, 14);
		frame.getContentPane().add(lblNewLabel_2_3_2);
		
		txtPhp = new JTextField();
		txtPhp.setText("PHP 50.00");
		txtPhp.setEditable(false);
		txtPhp.setBounds(696, 531, 86, 20);
		frame.getContentPane().add(txtPhp);
		txtPhp.setColumns(10);
		
		totalAmountTF = new JTextField();
		totalAmountTF.setEditable(false);
		totalAmountTF.setColumns(10);
		totalAmountTF.setBounds(696, 556, 86, 20);
		frame.getContentPane().add(totalAmountTF);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Gcash"}));
		comboBox_3.setBounds(696, 475, 61, 22);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Number of Items");
		lblNewLabel_2_3_1_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_3_1_1.setBounds(584, 508, 115, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1_1);
		
		
		JComboBox monthCB = new JComboBox();
		monthCB.setModel(new DefaultComboBoxModel(new String[] {"1", "", "2", "", "3", "", "4", "", "5", "", "6", "", "7", "", "8", "", "9", "", "10", "", "11", "", "12"}));
		monthCB.setBounds(63, 553, 62, 22);
		frame.getContentPane().add(monthCB);
		
		JComboBox dayCB = new JComboBox();
		dayCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayCB.setBounds(135, 553, 62, 22);
		frame.getContentPane().add(dayCB);
		
		JComboBox yearCB = new JComboBox();
		yearCB.setModel(new DefaultComboBoxModel(new String[] {"2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		yearCB.setBounds(207, 553, 62, 22);
		frame.getContentPane().add(yearCB);
		
		numberOfItemsTF = new JTextField();
		numberOfItemsTF.setEditable(false);
		numberOfItemsTF.setColumns(10);
		numberOfItemsTF.setBounds(696, 508, 86, 20);
		frame.getContentPane().add(numberOfItemsTF);
		
		JButton btnNewButton = new JButton("Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (customerNameTF.getText().equals("") || addressTF.getText().equals("")) {
				    JOptionPane.showMessageDialog(null, "Please enter your name and address");
				} else {
				    try {
				        String customer_name = customerNameTF.getText();
				        String customer_address = addressTF.getText();
				        String ham_burger = hbCB.getSelectedItem().toString();
				        String french_fries = ffCB.getSelectedItem().toString();
				        String rice_withFriedChicken = rfcCB.getSelectedItem().toString();
				        String fish_sandwich = fsCB.getSelectedItem().toString();
				        String cheese_sandwich = csCB.getSelectedItem().toString();
				        String chicken_sandwich = chickCB.getSelectedItem().toString();
				        String cola = cCB.getSelectedItem().toString();
				        String coffee = cofCB.getSelectedItem().toString();
				        String lemon_juice = ljCB.getSelectedItem().toString();
				        String strawberry_iceCream = sicCB.getSelectedItem().toString();
				        String vanilla_shake = vsCB.getSelectedItem().toString();
				        String choco_milkShake = cmsCB.getSelectedItem().toString();
				        String quantity = numberOfItemsTF.getText();
				        String price = totalAmountTF.getText();
				        String month = monthCB.getSelectedItem().toString();
				        String day = dayCB.getSelectedItem().toString();
				        String year = yearCB.getSelectedItem().toString();
				        String order_date = month + "/" + day + "/" + year;

				        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/offos", "root", "");
				        
				        

				        // Use PreparedStatement to prevent SQL injection and handle SQL syntax properly
				        String placeOrderQuery = "INSERT INTO orders (customer_name, customer_address, ham_burger, french_fries, rice_withFriedChicken, fish_sandwich, cheese_sandwich, chicken_sandwich, cola, coffee, lemon_juice, strawberry_iceCream, vanilla_shake, choco_milkShake, quantity, price, order_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				        PreparedStatement preparedStatement = con1.prepareStatement(placeOrderQuery, Statement.RETURN_GENERATED_KEYS);
				        preparedStatement.setString(1, customer_name);
				        preparedStatement.setString(2, customer_address);
				        preparedStatement.setString(3, ham_burger);
				        preparedStatement.setString(4, french_fries);
				        preparedStatement.setString(5, rice_withFriedChicken);
				        preparedStatement.setString(6, fish_sandwich);
				        preparedStatement.setString(7, cheese_sandwich);
				        preparedStatement.setString(8, chicken_sandwich);
				        preparedStatement.setString(9, cola);
				        preparedStatement.setString(10, coffee);
				        preparedStatement.setString(11, lemon_juice);
				        preparedStatement.setString(12, strawberry_iceCream);
				        preparedStatement.setString(13, vanilla_shake);
				        preparedStatement.setString(14, choco_milkShake);
				        preparedStatement.setString(15, quantity);
				        preparedStatement.setString(16, price);
				        preparedStatement.setString(17, order_date);

				        int rowsAffected = preparedStatement.executeUpdate();

				        if (rowsAffected > 0) {
				            // Retrieve the auto-generated order_id
				            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				            if (generatedKeys.next()) {
				                int order_id = generatedKeys.getInt(1); //  order_id is an integer
				                String msg = "Welcome, " + customer_name + "! Your order is placed successfully.";
				                JOptionPane.showMessageDialog(btnNewButton, msg);
				            }
				        } else {
				            JOptionPane.showMessageDialog(btnNewButton, "Insertion failed. Record might already exist.");
				        }

				        con1.close();
				    } catch (Exception e1) {
				        System.out.println(e1.getMessage());
				    }
				}
			}
		});
		btnNewButton.setBounds(804, 542, 138, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerClass obj=new CustomerClass();
				obj.setVisible(true);
				
				frame.setVisible(false);
				
			}
		});
		btnBack.setBounds(947, 497, 138, 34);
		frame.getContentPane().add(btnBack);
		
		JButton btnCancelorders = new JButton("Cancel Order");
		btnCancelorders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hbCB.setSelectedItem("0");
                ffCB.setSelectedItem("0");
                rfcCB.setSelectedItem("0");
                fsCB.setSelectedItem("0");
                csCB.setSelectedItem("0");
                chickCB.setSelectedItem("0");
                cCB.setSelectedItem("0");
                cofCB.setSelectedItem("0");
                ljCB.setSelectedItem("0");
                sicCB.setSelectedItem("0");
                vsCB.setSelectedItem("0");
                cmsCB.setSelectedItem("0");
		
			}
		});
		btnCancelorders.setBounds(804, 497, 138, 34);
		frame.getContentPane().add(btnCancelorders);
		
		JButton btnShowInvoice = new JButton("Generate Invoice");
		btnShowInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String customer_name = customerNameTF.getText();
		        String customer_address = addressTF.getText();
		        String ham_burger = hbCB.getSelectedItem().toString();
		        String french_fries = ffCB.getSelectedItem().toString();
		        String rice_withFriedChicken = rfcCB.getSelectedItem().toString();
		        String fish_sandwich = fsCB.getSelectedItem().toString();
		        String cheese_sandwich = csCB.getSelectedItem().toString();
		        String chicken_sandwich = chickCB.getSelectedItem().toString();
		        String cola = cCB.getSelectedItem().toString();
		        String coffee = cofCB.getSelectedItem().toString();
		        String lemon_juice = ljCB.getSelectedItem().toString();
		        String strawberry_iceCream = sicCB.getSelectedItem().toString();
		        String vanilla_shake = vsCB.getSelectedItem().toString();
		        String choco_milkShake = cmsCB.getSelectedItem().toString();
		        String quantity = numberOfItemsTF.getText();
		        String price = totalAmountTF.getText();
		        String month = monthCB.getSelectedItem().toString();
		        String day = dayCB.getSelectedItem().toString();
		        String year = yearCB.getSelectedItem().toString();
		        String order_date = month + "/" + day + "/" + year;
		        
		        
				double selectedOption1 = Double.parseDouble((String) hbCB.getSelectedItem());
				double hbCBa = 55;
				double hbCBamount = selectedOption1 * 55;

				
				double selectedOption2 = Double.parseDouble((String) ffCB.getSelectedItem());
				double ffCBa = 35;
				double ffCBamount = selectedOption2 * 35;
				
				double selectedOption3 = Double.parseDouble((String) rfcCB.getSelectedItem());
				double rfcCBa = 75;
				double rfcCBamount = selectedOption3 * 75;
		        
				double selectedOption4 = Double.parseDouble((String) fsCB.getSelectedItem());
				double fsCBa = 35;
				double fsCBamount = selectedOption4 * 35;
				
				double selectedOption5 = Double.parseDouble((String) csCB.getSelectedItem());
				double csCBa = 40;
				double csCBamount = selectedOption5 * 40;
				
				double selectedOption6 = Double.parseDouble((String) chickCB.getSelectedItem());
				double chickCBa = 55;
				double chickCBamount = selectedOption6 * 55;
				
				double selectedOption7 = Double.parseDouble((String) cCB.getSelectedItem());
				double cCBa = 30;
				double cCBamount = selectedOption7 * 30;
				
				double selectedOption8 = Double.parseDouble((String) cofCB.getSelectedItem());
				double cofCBa = 30;
				double cofCBamount = selectedOption8 * 30;
				
				double selectedOption9 = Double.parseDouble((String) ljCB.getSelectedItem());
				double ljCBa = 30;
				double ljCBamount = selectedOption9 * 30;
				
				double selectedOption10 = Double.parseDouble((String) sicCB.getSelectedItem());
				double sicCBa = 45;
				double sicCBamount = selectedOption10 * 45;
				
				double selectedOption11 = Double.parseDouble((String) vsCB.getSelectedItem());
				double vsCBa = 50;
				double vsCBamount = selectedOption11 * 50;
		        
				double selectedOption12 = Double.parseDouble((String) cmsCB.getSelectedItem());
				double cmsCBa = 50;
				double cmsCBamount = selectedOption12 * 50;
		        
		        JFileChooser dialog = new JFileChooser();
				dialog.setSelectedFile(new File("Invoice"+"_" +customer_name+"_"+customer_address+".pdf"));
				int result  = dialog.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String file_path = dialog.getSelectedFile().getPath();
					
					
					try {
					    Document invoice = new Document();
					    PdfWriter mywriter = PdfWriter.getInstance(invoice, new FileOutputStream(file_path));
					    
					    invoice.open();
					    invoice.add(new Paragraph("                                         INVOICE ", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20)));
					    invoice.add(new Paragraph("                                                                             ", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph("                                                                             ", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph(" Bill to: " + "            " + customer_name, FontFactory.getFont(FontFactory.TIMES, 15)));
					    invoice.add(new Paragraph("                      " + "         " + customer_address, FontFactory.getFont(FontFactory.TIMES, 15)));
					    invoice.add(new Paragraph(" Invoice Date: " + "            " + order_date, FontFactory.getFont(FontFactory.TIMES, 15)));
					    invoice.add(new Paragraph("                                                                             ", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph("                                                                             ", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph("______________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 12)));
					    invoice.add(new Paragraph("                                                                             ", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph("Description                            Quantity                            Unit Price                           Amount", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph("                                                                             ", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph("______________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 12)));

					    if (selectedOption1 > 0) {
					        invoice.add(new Paragraph(" Ham Burger " + "                             " + ham_burger + "                                     " + hbCBa + "                                  " + hbCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }
					    
					    if (selectedOption2 > 0) {
					        invoice.add(new Paragraph(" French Fries " + "                             " + french_fries + "                                     " + ffCBa + "                                   " + ffCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }
					    
					    if (selectedOption3 > 0) {
					        invoice.add(new Paragraph(" Rice w/ Fried Chicken " + "             " + rice_withFriedChicken + "                                    " + rfcCBa + "                                    " + rfcCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }
					    
					    if (selectedOption4 > 0) {
					        invoice.add(new Paragraph(" Fish Sandwich " + "                           " + fish_sandwich + "                                       " + fsCBa + "                                   " + fsCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }
					    
					    if (selectedOption5 > 0) {
					        invoice.add(new Paragraph(" Cheese Sandwich " + "                     " + cheese_sandwich + "                                      " + csCBa + "                                   " + csCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }
					    
					    if (selectedOption6 > 0) {
					        invoice.add(new Paragraph(" Chicken Sandwich " + "                  " + chicken_sandwich + "                                  " + chickCBa + "                                   " + chickCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }

					    if (selectedOption7 > 0) {
					        invoice.add(new Paragraph(" Cola " + "                                          " + cola + "                                         " + cCBa + "                               " + cCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }

					    if (selectedOption8 > 0) {
					        invoice.add(new Paragraph(" Coffee " + "                                        " + coffee + "                                        " + cofCBa + "                                " + cofCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }

					    if (selectedOption9 > 0) {
					        invoice.add(new Paragraph(" Lemon Juice " + "                            " + lemon_juice + "                                     " + ljCBa + "                                  " + ljCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }

					    if (selectedOption10 > 0) {
					        invoice.add(new Paragraph(" Strawberry Ice Cream " + "             " + strawberry_iceCream + "                                   " + sicCBa + "                                    " + sicCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }

					    if (selectedOption11 > 0) {
					        invoice.add(new Paragraph(" Vanilla Shake " + "                            " + vanilla_shake + "                                     " + vsCBa + "                                  " + vsCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }

					    if (selectedOption12 > 0) {
					        invoice.add(new Paragraph(" Choco Milk Shake " + "                     " + choco_milkShake + "                                   " + cmsCBa + "                                  " + cmsCBamount, FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    }

					    invoice.add(new Paragraph("                                                                             ", FontFactory.getFont(FontFactory.HELVETICA, 13)));
					    invoice.add(new Paragraph("______________________________________________________________________________", FontFactory.getFont(FontFactory.HELVETICA, 12)));
					    invoice.add(new Paragraph("                                                   " + quantity + "                                                                    " + price, FontFactory.getFont(FontFactory.HELVETICA, 13)));

					    invoice.add(new Paragraph(new Date().toString()));

					    invoice.close();
					    JOptionPane.showMessageDialog(null, "Successfully Generated");
					} catch (Exception e1) {
					    JOptionPane.showMessageDialog(null, e1);
					}
					
					
													
				}
			}
			
		});
		btnShowInvoice.setBounds(947, 542, 138, 34);
		frame.getContentPane().add(btnShowInvoice);
		
		JLabel lblNewLabel_2_3_1_2 = new JLabel("Receiver's Name");
		lblNewLabel_2_3_1_2.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_3_1_2.setBounds(27, 479, 115, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1_2);
		
		JLabel lblNewLabel_2_3_1_2_1 = new JLabel("Delivery Address");
		lblNewLabel_2_3_1_2_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_3_1_2_1.setBounds(27, 509, 115, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1_2_1);
		
		customerNameTF = new JTextField();
		customerNameTF.setColumns(10);
		customerNameTF.setBounds(138, 476, 267, 22);
		frame.getContentPane().add(customerNameTF);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(138, 506, 370, 22);
		frame.getContentPane().add(addressTF);
		
		JLabel lblNewLabel_2_3_1_2_1_1 = new JLabel("Date");
		lblNewLabel_2_3_1_2_1_1.setFont(new Font("Gadugi", Font.BOLD, 13));
		lblNewLabel_2_3_1_2_1_1.setBounds(29, 556, 48, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1_2_1_1);
		
		
	}

	

	private static void updateTotal(JTextField hbCBTotal, JTextField ffCBTotal, JTextField rfcCBTotal,  JTextField fsCBTotal, JTextField csCBTotal, JTextField chickCBTotal, JTextField cCBTotal, JTextField cofCBTotal, JTextField ljCBTotal, JTextField sicCBTotal, JTextField vsCBTotal, JTextField cmsCBTotal, JTextField totalAmount) {
	    double result1 = hbCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(hbCBTotal.getText());
	    double result2 = ffCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(ffCBTotal.getText());
	    double result3 = rfcCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(rfcCBTotal.getText());
	    double result4 = fsCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(fsCBTotal.getText());
	    double result5 = csCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(csCBTotal.getText());
	    double result6 = chickCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(chickCBTotal.getText());
	    double result7 = cCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(cCBTotal.getText());
	    double result8 = cofCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(cofCBTotal.getText());
	    double result9 = ljCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(ljCBTotal.getText());
	    double result10 = sicCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(sicCBTotal.getText());
	    double result11 = vsCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(vsCBTotal.getText());
	    double result12 = cmsCBTotal.getText().isEmpty() ? 0 : Double.parseDouble(cmsCBTotal.getText());



	    double total = result1 + result2+result3+result4+result5+result6+result7+result8+result9+result10+result11+result12;
	    totalAmount.setText(String.format("PHP %.2f", total)); 
    
    }

	
	
	private static void updateQuantity(JTextField hbCBq, JTextField ffCBq, JTextField rfcCBq, JTextField fsCBq, JTextField csCBq, JTextField chickCBq, JTextField cCBq, JTextField cofCBq, JTextField ljCBq, JTextField sicCBq, JTextField vsCBq, JTextField cmsCBq, JTextField numberOfItemsTF) {
	    // Method body remains unchanged based on your original method logic
		
	   int result1q = hbCBq.getText().isEmpty() ? 0 : Integer.parseInt(hbCBq.getText());
	   int result2q = ffCBq.getText().isEmpty() ? 0 : Integer.parseInt(ffCBq.getText());
	   int result3q = rfcCBq.getText().isEmpty() ? 0 : Integer.parseInt(rfcCBq.getText());
	   int result4q = fsCBq.getText().isEmpty() ? 0 : Integer.parseInt(fsCBq.getText());
	   int result5q = csCBq.getText().isEmpty() ? 0 : Integer.parseInt(csCBq.getText());
	   int result6q = chickCBq.getText().isEmpty() ? 0 : Integer.parseInt(chickCBq.getText());
	   int result7q = cCBq.getText().isEmpty() ? 0 : Integer.parseInt(cCBq.getText());
	   int result8q = cofCBq.getText().isEmpty() ? 0 : Integer.parseInt(cofCBq.getText());
	   int result9q = ljCBq.getText().isEmpty() ? 0 : Integer.parseInt(ljCBq.getText());
	   int result10q = sicCBq.getText().isEmpty() ? 0 : Integer.parseInt(sicCBq.getText());
	   int result11q = vsCBq.getText().isEmpty() ? 0 : Integer.parseInt(vsCBq.getText());
	   int result12q = cmsCBq.getText().isEmpty() ? 0 : Integer.parseInt(cmsCBq.getText());

	    int totalq = result1q + result2q+result3q+result4q+result5q+result6q+result7q+result8q+result9q+result10q+result11q+result12q;
	    numberOfItemsTF.setText(String.valueOf(totalq)); 


		
		
	}
		
		
		

	
	
	public void setVisible(boolean b) {
		 frame.setVisible(b);
		
	}
}
