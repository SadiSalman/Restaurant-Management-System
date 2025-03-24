package entities;
import java.lang.*;
public class OrderLine 
 {
	 private String orderLineId;
	 private String orderId;
	 private String  foodId;
	 private double quantity;
	 private double amount;
	 
	 public OrderLine()
	 {
	 }
	 
	 public OrderLine(String orderLineId,String orderId,String foodId,double quantity,double amount)
	 {
		this.orderLineId=orderLineId;
		this.orderId=orderId;
		this.foodId=foodId;
		this.quantity=quantity;
		this.amount=amount;
		
	 }
	 public void setOrderLineId(String orderLineId)
	{
		this.orderLineId=orderLineId;
	}
	public String getOrderLineId()
	{
		return this.orderLineId;
	}
	public void setOrderId(String orderId)
	{
		this.orderId=orderId;
	}
	public String getOrderId()
	{
		return this.orderId;
	}
	public void setFoodId(String foodId)
	{
		this.foodId=foodId;
	}
	public String getFoodId()
	{
		return this.foodId;
	}
	public void setQuantity(double quantity)
	{
		this.quantity=quantity;
	}
	public double getQuantity()
	{
		return this.quantity;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public double getAmount()
	{
		return this.amount;
	}
	
	public String toStringFromOrderLine()
	{
		String str=this.orderLineId+","+this.orderId+","+this.foodId+","+this.quantity+","+this.amount+"\n";
		return str;
	}
	
	public OrderLine fromStringToOrderLine(String str)
	{
		String[] info=str.split(",");
		
		OrderLine o=new OrderLine();
		o.setOrderLineId(info[0]);
		o.setOrderId(info[1]);
		o.setFoodId(info[2]);
		o.setQuantity(Double.parseDouble(info[3]));
		o.setAmount(Double.parseDouble(info[4]));
		
		return o;
	}
}