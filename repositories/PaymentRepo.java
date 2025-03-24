package repositories;
import java.lang.*;
import interfaces.*;
import entities.*;

public class PaymentRepo implements IPaymentRepo
{
	 public void addPayment(Payment p)
	{
		Payment[] paymentList=this.getAllPayment();
		
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]==null)
			{
				paymentList[i]=p;
				break;
			}
		}
		
		this.write(paymentList);
	}
	
	public void removePayment(String id)
	{
		Payment[] paymentList=this.getAllPayment();
		
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				if(paymentList[i].getPaymentId().equals(id))
				{
					paymentList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(paymentList);
	}
	
	public void updatePayment(Payment p)
	{
		Payment[] paymentList=this.getAllPayment();
		
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				if(paymentList[i].getPaymentId().equals(p.getPaymentId()))
				{
					paymentList[i]=p;
					break;
				}
			}
			
		}
		
		this.write(paymentList);
	}
	
	public Payment searchPaymentByPaymentId(String id)
	{
		Payment[] paymentList=this.getAllPayment();
		
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				if(paymentList[i].getPaymentId().equals(id))
				{
					return paymentList[i];
				}
			}
			
		}

		return null;
	}
	
	public Payment[] searchPaymentByOrderId(String id)
	{
		Payment[] paymentList=this.getAllPayment();
		Payment[] foundPayment=new Payment[100];
		
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				if(paymentList[i].getOrderId().equals(id))
				{
					foundPayment[i]=paymentList[i];
				}
			}
			
		}

		return foundPayment;
	}
	
	public Payment[] searchPaymentByUserId(String id)
	{
		Payment[] paymentList=this.getAllPayment();
		Payment[] foundPayment=new Payment[100];
		
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				if(paymentList[i].getUserId().equals(id))
				{
					foundPayment[i]=paymentList[i];
				}
			}
			
		}

		return foundPayment;
	}
	
	public Payment[] getAllPayment()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/payment.txt");
		
		
		Payment rl=new Payment();
		Payment[] paymentList=new Payment[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				paymentList[i]=rl.fromStringToPayment(str);
				
			}
			
			i++;
		}
		
		return paymentList;
	}
	
	public void write(Payment[] paymentList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(paymentList[i]!=null)
			{
				data[i]=paymentList[i].toStringFromPayment();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/payment.txt");
	}
}
