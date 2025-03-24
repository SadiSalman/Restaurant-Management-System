package frames;

import java.lang.*;
import entities.*;
import interfaces.*;
import repositories.*;
import javax.swing.*;
import java.awt.event.*;

public class TakeOrderFrame extends JFrame implements ActionListener
{
	private JCheckBox c1, c2,c3,c4,c5,c6,c7,c8,c9,c10;
	private JComboBox b1, b2, b3,b4,b5,b6,b7,b8,b9;
	private JLabel itemLabel, amountLabel, foodListLabel;
	private JButton backBtn, confirmBtn, orderBtn;
	private User u;
	private JPanel panel;
	
	public TakeOrderFrame(User u)
	{
		super("Food List");
		this.setSize(1024,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.foodListLabel=new JLabel("Food List");
		this.foodListLabel.setBounds(280,100,100,30);
		this.panel.add(foodListLabel);
		
		
		this.itemLabel=new JLabel("Item -----------------------Price");
		this.itemLabel.setBounds(50,150,300,20);
		this.panel.add(itemLabel);
		
		this.amountLabel=new JLabel("Amount");
		this.amountLabel.setBounds(380,150,300,20);
		this.panel.add(amountLabel);
		
		this.c1=new JCheckBox("Soup--------------------160/-");
		this.c1.setBounds(50,200,300,20);
		this.panel.add(c1);
		
		this.c2=new JCheckBox("Pizza--------------------400/-");
		this.c2.setBounds(50,230,300,20);
		this.panel.add(c2);
		
		this.c3=new JCheckBox("Burger-----------------1200/-");
		this.c3.setBounds(50,260,300,20);
		this.panel.add(c3);
		
		this.c4=new JCheckBox("Juice--------------------20/-");
		this.c4.setBounds(50,290,300,20);
		this.panel.add(c4);
		
		this.c5=new JCheckBox("coca cola-----------------25/-");
		this.c5.setBounds(50,320,300,20);
		this.panel.add(c5);
		
		this.c6=new JCheckBox("Pasta-------------------140/-");
		this.c6.setBounds(50,350,300,20);
		this.panel.add(c6);
		
		this.c7=new JCheckBox("fries--------------------60/-");
		this.c7.setBounds(50,380,300,20);
		this.panel.add(c7);
		
		this.c8=new JCheckBox("Ice Cream-----------------100/-");
		this.c8.setBounds(50,410,300,20);
		this.panel.add(c8);
		
		this.c9=new JCheckBox("Biriyani-------------------250/-");
		this.c9.setBounds(50,440,300,20);
		this.panel.add(c9);
		
		
		
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,200,100,30);
		this.panel.add(amountLabel);
		
		String [] item ={"1","2","3","4", "5"};
		this.b1=new JComboBox(item);
		this.b1.setBounds(450,200,100,30);
		this.panel.add(b1);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,230,100,30);
		this.panel.add(amountLabel);
		
		String [] item1 ={"1","2","3","4", "5"};
		this.b2=new JComboBox(item);
		this.b2.setBounds(450,230,100,30);
		this.panel.add(b2);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,260,100,30);
		this.panel.add(amountLabel);
		
		String [] item2 ={"1","2","3","4", "5"};
		this.b3=new JComboBox(item);
		this.b3.setBounds(450,260,100,30);
		this.panel.add(b3);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,290,100,30);
		this.panel.add(amountLabel);
		
		String [] item3 ={"1","2","3","4", "5"};
		this.b4=new JComboBox(item);
		this.b4.setBounds(450,290,100,30);
		this.panel.add(b4);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,320,100,30);
		this.panel.add(amountLabel);
		
		String [] item4 ={"1","2","3","4", "5"};
		this.b5=new JComboBox(item);
		this.b5.setBounds(450,320,100,30);
		this.panel.add(b5);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,350,100,30);
		this.panel.add(amountLabel);
		
		String [] item5 ={"1","2","3","4", "5"};
		this.b6=new JComboBox(item);
		this.b6.setBounds(450,350,100,30);
		this.panel.add(b6);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,380,100,30);
		this.panel.add(amountLabel);
		
		String [] item6 ={"1","2","3","4", "5"};
		this.b7=new JComboBox(item);
		this.b7.setBounds(450,380,100,30);
		this.panel.add(b7);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,410,100,30);
		this.panel.add(amountLabel);
		
		String [] item7 ={"1","2","3","4", "5"};
		this.b8=new JComboBox(item);
		this.b8.setBounds(450,410,100,30);
		this.panel.add(b8);
		
		this.amountLabel=new JLabel("Quantity");
		this.amountLabel.setBounds(350,440,100,30);
		this.panel.add(amountLabel);
		
		String [] item8 ={"1","2","3","4", "5"};
		this.b9=new JComboBox(item);
		this.b9.setBounds(450,440,100,30);
		this.panel.add(b9);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(90, 500,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.confirmBtn=new JButton("Confirm Order");
		this.confirmBtn.setBounds(480,500,150,30);
		this.confirmBtn.addActionListener(this);
		this.panel.add(confirmBtn);
		
		/*this.orderBtn=new JButton("get Order Id");
		this.orderBtn.setBounds(270,500,130,30);
		this.orderBtn.addActionListener(this);
		this.panel.add(orderBtn);*/
		
		this.u=u;
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if( command.equals(backBtn.getText()))
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
				CustomerHomeFrame chf=new CustomerHomeFrame(u);
				this.setVisible(false);
				chf.setVisible(true);
			}
		}
		
		/*if(command.equals(confirmBtn.getText()))
		{
			OrderFrame of = new OrderFrame(u);
			this.setVisible(false);
			of.setVisible(true);
		}*/
		
		if(command.equals(confirmBtn.getText()))
		{
			JOptionPane.showMessageDialog(this,"Your Order is confirmed");
		}
	}
}