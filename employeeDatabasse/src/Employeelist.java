import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Employeelist extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox selectComboBox; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employeelist frame = new Employeelist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextField id;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField username;
	private JTextField password;
	private JTextField age;
	private JTextField subject;
	
	public void refreshTable(){
		try
		{
			String query = "select id , firstname , lastname , subject from employee";
			PreparedStatement pstmt = connection.prepareStatement(query);
			ResultSet result = pstmt.executeQuery();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{new Integer(1), "merry", "johnson", "sql"},
					{new Integer(3), "titta", "johnson", "Math"},
					{new Integer(4), "austin", "markus", "Java"},
					{new Integer(5), "roshan", "bachhav", "c"},
					{new Integer(6), "admin", "admin", "c#"},
					{new Integer(7), "a", "b", "py"},
				},
				new String[] {
					"id", "Firstname", "Lastname", "subject"
				}
			));
			
			pstmt.close();
			result.close();
		}
		catch (Exception error)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong...");
		}
	}
	
	
	public void userComboBox() {
		try
		{
			String query = "select * from employee";
			PreparedStatement pstmt = connection.prepareStatement(query);
			ResultSet result = pstmt.executeQuery();
			while(result.next())
			{
				selectComboBox.addItem(result.getString("username"));
			}
		}
		catch (Exception error)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong in userComboBox...");
		}
	}
	
	public Employeelist() {
		connection = database.dbconnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 104, 485, 327);
		contentPane.add(scrollPane);
		
		table = new JTable();		
		scrollPane.setViewportView(table);
		btnNewButton = new JButton("Load Employee data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "select id , firstname , lastname ,username,password,age subject from employee";
					PreparedStatement pstmt = connection.prepareStatement(query);
					ResultSet result = pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));
				}
				catch (Exception error)
				{
					JOptionPane.showMessageDialog(null, "Something went wrong in table...");
				}
				refreshTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(399, 11, 214, 43);
		contentPane.add(btnNewButton);
		
		id = new JTextField();
		id.setBounds(114, 65, 124, 28);
		contentPane.add(id);
		id.setColumns(10);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(114, 104, 124, 28);
		contentPane.add(firstname);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(114, 142, 124, 28);
		contentPane.add(lastname);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(114, 185, 124, 28);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(114, 226, 124, 28);
		contentPane.add(password);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(114, 265, 124, 28);
		contentPane.add(age);
		
		subject = new JTextField();
		subject.setColumns(10);
		subject.setBounds(114, 304, 124, 28);
		contentPane.add(subject);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(10, 104, 94, 26);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(10, 142, 94, 26);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(10, 185, 94, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 226, 94, 26);
		contentPane.add(lblPassword);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(10, 264, 94, 26);
		contentPane.add(lblAge);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubject.setBounds(10, 304, 94, 26);
		contentPane.add(lblSubject);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 66, 94, 26);
		contentPane.add(lblId);
		
		JButton btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "insert into employee(id , firstname , lastname , username , password , age , subject) values(?,?,?,?,?,?,?)";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1,id.getText());
					ps.setString(2,firstname.getText());
					ps.setString(3,lastname.getText());
					ps.setString(4,username.getText());
					ps.setString(5,password.getText());
					ps.setString(6,age.getText());
					ps.setString(7,subject.getText());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data send successfully...");
					
					ps.close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 354, 101, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String query = "update employee set id=' "+id.getText()+"', firstname = '"+firstname.getText()+"', lastname = '"+lastname.getText()+"', username = '"+username.getText()+"', password = '"+password.getText()+"', age = '"+age.getText()+"', subject = '"+subject.getText()+"' where id = '"+id.getText()+"'  ";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data updated successfully...");
					
					ps.close();
				}
				catch (Exception e2)
				{
					e2.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(137, 354, 101, 34);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "delete from employee where id = '"+id.getText()+"'  ";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data updated successfully...");
					
					ps.close();
				}
				catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(10, 399, 101, 34);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Clear");
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_3.setBounds(137, 399, 101, 34);
		contentPane.add(btnNewButton_1_3);
		
		selectComboBox = new JComboBox();
		selectComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "select * from employee where username=?";
					PreparedStatement pstmt = connection.prepareStatement(query);
					pstmt.setString(1, (String)selectComboBox.getSelectedItem());
					ResultSet result = pstmt.executeQuery();
					
					
					while(result.next())
					{
						id.setText(result.getString("id"));
						firstname.setText(result.getString("firstname"));
						lastname.setText(result.getString("lastname"));
						username.setText(result.getString("username"));
						password.setText(result.getString("password"));
						age.setText(result.getString("age"));
						subject.setText(result.getString("subject"));
					}
					pstmt.close();
					refreshTable();
				}
				catch (Exception error)
				{
					JOptionPane.showMessageDialog(null, "Something went wrong in userComboBox...");
				}
			}
		});
		selectComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		selectComboBox.setBounds(273, 16, 116, 28);
		contentPane.add(selectComboBox);
		
		refreshTable();
		userComboBox();
	}
}
