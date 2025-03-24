package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;
import interfaces.*;
public class EmployeeOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel,emailLabel,phoneNoLabel,genderLabel,ageLabel,addressLabel,securityQuesLabel,securityAnsLabel,passLabel,designationLabel,salaryLabel;
	private JTextField userTF,nameTF,emailTF,phoneNoTF,ageTF,addressTF,securityAnsTF, salaryTF;
	private JPasswordField passPF;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup bg;
	private JComboBox designationCMB;
	private JButton addBtn,removeBtn,updateBtn,resetBtn,searchBtn,backBtn;
	private JTable employeeTable;
	private JScrollPane employeeTableSP;
	private JPanel panel;
	private User u;
	private Food f;
	
	public EmployeeOperationFrame(User u)
	{
		super("Employee Operation");
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
		
		this.securityQuesLabel=new JLabel("What is your favourite food");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Ans :");
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
		
		this.designationLabel=new JLabel("Designation");
		this.designationLabel.setBounds(280,250,100,30);
		this.panel.add(designationLabel);
		
		String [] item ={"Manager","Chef","Waiter"};
		this.designationCMB=new JComboBox(item);
		this.designationCMB.setBounds(390,250,200,30);
		this.panel.add(designationCMB);
		
		this.salaryLabel=new JLabel("Salary:");
		this.salaryLabel.setBounds(280,300,100,30);
		this.panel.add(salaryLabel);
		
		this.salaryTF=new JTextField();
		this.salaryTF.setBounds(390,300,100,30);
		this.panel.add(salaryTF);
		
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
		
		EmployeeRepo erp=new EmployeeRepo();
		Employee[] employeeList=erp.getAllEmployee();
		
		String employeeData[][]=new String[employeeList.length][9];
		for(int i=0;i<employeeList.length;i++)
		{
			if(employeeList[i]!=null)
			{
				System.out.println(employeeList[i].toStringFromEmployee());
				employeeData[i][0]=employeeList[i].getUserId();
				employeeData[i][1]=employeeList[i].getName();
				employeeData[i][2]=employeeList[i].getEmail();
				employeeData[i][3]=employeeList[i].getPhoneNo();
				employeeData[i][4]=employeeList[i].getGender();
				employeeData[i][5]=String.valueOf(employeeList[i].getAge());
				employeeData[i][6]=employeeList[i].getAddress();
				employeeData[i][7]=String.valueOf(employeeList[i].getSalary());
				employeeData[i][8]=employeeList[i].getDesignation();
			}
		}
		String head[]={"ID","Name","Email","PhoneNo","Gender","Age","Adress","Salary","Designation"};
		this.employeeTable=new JTable(employeeData,head);
		this.employeeTableSP=new JScrollPane(employeeTable);
		this.employeeTableSP.setBounds(50,380,700,200);
		this.employeeTable.setEnabled(false);
		this.panel.add(employeeTableSP);
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
			String userId,name,email,phoneNo,gender,address,securityAns,pass,designation;
			int age;
			double salary;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected()))  && (!salaryTF.getText().isEmpty()) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
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
						designation=designationCMB.getSelectedItem().toString();
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						int role=2;
						salary=Double.parseDouble(salaryTF.getText());
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						Employee emp=new Employee(userId,name,gender, age,email,phoneNo,address,role,securityAns,pass,designation,salary);
						urp.addUser(emp);
						EmployeeRepo erp=new EmployeeRepo();
						erp.addEmployee(emp);
						JOptionPane.showMessageDialog(this,"Employee added Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid age or salary");
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
			
			String userId,name,email,phoneNo,gender,address,designation;
			int age;
			double salary;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected()))  && (!salaryTF.getText().isEmpty()) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=userTF.getText();
				EmployeeRepo erp=new EmployeeRepo();
				Employee emp=erp.searchEmployeeByUserId(userId);
				if(emp!=null)
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
						salary=Double.parseDouble(salaryTF.getText());
						designation=designationCMB.getSelectedItem().toString();
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						emp.setSalary(salary);
						emp.setDesignation(designation);
						emp.setName(name);
						emp.setEmail(email);
						emp.setPhoneNo(phoneNo);
						emp.setGender(gender);
						emp.setAge(age);
						emp.setAddress(address);
						erp.updateEmployee(emp);
						JOptionPane.showMessageDialog(this,"Employee updated Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid age or Input salary in decimal form");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			
			if(!userTF.getText().isEmpty()) 
			{
				userId=userTF.getText();
				EmployeeRepo erp=new EmployeeRepo();
				Employee emp=erp.searchEmployeeByUserId(userId);
				if(emp!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					erp.removeEmployee(userId);
					JOptionPane.showMessageDialog(this,"Employee removed Successfully");
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
				EmployeeRepo erp=new EmployeeRepo();
				Employee emp=erp.searchEmployeeByUserId(userId);
				if(emp!=null)
				{
					userTF.setEditable(false);
					nameTF.setText(emp.getName());
					emailTF.setText(emp.getEmail());
					phoneNoTF.setText(emp.getPhoneNo()); 
					salaryTF.setText(String.valueOf(emp.getSalary()));
					if(emp.getDesignation().equals("Manager"))
					{
						designationCMB.setSelectedItem("Manager");
					}
					else if(emp.getDesignation().equals("Chef"))
					{
						designationCMB.setSelectedItem("Chef");
					}
					else
					{
						designationCMB.setSelectedItem("Waiter");
					}
					if(emp.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}

					ageTF.setText(String.valueOf(emp.getAge()));
					addressTF.setText(emp.getAddress());
					JOptionPane.showMessageDialog(this,"Employee found");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Employee not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to search Employee.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			EmployeeOperationFrame oof= new EmployeeOperationFrame(u);
			this.setVisible(false);
			oof.setVisible(true);
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