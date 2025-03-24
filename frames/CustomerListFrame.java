package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;
import interfaces.*;

public class CustomerListFrame extends JFrame implements ActionListener
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
	
	public CustomerListFrame(User u)
	{
		
		super("Customer Operation Frame");
		this.setSize(1024,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.userIdLabel=new JLabel("Customer List ");
		this.userIdLabel.setBounds(350,50,150,30);
		this.panel.add(userIdLabel);
		
		
		/*this.addBtn = new JButton("Add");
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
		this.panel.add(resetBtn);*/
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(690,450,100,30);
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
		this.customerTableSP.setBounds(50,100,770,200);
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
	
		if(command.equals(backBtn.getText()))
		{
			EmployeeHomeFrame ehf=new EmployeeHomeFrame(u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
	}
}