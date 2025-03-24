package frames;

import java.lang.*;
import javax.swing.*;
import entities.*;
import interfaces.*;
import repositories.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class ViewFoodListFrame extends JFrame implements ActionListener 
{

    private JButton backBtn;
    private JTable foodTable;
    private JScrollPane foodTableSP;
    private JPanel panel;
    private Food f;
	private User u;
    public ViewFoodListFrame(Food f) 
	{
        super("View Food List Operation Frame");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(50, 50, 100, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        FoodRepo frp = new FoodRepo();
        Food[] foodList = frp.getAllFood();

        String foodData1[][] = new String[foodList.length][5];
        for (int i = 0; i < foodList.length; i++) {
            if (foodList[i] != null) {
                foodData1[i][0] = foodList[i].getFoodId();
                foodData1[i][1] = foodList[i].getName();
                foodData1[i][2] = foodList[i].getCategory();
                foodData1[i][3] = String.valueOf(foodList[i].getPricePerUnit());
                foodData1[i][4] = foodList[i].getDetails();
            }
        }

        String head1[] = {"Food Id", "Name", "Category", "Price", "Details"};
        this.foodTable = new JTable(foodData1, head1);
        this.foodTableSP = new JScrollPane(foodTable);
        this.foodTableSP.setBounds(50, 110, 700, 200);
        this.foodTable.setEnabled(false);
        this.panel.add(foodTableSP);

        this.panel.revalidate();
        this.panel.repaint();

        this.add(panel);

        this.u=u;
    }
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(backBtn.getText()))
		{
			OwnerHomeFrame ohf=new OwnerHomeFrame(u);
			this.setVisible(false);
			ohf.setVisible(true);		
		}
	}
}