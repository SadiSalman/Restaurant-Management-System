package entities;
import java.lang.*;
public class Order 
 {
	 private String orderId;
	 private String userId;
	 private double totalAmount;
	 private double paidAmount;
	 private double dueAmount;
	 private String orderStatus;
	 private String paymentStatus;
	 private String orderDate;
	 
	 public Order()
	 {
	 }
	 
	 public Order(String orderId,String userId,double totalAmount,double paidAmount,double dueAmount,String orderStatus,String paymentStatus,String orderDate)
	 {
		this.orderId=orderId;
		this.userId=userId;
		this.totalAmount=totalAmount;
		this.paidAmount=paidAmount;
		this.dueAmount=dueAmount;
		this.orderStatus=orderStatus;
		this.paymentStatus=paymentStatus;
		this.orderDate=orderDate;
		
	 }
	 public void setOrderId(String orderId)
	{
		this.orderId=orderId;
	}
	public String getOrderId()
	{
		return this.orderId;
	}
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	public String getUserId()
	{
		return this.userId;
	}
	public void setTotalAmount(double totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	public double getTotalAmount()
	{
		return this.totalAmount;
	}
	public void setPaidAmount(double paidAmount)
	{
		this.paidAmount=paidAmount;
	}
	public double getPaidAmount()
	{
		return this.paidAmount;
	}
	public void setDueAmount(double dueAmount)
	{
		this.dueAmount=dueAmount;
	}
	public double getDueAmount()
	{
		return this.dueAmount;
	}
	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus=orderStatus;
	}
	public String getOrderStatus()
	{
		return this.orderStatus;
	}
	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus=paymentStatus;
	}
	public String getPaymentStatus()
	{
		return this.paymentStatus;
	}
	public void setOrderDate(String orderDate)
	{
		this.orderDate=orderDate;
	}
	public String getOrderDate()
	{
		return this.orderDate;
	}
	
	public String toStringFromOrder()
	{
		String str=this.orderId+","+this.userId+","+this.totalAmount+","+this.paidAmount+","+this.dueAmount+","+this.orderStatus+","+this.paymentStatus+","+this.orderDate+"\n";
		return str;
	}
	
	public Order fromStringToOrder(String str)
	{
		String[] info=str.split(",");
		
		Order o=new Order();
		o.setOrderId(info[0]);
		o.setUserId(info[1]);
		o.setTotalAmount(Double.parseDouble(info[2]));
		o.setPaidAmount(Double.parseDouble(info[3]));
		o.setDueAmount(Double.parseDouble(info[4]));
		o.setOrderStatus(info[5]);
		o.setPaymentStatus(info[6]);
		o.setOrderDate(info[7]);
		
		return o;
		
	}
}