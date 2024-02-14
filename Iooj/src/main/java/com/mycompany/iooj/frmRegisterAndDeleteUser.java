package com.mycompany.iooj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class frmRegisterAndDeleteUser extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField tfUsername;
	private JTextField tfAlias;
	private JTextField tfPassword;
	private JTextField tfEmail;
	private JTextField tfContactNum;
	private JLabel lblUsername;
	private String username;
	private String alias;
	private static JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegisterAndDeleteUser frame = new frmRegisterAndDeleteUser();
					frame.setVisible(true);
					importTextFile();	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 public frmRegisterAndDeleteUser() {
		    initComponents();
		    }
	 public frmRegisterAndDeleteUser(String username, String alias) {
		 initComponents();
		 lblUsername.setText(username);
		 this.username = username;
		 this.alias = alias;
	 }
	 
	public Boolean registerDetailsValid() {
		
		String filepath = "userinfo.txt";
		
		// Alias must all be in words
		// Role will not be inspected since it is a comboBox, and its index = 0 (default Role)
		if (tfUsername.getText().trim().isBlank() 
				|| tfAlias.getText().trim().isEmpty()  
				|| tfPassword.getText().trim().isEmpty()   
				|| tfEmail.getText().trim().isEmpty()
				|| tfContactNum.getText().trim().isEmpty()) 
		{	
			JOptionPane.showMessageDialog(frame, "Some Fields Are Empty!", "User Profile", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (! Validations.usernameUnique(tfUsername.getText(), 0, filepath)) {
			JOptionPane.showMessageDialog(frame, "Username Taken", "User Profile", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (! Validations.aliasIsValid(tfAlias.getText())) {
			JOptionPane.showMessageDialog(frame, "Alias must be in words", "User Profile", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (! Validations.passwordIsValid(tfPassword.getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid Password. Must have at least 1 special character", "User Profile", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (! Validations.emailIsValid(tfEmail.getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid Email", "User Profile", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// skipped cmbRole since it is comboBox
		else if (! Validations.contactNumIsValid(tfContactNum.getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid Phone Number. Must start with 60...(10 - 12 numbers inclusive)", "User Profile", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
		
	}
	
	 
	// IMPORT TEXT FILE TO TABLE
	public static void importTextFile () {
		
		String filepath = "userinfo.txt";
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			
			// get lines from txt file
            Object[] allRec = br.lines().toArray();
             
            for (Object eachRec : allRec) {
				
            	String[] tableRow = ((String) eachRec).split(",");
                model.addRow(tableRow);	
			}
            
            br.close();
                     
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	// EXPORT TEXT FILE TO TABLE
	public static void exportTable () {
		
		String filepath = "userinfo.txt";
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
			for (int i = 0; i < table.getRowCount(); i++) {
				for (int j = 0; j < table.getColumnCount(); j++) {
					bw.write(table.getModel().getValueAt(i, j)+",");
				};
				bw.write("\n");
			}
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// To remove the last comma at the end of each record
		ArrayList<String> tempArray = new ArrayList<>();
		String line;
		String new_line;
		
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(filepath)));
			
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				new_line = line.substring(0, line.length() - 1);
				tempArray.add(new_line);
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
			for (String record : tempArray) {
				bw.write(record + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 576);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel.setBounds(10, 11, 1000, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(38, 23, 931, 73);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Stakeholder Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(351, 24, 181, 27);
		panel_1.add(lblNewLabel);
		
		lblUsername = new JLabel("none");
		lblUsername.setBounds(66, 33, 65, 14);
		panel_1.add(lblUsername);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1.setBounds(38, 107, 263, 284);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(24, 28, 112, 27);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alias");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(24, 66, 112, 27);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(24, 98, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(24, 136, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Role");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_3.setBounds(24, 172, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Contact Number");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_3_1.setBounds(24, 209, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_3_1);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfUsername.setBounds(146, 28, 92, 30);
		panel_1_1.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfAlias = new JTextField();
		tfAlias.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfAlias.setColumns(10);
		tfAlias.setBounds(146, 64, 92, 30);
		panel_1_1.add(tfAlias);
		
		tfPassword = new JTextField();
		tfPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfPassword.setColumns(10);
		tfPassword.setBounds(146, 98, 92, 30);
		panel_1_1.add(tfPassword);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfEmail.setColumns(10);
		tfEmail.setBounds(146, 136, 92, 30);
		panel_1_1.add(tfEmail);
		
		tfContactNum = new JTextField();
		tfContactNum.setText("60");
		tfContactNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfContactNum.setColumns(10);
		tfContactNum.setBounds(146, 209, 92, 30);
		panel_1_1.add(tfContactNum);
		
		JComboBox cmbRole = new JComboBox();
		cmbRole.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Trainer", "Manager"}));
		cmbRole.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbRole.setBounds(146, 175, 92, 30);
		panel_1_1.add(cmbRole);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_2.setBackground(new Color(176, 224, 230));
		panel_1_2.setBounds(38, 402, 931, 72);
		panel.add(panel_1_2);
		
		JButton btnAddRecord = new JButton("Add Record");
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				if (registerDetailsValid()) 
				{
					model.addRow(new Object[] { 
							tfUsername.getText(),
							tfAlias.getText(),
							tfPassword.getText(),
							tfEmail.getText(),
							cmbRole.getSelectedItem(),
							tfContactNum.getText()});
					
					// will be exporting table to write over the userinfo.txt, 
					// but will produce the same result as append
					exportTable();				  
					JOptionPane.showMessageDialog(frame, "New Profile Added!", "User Profile", JOptionPane.INFORMATION_MESSAGE);	
				}			
			}		

		});
		btnAddRecord.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddRecord.setBounds(105, 26, 127, 23);
		panel_1_2.add(btnAddRecord);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfUsername.setText("");
				tfAlias.setText("");
				tfPassword.setText("");
				tfEmail.setText("");
				cmbRole.setSelectedIndex(0);
				tfContactNum.setText("");
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(296, 26, 127, 23);
		panel_1_2.add(btnReset);
		
		JButton btnDelete = new JButton("Delete Record");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(btnDelete, "No Record to Delete", "Stakeholder Profile", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(btnDelete, "Select A Record to Delete", "Stakeholder Profile", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (table.getSelectedRow() != -1) {
					
					// Asking user to confirm delete
					int dialogVal = JOptionPane.showConfirmDialog(frame, "Confirm Deletion ?", 
							"Stakeholder Profile", JOptionPane.YES_NO_OPTION);
					
					if(dialogVal == 0) {
						model.removeRow(table.getSelectedRow());
						exportTable();
					}
				}	
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(490, 26, 127, 23);
		panel_1_2.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogVal = JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", 
						"Exit", JOptionPane.YES_NO_OPTION);
				
				if (dialogVal == 0) {
					frmManagerMainPage frmobj = new frmManagerMainPage(username + "," + alias);
					frmobj.setVisible(true);
					dispose();
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(689, 26, 127, 23);
		panel_1_2.add(btnExit);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1_1.setBounds(311, 107, 658, 284);
		panel.add(panel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				table.getSelectionModel().clearSelection();
				
			}
		});
		scrollPane.setBounds(24, 21, 610, 241);
		panel_1_1_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				tfUsername.setText(model.getValueAt(selectedRow, 0).toString());
				tfAlias.setText(model.getValueAt(selectedRow, 1).toString());
				tfPassword.setText(model.getValueAt(selectedRow, 2).toString());
				tfEmail.setText(model.getValueAt(selectedRow, 3).toString());
				cmbRole.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
				tfContactNum.setText(model.getValueAt(selectedRow, 5).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Username (ID)", "Alias", "Password", "Email", "Role", "Contact Number"
			}
		));
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
