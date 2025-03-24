package frames;

import java.lang.*;
import repositories.*;
import entities.*;
import interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForgotPasswordFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, securityQuesLabel, securityAnsLabel,newPassLabel;
	private JTextField userTF, securityAnsTF;
	private JButton submitBtn, backBtn;
	private JPasswordField newPassPF;
	private JPanel panel;
	
	public ForgotPasswordFrame()
	{
		super("Forget Password Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(150,100,100,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(300,100,200,30);
		this.panel.add(userTF);
		
		this.securityQuesLabel=new JLabel("Security question:	 What is your favourite food?");
		this.securityQuesLabel.setBounds(150,150,550,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Answer:");
		this.securityAnsLabel.setBounds(150,200,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(300,200,200,30);
		this.panel.add(securityAnsTF);
		
		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(150,250,100,30);
		this.panel.add(newPassLabel);
		
		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(300,250,200,30);
		this.panel.add(newPassPF);
		
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(550,300,100,30);
		this.submitBtn.addActionListener(this);
		this.panel.add(submitBtn);
	
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(150,300,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{	
			if((!userTF.getText().isEmpty())&&(!securityAnsTF.getText().isEmpty())&&(!newPassPF.getText().isEmpty()))
			{
				String userId, securityAns, newPass;
				userId=userTF.getText();
				securityAns=securityAnsTF.getText();
				newPass=newPassPF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(urp!=null)
				{
					if((user.getUserId().equals(userId))&&(user.getSecurityAns().equals(securityAns)))
					{
						user.setPassword(newPass);
						urp.updateUser(user);
						JOptionPane.showMessageDialog(this,"Password changed successfully");
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong security Ans");
					}
				}
				else
				{
				JOptionPane.showMessageDialog(this,"User not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fillup all the fields");
			}
		}
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
	}
}
