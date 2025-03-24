package frames;

import java.lang.*;
import repositories.*;
import entities.*;
import interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener
{

	private JLabel nameLabel,userIdLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn , signUpBtn, forgetPasswordBtn, exitBtn;
	private JPanel panel;
	
	
	public LoginFrame()
	{	
		super("User Login");
		this.setSize(750,580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
	
		this.nameLabel = new JLabel ("User Login");
		this.nameLabel.setBounds(300,20,100,30);
		this.panel.add(nameLabel);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(150,100,200,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(350,100,250,30);
		this.panel.add(userTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(150,200,200,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(350,200,250,30);
		this.panel.add(passPF);
		
		this.loginBtn=new JButton("Login");
		this.loginBtn.setBounds(150,300,150,30);
		this.loginBtn.addActionListener(this);
		this.panel.add(loginBtn);
		
		this.forgetPasswordBtn=new JButton("Forget Password");
		this.forgetPasswordBtn.setBounds(350,300,150,30);
		this.forgetPasswordBtn.addActionListener(this);
		this.panel.add(forgetPasswordBtn);
		
		this.nameLabel=new JLabel("Don't have an account?");
		this.nameLabel.setBounds(150,400,150,30);
		this.panel.add(nameLabel);
	
		
		this.signUpBtn=new JButton("Sign Up");
		this.signUpBtn.setBounds(350,400,150,30);
		this.signUpBtn.addActionListener(this);
		this.panel.add(signUpBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(250,500,150,30);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		{
			if(command.equals(loginBtn.getText()))
			{
				String uId=userTF.getText();
				String pass=passPF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(uId);
				if(user!=null)
				{
					if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==1)
					{
						OwnerHomeFrame ohf=new OwnerHomeFrame(user);
						this.setVisible(false);
						ohf.setVisible(true);
					}
					else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==2)
					{
						EmployeeHomeFrame ehf=new EmployeeHomeFrame(user);
						this.setVisible(false);
						ehf.setVisible(true);
					}
					else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==3)
					{
						CustomerHomeFrame chf=new CustomerHomeFrame(user);
						this.setVisible(false);
						chf.setVisible(true);
					}
					
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
					}
					
				}
			
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
				}
				
			}
			
			if(command.equals(signUpBtn.getText()))
			{
				NewAccountFrame naf=new NewAccountFrame();
				this.setVisible(false);
				naf.setVisible(true);
			}
			
			if(command.equals(forgetPasswordBtn.getText()))
			{
				ForgotPasswordFrame fpf=new ForgotPasswordFrame();
				this.setVisible(false);
				fpf.setVisible(true);
			}
			
			if(command.equals(exitBtn.getText()))
			{
				System.exit(0);
			}
		}
	}
}
	
	