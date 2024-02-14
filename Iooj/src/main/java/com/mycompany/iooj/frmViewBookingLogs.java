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
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class frmViewBookingLogs extends JFrame implements resetGUI {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfDateOrYear;
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cmbMonth;
	private JTextArea txtAreaReport;
	private JButton btnSearch;
	private JButton btnPrintLogTable;
	private JButton btnPrintSummaryInfo;
	private JLabel lblUsername;
	private String username;
	private String alias;
	
	public frmViewBookingLogs() {
		initComponents();
	}
	public frmViewBookingLogs(String username, String alias) {
		initComponents();
		lblUsername.setText(username);
		this.username = username;
		this.alias = alias;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmViewBookingLogs frame = new frmViewBookingLogs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String monthNum (String month) {
		
		switch(month) {
        case "Jan":
            month = "01";
            break;
        case "Feb":
            month = "02";
            break;
        case "Mar":
            month = "03";
            break;
        case "Apr":
            month = "04";
            break;
        case "May":
            month = "05";
            break;
        case "Jun":
            month = "06";
            break;
        case "Jul":
            month = "07";
            break;
        case "Aug":
            month = "08";
            break;
        case "Sep":
            month = "09";
            break;
        case "Oct":
            month = "10";
            break;
        case "Nov":
            month = "11";
            break;
        case "Dec":
            month = "12";
        }
		return month;
	}
	
	public void filterBookingLogsAndPopulateJTable(String searchTerm) {
		
		String filepath = "Booking_Logs.txt";
		String line;
		String[] eachColVal;
		ArrayList<String> sameDateRec = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// clear table evertytime a new search date is entered
		model.setRowCount(0);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			while((line = br.readLine()) != null) {
				eachColVal = line.split(",");
				if (eachColVal[1].contains(searchTerm)) {
					sameDateRec.add(line);	
				}
			}
			br.close();
			for (String eachRec : sameDateRec) {
            	ArrayList<String> tableRow1 = new ArrayList<>(Arrays.asList(eachRec.split(",")));
            	model.addRow(tableRow1.toArray());	
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public ArrayList<String> countEachActivity() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// Number of Registered and Deleted Bookings
		int numberOfRegBook = 0;
		int numberOfDelBook = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 3).equals("AddedCustomerBooking")) {
				numberOfRegBook++;
			}
			else {
				numberOfDelBook++;
			}
		}
		ArrayList<String> activityCount = new ArrayList<>(Arrays.asList(
						Integer.toString(numberOfRegBook), 
						Integer.toString(numberOfDelBook)));
		return activityCount;
	}
	
	public ArrayList<String> countEachTrainingBasedOnEachActivity(String sessionName){
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int numberOfRegTraining = 0;
		int numberOfDelTraining = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 3).equals("AddedCustomerBooking") && model.getValueAt(i, 4).equals(sessionName)) {
				numberOfRegTraining++;
			}
			else if (model.getValueAt(i, 3).equals("DeletedCustomerBooking") && model.getValueAt(i, 4).equals(sessionName)) {
				numberOfDelTraining++;
			}
		}
		ArrayList<String> trainingCount = new ArrayList<>(Arrays.asList(
				Integer.toString(numberOfRegTraining), 
				Integer.toString(numberOfDelTraining)));
		return trainingCount;
	}
	
	public void writeSummaryInfo(String reference, String username) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		LocalDateTime currenDateTime = LocalDateTime.now();
		String formatted_currentDateTime = currenDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		
		txtAreaReport.append("\nBOOKING LOG: " + reference + " \n\n" + 
		
				"=====================================\n\n" + 
				
				"Overall\n"+ 
				"----------------------------------------------------------------\n\n" +
				
				"Total Number Of Logs: " + model.getRowCount() +"\n" + 
				"Total Number Of Registered Bookings: " + countEachActivity().get(0) +"\n" +
				"Total Number Of Deleted Bookings: " + countEachActivity().get(1) +"\n\n" + 
				
				"HIIT Training\n" + 
				"----------------------------------------------------------------\n\n" + 
				
				"Total Number Of Registered HIIT: " + countEachTrainingBasedOnEachActivity("HIIT").get(0) +"\n" +
				"Total Number Of Deleted HIIT: " + countEachTrainingBasedOnEachActivity("HIIT").get(1) +"\n\n" + 
				
				"LISS Training\n" + 
				"----------------------------------------------------------------\n\n" + 
				
				"Total Number Of Registered LISS: " + countEachTrainingBasedOnEachActivity("LISS").get(0) +"\n" +
				"Total Number Of Deleted LISS: " + countEachTrainingBasedOnEachActivity("LISS").get(1) +"\n\n" + 
				
				"WEIGHT Training\n" + 
				"----------------------------------------------------------------\n\n" + 
				
				"Total Number Of Registered WEIGHT: " + countEachTrainingBasedOnEachActivity("WEIGHT").get(0) +"\n" +
				"Total Number Of Deleted WEIGHT: " + countEachTrainingBasedOnEachActivity("WEIGHT").get(1) +"\n\n"+ 
		
				"=====================================\n\n" + 
				"Report Made On: " + formatted_currentDateTime + "\n" +
				"By: " + username);	
	}
	
	@Override
	// housekeeping commands when wrong date or year is entered
	public void resetComponents(String term, String format) {
		
			JOptionPane.showMessageDialog(null, "Invalid " + term + " Entry. Try Again",  term + " Format", JOptionPane.ERROR_MESSAGE);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			tfDateOrYear.setText(format);
			tfDateOrYear.requestFocus();
			btnPrintLogTable.setEnabled(false);
			btnPrintSummaryInfo.setEnabled(false);		
	}
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1241, 603);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(28, 11, 1156, 540);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(23, 23, 748, 73);
		panel.add(panel_1);
		
		JLabel lblCustomerTrainingBooking = new JLabel("Customer Training Booking Logs");
		lblCustomerTrainingBooking.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCustomerTrainingBooking.setBounds(189, 23, 301, 27);
		panel_1.add(lblCustomerTrainingBooking);
		
		lblUsername = new JLabel("New label");
		lblUsername.setBounds(582, 23, 84, 23);
		panel_1.add(lblUsername);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1_1.setBounds(20, 268, 751, 248);
		panel.add(panel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 22, 705, 168);
		panel_1_1_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"By", "Date Of Log", "Time Of Log", "Activity", "Training Session"
			}
		));
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1.setBounds(23, 107, 748, 150);
		panel.add(panel_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1_2.setBackground(new Color(176, 224, 230));
		panel_1_1_2.setBounds(793, 23, 341, 459);
		panel.add(panel_1_1_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 50, 297, 353);
		panel_1_1_2.add(scrollPane_1);
		
		txtAreaReport = new JTextArea();
		txtAreaReport.setEditable(false);
		txtAreaReport.setBackground(Color.LIGHT_GRAY);
		scrollPane_1.setViewportView(txtAreaReport);
		
		JLabel lblSummaryInformation = new JLabel("Summary Information");
		lblSummaryInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSummaryInformation.setBounds(57, 20, 211, 27);
		panel_1_1_2.add(lblSummaryInformation);
		
		JRadioButton rdbAll = new JRadioButton("Show All Logs");
		buttonGroup.add(rdbAll);
		rdbAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (rdbAll.isSelected()) {
					
					btnSearch.setEnabled(true);
					btnPrintLogTable.setEnabled(true);
					btnPrintSummaryInfo.setEnabled(true);
					model.setRowCount(0);
					txtAreaReport.setText("");
					tfDateOrYear.setText("");
					tfDateOrYear.setEnabled(false);
					cmbMonth.setSelectedIndex(-1);
					cmbMonth.setEnabled(false);
					
					String filepath = "Booking_Logs.txt";
					
					try {
						BufferedReader br = new BufferedReader(new FileReader(filepath));
						// get lines from txt file
			            Object[] allRec = br.lines().toArray();
			            for (Object eachRec : allRec) {
			            	String[] tableRow = ((String) eachRec).split(",");
			                model.addRow(tableRow);	
						}
			            br.close();
			            
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					writeSummaryInfo("HISTORY", username);
				}
				else {
					// clear table if rdbALl is not selected
					model.setRowCount(0);
				}
			}
		});
		rdbAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbAll.setBounds(164, 21, 127, 23);
		panel_1_1.add(rdbAll);
		
		JRadioButton rdbDate = new JRadioButton("Search By Date");
		buttonGroup.add(rdbDate);
		rdbDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbDate.isSelected()) {
					
					btnSearch.setEnabled(true);
					tfDateOrYear.setEnabled(true);
					tfDateOrYear.requestFocus();
					tfDateOrYear.setText("dd/mm/yyyy");
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					txtAreaReport.setText("");
					cmbMonth.setSelectedIndex(-1);
					cmbMonth.setEnabled(false);
				}
			}
		});
		rdbDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbDate.setBounds(164, 47, 127, 23);
		panel_1_1.add(rdbDate);
		
		JRadioButton rdbYear = new JRadioButton("Search By Year");
		rdbYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbYear.isSelected()) {
					
					btnSearch.setEnabled(true);
					tfDateOrYear.setEnabled(true);
					tfDateOrYear.requestFocus();
					tfDateOrYear.setText("yyyy");
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					txtAreaReport.setText("");
					cmbMonth.setSelectedIndex(-1);
					cmbMonth.setEnabled(false);
				}
			}
		});
		buttonGroup.add(rdbYear);
		rdbYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbYear.setBounds(393, 21, 191, 23);
		panel_1_1.add(rdbYear);
		
		JRadioButton rdbYrMth = new JRadioButton("Search By Year & Month");
		buttonGroup.add(rdbYrMth);
		rdbYrMth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbYrMth.isSelected()) {
					
					btnSearch.setEnabled(true);
					tfDateOrYear.setEnabled(true);
					cmbMonth.setEnabled(true);
					tfDateOrYear.requestFocus();
					tfDateOrYear.setText("yyyy");
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					txtAreaReport.setText("");
					model.setRowCount(0);
					cmbMonth.setSelectedIndex(0);
				}
				
			}
		});
		rdbYrMth.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbYrMth.setBounds(393, 47, 191, 23);
		panel_1_1.add(rdbYrMth);
		
		tfDateOrYear = new JTextField();
		tfDateOrYear.setEnabled(false);
		tfDateOrYear.setBounds(289, 78, 86, 30);
		panel_1_1.add(tfDateOrYear);
		tfDateOrYear.setColumns(10);
		
		cmbMonth = new JComboBox();
		cmbMonth.setEnabled(false);
		cmbMonth.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		cmbMonth.setBounds(289, 103, 86, 30);
		panel_1_1.add(cmbMonth);
		cmbMonth.setSelectedIndex(-1);
		
		JLabel lblNewLabel = new JLabel("Select An Option:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(43, 22, 127, 21);
		panel_1_1.add(lblNewLabel);
		
		btnSearch = new JButton("Search");
		btnSearch.setEnabled(false);
		btnSearch.setBounds(412, 102, 127, 23);
		panel_1_1.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				btnPrintLogTable.setEnabled(true);
				btnPrintSummaryInfo.setEnabled(true);
				// Clear previous summary information
				txtAreaReport.setText("");
									
				if (rdbDate.isSelected()) {
					// tfDateOrYear will be validated to be in DATE first before proceeding
					if (Validations.dateIsValid(tfDateOrYear.getText())) {
						// populating JTable with the desired info in accordance with date
						filterBookingLogsAndPopulateJTable(tfDateOrYear.getText());
						// check to see if the dates or year have any logs
						if (model.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "No Logs !", "Booking Logs", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							// count certain columns to produce report and write to text area
							writeSummaryInfo(tfDateOrYear.getText(), username);
						}						
					}
					else {					
						resetComponents("Date", "dd/mm/yyyy");
					}
					
				}
				else if (rdbYear.isSelected()) {	
					// tfDateOrYear will be validated to be in YEAR first before proceeding
					if (Validations.yearIsValid(tfDateOrYear.getText())) {	
						filterBookingLogsAndPopulateJTable(tfDateOrYear.getText());
						if (model.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "No Logs !", "Booking Logs", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							writeSummaryInfo(tfDateOrYear.getText(), username);
						}					
					}
					else {
						resetComponents("Year", "yyyy");
					}
					
				}
				else if (rdbYrMth.isSelected()) {
					if (Validations.yearIsValid(tfDateOrYear.getText())) {
						// Formatting month to be number (like Jun to 06), and then appending year to it (06/2022)
						// also, month dont need validation since its values are from comboBox (uneditable)
						String month = cmbMonth.getSelectedItem().toString();
						String correctMthYrFormat = monthNum(month).concat("/") + tfDateOrYear.getText();	
						filterBookingLogsAndPopulateJTable(correctMthYrFormat);
						if (model.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "No Logs !", "Booking Logs", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							writeSummaryInfo(month + " " + tfDateOrYear.getText(), username);
						}						
					}
					else {
						resetComponents("Year", "yyyy");
					}
				}	
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		btnExit.setBounds(894, 493, 121, 23);
		panel.add(btnExit);
		
		btnPrintLogTable = new JButton("Print Log Table");
		btnPrintLogTable.setEnabled(false);
		btnPrintLogTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header;
				if (rdbDate.isSelected() || rdbYear.isSelected()) {
					header = new MessageFormat("Booking Logs For " + tfDateOrYear.getText());
				}
				else if (rdbAll.isSelected()) {
					header = new MessageFormat("All Booking Logs History");
				}
				else 
				{
					header = new MessageFormat("Booking Logs For " + cmbMonth.getSelectedItem() +  " " + tfDateOrYear.getText());
				}
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				
				try {		
					Boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					
					if (complete) {
						JOptionPane.showMessageDialog(btnPrintSummaryInfo, "Done Printing !", "Printer", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(btnPrintSummaryInfo, "Printing...", "Printer", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (java.awt.print.PrinterException e1) {
					JOptionPane.showMessageDialog(btnPrintLogTable, 
							System.err.format("No Printer Found", e1.getMessage()), 
							"Printer", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPrintLogTable.setBounds(589, 201, 140, 23);
		panel_1_1_1.add(btnPrintLogTable);
		btnPrintLogTable.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnPrintSummaryInfo = new JButton("Print Summary Information");
		btnPrintSummaryInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header;
				if (rdbDate.isSelected() || rdbYear.isSelected()) {
					header = new MessageFormat("Summary Information For " + tfDateOrYear.getText());
				}
				else if (rdbAll.isSelected()) {
					header = new MessageFormat("Summary Information Of All Logs");
				}
				else 
				{
					header = new MessageFormat("Summary Information For " + cmbMonth.getSelectedItem() +  " " + tfDateOrYear.getText());
				}
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				
				try {
					
					Boolean complete = txtAreaReport.print(header, footer);
					if (complete) {
						JOptionPane.showMessageDialog(btnPrintSummaryInfo, "Done Printing !", "Printer", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(btnPrintSummaryInfo, "Printing...", "Printer", JOptionPane.ERROR_MESSAGE);
					}
				} catch (java.awt.print.PrinterException e1) {
					JOptionPane.showMessageDialog(btnPrintLogTable, 
							System.err.format("No Printer Found", e1.getMessage()), 
							"Printer", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPrintSummaryInfo.setEnabled(false);
		btnPrintSummaryInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrintSummaryInfo.setBounds(67, 414, 201, 23);
		panel_1_1_2.add(btnPrintSummaryInfo);
	}
}
