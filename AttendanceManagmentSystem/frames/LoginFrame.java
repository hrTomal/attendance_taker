package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;


public class LoginFrame extends JFrame implements ActionListener,MouseListener {
	JLabel title, userNameLabel, passwordLabel;
	JTextField userNameTF;
	JPasswordField passwordPF;
	JButton loginButton,signUpBtn,exitButton,showPasswordButton;
	JPanel panel;
	Color myColor;
	Font myFont;
	
	
	public LoginFrame(){
		super("Attendance Managment System - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myColor = new Color(130,190,175);
		myFont = new Font("Arial Black", Font.ITALIC | Font.BOLD, 25);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		title = new JLabel("Attendance Managment System");
		title.setBounds(170,50,550,30);
		title.setFont(myFont);
		panel.add(title);
		
		userNameLabel = new JLabel("User ID: ");
		userNameLabel.setBounds(300, 100, 60, 30);
		panel.add(userNameLabel);
		
		userNameTF = new JTextField();
		userNameTF.setBounds(370, 100, 100, 30);
		panel.add(userNameTF);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(300, 150, 100, 30);
		panel.add(passwordLabel);
		
		passwordPF = new JPasswordField();
		passwordPF.setBounds(370, 150, 100, 30);
		passwordPF.setEchoChar('*');
		panel.add(passwordPF);
		
		showPasswordButton = new JButton("Show");
		showPasswordButton.setBounds(470,150,80,30);
		showPasswordButton.addMouseListener(this);
		panel.add(showPasswordButton);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(300, 200, 80, 30);
		loginButton.addActionListener(this);
		loginButton.setBackground(Color.GREEN);
		panel.add(loginButton);
		
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(390, 200, 80, 30);
		exitButton.addActionListener(this);
		exitButton.setBackground(Color.RED);
		panel.add(exitButton);
		
		signUpBtn = new JButton("Sign Up!!!");
		signUpBtn.setBounds(300, 250, 170, 30);
		signUpBtn.addActionListener(this);
		panel.add(signUpBtn);
		
		
		this.add(panel);
		
	}
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		
		if(command.equals(loginButton.getText())){
			UserRepo userRepo = new UserRepo();
			User user = userRepo.getUser(userNameTF.getText(),passwordPF.getText());
			
			if(user != null){
				if (user.getStatus() == 0){
					AdminFrame af = new AdminFrame(user);
					af.setVisible(true);
					this.setVisible(false);					
				}
					
					else if(user.getStatus() == 1){
						FacultyFrame ff = new FacultyFrame(user);
						ff.setVisible(true);
						this.setVisible(false);				
					}
					else{
					
					}
			}
			else{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
		}
		else if(command.equals(exitButton.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(signUpBtn.getText()))
		{
			SignUpFrame suf = new SignUpFrame();
			suf.setVisible(true);
			this.setVisible(false);
		}
		else{
			
		}
	
	}
		public void mouseClicked(MouseEvent me){}
		public void mousePressed(MouseEvent me){
		passwordPF.setEchoChar((char)0);
		}
		public void mouseReleased(MouseEvent me){
		passwordPF.setEchoChar('*');
		}
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}
		
}