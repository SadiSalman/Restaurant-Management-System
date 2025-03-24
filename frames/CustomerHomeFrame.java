package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.event.*;
public class CustomerHomeFrame extends JFrame implements ActionListener
{
	private JButton accountBtn, passwordBtn, orderBtn, cancelOrderBtn, vFoodListBtn, makePaymentBtn, vPaymentHistBtn, vOrderHistBtn, vOrderLineHistBtn, signOutBtn;
	private JPanel panel;
	
	private User u;
	
	public CustomerHomeFrame(User u)
	{
		super("Customer Home");
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
		
		/*this.orderBtn=new JButton("Order");
		this.orderBtn.setBounds(300,215,354,39);
		this.panel.add(orderBtn);
		
		this.cancelOrderBtn=new JButton("Cancel Orders");
		this.cancelOrderBtn.setBounds(300,268,354,39);
		this.panel.add(cancelOrderBtn);*/
		
		this.vFoodListBtn=new JButton("View Food List");
		this.vFoodListBtn.setBounds(300,215,354,39);
		this.vFoodListBtn.addActionListener(this);
		this.panel.add(vFoodListBtn);
		
		/*this.makePaymentBtn=new JButton("Make Payment");
		this.makePaymentBtn.setBounds(300,374,354,39);
		this.panel.add(makePaymentBtn);*/
		
		this.vPaymentHistBtn=new JButton("View Payment History");
		this.vPaymentHistBtn.setBounds(300,268,354,39);
		this.panel.add(vPaymentHistBtn);
		
		this.vOrderHistBtn=new JButton("View Order History");
		this.vOrderHistBtn.setBounds(300,321,354,39);
		this.panel.add(vOrderHistBtn);
		
		this.vOrderLineHistBtn=new JButton("View Order Line History");
		this.vOrderLineHistBtn.setBounds(300,374,354,39);
		this.panel.add(vOrderLineHistBtn);
		
		this.signOutBtn=new JButton("Sign out");
		this.signOutBtn.setBounds(600,480,300,39);
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
			CustomerAccountFrame caf=new CustomerAccountFrame(u);
			this.setVisible(false);
			caf.setVisible(true);
		}
		if(command.equals(vFoodListBtn.getText()))
		{
			FoodListFrame flf=new FoodListFrame(u);
			this.setVisible(false);
			flf.setVisible(true);
		}
	}
}