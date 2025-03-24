package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.event.*;
public class OwnerHomeFrame extends JFrame implements ActionListener
{
	private JButton accountBtn, passwordBtn, ownerBtn, employeeBtn, customerBtn, vFoodBtn, vOrderBtn, vOrderLineBtn, vPaymentBtn, signOutBtn;
	private JPanel panel;
	private User u;
	private Food f;
	
	public OwnerHomeFrame(User u)
	{
		super("Owner Home Frame");
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
		
		this.ownerBtn=new JButton("Owner Operations");
		this.ownerBtn.setBounds(300,215,354,39);
		this.ownerBtn.addActionListener(this);
		this.panel.add(ownerBtn);
		
		this.employeeBtn=new JButton("Employee Operations");
		this.employeeBtn.setBounds(300,268,354,39);
		this.employeeBtn.addActionListener(this);
		this.panel.add(employeeBtn);
		
		this.customerBtn=new JButton("Customer Operations");
		this.customerBtn.setBounds(300,321,354,39);
		this.customerBtn.addActionListener(this);
		this.panel.add(customerBtn);
		
		this.vFoodBtn=new JButton("View Food List");
		this.vFoodBtn.setBounds(300,374,354,39);
		this.vFoodBtn.addActionListener(this);
		this.panel.add(vFoodBtn);
		
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
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(ownerBtn.getText()))
		{
			OwnerOperationFrame oof=new OwnerOperationFrame(u);
			this.setVisible(false);
			oof.setVisible(true);
		}
		if(command.equals(employeeBtn.getText()))
		{
			EmployeeOperationFrame eof=new EmployeeOperationFrame(u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		if(command.equals(customerBtn.getText()))
		{
			CustomerOperationFrame cof=new CustomerOperationFrame(u);
			this.setVisible(false);
			cof.setVisible(true);
		}
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
		if(command.equals(vFoodBtn.getText()))
		{
			ViewFoodListFrame vfl=new ViewFoodListFrame(f);
			this.setVisible(false);
			vfl.setVisible(true);
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
		
		if(command.equals(accountBtn.getText()))
		{
			OwnerAccountFrame oaf=new OwnerAccountFrame(u);
			this.setVisible(false);
			oaf.setVisible(true);
		}
	
	}
	
}