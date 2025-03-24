package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class FoodRepo implements IFoodRepo
{
	public void addFood(Food f)
	{
		Food[] foodList=this.getAllFood();
		for(int i=0; i<foodList.length;i++)
		{
			if(foodList[i]==null)
			{
				foodList[i]=f;
				break;
			}
		}
		
		this.write(foodList);
	}
	
	public void removeFood(String id)
	{
		Food[] foodList = this.getAllFood();
		
		for(int i=0; i<foodList.length;i++)
		{
			if(foodList[i]!=null)
			{
				if(foodList[i].getFoodId().equals(id))
				{
					foodList[i]=null;
					break;
				}
			}
		}
		
		this.write(foodList);
	}
	
	public void updateFood(Food f)
	{
		Food[] foodList = this.getAllFood();
		
		for(int i =0; i< foodList.length; i++)
		{
			if(foodList[i]!=null)
			{
				if(foodList[i].getFoodId().equals(f.getFoodId()))
				{
					foodList[i]=f;
					break;
				}
			}
		}
		
		this.write(foodList);
	}
	
	public Food searchFoodByFoodId(String id)
	{
		Food[] foodList = this.getAllFood();
		for( int i= 0; i<foodList.length;i++)
		{
			if ( foodList[i]!= null)
			{
				if(foodList[i].getFoodId().equals(id))
				{
					return foodList[i];
				}
			}
		}
		
		return null;
	}
	
	public Food[] getAllFood()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/food.txt");
		
		
		Food f=new Food();
		Food[] foodList=new Food[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				foodList[i]=f.fromStringToFood(str);
				
			}
			
			i++;
		}
		
		return foodList;
	}
	
	public void write(Food[] foodList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(foodList[i]!=null)
			{
				data[i]=foodList [i].toStringFromFood();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/food.txt");
	}
}