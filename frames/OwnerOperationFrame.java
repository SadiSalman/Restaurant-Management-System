package frames;

import entities.*;
import interfaces.*;
import repositories.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;


public class OwnerOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, userTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable ownerT;
	private JScrollPane ownerSP;
	private JPanel panel;
	
	private User u;
	
	
	public OwnerOperationFrame(User u)
	{
		super("Owner Operation Frame");
		this.setSize(900,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(100,20,215,34);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(280,20,200,34);
		this.panel.add(userTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(500,20,215,34);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(500,65,200,34);
		this.panel.add(passPF);
		
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(100,65,215,34);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(280,65,200,34);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(100,110,215,34);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(280,110,200,34);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
		this.phoneNoLabel.setBounds(100,155,200,34);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(280,155,200,34);
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(100,200,215,34);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(280,200,100,34);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(420,200,100,34);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(100,245,215,34);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(280,245,200,34);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(100,290,215,34);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(280,290,200,34);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("What is your favourite food?:");
		this.securityQuesLabel.setBounds(100,335,572,34);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(100,385,215,34);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(280,385,200,34);
		this.panel.add(securityAnsTF);
		
		this.addBtn=new JButton("Add Owner");
		this.addBtn.setBounds(100,430,120,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Owner");
		this.updateBtn.setBounds(250,430,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Owner");
		this.removeBtn.setBounds(400,430,150,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		
		this.searchBtn=new JButton("Search");
		this.searchBtn.setBounds(560,430,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(560,335,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(560,385,120,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.add(panel);
		
		OwnerRepo or=new OwnerRepo();
		Owner[] ownerList= or.getAllOwner();
		
		String ownerData1[][]=new String[ownerList.length][8];
		for(int i=0;i<ownerList.length;i++)
		{
		
			if(ownerList[i]!=null)
			{
				System.out.println(ownerList[i].toStringFromOwner());
				ownerData1[i][0]=ownerList[i].getUserId();
				ownerData1[i][1]=ownerList[i].getName();
				ownerData1[i][2]=ownerList[i].getEmail();
				ownerData1[i][3]=ownerList[i].getPhoneNo();
				ownerData1[i][4]=ownerList[i].getGender();
				ownerData1[i][5]=String.valueOf(ownerList[i].getAge());
				ownerData1[i][6]=ownerList[i].getAddress();
				ownerData1[i][7]=String.valueOf(ownerList[i].getCompanySharePercentage());
			}
		}
		
		String head1[]={"Owner id","Name","Email","Phone No","Gender","Age","Address","Owner Share per"};
		
		this.ownerT=new JTable(ownerData1,head1);
		this.ownerSP=new JScrollPane(ownerT);
		this.ownerSP.setBounds(100,470,700,280);
		this.ownerT.setEnabled(false);
		this.panel.add(ownerSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,securityAns,pass;
			double ownerShare;
			int age;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=userTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(user==null)
				{
					try
					{
						name=nameTF.getText();
						email=emailTF.getText();
						phoneNo=phoneNoTF.getText();
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						int role=1;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						ownerShare=5.0;
						Owner o=new Owner(userId,name,gender, age,email,phoneNo,address,role,securityAns,pass,ownerShare);
						urp.addUser(o);
						OwnerRepo orp=new OwnerRepo();
						orp.addOwner(o);
						JOptionPane.showMessageDialog(this,"Owner added Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
			
		}
		
		if(command.equals(updateBtn.getText()))
		{
			
			String userId,name,email,phoneNo,gender,address,adminType;
			int age;
			double ownerShare;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=userTF.getText();
				OwnerRepo orp=new OwnerRepo();
				Owner o=orp.searchOwnerByUserId(userId);
				if(o!=null)
				{
					try
					{
						name=nameTF.getText();
						email=emailTF.getText();
						phoneNo=phoneNoTF.getText();
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						ownerShare=0.0;
					
						o.setName(name);
						o.setEmail(email);
						o.setPhoneNo(phoneNo);
						o.setGender(gender);
						o.setAge(age);
						o.setAddress(address);
						orp.updateOwner(o);
						JOptionPane.showMessageDialog(this,"Owner updated Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			
			if(!userTF.getText().isEmpty()) 
			{
				userId=userTF.getText();
				OwnerRepo orp=new OwnerRepo();
				Owner o=orp.searchOwnerByUserId(userId);
				if(o!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					orp.removeOwner(userId);
					JOptionPane.showMessageDialog(this,"Owner removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty())
			{
				userId=userTF.getText();
				OwnerRepo orp=new OwnerRepo();
				Owner o=orp.searchOwnerByUserId(userId);
				if(o!=null)
				{
					userTF.setEditable(false);
					nameTF.setText(o.getName());
					emailTF.setText(o.getEmail());
					phoneNoTF.setText(o.getPhoneNo()); 
					if(o.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}

					ageTF.setText(String.valueOf(o.getAge()));
					addressTF.setText(o.getAddress());
					JOptionPane.showMessageDialog(this,"Owner found");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Owner not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to search Owner.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			OwnerOperationFrame oof= new OwnerOperationFrame(u);
			this.setVisible(false);
			oof.setVisible(true);
			JOptionPane.showMessageDialog(this,"reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			OwnerHomeFrame ohf=new OwnerHomeFrame(u);
			this.setVisible(false);
			ohf.setVisible(true);
		}
	}
	
}
