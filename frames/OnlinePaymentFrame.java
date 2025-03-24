package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlinePaymentFrame extends JFrame implements ActionListener
{
	private JLabel nameLabel, acNoLabel, amountLabel, pinLabel;
	private JTextField acNoTF, amountTF;
	private JPasswordField pinTF;
	private JButton backBtn, confirmBtn;
	private User u;
	private JPanel panel;
	
	public OnlinePaymentFrame(User u)
	{
		super("Online Payment");
		this.setSize(1024,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.nameLabel=new JLabel("Online Payment");
		this.nameLabel.setBounds(280,100,100,30);
		this.panel.add(nameLabel);
		
		this.acNoLabel=new JLabel("Account No:");
		this.acNoLabel.setBounds(80,150,150,30);
		this.panel.add(acNoLabel);
		
		this.acNoTF=new JTextField();
		this.acNoTF.setBounds(220,150,200,30);
		this.panel.add(acNoTF);
		
		this.amountLabel=new JLabel("Amount:");
		this.amountLabel.setBounds(80,200,150,30);
		this.panel.add(amountLabel);
		
		this.amountTF=new JTextField();
		this.amountTF.setBounds(220,200,200,30);
		this.panel.add(amountTF);
		
		this.pinLabel=new JLabel("Pin:");
		this.pinLabel.setBounds(80,250,150,30);
		this.panel.add(pinLabel);
		
		this.pinTF=new JPasswordField();
		this.pinTF.setBounds(220,250,200,30);
		this.panel.add(pinTF);
		
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
		String command = ae.getActionCommand();
		
		if( command.equals(backBtn.getText()))
		{
			PaymentFrame pf = new PaymentFrame(u);
			this.setVisible(false);
			pf.setVisible(true);
		}
		
		if(command.equals(confirmBtn.getText()))
		{
			JOptionPane.showMessageDialog(this,"Your Order is Confirmed");
		}
		
	}
}