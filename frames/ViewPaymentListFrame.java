package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class ViewPaymentListFrame extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableP;
	private JPanel panel;
	private User u;
	
	public ViewPaymentListFrame(User u)
	{
		super("Payment List");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		PaymentRepo pr=new PaymentRepo();
		Payment[] paymentList=pr.getAllPayment();
		
		String paymentData1[][]=new String[paymentList.length][5];
		for(int i=0;i<paymentList.length;i++)
		{
		
			if(paymentList[i]!=null)
			{
				paymentData1[i][0]=paymentList[i].getPaymentId();
				paymentData1[i][1]=paymentList[i].getOrderId();
				paymentData1[i][2]=paymentList[i].getUserId();
				paymentData1[i][3]=String.valueOf(paymentList[i].getAmount());
				paymentData1[i][4]=paymentList[i].getPaymentDate();
			}
				
		}
		
		String head1[]={"Payment Id","Order Id","User Id","Amount","Payment Date"};
		this.paymentTable=new JTable(paymentData1,head1);
		this.paymentTableP=new JScrollPane(paymentTable);
		this.paymentTableP.setBounds(50,110,700,200);
		this.paymentTable.setEnabled(false);
		this.panel.add(paymentTableP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
	
		this.u =u;
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
			else
			{
				CustomerHomeFrame chf=new CustomerHomeFrame(u);
				this.setVisible(false);
				chf.setVisible(true);
			}				
		}
	}
}


		

