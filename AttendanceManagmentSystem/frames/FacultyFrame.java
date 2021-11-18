package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


import repository.*;
import entity.*;

public class FacultyFrame extends JFrame implements ActionListener,MouseListener,TableModelListener{
	private JLabel studentId, studentName;
	private JTextField studentIdTF,studentNameTF;
	private JButton addButton, removeButton,updateButton,logOutButton, searchButton,refreshButton,showAllButton,changePasswordButton,exitButton;
	private JTable studentTable;
	private JScrollPane studentTableSP;
	private JPanel panel;
	Color myColor;
	Font textLabelFont;

	private StudentRepo studentRepo;
	private User user;
	DefaultTableModel tableModel;
		
	public FacultyFrame(User user){

		super("Attendance sheet");
		this.setSize(1056,576);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myColor = new Color(130,190,175);
		textLabelFont = new Font("Arial Black", Font.BOLD, 12);
		
		this.user = user;
		
		studentRepo = new StudentRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		studentId = new JLabel("Student ID:");
		studentId.setBounds(50, 10, 100, 30);
		studentId.setFont(textLabelFont);
		panel.add(studentId);
		
		studentIdTF = new JTextField();
		studentIdTF.setBounds(165, 10, 215, 30);
		panel.add(studentIdTF);
		
		studentName = new JLabel("Name:");
		studentName.setBounds(410, 10, 65, 30);
		studentName.setFont(textLabelFont);
		panel.add(studentName);
		
		studentNameTF = new JTextField();
		studentNameTF.setBounds(490, 10, 235, 30);
		panel.add(studentNameTF);
		
		searchButton = new JButton("GET");
		searchButton.setBounds(740, 10, 150, 30);
		searchButton.addActionListener(this);
		panel.add(searchButton);
		
		changePasswordButton = new JButton("Change Password");
		changePasswordButton.setBounds(740,55,150,30);
		changePasswordButton.addActionListener(this);
		panel.add(changePasswordButton);
		
		addButton = new JButton("ADD");
		addButton.setBounds(50, 55, 100, 30);
		addButton.addActionListener(this);
		panel.add(addButton);
		
		removeButton = new JButton("Remove");
		removeButton.setBounds(165, 55, 100, 30);
		removeButton.addActionListener(this);
		removeButton.setEnabled(false);
		panel.add(removeButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(280, 55, 100, 30);
		updateButton.addActionListener(this);
		updateButton.setEnabled(false);
		panel.add(updateButton);
		
		
		refreshButton = new JButton("Refresh");
		refreshButton.setBounds(395, 55, 100, 30);
		refreshButton.addActionListener(this);
		panel.add(refreshButton);
		
		showAllButton = new JButton("Show All");
		showAllButton.setBounds(510, 55, 100, 30);
		showAllButton.setBackground(Color.GREEN);
		showAllButton.addActionListener(this);
		panel.add(showAllButton);
		
		
		logOutButton = new JButton("Log Out");
		logOutButton.setBounds(625, 55, 100, 30);
		logOutButton.addActionListener(this);
		panel.add(logOutButton);
		
		exitButton = new JButton("EXIT");
		exitButton.setBounds(905,10,85,75);
		exitButton.setBackground(Color.RED);
		exitButton.addActionListener(this);
		panel.add(exitButton);

		String data[][] = {{"","","","","","","","","","","","","",""}};
		String head[] = {"studentId","name","class1","class2","class3","class4","class5","class6","class7",
							"class8","class9","class10","class11","class12"};	
	
		tableModel = new DefaultTableModel(data,head);
		tableModel.addTableModelListener(this);
		studentTable = new JTable(tableModel);
		studentTableSP = new JScrollPane(studentTable);
		studentTableSP.setBounds(50,100,950,416);
		panel.add(studentTableSP);
		
		this.add(panel);
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(searchButton.getText()))
		{
			if(!studentId.getText().equals("") || !studentId.getText().equals(null))
			{
				Student student = studentRepo.searchStudent(studentIdTF.getText());
				if(student!= null)
				{
					studentNameTF.setText(student.getName());
					
					studentIdTF.setEnabled(false);
					studentNameTF.setEnabled(true);
								
					updateButton.setEnabled(true);
					removeButton.setEnabled(true);
					refreshButton.setEnabled(true);
					addButton.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(addButton.getText()))
		{
			Student student = new Student();
			
			student.setStudentId(studentIdTF.getText());
			student.setName(studentNameTF.getText());
									
			studentRepo.insertStudent(student);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+studentIdTF.getText()+" and Name: "+studentNameTF.getText());
			
			studentIdTF.setText("");
			studentNameTF.setText("");

			searchButton.setEnabled(true);
			showAllButton.setEnabled(true);
			addButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
			
		}
		else if(command.equals(refreshButton.getText()))
		{
			studentIdTF.setText("");
			studentNameTF.setText("");
				
			studentIdTF.setEnabled(true);
			searchButton.setEnabled(true);
			addButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
		}
		else if(command.equals(removeButton.getText()))
		{			
			studentRepo.deleteStudent(studentIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			studentIdTF.setText("");
			studentNameTF.setText("");
			
			studentIdTF.setEnabled(true);
			studentNameTF.setEnabled(true);
	
			searchButton.setEnabled(true);
			showAllButton.setEnabled(true);
			addButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
		}
		else if(command.equals(updateButton.getText()))
		{
			Student student = new Student();
			
			student.setStudentId(studentIdTF.getText());
			student.setName(studentNameTF.getText());
		
			studentRepo.updateStudent(student);

			JOptionPane.showMessageDialog(this, "Updated");
			
			studentIdTF.setText("");
			studentNameTF.setText("");
			
			searchButton.setEnabled(true);
			showAllButton.setEnabled(true);
			addButton.setEnabled(true);
			updateButton.setEnabled(false);
			removeButton.setEnabled(false);
			refreshButton.setEnabled(false);
			
			studentIdTF.setEnabled(true);
			studentNameTF.setEnabled(true);
		}
		else if(command.equals(showAllButton.getText()))
		{
			String data[][] = studentRepo.getAllStudent();
			String head[] = {"Id", "Name", "class1","class2","class3","class4","class5","class6","class7","class8","class9","class10","class11","class12"};

			panel.remove(studentTableSP);
			panel.repaint();
			panel.revalidate();

			tableModel = new DefaultTableModel(data,head);
			tableModel.addTableModelListener(this);
			studentTable = new JTable(tableModel);
			studentTableSP = new JScrollPane(studentTable);
			studentTableSP.setBounds(50,100,950,416);
			panel.add(studentTableSP);
			
			panel.repaint();
			panel.revalidate();
		}
				
		else if(command.equals(changePasswordButton.getText()))
		{
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
		else if(command.equals(exitButton.getText())){
			System.exit(0);
		}
		

		else{}
		
	}
	
	public void tableChanged( TableModelEvent e ) {
		DefaultTableModel model = (DefaultTableModel)e.getSource();
		int row = e.getFirstRow();
		int column = e.getColumn();
		String cellValue = String.valueOf(studentTable.getValueAt(row,column));
		String sId = String.valueOf(studentTable.getValueAt(row,0));
		String cName = studentTable.getColumnName(column);
		
		try
			{
				int status = Integer.parseInt(cellValue);
		
			if (status == 1){
				System.out.println("Value at (" + row + "," + column + ") changed to " + "'" + cellValue + "\'");
				studentRepo.correctTable(sId,cName);
				refreshTable();
			}
			else if(status == 0){
				//System.out.println("Value at (" + row + "," + column + ") changed to " + "'" + cellValue + "\'");
				studentRepo.updateTable(sId,cName);
				refreshTable();
			}
			else{
			}
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(this, "Restricted");
		}
	}
	
	public void refreshTable(){
			String data[][] = studentRepo.getAllStudent();
			String head[] = {"Id", "Name", "class1","class2","class3","class4","class5","class6","class7","class8","class9","class10","class11","class12"};

			panel.remove(studentTableSP);

			tableModel = new DefaultTableModel(data,head);
			tableModel.addTableModelListener(this);
			studentTable = new JTable(tableModel);
			studentTableSP = new JScrollPane(studentTable);
			studentTableSP.setBounds(50,100,950,416);
			panel.add(studentTableSP);
			
			panel.repaint();
			panel.revalidate();
			
	}
	
	
		public void mouseClicked(MouseEvent me){}
		public void mousePressed(MouseEvent me){}
		public void mouseReleased(MouseEvent me){}
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}
	
}