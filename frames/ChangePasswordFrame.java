package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangePasswordFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, currentPasswordLabel, newPasswordLabel,reEnterNewPasswordLabel;
	private JTextField userTF; 
	private JPasswordField currentPF, newPF, reEnterPF;
	private JButton backBtn, confirmBtn;
	private JPanel panel;
	private User u;
	
	public ChangePasswordFrame(User u)
	{
		super("Change Password");
		this.setSize(1024,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(200,100,200,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(400,100,200,30);
		this.panel.add(userTF);
		
		this.currentPasswordLabel=new JLabel("Current Password:");
		this.currentPasswordLabel.setBounds(200,150,200,30);
		this.panel.add(currentPasswordLabel);
		
		
		this.currentPF=new JPasswordField();
		this.currentPF.setBounds(400,150,200,30);
		this.panel.add(currentPF);
		
		this.newPasswordLabel=new JLabel("New Password:");
		this.newPasswordLabel.setBounds(200,200,200,30);
		this.panel.add(newPasswordLabel);
		
		this.newPF=new JPasswordField();
		this.newPF.setBounds(400,200,200,30);
		this.panel.add(newPF);
		
		this.reEnterNewPasswordLabel=new JLabel("Re-enter New Password:");
		this.reEnterNewPasswordLabel.setBounds(200,250,200,30);
		this.panel.add(reEnterNewPasswordLabel);
		
		
		
		this.reEnterPF=new JPasswordField();
		this.reEnterPF.setBounds(400,250,200,30);
		this.panel.add(reEnterPF);
		
		this.confirmBtn=new JButton("Confirm");
		this.confirmBtn.setBounds(520,350,100,30);
		this.confirmBtn.addActionListener(this);
		this.panel.add(confirmBtn);
	
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(180,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		this.add(panel);
		this.u=u;
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(confirmBtn.getText()))
		{
			if((!currentPF.getText().isEmpty()) && (!newPF.getText().isEmpty())&& (!reEnterPF.getText().isEmpty()))
			{
				
				if(currentPF.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPF.getText());
					UserRepo urp=new UserRepo();
					urp.updateUser(u);
					JOptionPane.showMessageDialog(this,"Password updated Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Current Password didn't match");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the fields properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			
			if(u.getRole()==1)
			{
				OwnerHomeFrame ohf=new OwnerHomeFrame(u);
				this.setVisible(false);
				ohf.setVisible(true);
			}
			else if(u.getRole()==2)
			{
				EmployeeHomeFrame ehf=new EmployeeHomeFrame(u);
				this.setVisible(false);
				ehf.setVisible(true);
			}
			else
			{
				CustomerHomeFrame chf=new CustomerHomeFrame(u);
				this.setVisible(false);
				chf.setVisible(true);
			}				
		}
	}
	
}
	
	
