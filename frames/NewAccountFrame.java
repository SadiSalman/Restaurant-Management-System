package frames;

import java.lang.*;
import entities.*;
import repositories.*;
import interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewAccountFrame extends JFrame implements ActionListener
{
	private JLabel headerLabel, idLabel, nameLabel, mailLabel, addressLabel, phoneLabel, genderLabel, ageLabel, passwordLabel, questionLabel, answerLabel, membershipLabel;
	private JTextField idTF, nameTF, mailTF, addressTF, phoneTF, ageTF, answerTF;
	private JRadioButton maleRB, femaleRB, noneRB, goldRB;
	private JPasswordField passPF;
	private ButtonGroup bg1, bg2;
	private JButton backBtn, signUpBtn;
	
	private JPanel panel;
	
	public NewAccountFrame()
	{
		super("New Account Frame");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.headerLabel= new JLabel("Create a new account");
		this.headerLabel.setBounds(200,20,200,35);
		this.panel.add(headerLabel);
		
		this.idLabel= new JLabel("User Id: ");
		this.idLabel.setBounds(100,50,100,30);
		this.panel.add(idLabel);
		
		this.idTF= new JTextField();
		this.idTF.setBounds(220,50,200,30);
		this.panel.add(idTF);
		
		this.nameLabel= new JLabel("Name: ");
		this.nameLabel.setBounds(100,80,100,30);
		this.panel.add(nameLabel);
		
		this.nameTF= new JTextField();
		this.nameTF.setBounds(220,80,200,30);
		this.panel.add(nameTF);
		
		this.mailLabel= new JLabel("E-mail: ");
		this.mailLabel.setBounds(100,110,100,30);
		this.panel.add(mailLabel);
		
		this.mailTF= new JTextField();
		this.mailTF.setBounds(220,110,200,30);
		this.panel.add(mailTF);
		
		this.addressLabel= new JLabel("Address: ");
		this.addressLabel.setBounds(100,140,100,30);
		this.panel.add(addressLabel);
		
		this.addressTF= new JTextField();
		this.addressTF.setBounds(220,140,200,30);
		this.panel.add(addressTF);
		
		this.phoneLabel= new JLabel("Phone: ");
		this.phoneLabel.setBounds(100,170,100,30);
		this.panel.add(phoneLabel);
		
		this.phoneTF= new JTextField();
		this.phoneTF.setBounds(220,170,200,30);
		this.panel.add(phoneTF);
		
		this.genderLabel= new JLabel("Gender: ");
		this.genderLabel.setBounds(100,200,100,30);
		this.panel.add(genderLabel);
		
		this.maleRB= new JRadioButton("Male");
		this.maleRB.setBounds(220,200,70,30);
		this.panel.add(maleRB);
		
		this.femaleRB= new JRadioButton("Female");
		this.femaleRB.setBounds(300,200,70,30);
		this.panel.add(femaleRB);
		
		this.bg1=new ButtonGroup();
		bg1.add(maleRB);
		bg1.add(femaleRB);
		
		this.ageLabel= new JLabel("Age: ");
		this.ageLabel.setBounds(100,230,100,30);
		this.panel.add(ageLabel);
		
		this.ageTF= new JTextField();
		this.ageTF.setBounds(220,230,200,30);
		this.panel.add(ageTF);
		
		this.passwordLabel= new JLabel("Password: ");
		this.passwordLabel.setBounds(100,260,100,30);
		this.panel.add(passwordLabel);
		
		this.passPF= new JPasswordField();
		this.passPF.setBounds(220,260,100,30);
		this.panel.add(passPF);
		
		this.questionLabel= new JLabel("Security Question: 	What is your favourite food? ");
		this.questionLabel.setBounds(100,290,300,30);
		this.panel.add(questionLabel);
		
		this.answerLabel= new JLabel("Answer: ");
		this.answerLabel.setBounds(100,320,100,30);
		this.panel.add(answerLabel);
		
		this.answerTF= new JTextField();
		this.answerTF.setBounds(220,320,200,30);
		this.panel.add(answerTF);
		
		this.membershipLabel= new JLabel("Membership: ");
		this.membershipLabel.setBounds(100,350,100,30);
		this.panel.add(membershipLabel);
		
		this.noneRB= new JRadioButton("None");
		this.noneRB.setBounds(220,350,70,30);
		this.panel.add(noneRB);
		
		this.goldRB= new JRadioButton("Gold");
		this.goldRB.setBounds(300,350,70,30);
		this.panel.add(goldRB);
		
		this.bg2=new ButtonGroup();
		bg2.add(noneRB);
		bg2.add(goldRB);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(100,390,150,35);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.signUpBtn= new JButton("Sign up");
		this.signUpBtn.setBounds(350,390,150,35);
		this.signUpBtn.addActionListener(this);
		this.panel.add(signUpBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(signUpBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,securityAns,pass,membershipType;
			int age;
			double discountPercentage;
			if((!idTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!mailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty())&&((noneRB.isSelected()) || (goldRB.isSelected())) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!answerTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=idTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(user==null)
				{
					try
					{
						name=nameTF.getText();
						email=mailTF.getText();
						phoneNo=phoneTF.getText();
						if(maleRB.isSelected())
						{
							gender="Male";
						}
				
						else if(femaleRB.isSelected())
						{
							gender="Female";
						}
				
						else
						{
							gender="Male";
						}
						
						if(noneRB.isSelected())
						{
							membershipType="None";
							discountPercentage=0.0;
						}
				
						else if(goldRB.isSelected())
						{
							membershipType="Gold";
							discountPercentage=20.0;
						}
				
						else
						{
							membershipType="None";
							discountPercentage=0.0;
						}
						
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						int role=3;
						securityAns=answerTF.getText();
						pass=passPF.getText();
						Customer c=new Customer(userId,name,gender,age,email,phoneNo,address,role,securityAns,pass,discountPercentage,membershipType);
						urp.addUser(c);
						CustomerRepo crp=new CustomerRepo();
						crp.addCustomer(c);
						JOptionPane.showMessageDialog(this,"Customer account created successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Please input valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
			
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame adf=new LoginFrame();
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
}