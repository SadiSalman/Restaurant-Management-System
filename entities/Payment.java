package entities;
import java.lang.*;
public class Payment
{
	private String paymentId; 
	private String orderId; 
	private String userId;
	private double amount;
	private String paymentDate;
	
	
	public Payment()
	{
	}
	
	public Payment(String  paymentId, String  orderId, String  userId, double amount, String  paymentDate)
	{
		this.paymentId=paymentId;
		this.orderId=orderId;
		this.userId=userId;
		this.amount=amount;
		this.paymentDate=paymentDate;
	
	}
	
	public void setPaymentId(String  paymentId)
	{
		this.paymentId=paymentId;
	}
	public String getPaymentId()
	{
		return this.paymentId;
	}
	
	public void setOrderId(String  orderId)
	{
		this.orderId=orderId;
	}
	
	public String  getOrderId()
	{
		return this.orderId;
	}
	public void setUserId(String  userId)
	{
		this.userId=userId;
	}
	public String  getUserId()
	{
		return this.userId;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public double  getAmount()
	{
		return this.amount;
	}
	public void setPaymentDate(String  paymentDate)
	{
		this.paymentDate=paymentDate;
	}
	public String getPaymentDate()
	{
		return this.paymentDate;
		
	}
	
	
	public String toStringFromPayment()
	{
		String str=this.paymentId+","+this.orderId+","+this.userId+","+this.amount+","+this.paymentDate+"\n";
		return str;
	}
	
	public Payment fromStringToPayment(String str)
	{
		String[] info=str.split(",");
		
		Payment p=new Payment();
		p.setPaymentId(info[0]);
		p.setOrderId(info[1]);
		p.setUserId(info[2]);
		p.setAmount(Double.parseDouble(info[3]));
		p.setPaymentDate(info[4]);
		
		return p;
		
	}
}