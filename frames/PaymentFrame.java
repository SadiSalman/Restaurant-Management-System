package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentFrame extends JFrame implements ActionListener
{
	private JLabel paymentLabel, pmethodLabel;
	private JButton codBtn, onlineBtn, backBtn, confirmBtn;
	private User u;
	private JPanel panel;
	
	public PaymentFrame(User u)
	{
		super("Payment");
		this.setSize(800,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.paymentLabel= new JLabel("Payment");
		this.paymentLabel.setBounds(200,50,200,35);
		this.panel.add(paymentLabel);
		
		this.pmethodLabel= new JLabel("Select payment Option ");
		this.pmethodLabel.setBounds(100,150,200,30);
		this.panel.add(pmethodLabel);
		
		this.codBtn= new JButton("Cod");
		this.codBtn.setBounds(300,150,100,30);
		this.codBtn.addActionListener(this);
		this.panel.add(codBtn);
		
		this.onlineBtn= new JButton("Online");
		this.onlineBtn.setBounds(500,150,100,30);
		this.onlineBtn.addActionListener(this);
		this.panel.add(onlineBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(80, 300,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.confirmBtn=new JButton("Confirm");
		this.confirmBtn.setBounds(190,300,100,30);
		this.confirmBtn.addActionListener(this);
		this.panel.add(confirmBtn);
		
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
				OrderFrame of=new OrderFrame(u);
				this.setVisible(false);
				of.setVisible(true);
			}				
		}
		
		if(command.equals(codBtn.getText()))
		{
			JOptionPane.showMessageDialog(this,"Your Order is Confirmed");
		}
		
		if(command.equals(onlineBtn.getText()))
		{
			OnlinePaymentFrame opf = new OnlinePaymentFrame(u);
			this.setVisible(false);
			opf.setVisible(true);
		}
		
	}	
}