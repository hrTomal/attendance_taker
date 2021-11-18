package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


public class SignUpFrame extends JFrame implements ActionListener{
	
	JLabel messageLabel;
	private JButton submitButton, backButton;
	private JPanel panel;
	Color myColor,labelBackColor;
	Font myFont;
	
	public SignUpFrame(){
		super("Register !!!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myColor = new Color(0,0,90);
		myFont = new Font("Arial Black", Font.BOLD | Font.BOLD, 20);
		labelBackColor = new Color(255,0,0);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		messageLabel = new JLabel("Restricted!!! Only Admin can add new user.");
		messageLabel.setBounds(135,100,525,30);
		messageLabel.setFont(myFont);
		messageLabel.setBackground(labelBackColor);
		messageLabel.setOpaque(true);
		panel.add(messageLabel);
	
		backButton = new JButton("Back");
		backButton.setBounds(350, 250, 80, 30);
		backButton.addActionListener(this);
		panel.add(backButton);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae){
		String command= ae.getActionCommand();
		
		if(command.equals(backButton.getText())){
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
	}
	
}