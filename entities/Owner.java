package entities;
import java.lang.*;
public class Owner extends User
{
	private double companySharePercentage;
	public Owner()
	{
		super();
	}
	public Owner(String userId,String name,String gender,int age,String email,String phoneNo,String address,int role,String securityAns,String password,double companySharePercentage)
	{
		super(userId,name,gender,age,email,phoneNo,address,role,securityAns,password);
		this.companySharePercentage=companySharePercentage;
	}
	public void setCompanySharePercentage(double companySharePercentage)
	{
		this.companySharePercentage=companySharePercentage;
	}
	public double getCompanySharePercentage()
	{
		return this.companySharePercentage;
	} 
	
	public String toStringFromOwner()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.role+","+this.securityAns+","+this.password+","+this.companySharePercentage+"\n";
		return str;
	}
	public Owner fromStringToOwner(String str)
	{
		String [] info=str.split(","); 
		Owner o =new Owner();
		o.setUserId(info[0]);
		o.setName(info[1]);
		o.setGender(info[2]);
		o.setAge(Integer.parseInt(info[3]));
		o.setEmail(info[4]);
		o.setPhoneNo(info[5]);
		o.setAddress(info[6]);
		o.setRole(Integer.parseInt(info[7]));
		o.setSecurityAns(info[8]);
		o.setPassword(info[9]);
		o.setCompanySharePercentage(Double.parseDouble(info[10]));
		return o;		
		
	}
}