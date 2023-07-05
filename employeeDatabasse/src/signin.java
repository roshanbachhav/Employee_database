import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class signin extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField id;
	Connection connection = null;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField username;
	private JTextField password;
	private JTextField age;
	private JTextField subject;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin frame = new signin();
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
	public signin() {
		frame = new JFrame();		
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		frame.setBounds(100, 100, 715, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(null, "Database Connected successfully");
		frame.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.setBounds(36, 107, 254, 36);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(101, 78, 125, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(251, 457, 172, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "select * from employee where username =? and password =?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,id.getText());
					pst.setString(2,password.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count = count + 1;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Valid username and password");
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
		frame.getContentPane().add(btnNewButton);
		
		firstname = new JTextField();
		firstname.setBounds(36, 205, 254, 36);
		firstname.setColumns(10);
		frame.getContentPane().add(firstname);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(101, 175, 125, 26);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel_1);
		
		lastname = new JTextField();
		lastname.setBounds(36, 306, 254, 36);
		lastname.setColumns(10);
		frame.getContentPane().add(lastname);
		
		JLabel lblNewLabel_1_1 = new JLabel("lastname");
		lblNewLabel_1_1.setBounds(101, 276, 125, 26);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(385, 108, 254, 36);
		username.setColumns(10);
		frame.getContentPane().add(username);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username");
		lblNewLabel_1_2.setBounds(450, 78, 125, 26);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		password = new JTextField();
		password.setBounds(385, 205, 254, 36);
		password.setColumns(10);
		frame.getContentPane().add(password);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setBounds(450, 175, 125, 26);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel_1_3);
		
		age = new JTextField();
		age.setBounds(385, 306, 254, 36);
		age.setColumns(10);
		frame.getContentPane().add(age);
		
		JLabel lblNewLabel_1_4 = new JLabel("Age");
		lblNewLabel_1_4.setBounds(486, 276, 125, 26);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel_1_4);
		
		subject = new JTextField();
		subject.setBounds(209, 402, 254, 36);
		subject.setColumns(10);
		frame.getContentPane().add(subject);
		
		JLabel lblNewLabel_1_5 = new JLabel("Subject");
		lblNewLabel_1_5.setBounds(298, 372, 125, 26);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2 = new JLabel("Sign Up page");
		lblNewLabel_2.setBounds(274, 27, 240, 26);
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(251, 504, 172, 36);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnLogin.setBackground(Color.WHITE);
		frame.getContentPane().add(btnLogin);
		
	}

}
