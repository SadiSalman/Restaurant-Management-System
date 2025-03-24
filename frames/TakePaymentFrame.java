package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;


public class TakePaymentFrame extends JFrame implements ActionListener
{
	private JLabel paymentIdLabel,orderIdLabel, userIdLabel, amountLabel,paymentDateLabel;
	private JTextField  paymentIdTF, orderIdTF, userIdTF, amountTF, paymentDateTF;
	private JButton confirmBtn, backBtn;
	private JPanel panel;
	private User u;
	
	
	
	
	public TakePaymentFrame(User u)
	{
		super("Payment Frame");
		this.setSize(1024,760);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.paymentIdLabel=new JLabel("Payment Id:");
		this.paymentIdLabel.setBounds(80,50,150,30);
		this.panel.add(paymentIdLabel);
		
		this.paymentIdTF=new JTextField();
		this.paymentIdTF.setBounds(220,50,200,30);
		this.panel.add(paymentIdTF);
		
		this.orderIdLabel=new JLabel("Order Id:");
		this.orderIdLabel.setBounds(80,100,150,30);
		this.panel.add(orderIdLabel);
		
		this.orderIdTF=new JTextField();
		this.orderIdTF.setBounds(220,100,200,30);
		this.panel.add(orderIdTF);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(80,150,150,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(220,150,200,30);
		this.panel.add(userIdTF);
		
		this.amountLabel=new JLabel("Amount:");
		this.amountLabel.setBounds(80,200,150,30);
		this.panel.add(amountLabel);
		
		this.amountTF=new JTextField();
		this.amountTF.setBounds(220,200,200,30);
		this.panel.add(amountTF);
		
		
		
		this.paymentDateLabel=new JLabel("Payment Date:");
		this.paymentDateLabel.setBounds(80,250,100,30);
		this.panel.add(paymentDateLabel);
		
		this.paymentDateTF=new JTextField();
		this.paymentDateTF.setBounds(220,250,200,30);
		this.panel.add(paymentDateTF);
		
		
		
		
		this.confirmBtn=new JButton("Confirm");
		this.confirmBtn.setBounds(300,350,150,30);
		this.confirmBtn.addActionListener(this);
		this.panel.add(confirmBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(80,350,150,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
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
		
		
		if(command.equals(confirmBtn.getText()))
		{
			JOptionPane.showMessageDialog(this,"Your Payment is Confirmed");
		}
	}
}