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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class frmModifyProfile extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfAlias;
	private JTextField tfPassword;
	private JTextField tfEmail;
	private JTextField tfContactNum;
	private JFrame frame;
	private JLabel lblUsername;
	private String username;
	private String alias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmModifyProfile frame = new frmModifyProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public frmModifyProfile() {
		initComponents();
	}
	public frmModifyProfile(String username, String alias) {
		initComponents();
		lblUsername.setText(username);
		this.username = username;
		this.alias = alias;
	}
	
	// check if modified credentials are valid
	public Boolean modifiedDetailsIsValid() {
		
		if (! Validations.aliasIsValid(tfAlias.getText())) {
			JOptionPane.showMessageDialog(frame, "Alias must be in words", "Modify Profile", JOptionPane.ERROR_MESSAGE);
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
		// cmbRole skipped because its comboBox, wont have invalid values
		else if (! Validations.contactNumIsValid(tfContactNum.getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid Phone Number. Must start with 60...(10 - 12 numbers inclusive)", "User Profile", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;	
	}

	/**
	 * Create the frame.
	 */
	private void initComponents() {
		
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1273, 604);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(118, 31, 1000, 502);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(38, 23, 931, 73);
		panel.add(panel_1);
		
		JLabel lblModifyUserProfile = new JLabel("Modify User Profile");
		lblModifyUserProfile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModifyUserProfile.setBounds(374, 24, 181, 27);
		panel_1.add(lblModifyUserProfile);
		
		lblUsername = new JLabel("no name");
		lblUsername.setBounds(654, 33, 58, 14);
		panel_1.add(lblUsername);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1.setBounds(363, 190, 263, 272);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alias");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(24, 25, 112, 27);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(24, 57, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(24, 95, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Role");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_3.setBounds(24, 131, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Contact Number");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_3_1.setBounds(24, 168, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_3_1);
		
		tfAlias = new JTextField();
		tfAlias.setEnabled(false);
		tfAlias.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfAlias.setColumns(10);
		tfAlias.setBounds(146, 23, 92, 30);
		panel_1_1.add(tfAlias);
		
		tfPassword = new JTextField();
		tfPassword.setEnabled(false);
		tfPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfPassword.setColumns(10);
		tfPassword.setBounds(146, 60, 92, 30);
		panel_1_1.add(tfPassword);
		
		tfEmail = new JTextField();
		tfEmail.setEnabled(false);
		tfEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfEmail.setColumns(10);
		tfEmail.setBounds(146, 95, 92, 30);
		panel_1_1.add(tfEmail);
		
		tfContactNum = new JTextField();
		tfContactNum.setEnabled(false);
		tfContactNum.setText("60");
		tfContactNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfContactNum.setColumns(10);
		tfContactNum.setBounds(146, 168, 92, 30);
		panel_1_1.add(tfContactNum);
		
		JComboBox cmbRole = new JComboBox();
		cmbRole.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Trainer", "Manager"}));
		cmbRole.setEnabled(false);
		cmbRole.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbRole.setBounds(146, 134, 92, 30);
		panel_1_1.add(cmbRole);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filepath = "userinfo.txt";
				String line;
				String[] eachColVal;
				ArrayList<String> tempArray = new ArrayList<>();

				if (modifiedDetailsIsValid()) {
					try {
						BufferedReader br = new BufferedReader(new FileReader(filepath));
						while((line = br.readLine()) != null) {
							eachColVal = line.split(",");
							// assign modified info to specifc record
							if (eachColVal[0].equals(tfUsername.getText())) {
								tempArray.add(
									tfUsername.getText() + "," + 
									tfAlias.getText() + "," + 
									tfPassword.getText() + "," + 
									tfEmail.getText() + "," + 
									cmbRole.getSelectedItem() + "," +
									tfContactNum.getText());
							}
							else {
								tempArray.add(line);
							}
						}
						br.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					// overwrite the userinfo.txt with latest changes
					try {
						PrintWriter pw = new PrintWriter(filepath);
						for (String rec : tempArray) {
							pw.println(rec);
						}
						pw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Update Successful !", "Modify User Profile", JOptionPane.INFORMATION_MESSAGE);
					// go back to form load appearance
					tfUsername.setText("");;
					tfUsername.setEnabled(true);
					tfAlias.setText("");
					tfAlias.setEnabled(false);
					tfPassword.setText("");
					tfPassword.setEnabled(false);
					tfEmail.setText("");
					tfEmail.setEnabled(false);
					cmbRole.setSelectedIndex(0);
					cmbRole.setEnabled(false);
					tfContactNum.setText("");
					tfContactNum.setEnabled(false);
					btnUpdate.setEnabled(false);		
				}
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(74, 215, 127, 23);
		panel_1_1.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_2.setBackground(new Color(176, 224, 230));
		panel_1_2.setBounds(38, 107, 931, 72);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(337, 23, 77, 27);
		panel_1_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfUsername = new JTextField();
		tfUsername.setBounds(424, 26, 92, 30);
		panel_1_2.add(tfUsername);
		tfUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfUsername.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filepath = "userinfo.txt";
				String line;
				String[] eachColVal;
				
				if(! Validations.usernameUnique(tfUsername.getText(), 0, filepath)) {
					
					tfUsername.setEnabled(false);
					tfAlias.setEnabled(true);
					tfPassword.setEnabled(true);
					tfEmail.setEnabled(true);
					cmbRole.setEnabled(true);
					tfContactNum.setEnabled(true);
					btnUpdate.setEnabled(true);
					
					try {
						BufferedReader br = new BufferedReader(new FileReader(filepath));
						while((line = br.readLine()) != null) {
							eachColVal = line.split(",");
							if (eachColVal[0].equals(tfUsername.getText())) {
								
								tfAlias.setText(eachColVal[1].toString());
								tfPassword.setText(eachColVal[2].toString());
								tfEmail.setText(eachColVal[3].toString());
								cmbRole.setSelectedItem(eachColVal[4].toString());
								tfContactNum.setText(eachColVal[5].toString());
								
							}
						}
						br.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Username Not Found. Try Again", "Modify User Profile", JOptionPane.ERROR_MESSAGE);
					tfUsername.requestFocus();
				}

			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(533, 25, 127, 23);
		panel_1_2.add(btnSearch);
		
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
		btnExit.setBounds(758, 393, 127, 23);
		panel.add(btnExit);
	}
}