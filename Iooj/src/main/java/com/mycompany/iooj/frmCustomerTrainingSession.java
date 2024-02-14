package com.mycompany.iooj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmCustomerTrainingSession extends JFrame implements resetGUI {

	private JPanel contentPane;
	private JTextField tfCustomerID;
	private JTextField tfDate;
	private JTable table;
	private JFrame frame;
	private JComboBox cmbTrainer;
	private JComboBox cmbTime;
	private JComboBox cmbTraining;
	private JLabel lblUsername;
	private String username;
	private String alias;
	private JButton btnAddBooking;
	private JButton btnReset;
	private JButton btnDeleteBooking;
	private JButton btnExit;
	private JButton btnPrint;
	
	
	 public frmCustomerTrainingSession() {
		    initComponents();
		    }
	 public frmCustomerTrainingSession(String username, String alias) {
		 initComponents();
		 lblUsername.setText(username);
		 this.username = username;
		 this.alias = alias;
	 }
	
	// JTableOperations abstract methods
	 
	public ArrayList<String> createRecArray() {
		
		// Creating an array of the booking record to be inserted to table and text file
		ArrayList<String> tableRows = new ArrayList<>();
		tableRows.add(String.format("%04d", latestSessionID("sessions.txt")));
		tableRows.add(tfDate.getText());
		tableRows.add(cmbTime.getSelectedItem().toString());
		tableRows.add(cmbTraining.getSelectedItem().toString());
		tableRows.add(tfCustomerID.getText());
		tableRows.add(cmbTrainer.getSelectedItem().toString());
		return tableRows;
		
	}

	
	public boolean noDuplicates() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<String> bookedTimes = new ArrayList<>();
		ArrayList<String> bookedSession = new ArrayList<>();
		ArrayList<String> bookedTrainer = new ArrayList<>();
		Boolean noDuplicateBookings = true;
		
		// Getting column values for Time, Training, and Trainer ID
		for (int i = 0; i < model.getRowCount(); i++) {	
			bookedTimes.add((String) model.getValueAt(i, 2));
		}
		
		for (int i = 0; i < model.getRowCount(); i++) {
			bookedSession.add((String) model.getValueAt(i, 3));	
		}
		
		for (int i = 0; i < model.getRowCount(); i++) {
			bookedTrainer.add((String) model.getValueAt(i, 5));	
		}
		
		// Comparing respective comboBoxes' selected item to its matching column 
		for (int i = 0; i < model.getRowCount(); i++) {
			
			// checking if the booking details has already been taken
			if(bookedTimes.get(i).equals(cmbTime.getSelectedItem().toString()) && 
				bookedSession.get(i).equals(cmbTraining.getSelectedItem().toString()) &&
				bookedTrainer.get(i).equals(cmbTrainer.getSelectedItem().toString()))
			{
				noDuplicateBookings = false;
			}
		}
		
		return noDuplicateBookings;
	}
	
	public int deleteRow() {
		
		int dialogVal = -1;	 // 
		
		if (table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(frame, "No Record to Delete", "Stakeholder Profile", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(frame, "Select A Record to Delete", "Stakeholder Profile", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (table.getSelectedRow() != -1) {
			// Asking user to confirm delete
			dialogVal = JOptionPane.showConfirmDialog(frame, "Confirm Deletion ?", 
					"Stakeholder Profile", JOptionPane.YES_NO_OPTION);
		}
		// YES will return 0
		// NO will retun 1
		return dialogVal;
	}

	
	// FileOperations abstract methods
	public void appendToFile(String filepath, ArrayList<String> newRec) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true));
			
			// Appending default column values to booking record, which will be modified by trainer
			ArrayList<String> defaultColVal = new ArrayList<>(Arrays.asList(
					"incomplete", 
					"null", 
					"null", 
					"50", 
					"unpaid"));
			newRec.addAll(defaultColVal);
			
			String newBookingRecord = "";
			
			// Converting booking record to string with desired delimiter
			for (String colValue : newRec) {
				newBookingRecord += colValue + "~";
			}
			
			// remove the final ~
			newBookingRecord = newBookingRecord.substring(0, newBookingRecord.length() - 1);
			
			// append booking record to text file
			bw.write(newBookingRecord);
                        bw.newLine();
			bw.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

	public void deleteFileRecord(String filepath, String removeTerm, int index) {
		
		// create temp file 
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String currentLine;
		String[] data;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, true));
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			
			while ((currentLine = br.readLine()) != null) {
				data = currentLine.split("~");
				
				// will write records to temp file if session ID does not match
				if (! data[index].equals(removeTerm)) {
					bw.write(currentLine);
					bw.newLine();
				}
			}
			
			bw.close();
			br.close();
			
			// delete old file and rename the abstract path name for temp file
			oldFile.delete();
			File temp = new File(filepath);
			newFile.renameTo(temp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	// Class methods
	
	public void populateBookedTable(String dateTerm) {
		
		String filepath = "sessions.txt";
		String line;
		String[] eachColVal;
		ArrayList<String> sameDateRec = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			while((line = br.readLine()) != null) {
				eachColVal = line.split("~");
				if (eachColVal[1].contains(dateTerm)) {
					sameDateRec.add(line);	
				}
			}
			br.close();
			for (String eachRec : sameDateRec) {
            	ArrayList<String> tableRow1 = new ArrayList<>(Arrays.asList(eachRec.split("~")));
            	// getting only desired columns from sessions.txt
            	String[] tableRow2 = {tableRow1.get(0),tableRow1.get(1), tableRow1.get(2), tableRow1.get(3), tableRow1.get(4), tableRow1.get(5)};
            	model.addRow(tableRow2);	
			}			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	
	// only dateTextField and Exit button won't be included here
	public void setBtnEnabledState(Boolean state) {
		
		cmbTime.setEnabled(state);
		cmbTraining.setEnabled(state);
		cmbTrainer.setEnabled(state);
		tfCustomerID.setEnabled(state);
		
		btnAddBooking.setEnabled(state);
		btnDeleteBooking.setEnabled(state);
		btnReset.setEnabled(state);
		btnPrint.setEnabled(state);		
		
	}
	
	@Override
	// housekeeping commands when wrong date or year is entered
	public void resetComponents(String term, String format) {

		JOptionPane.showMessageDialog(null, "Invalid " + term + " Entry. Try Again",  term + " Format", JOptionPane.ERROR_MESSAGE);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		tfDate.setText(format);
		tfDate.requestFocus();
		
		setBtnEnabledState(false);
			
	}
	
	public int latestSessionID(String filepath) {
		
		/*
		 * Will be finding the last sessionID and adding it by 1
		 * 
		 * Note: counting the number of rows for the file will not be suitable
		 * 		 as the delete function may cause several rows to be deleted,
		 * 		 causing some session IDs to match, hence, not unique.
		 * 
		 * This way, session IDs will never duplicate
		 * */
		
		String line;
		String lastSessionID = null;
		int lastID;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			while((line = br.readLine()) != null) {
				String[] eachColVal = line.split("~");
				
				// will loop till the last session ID
				lastSessionID = eachColVal[0];
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// adding 1 to the last session ID to be used when new customer booking is made
		// (will be formatted to String in createRecArray() method)
		lastID = Integer.parseInt(lastSessionID) + 1;
		return lastID;
	}

	// Since new trainers can be registered, this method will add all registered trainers
	// for to the comboBox for customers to choose thier desired trainers
	public void populateCmbTrainer() {
		
		String filepath = "userinfo.txt";
		String line;
		String[] eachColVal;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			while((line = br.readLine()) != null) {
				eachColVal = line.split(",");
				if (eachColVal[4].contains("Trainer")) {
					cmbTrainer.addItem(eachColVal[0]);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCustomerTrainingSession frame = new frmCustomerTrainingSession();
					frame.setVisible(true);
					frame.populateCmbTrainer();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 592);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 11, 1000, 502);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(38, 23, 931, 73);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Training Sessions");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(50, 22, 167, 27);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date");
		lblNewLabel_1_1.setBounds(350, 24, 64, 27);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfDate = new JTextField();
		tfDate.setText("dd/mm/yyyy");
		tfDate.setBounds(398, 27, 92, 30);
		panel_1.add(tfDate);
		tfDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfDate.setColumns(10);
		tfDate.requestFocus();
		
		JButton btnSearchDate = new JButton("Search");
		btnSearchDate.setBounds(510, 28, 127, 23);
		panel_1.add(btnSearchDate);
		btnSearchDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				// clear table evertytime a new search date is entered to not append the table
				model.setRowCount(0);
				if (Validations.dateIsValid(tfDate.getText())) {
					// Just a kind note
					// enable other buttons
					setBtnEnabledState(true);
					// will search for booked sessions for that date from sessions.txt and populate table
					populateBookedTable(tfDate.getText());
					// just a kind reminder tha there has not been bookings made for that date, as the table will be empty
					if (model.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "No Booked Sessions !", "Customer Booking", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					resetComponents("Date", "dd/mm/yyyy");	
				}
				
				
			}
		});
		btnSearchDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblUsername = new JLabel("no manager");
		lblUsername.setBounds(708, 31, 92, 14);
		panel_1.add(lblUsername);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1.setBounds(38, 107, 263, 284);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(24, 199, 112, 27);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Time");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(24, 85, 47, 27);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Trainer");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(24, 161, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_2);
		
		tfCustomerID = new JTextField();
		tfCustomerID.setEnabled(false);
		tfCustomerID.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfCustomerID.setColumns(10);
		tfCustomerID.setBounds(146, 202, 92, 30);
		panel_1_1.add(tfCustomerID);
		
		cmbTime = new JComboBox();
		cmbTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbTime.setEnabled(false);
		cmbTime.setModel(new DefaultComboBoxModel(new String[] {"12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00"}));
		cmbTime.setBounds(146, 88, 92, 30);
		panel_1_1.add(cmbTime);
		
		cmbTrainer = new JComboBox();
		cmbTrainer.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbTrainer.setEnabled(false);
		cmbTrainer.setBounds(146, 164, 92, 30);
		panel_1_1.add(cmbTrainer);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Training");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2_1.setBounds(24, 123, 112, 27);
		panel_1_1.add(lblNewLabel_1_1_2_1);
		
		cmbTraining = new JComboBox();
		cmbTraining.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbTraining.setModel(new DefaultComboBoxModel(new String[] {"HIIT", "LISS", "WEIGHT"}));
		cmbTraining.setEnabled(false);
		cmbTraining.setBounds(146, 126, 92, 30);
		panel_1_1.add(cmbTraining);
		
		JLabel lblNewLabel_1_2 = new JLabel("Note: Booking ID is Auto-Generated");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1_2.setBounds(24, 26, 214, 27);
		panel_1_1.add(lblNewLabel_1_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_2.setBackground(new Color(176, 224, 230));
		panel_1_2.setBounds(38, 402, 931, 72);
		panel.add(panel_1_2);
		
		btnAddBooking = new JButton("Add Booking");
		btnAddBooking.setEnabled(false);
		btnAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String filepath = "sessions.txt";
				ArrayList<String> newRec = new ArrayList<>();
				
				// Session details already booked
				if (! noDuplicates()) {
					JOptionPane.showMessageDialog(frame, "Session Already Booked ! Try Again", "Add Booking", JOptionPane.ERROR_MESSAGE);
				}
				// Session details are not yet booked (good for booking)
				else 
				{	
					if (Validations.customerIdIsValid(tfCustomerID.getText().trim())) {
						// creating an array of all the entry fields (booking record)
						newRec = createRecArray();
						// inserting booking record to table
						model.addRow(newRec.toArray());
						// appending booking record to file
						appendToFile(filepath, newRec);
						// create add booking log
						Logs.bookingLog(username, "Add", newRec.get(3));
						JOptionPane.showMessageDialog(null, "Customer Booking Added !", "Add Booking", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Customer ID ! Try Again", "Add Booking", JOptionPane.ERROR_MESSAGE);
					}			
				}
			}
		});

		btnAddBooking.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddBooking.setBounds(37, 27, 127, 23);
		panel_1_2.add(btnAddBooking);
		
		btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear fields and place default values
				tfDate.setText("");
				cmbTime.setSelectedIndex(0);
				cmbTraining.setSelectedIndex(0);
				cmbTrainer.setSelectedIndex(0);
				tfCustomerID.setText("");
				
				// make it look like form load
				setBtnEnabledState(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(194, 27, 139, 23);
		panel_1_2.add(btnReset);
		
		btnDeleteBooking = new JButton("Delete Booking");
		btnDeleteBooking.setEnabled(false);
		btnDeleteBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				ArrayList<String> deletedRec = new ArrayList<>();
				
				// user confirms deletion from ShowDialog box , 0 is YES
				if (deleteRow() == 0) {
					
					for (int i = 0; i < model.getColumnCount(); i++) {
						deletedRec.add(model.getValueAt(table.getSelectedRow(), i).toString());
					}
					
					model.removeRow(table.getSelectedRow());
					// delete specific row from file
					deleteFileRecord("sessions.txt", deletedRec.get(0), 0);
					Logs.bookingLog(username, "Del", deletedRec.get(3));
				}
			}
		});
		btnDeleteBooking.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteBooking.setBounds(382, 27, 127, 23);
		panel_1_2.add(btnDeleteBooking);
		
		btnExit = new JButton("Exit");
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
		btnExit.setBounds(776, 27, 127, 23);
		panel_1_2.add(btnExit);
		
		btnPrint = new JButton("Print Booked Sessions");
		btnPrint.setBounds(550, 27, 186, 23);
		panel_1_2.add(btnPrint);
		btnPrint.setEnabled(false);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header = new MessageFormat("Booked Training Sessions On " + tfDate.getText());
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (java.awt.print.PrinterException e1) {
					JOptionPane.showMessageDialog(btnPrint, 
							System.err.format("No Printer Found", e1.getMessage()), 
							"Customer Training Session", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		scrollPane.setBounds(24, 64, 610, 198);
		panel_1_1_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				cmbTime.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
				cmbTraining.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
				cmbTrainer.setSelectedItem(model.getValueAt(selectedRow, 5).toString());
				tfCustomerID.setText(model.getValueAt(selectedRow, 4).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Booking ID", "Date", "Time", "Training", "Customer ID", "Trainer ID"
			}
		));
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblBookedTrainingSessions = new JLabel("Booked Training Sessions");
		lblBookedTrainingSessions.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBookedTrainingSessions.setBounds(24, 26, 237, 27);
		panel_1_1_1.add(lblBookedTrainingSessions);
	}
}
