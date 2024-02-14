package com.mycompany.iooj;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class frmManagerMainPage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JLabel lblUsername;
	private String information;
	private String username;
	private String alias;
	
	public frmManagerMainPage() {
        initComponents();
    }
	
	public frmManagerMainPage(String information) {
		this.information = information;
        String [] userinformation = this.information.split(",");
        
        userManager manager = new userManager();
        manager.setUsername(userinformation[0]);
        manager.setAlias(userinformation[1]);

        this.username = userinformation[0];
        this.alias = userinformation[1];
        
        initComponents();
                lblUsername.setText(userinformation[0]);
 
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmManagerMainPage frame = new frmManagerMainPage();
					frame.setVisible(true);
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
		setBounds(100, 100, 1057, 557);
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
		
		JLabel lblManageMainPage = new JLabel("Manager Main Page");
		lblManageMainPage.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblManageMainPage.setBounds(345, 12, 239, 49);
		panel_1.add(lblManageMainPage);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1.setBounds(33, 179, 229, 286);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("User Registration");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(48, 89, 127, 27);
		panel_1_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegisterAndDeleteUser frmobj = new frmRegisterAndDeleteUser(username, alias);
				frmobj.importTextFile();
				frmobj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(35, 187, 140, 68);
		panel_1_1.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel(" & Termination");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(51, 113, 112, 27);
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1_1.setBounds(511, 179, 224, 286);
		panel.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Customer Booking");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(40, 85, 136, 27);
		panel_1_1_1.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,"Incorrect password","Error",JOptionPane.ERROR_MESSAGE);
				frmCustomerTrainingSession frmobj = new frmCustomerTrainingSession(username, alias);
				frmobj.populateCmbTrainer();
				frmobj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(36, 189, 140, 68);
		panel_1_1_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Registration &");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(22, 110, 110, 27);
		panel_1_1_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Termination");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(124, 110, 90, 27);
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1_1_1.setBounds(745, 179, 224, 286);
		panel.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("View Customer");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(62, 86, 115, 27);
		panel_1_1_1_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Booking Logs");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_2.setBounds(62, 112, 103, 27);
		panel_1_1_1_1.add(lblNewLabel_1_3_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Enter");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmViewBookingLogs frmobj = new frmViewBookingLogs(username, alias);
				frmobj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(49, 188, 140, 68);
		panel_1_1_1_1.add(btnNewButton_1_1);
		
		lblUsername = new JLabel("no manager");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsername.setBounds(533, 107, 126, 37);
		panel.add(lblUsername);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back,");
		lblWelcomeBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWelcomeBack.setBounds(366, 107, 168, 37);
		panel.add(lblWelcomeBack);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1_1_2.setBackground(new Color(176, 224, 230));
		panel_1_1_2.setBounds(272, 179, 229, 286);
		panel.add(panel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Modify User Profile");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(45, 102, 140, 27);
		panel_1_1_2.add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("Enter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmModifyProfile frmobj = new frmModifyProfile(username, alias);
				frmobj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(45, 187, 140, 68);
		panel_1_1_2.add(btnNewButton_2);
	}
}
