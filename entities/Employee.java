package entities;
import java.lang.*;
public class Employee extends User
{
	private String designation;
	private double salary;
	
	public Employee()
	{
		super();
	}
	public Employee(String userId,String name,String gender,int age,String email,String phoneNo,String address,int role,String securityAns,String password,String designation,double salary)
	{
		super(userId,name,gender,age,email,phoneNo,address,role,securityAns,password);
		this.designation=designation;
		this.salary=salary;
	}
	public void setDesignation(String designation)
	{
		this.designation=designation;
	}
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	public String getDesignation()
	{
		return this.designation;
	}
	public double getSalary()
	{
		return this.salary;
	}
	
	public String toStringFromEmployee()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.role+","+this.securityAns+","+this.password+","+this.designation+","+this.salary+"\n";
		return str;
	}
	public Employee fromStringToEmployee(String str)
	{
		String [] info=str.split(",");
		Employee emp=new Employee();
		emp.setUserId(info[0]);
		emp.setName(info[1]);
		emp.setGender(info[2]);
		emp.setAge(Integer.parseInt(info[3]));
		emp.setEmail(info[4]);
		emp.setPhoneNo(info[5]);
		emp.setAddress(info[6]);
		emp.setRole(Integer.parseInt(info[7]));
		emp.setSecurityAns(info[8]);
		emp.setPassword(info[9]);
		emp.setDesignation(info[10]);
		emp.setSalary(Double.parseDouble(info[11]));
		return emp;
	}
}