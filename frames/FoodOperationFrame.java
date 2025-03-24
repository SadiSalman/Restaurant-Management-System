package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;
import interfaces.*;
public class FoodOperationFrame extends JFrame implements ActionListener
{
	private JLabel foodIdLabel,nameLabel, categoryLabel,pricePerUnitLabel,detailsLabel;
	private JTextField foodTF,nameTF,categoryTF,pricePerUnitTF, detailsTF;
	private JButton addBtn,removeBtn,updateBtn,resetBtn,searchBtn,backBtn;
	private JTable foodTable;
	private JScrollPane foodTableSP;
	private JPanel panel;
	private Food f;
	private User u;
	
	public FoodOperationFrame(Food f)
	{
		super("food Operation Frame");
		this.setSize(1024,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.foodIdLabel=new JLabel("Food ID ");
		this.foodIdLabel.setBounds(50,50,60,30);
		this.panel.add(foodIdLabel);
		
		this.foodTF=new JTextField();
		this.foodTF.setBounds(120,50,100,30);
		this.panel.add(foodTF);
		
		this.nameLabel=new JLabel("Name");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		this.categoryLabel=new JLabel("Category");
		this.categoryLabel.setBounds(50,150,60,30);
		this.panel.add(categoryLabel);
		
		this.categoryTF=new JTextField();
		this.categoryTF.setBounds(120,150,100,30);
		this.panel.add(categoryTF);
		
		this.pricePerUnitLabel=new JLabel("Price");
		this.pricePerUnitLabel.setBounds(50,200,60,30);
		this.panel.add(pricePerUnitLabel);
		
		this.pricePerUnitTF=new JTextField();
		this.pricePerUnitTF.setBounds(120,200,100,30);
		this.panel.add(pricePerUnitTF);
		
		this.detailsLabel=new JLabel("details");
		this.detailsLabel.setBounds(50,250,60,30);
		this.panel.add(detailsLabel);
		
		this.detailsTF=new JTextField();
		this.detailsTF.setBounds(120,250,100,30);
		this.panel.add(detailsTF);
		
		this.addBtn = new JButton("Add");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn = new JButton("Update");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(670,350,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(550,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		FoodRepo fr=new FoodRepo();
		Food[]foodList=fr.getAllFood();
		
		String foodData[][]=new String[foodList.length][5];
		for(int i=0;i<foodList.length;i++)
		{
			if(foodList[i]!=null)
			{
				System.out.println(foodList[i].toStringFromFood());
				foodData[i][0]=foodList[i].getFoodId();
				foodData[i][1]=foodList[i].getName();
				foodData[i][2]=foodList[i].getCategory();
				foodData[i][3]=foodList[i].getPricePerUnit();
				foodData[i][4]=foodList[i].getDetails();
			}
		}
		String head[]={"Food ID","Name","category","pricePerUnit","Details"};
		this.foodTable=new JTable(foodData,head);
		this.foodTableSP=new JScrollPane(foodTable);
		this.foodTableSP.setBounds(50,400,770,200);
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
		
		if(command.equals(addBtn.getText()))
		{
			String foodId,name,category,pricePerUnit,details;
			
			if((!foodTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!categoryTF.getText().isEmpty()) && (!pricePerUnitTF.getText().isEmpty()))
			{
				foodId=foodTF.getText();
				FoodRepo urp=new FoodRepo();
				Food food=urp.searchFoodByFoodId(foodId);
				if(food==null)
				{
					try
					{
						name=nameTF.getText();
						category=categoryTF.getText();
						pricePerUnit=pricePerUnitTF.getText();
						details=detailsTF.getText();
						Food f=new Food(foodId,name,category,pricePerUnit,details);
						urp.addFood(f);
						FoodRepo crp=new FoodRepo();
						crp.addFood(f);
						JOptionPane.showMessageDialog(this,"food added Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Food Id already exists.");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Fill up all the field properly");
			}
			
		}
		
		if(command.equals(updateBtn.getText()))
		{
			
			String foodId,name,category,pricePerUnit,details;
			
		
			if((!foodTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!categoryTF.getText().isEmpty()) && (!pricePerUnitTF.getText().isEmpty()))
			{
				foodId=foodTF.getText();
				FoodRepo crp=new FoodRepo();
				Food f=crp.searchFoodByFoodId(foodId);
				if(f!=null)
				{
					try
					{
						name=nameTF.getText();
						category=categoryTF.getText();
						pricePerUnit=pricePerUnitTF.getText();
						details=detailsTF.getText();
						f.setName(name);
						f.setCategory(category);
						f.setPricePerUnit(pricePerUnit);
						f.setDetails(details);
						crp.updateFood(f);
						JOptionPane.showMessageDialog(this,"food updated Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide valid Id");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid food ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String foodId;
			
			if(!foodTF.getText().isEmpty()) 
			{
				foodId=foodTF.getText();
				FoodRepo crp=new FoodRepo();
				Food f=crp.searchFoodByFoodId(foodId);
				if(f!=null)
				{
					FoodRepo urp=new FoodRepo();
					urp.removeFood(foodId);
					crp.removeFood(foodId);
					JOptionPane.showMessageDialog(this,"food removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid food ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Provide a valid foodId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String foodId;
			if(!foodTF.getText().isEmpty())
			{
				foodId=foodTF.getText();
				FoodRepo crp=new FoodRepo();
				Food f=crp.searchFoodByFoodId(foodId);
				if(f!=null)
				{
					foodTF.setEditable(false);
					nameTF.setText(f.getName());
					categoryTF.setText(f.getCategory());
					pricePerUnitTF.setText(f.getPricePerUnit()); 
					detailsTF.setText(f.getDetails());
					JOptionPane.showMessageDialog(this,"food found");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"food not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Provide foodId to search food.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			FoodOperationFrame cof= new FoodOperationFrame(f);
			this.setVisible(false);
			cof.setVisible(true);
			JOptionPane.showMessageDialog(this,"Reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			EmployeeHomeFrame ehf=new EmployeeHomeFrame(u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
	}
}