package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;
import interfaces.*;
public class CustomerOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel,emailLabel,phoneNoLabel,genderLabel,ageLabel,addressLabel,securityQuesLabel,securityAnsLabel,passLabel,memberShipTypeLabel;
	private JTextField userTF,nameTF,emailTF,phoneNoTF,genderTF,ageTF,addressTF,securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB,femaleRB,noneRB,goldRB;
	private ButtonGroup bg;
	private JButton addBtn,removeBtn,updateBtn,resetBtn,searchBtn,backBtn;
	private JTable customerTable;
	private JScrollPane customerTableSP;
	private JPanel panel;
	private User u;
	
	public CustomerOperationFrame(User u)
	{
		super("Customer Operation Frame");
		this.setSize(1024,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User ID ");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email ");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,100,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender");
		this.genderLabel.setBounds(50,250,60,30);
		this.panel.add(genderLabel);
		
		this.maleRB= new JRadioButton("Male");
		this.maleRB.setBounds(120,250,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,250,80,30);
		this.panel.add(femaleRB);
		
		this.ageLabel=new JLabel("Age");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address");
		this.addressLabel.setBounds(280,50,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(350,50,100,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel( "What is your favourite food?");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("security Ans :");
		this.securityAnsLabel.setBounds(280,150,60,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,150,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password");
		this.passLabel.setBounds(280,200,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		this.panel.add(passPF);
		
		this.memberShipTypeLabel=new JLabel("Member");
		this.memberShipTypeLabel.setBounds(280,300,215,34);
		this.panel.add(memberShipTypeLabel);
		
		
		this.noneRB=new JRadioButton("None");
		this.noneRB.setBounds(395,300,120,34);
		this.panel.add(noneRB);
		
		this.goldRB=new JRadioButton("Gold");
		this.goldRB.setBounds(520,300,188,34);
		this.panel.add(goldRB);
		
		this.bg=new ButtonGroup();
		bg.add(noneRB);
		bg.add(goldRB);
		
		
		this.addBtn = new JButton("Add");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn = new JButton("Update");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(670,350,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(550,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		CustomerRepo c=new CustomerRepo();
		Customer[]customerList=c.getAllCustomer();
		
		String customerData[][]=new String[customerList.length][8];
		for(int i=0;i<customerList.length;i++)
		{
			if(customerList[i]!=null)
			{
				System.out.println(customerList[i].toStringFromCustomer());
				customerData[i][0]=customerList[i].getUserId();
				customerData[i][1]=customerList[i].getName();
				customerData[i][2]=customerList[i].getGender();
				customerData[i][3]=String.valueOf(customerList[i].getAge());
				customerData[i][4]=customerList[i].getEmail();
				customerData[i][5]=customerList[i].getPhoneNo();
				customerData[i][6]=customerList[i].getAddress();
				customerData[i][7]=String.valueOf(customerList[i].getDiscountPercentage());
			}
		}
		String head[]={"ID","Name","Gender","Age","Email","PhoneNo","Adress","Discount"};
		this.customerTable=new JTable(customerData,head);
		this.customerTableSP=new JScrollPane(customerTable);
		this.customerTableSP.setBounds(50,400,770,200);
		this.customerTable.setEnabled(false);
		this.panel.add(customerTableSP);
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
			String userId,name,email,phoneNo,gender,address,securityAns,pass,memberShipType;
			double discountPercen;
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
						
						if(noneRB.isSelected())
							{
								memberShipType="None";	
								discountPercen=0.0;
							}

						else if(goldRB.isSelected())
						{
							
							memberShipType="Gold";						
							discountPercen=20.0;
						}
							
						else
						{
							memberShipType="None";
							discountPercen=0.0;
						}	



						Customer c=new Customer(userId,name,gender, age,email,phoneNo,address,role,securityAns,pass,discountPercen,memberShipType);
						urp.addUser(c);
						CustomerRepo crp=new CustomerRepo();
						crp.addCustomer(c);
						JOptionPane.showMessageDialog(this,"Customer added Successfully");
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
				JOptionPane.showMessageDialog(this,"Fill up all the field properly");
			}
			
		}
		
		if(command.equals(updateBtn.getText()))
		{
			
			String userId,name,email,phoneNo,gender,address,memberShipType;
			int age;
			double discountPercen;
		
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=userTF.getText();
				CustomerRepo crp=new CustomerRepo();
				Customer c=crp.searchCustomerByUserId(userId);
				if(c!=null)
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
						
						if(noneRB.isSelected())
							{
								memberShipType="None";	
								discountPercen=0.0;
							}

						else if(goldRB.isSelected())
						{
							
							memberShipType="Gold";						
							discountPercen=20.0;
						}
							
						else
						{
							memberShipType="None";
							discountPercen=0.0;
						}	

						c.setName(name);
						c.setEmail(email);
						c.setPhoneNo(phoneNo);
						c.setGender(gender);
						c.setAge(age);
						c.setAddress(address);
						crp.updateCustomer(c);
						JOptionPane.showMessageDialog(this,"Customer updated Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			
			if(!userTF.getText().isEmpty()) 
			{
				userId=userTF.getText();
				CustomerRepo crp=new CustomerRepo();
				Customer c=crp.searchCustomerByUserId(userId);
				if(c!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					crp.removeCustomer(userId);
					JOptionPane.showMessageDialog(this,"Customer removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty())
			{
				userId=userTF.getText();
				CustomerRepo crp=new CustomerRepo();
				Customer c=crp.searchCustomerByUserId(userId);
				if(c!=null)
				{
					userTF.setEditable(false);
					nameTF.setText(c.getName());
					emailTF.setText(c.getEmail());
					phoneNoTF.setText(c.getPhoneNo()); 
					if(c.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}

					ageTF.setText(String.valueOf(c.getAge()));
					addressTF.setText(c.getAddress());
					
					JOptionPane.showMessageDialog(this,"Customer found");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Customer not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Provide userId to search Customer.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			CustomerOperationFrame cof= new CustomerOperationFrame(u);
			this.setVisible(false);
			cof.setVisible(true);
			JOptionPane.showMessageDialog(this,"Reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			OwnerHomeFrame ohf=new OwnerHomeFrame(u);
			this.setVisible(false);
			ohf.setVisible(true);
		}
	}
}