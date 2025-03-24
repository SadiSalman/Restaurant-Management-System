package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class OrderFrame extends JFrame implements ActionListener
{
	private JLabel orderIdLabel, userIdLabel, orderStatusLabel, paymentStatusLabel,orderDateLabel;
	private JTextField orderIdTF, userIdTF, orderStatusTF, paymentStatusTF, orderDateTF;
	private JButton paymentBtn, backBtn, cancelBtn, updateBtn;
	private JPanel panel;
	private User u;
	private Customer customer;
	
	
	
	
	public OrderFrame(User u)
	{
		super("Order Frame");
		this.setSize(1024,760);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		
		this.orderIdLabel=new JLabel("Order Id:");
		this.orderIdLabel.setBounds(80,50,150,30);
		this.panel.add(orderIdLabel);
		
		this.orderIdTF=new JTextField();
		this.orderIdTF.setBounds(220,50,200,30);
		this.panel.add(orderIdTF);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(80,100,150,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(220,100,200,30);
		this.panel.add(userIdTF);
		
		this.orderStatusLabel=new JLabel("Total Amount:");
		this.orderStatusLabel.setBounds(80,150,150,30);
		this.panel.add(orderStatusLabel);
		
		this.orderStatusTF=new JTextField();
		this.orderStatusTF.setBounds(220,150,200,30);
		this.panel.add(orderStatusTF);
		
		this.paymentStatusLabel=new JLabel("Paid Amount:");
		this.paymentStatusLabel.setBounds(80,200,150,30);
		this.panel.add(paymentStatusLabel);
		
		this.paymentStatusTF=new JTextField();
		this.paymentStatusTF.setBounds(220,200,200,30);
		this.panel.add(paymentStatusTF);
		
		this.orderDateLabel=new JLabel("Due Amount:");
		this.orderDateLabel.setBounds(80,250,100,30);
		this.panel.add(orderDateLabel);
		
		this.orderDateTF=new JTextField();
		this.orderDateTF.setBounds(220,250,200,30);
		this.panel.add(orderDateTF);
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(80, 300,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.paymentBtn=new JButton("Payment");
		this.paymentBtn.setBounds(190,300,100,30);
		this.paymentBtn.addActionListener(this);
		this.panel.add(paymentBtn);
		
		this.cancelBtn=new JButton("Cancel");
		this.cancelBtn.setBounds(300,300,100,30);
		this.panel.add(cancelBtn);
		this.add(panel);
		
		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(410,300,100,30);
		this.panel.add(updateBtn);
		this.add(panel);
		
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
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
				FoodListFrame flf=new FoodListFrame(u);
				this.setVisible(false);
				flf.setVisible(true);
			}				
		}
		
		if(command.equals(cancelBtn.getText()))
		{
			JOptionPane.showMessageDialog(this,"Your Order is cancel");
		}
		
		if(command.equals(updateBtn.getText()))
		{
			JOptionPane.showMessageDialog(this,"Your Order is Updated");
		}
		
		if(command.equals(paymentBtn.getText()))
		{
			PaymentFrame pf = new PaymentFrame(u);
			this.setVisible(false);
			pf.setVisible(true);
		}
	}
}