package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class ViewOrderListFrame extends JFrame implements ActionListener 
{
	
	private JButton backBtn;
	private JTable orderT;
	private JScrollPane orderSP;
	private JPanel panel;
	private User u;
	
	public ViewOrderListFrame(User u)
	{
		super("Order List");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn = new JButton("BACK");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		OrderRepo or=new OrderRepo();
		Order[] orderList=or.getAllOrder();
		
		String orderData1[][]=new String[orderList.length][8];
		for(int i=0;i<orderList.length;i++)
		{
		
			if(orderList[i]!=null)
			{
				orderData1[i][0]=orderList[i].getOrderId();
				orderData1[i][1]=orderList[i].getUserId();
				orderData1[i][2]=String.valueOf(orderList[i].getTotalAmount());
				orderData1[i][3]=String.valueOf(orderList[i].getPaidAmount());
				orderData1[i][4]=String.valueOf(orderList[i].getDueAmount());
				orderData1[i][5]=orderList[i].getOrderStatus();
				orderData1[i][6]=orderList[i].getPaymentStatus();
				orderData1[i][7]=orderList[i].getOrderDate();
			}
		}
		
		String head1[]={"Order id","User Id","Total Amount","Paid Amount","Due Amount","Order Status","Payment Status","Order Date"};
		
		this.orderT=new JTable(orderData1,head1);
		this.orderSP=new JScrollPane(orderT);
		this.orderSP.setBounds(50,110,700,200);
		this.orderT.setEnabled(false);
		this.panel.add(orderSP);
		
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
			EmployeeHomeFrame ehf=new EmployeeHomeFrame(u);
			this.setVisible(false);
			ehf.setVisible(true);	
		}
	}
}

