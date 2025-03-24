package entities;

import java.lang.*;
public class Customer extends User
{
	private double discountPercentage;
	private String membershipType;
	
	public Customer()
	{
		super();
	}
	public Customer(String userId,String name,String gender,int age, String email,String phoneNo,String address,int role,String securityAns,String password,double discountPercentage,String membershipType)
	{
		super ( userId, name, gender, age, email, phoneNo,address, role, securityAns, password);
		this.discountPercentage = discountPercentage;
        this.membershipType = membershipType;
        
    }
	public void setDiscountPercentage(double  discountPercentage)
	{
		this.discountPercentage=discountPercentage;
	}
	
	public double getDiscountPercentage()
	{
		return this.discountPercentage;
	}
	
	public void setMembershipType(String membershipType)
	{
		this.membershipType=membershipType;
	}
	
	public String getMembershipType()
	{
		return this.membershipType;
	}
	
	
	public String toStringFromCustomer ()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.role+","+this.securityAns+","+this.password+","+this.discountPercentage+","+this.membershipType+"\n";
		return str;
	}
	
	public Customer fromStringToCustomer(String str)
	{
		String[] info=str.split(",");
		Customer c=new Customer();
		c.setUserId(info[0]);
		c.setName(info[1]);
		c.setGender(info[2]);
		c.setAge(Integer.parseInt(info[3]));
		c.setEmail(info[4]);
		c.setPhoneNo(info[5]);
		c.setAddress(info[6]);
		c.setRole(Integer.parseInt(info[7]));
		c.setSecurityAns(info[8]);
		c.setPassword(info[9]);
		c.setDiscountPercentage(Double.parseDouble(info[10]));
		c.setMembershipType(info[11]);
		
		return c;
	}
	
	
}