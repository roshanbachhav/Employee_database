import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends JFrame {
	

	private JPanel contentPane;
	private JFrame frame;
	private JTextField username;
	private JTextField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	
	
	public Login()
	{
		initialize();
		connection = database.dbconnector();
	}
	
	private void initialize() {
		frame = new JFrame();		
		frame.getContentPane().setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
		frame.setBounds(100, 100, 754, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
//		JOptionPane.showMessageDialog(null, "Database Connected successfully");
		
		username = new JTextField();
		username.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		username.setBounds(292, 146, 254, 36);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		password.setBackground(new Color(255, 255, 255));
		password.setColumns(10);
		password.setBounds(292, 232, 254, 36);
		frame.getContentPane().add(password);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(350, 118, 125, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(350, 203, 125, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "select * from employee where username =? and password =?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,username.getText());
					pst.setString(2,password.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count = count + 1;
					}
					if(count == 1)
					{
						frame.dispose();							
						Employeelist el = new Employeelist();
						el.setVisible(true);
					}
					else if(count > 1)
					{
						JOptionPane.showMessageDialog(null, "Username and password already exist");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid username and password");
					}
					
					rs.close();
					pst.close();
				}catch(Exception error)
				{
					JOptionPane.showMessageDialog(null, "Something went wrong!...");
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(340, 294, 150, 44);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(216, 146, 56, 36);
		frame.getContentPane().add(label);	
		
		JLabel label1 = new JLabel("");
		label1.setBounds(216, 227, 56, 41);
		frame.getContentPane().add(label1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Login Page");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_2.setBounds(253, 21, 345, 61);
		frame.getContentPane().add(lblNewLabel_2);
		
	}

}
