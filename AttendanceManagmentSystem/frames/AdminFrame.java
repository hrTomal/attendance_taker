package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class AdminFrame extends JFrame implements ActionListener,MouseListener{
	private JLabel empId, empName, empDesignation, welcomeMessageLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF;
	private JButton searchButton,insertButton,updateButton,removeButton,
					refreshButton,showAllButton,logOutButton,changePasswordButton;
	private JPanel panel;
	private JTable empTable;
	private JScrollPane empTableSP;
	
	private EmployeeRepo employeeRepo;
	private User user;
	private UserRepo userRepo;
	Color myColor;
	Font myFont;
	
	public AdminFrame(User user)
	{
		super("Admin");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		myColor = new Color(130,190,175);
		myFont = new Font("Arial Black", Font.ITALIC | Font.BOLD, 30);
		
		panel.setBackground(myColor);
		
		employeeRepo = new EmployeeRepo();
		userRepo = new UserRepo();
		
		String data[][] = {{"","","",""}};
		
		String head[] = {"ID", "Name", "Department"};
		
		empTable = new JTable(data, head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(350, 100, 400, 180);
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		welcomeMessageLabel = new JLabel("Welcome To Admin Wizard");
		welcomeMessageLabel.setBounds(50,20,530,60);
		welcomeMessageLabel.setFont(myFont);
		panel.add(welcomeMessageLabel);
		
		empId = new JLabel("ID :");
		empId.setBounds(50,100,100,30);
		panel.add(empId);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(170,100,100,30);
		panel.add(empIdTF);
		
		empName = new JLabel("Name :");
		empName.setBounds(50,150,100,30);
		panel.add(empName);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(170,150,100,30);
		panel.add(empNameTF);
		
		empDesignation = new JLabel("Designation: ");
		empDesignation.setBounds(50,200,100,30);
		panel.add(empDesignation);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(170,200,100,30);
		panel.add(empDesignationTF);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(150,260,80,30);
		searchButton.addActionListener(this);
		panel.add(searchButton);
		
		insertButton = new JButton("Insert");
		insertButton.setBounds(50,300,80,30);
		insertButton.addActionListener(this);
		panel.add(insertButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(150,300,80,30);
		updateButton.addActionListener(this);
		updateButton.setEnabled(false);
		panel.add(updateButton);
		
		removeButton = new JButton("Delete");
		removeButton.setBounds(250,300,80,30);
		removeButton.addActionListener(this);
		removeButton.setEnabled(false);
		panel.add(removeButton);
		
		refreshButton = new JButton("Refresh");
		refreshButton.setBounds(350,300,80,30);
		refreshButton.addActionListener(this);
		refreshButton.setEnabled(false);
		panel.add(refreshButton);
		
		showAllButton = new JButton("Show All");
		showAllButton.setBounds(480,300,150,30);
		showAllButton.setBackground(Color.GREEN);
		showAllButton.addActionListener(this);
		panel.add(showAllButton);
		
		changePasswordButton = new JButton("Change Password");
		changePasswordButton.setBounds(600,60,150,30);
		changePasswordButton.addActionListener(this);
		this.add(changePasswordButton);
		
		logOutButton = new JButton("Log Out");
		logOutButton.setBounds(625,20, 100, 30);
		logOutButton.setBackground(Color.RED);
		logOutButton.addActionListener(this);
		panel.add(logOutButton);
		
		this.add(panel);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(searchButton.getText()))
		{
			if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Employee e = employeeRepo.searchEmployee(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getName());
					empDesignationTF.setText(e.getDesignation());
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empDesignationTF.setEnabled(true);
					
					updateButton.setEnabled(true);
					removeButton.setEnabled(true);
					refreshButton.setEnabled(true);
					insertButton.setEnabled(false);
					searchButton.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertButton.getText()))
		{
			Employee e = new Employee();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			e.setEmpId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setDesignation(empDesignationTF.getText());
			
			u.setUserId(empIdTF.getText());
			u.setPassword(x+"");
			
			if(((empDesignationTF.getText()).equals("Admin")) || ((empDesignationTF.getText()).equals("admin")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}
			
			employeeRepo.insert(e);
			userRepo.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+empIdTF.getText()+"and Password: "+x);
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			
			searchButton.setEnabled(true);
			insertButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
			
		}
		else if(command.equals(refreshButton.getText()))
		{
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			
			empIdTF.setEnabled(true);
			searchButton.setEnabled(true);
			insertButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
		}
		else if(command.equals(updateButton.getText()))
		{
			Employee e = new Employee();
			
			e.setEmpId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setDesignation(empDesignationTF.getText());
			
			employeeRepo.update(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			
			searchButton.setEnabled(true);
			insertButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
		}
		else if(command.equals(removeButton.getText()))
		{
			employeeRepo.delete(empIdTF.getText());
			userRepo.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
	
			searchButton.setEnabled(true);
			insertButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
		}
		else if(command.equals(showAllButton.getText()))
		{
			String data[][] = employeeRepo.getAllEmployee();
			String head[] = {"Id", "Name", "Designation"};
			
			panel.remove(empTableSP);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(350, 100, 400, 180);
			panel.add(empTableSP);
			
			//panel.revalidate();
			//panel.repaint();
			
		}
		else if(command.equals(changePasswordButton.getText())){
			ChangePasswordFrame cf = new ChangePasswordFrame(user);
			cf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logOutButton.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
	public void mouseClicked(MouseEvent me){}
		public void mousePressed(MouseEvent me){}
		public void mouseReleased(MouseEvent me){}
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}
}