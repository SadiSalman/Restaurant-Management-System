package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class EmployeeAccountFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF;
	private JButton updateBtn,backBtn;
	private JPanel panel;
	private User u;
	private Employee employee;
	
	
	
	public EmployeeAccountFrame(User u)
	{
		super("My Account");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		EmployeeRepo erp=new EmployeeRepo();
		this.employee=erp.searchEmployeeByUserId(u.getUserId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(employee.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(employee.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,150,30);
		this.emailTF.setText(employee.getEmail());
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.phoneNoTF.setText(employee.getPhoneNo());
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		this.panel.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(120,250,100,30);
		this.genderTF.setText(employee.getGender());
		this.genderTF.setEditable(false);
		this.panel.add(genderTF);
		
		
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.ageTF.setText(String.valueOf(employee.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(120,350,100,30);
		this.addressTF.setText(employee.getAddress());
		this.panel.add(addressTF);
		
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,450,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,450,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(updateBtn.getText()))
		{
			
			if((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				employee.setEmail(emailTF.getText());
				employee.setPhoneNo(phoneNoTF.getText());
				employee.setAddress(addressTF.getText());
				
				EmployeeRepo erp=new EmployeeRepo();
				erp.updateEmployee(employee);
				
				JOptionPane.showMessageDialog(this,"Employee updated Successfully");
		
			}
			else
			{
				
				JOptionPane.showMessageDialog(this,"Fill up all the field properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			
			EmployeeHomeFrame ohf=new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			ohf.setVisible(true);
		}
	}
	
}