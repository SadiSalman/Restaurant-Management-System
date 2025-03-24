package entities;
import java.lang.*;
public class Food
{
	private String foodId,name,category,details, pricePerUnit;
	public Food()
	{
		
	}
	public Food(String foodId,String name,String category,String pricePerUnit,String details)
	{
		this.foodId=foodId;
		this.name=name;
		this.category=category;
		this.details=details;
		this.pricePerUnit=pricePerUnit;
	}
	public void setFoodId(String foodId)
	{ 
	this.foodId=foodId;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setCategory(String cetagory)
	{
		this.category=cetagory;
	}
	public void setDetails(String details)
	{
		this.details=details;
	}
	public void setPricePerUnit(String pricePerUnit)
	{
		this.pricePerUnit=pricePerUnit;
	}
	
	
	public String getFoodId()
	{ 
	return this.foodId;
	}
	public String getName()
	{
		return this.name;
	}
	public String getCategory()
	{
		return this.category;
	}
	public String getDetails()
	{
		return this.details;
	}
	public String getPricePerUnit()
	{
		return this.pricePerUnit;
	}
	
	public String toStringFromFood()
	{
		String str=this.foodId+","+this.name+","+this.pricePerUnit+","+this.category+","+this.details+"\n";
		return str;
	}
	public Food fromStringToFood(String str)
	{
	    String [] info=str.split(",");
		Food f = new Food();
		f.setFoodId(info[0]);
		f.setName(info[1]);
		f.setCategory(info[2]);
		f.setPricePerUnit(info[3]);
		f.setDetails(info[4]);
		return f;
	}
	
	
}