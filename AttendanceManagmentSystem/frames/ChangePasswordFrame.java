package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class ChangePasswordFrame extends JFrame implements ActionListener{
	
	JLabel empIdLabel, passwordLabel,headLabel;
	private JButton changeButton, cancelButton, loginButton;
	private JTextField empIdTF,passwordTF; 
	private JPanel panel;
	Color myColor;
	Font myFont;
	
	private User user;
	private UserRepo userRepo;
	
	public ChangePasswordFrame(User user){
		super("Change Password!!!");
		this.setSize(300,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		userRepo = new UserRepo();

		panel = new JPanel();
		panel.setLayout(null);
		
		myColor = new Color(130,190,175);
		myFont = new Font("Arial Black", Font.BOLD | Font.BOLD, 20);
		
		panel.setBackground(myColor);
		
		headLabel = new JLabel("Changing Password");
		headLabel.setBounds(20,20,260,50);
		headLabel.setFont(myFont);
		panel.add(headLabel);
		
		empIdLabel = new JLabel("ID :");
		empIdLabel.setBounds(20,80,80,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField(user.getUserId());
		empIdTF.setEnabled(false);
		empIdTF.setBounds(120, 80, 150, 30);
		panel.add(empIdTF);
		
		passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(20,120,80,30);
		panel.add(passwordLabel);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(120, 120, 150, 30);
		panel.add(passwordTF);
		
		changeButton = new JButton("Change");
		changeButton.setBounds(50,160,200,30);
		changeButton.addActionListener(this);
		panel.add(changeButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(50,200,200,30);
		cancelButton.addActionListener(this);
		cancelButton.setBackground(Color.RED);
		panel.add(cancelButton);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(50,240,200,30);
		loginButton.addActionListener(this);
		loginButton.setBackground(Color.GREEN);
		panel.add(loginButton);
		
		this.add(panel);
		
	}
	public void actionPerformed(ActionEvent ae){
		
		String command = ae.getActionCommand();
		
		if(command.equals(changeButton.getText())){
			user.setPassword(passwordTF.getText());
			
			userRepo.passwordChange(user);
			
			JOptionPane.showMessageDialog(this, "Changed, Id: "+empIdTF.getText()+"and Password: "+passwordTF.getText());
		}
		else if(command.equals(cancelButton.getText())){
			
			if(user.getStatus() == 1){
			FacultyFrame ff = new FacultyFrame(user);
			ff.setVisible(true);
			this.setVisible(false);
			}
			else{
			AdminFrame af = new AdminFrame(user);
			af.setVisible(true);
			this.setVisible(false);
			}
		}
		else if(command.equals(loginButton.getText())){
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else{}
	}
	
}