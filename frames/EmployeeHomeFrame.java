package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.event.*;
public class EmployeeHomeFrame extends JFrame implements ActionListener
{
	private JButton accountBtn, passwordBtn, orderBtn, foodListBtn, takePaymentBtn, vCustomerBtn, vOrderBtn, vOrderLineBtn, vPaymentBtn, signOutBtn;
	private JPanel panel;
	private Food f;
	private User u;
	
	public EmployeeHomeFrame(User u)
	{
		super("Employee Home");
		this.setSize(1000,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.accountBtn=new JButton("My Account");
		this.accountBtn.setBounds(300,109,354,39);
		this.accountBtn.addActionListener(this);
		this.panel.add(accountBtn);
		
		this.passwordBtn=new JButton("Change Password");
		this.passwordBtn.setBounds(300,162,354,39);
		this.passwordBtn.addActionListener(this);
		this.panel.add(passwordBtn);
		
		this.orderBtn=new JButton(" Take Order ");
		this.orderBtn.setBounds(300,215,354,39);
		this.orderBtn.addActionListener(this);
		this.panel.add(orderBtn);
		
		this.foodListBtn=new JButton("Food List");
		this.foodListBtn.setBounds(300,268,354,39);
		this.foodListBtn.addActionListener(this);
		this.panel.add(foodListBtn);
		
		this.takePaymentBtn=new JButton("Take Payment");
		this.takePaymentBtn.setBounds(300,321,354,39);
		this.takePaymentBtn.addActionListener(this);
		this.panel.add(takePaymentBtn);
		
		this.vCustomerBtn=new JButton("View Customer List");
		this.vCustomerBtn.setBounds(300,374,354,39);
		this.vCustomerBtn.addActionListener(this);
		this.panel.add(vCustomerBtn);
		
		this.vOrderBtn=new JButton("View Order list");
		this.vOrderBtn.setBounds(300,427,354,39);
		this.vOrderBtn.addActionListener(this);
		this.panel.add(vOrderBtn);
		
		this.vOrderLineBtn=new JButton("View Order Line List");
		this.vOrderLineBtn.setBounds(300,427,354,39);
		this.panel.add(vOrderLineBtn);
		
		this.vPaymentBtn=new JButton("View Payment List");
		this.vPaymentBtn.setBounds(300,480,354,39);
		this.vPaymentBtn.addActionListener(this);
		this.panel.add(vPaymentBtn);
		
		this.signOutBtn=new JButton("Sign out");
		this.signOutBtn.setBounds(600,540,300,39);
		this.signOutBtn.addActionListener(this);
		this.panel.add(signOutBtn);
		
		this.u=u;
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(command.equals(passwordBtn.getText()))
		{
			ChangePasswordFrame cf=new ChangePasswordFrame(u);
			this.setVisible(false);
			cf.setVisible(true);
		}
		if(command.equals(signOutBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		if(command.equals(accountBtn.getText()))
		{
			EmployeeAccountFrame eaf=new EmployeeAccountFrame(u);
			this.setVisible(false);
			eaf.setVisible(true);
		}
		
		if(command.equals(orderBtn.getText()))
		{
			TakeOrderFrame tof=new TakeOrderFrame(u);
			this.setVisible(false);
			tof.setVisible(true);
		}
		
		if(command.equals(vOrderBtn.getText()))
		{
			ViewOrderListFrame vol=new ViewOrderListFrame(u);
			this.setVisible(false);
			vol.setVisible(true);
		}
		if(command.equals(vPaymentBtn.getText()))
		{
			ViewPaymentListFrame vpl=new ViewPaymentListFrame(u);
			this.setVisible(false);
			vpl.setVisible(true);
		}
		
		if(command.equals(foodListBtn.getText()))
		{
			FoodOperationFrame fof=new FoodOperationFrame(f);
			this.setVisible(false);
			fof.setVisible(true);
		}
		
		if(command.equals(takePaymentBtn.getText()))
		{
			TakePaymentFrame tpf=new TakePaymentFrame(u);
			this.setVisible(false);
			tpf.setVisible(true);
		}
		
		if(command.equals(vCustomerBtn.getText()))
		{
			CustomerListFrame clf=new CustomerListFrame(u);
			this.setVisible(false);
			clf.setVisible(true);
		}
		
		
		
	}
}
