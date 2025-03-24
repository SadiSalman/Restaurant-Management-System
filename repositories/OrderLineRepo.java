package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class OrderLineRepo implements IOrderLineRepo
{
	 public void addOrderLine(OrderLine ol)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]==null)
			{
				orderLineList[i]=ol;
				break;
			}
		}
		
		this.write(orderLineList);
	}
	 
	public void removeOrderLine(String id)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]!=null)
			{
				if(orderLineList[i].getOrderLineId().equals(id))
				{
					orderLineList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(orderLineList);
	}
	
	public void updateOrderLine(OrderLine ol)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]!=null)
			{
				if(orderLineList[i].getOrderLineId().equals(ol.getOrderLineId()))
				{
					orderLineList[i]=ol;
					break;
				}
			}
			
		}
		
		this.write(orderLineList);
	}
	
	public OrderLine searchOrderLineByOrderLineId(String id)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]!=null)
			{
				if(orderLineList[i].getOrderLineId().equals(id))
				{
					return orderLineList[i];
				}
			}
			
		}

		return null;
	}
	
	public OrderLine[] searchOrderLineByOrderId(String id)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		OrderLine[] foundOrderLine=new OrderLine[100];
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]!=null)
			{
				if(orderLineList[i].getOrderId().equals(id))
				{
					foundOrderLine[i]=orderLineList[i];
				}
			}
			
		}

		return foundOrderLine;
	}

	public OrderLine[] searchOrderLineByFoodId(String id)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		OrderLine[] foundOrderLine=new OrderLine[100];
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]!=null)
			{
				if(orderLineList[i].getFoodId().equals(id))
				{
					foundOrderLine[i]=orderLineList[i];
				}
			}
			
		}

		return foundOrderLine;
	}

	
	public OrderLine[] getAllOrderLine()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/orderLine.txt");
		
		
		OrderLine rl=new OrderLine();
		OrderLine[] orderLineList=new OrderLine[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				orderLineList[i]=rl.fromStringToOrderLine(str);
				
			}
			
			i++;
		}
		
		return orderLineList;
	}
	
	public void write(OrderLine[] orderLineList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(orderLineList[i]!=null)
			{
				data[i]=orderLineList [i].toStringFromOrderLine();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/orderLine.txt");
	}
}