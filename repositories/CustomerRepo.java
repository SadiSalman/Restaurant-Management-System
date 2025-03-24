 package repositories;
 import java.lang.*;
 import entities.*;
 import interfaces.*;
 public class CustomerRepo implements ICustomerRepo
 {
	public void addCustomer(Customer c)
	 {
		 Customer[] customerList =this.getAllCustomer();
		 for(int i=0;i<customerList.length;i++)
		 {
			 if(customerList[i]==null)
			 {
				 customerList[i]=c;
				 break;
			 }
		 }
		 this.write(customerList);
	 }
 
  public void removeCustomer(String id)
  {
	  Customer[] customerList=this.getAllCustomer();
	  for(int i=0;i<customerList.length;i++)
	  {
		  if(customerList[i]!=null)
		  {
			  if(customerList[i].getUserId().equals(id))
			  {
				  customerList[i]=null;
				  break;
			  }
		  }
		  this.write(customerList);
	  }
  } 
  
  public void updateCustomer(Customer c)
  {
	  Customer[] customerList=this.getAllCustomer();
	  for(int i=0;i<customerList.length;i++)
	  {
		  if(customerList[i]!=null)
		  {
			  if(customerList[i].getUserId().equals(c.getUserId()))
			  {
				  customerList[i]=c;
				  break;
			  }
		  }
		  this.write(customerList);
	  }
  }
  public Customer searchCustomerByUserId(String id)
  {
	  Customer[] customerList=this.getAllCustomer();
	  for(int i=0;i<customerList.length;i++)
	  {
		  if(customerList[i]!=null)
		  {
			  if(customerList[i].getUserId().equals(id))
			  {
				  return customerList[i];
			  }
		  }
		  
	  }
	  return null;
  }
  public Customer[] getAllCustomer()
  {
	  FileIO fio=new FileIO();
	  String[] data =fio.readFile("repositories/data/customer.txt");
	  
	  Customer c=new Customer();
	  Customer[] customerList =new Customer[100];
	  int i=0;
	  for(String str:data)
	  {
		  if(str!=null)
		  {
			  customerList[i]=c.fromStringToCustomer(str);
		  }
		  i++;
	  }
	  return customerList;
   }
   
   public void write(Customer[] customerList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(customerList[i]!=null)
			{
				data[i]=customerList[i].toStringFromCustomer();
			}
			
		}
		
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/customer.txt");
	}
  
 }