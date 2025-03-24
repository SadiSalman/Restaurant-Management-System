 package repositories;
 import java.lang.*;
 import entities.*;
 import interfaces.*;
 public class OwnerRepo implements IOwnerRepo
 {
	public void addOwner(Owner o)
	{
		Owner[] ownerList =this.getAllOwner();
		for(int i=0;i<ownerList.length;i++)
		{
			if(ownerList[i]==null)
			{
				ownerList[i]=o;
				break;
			}
		}
		this.write(ownerList);
	}
 
    public void removeOwner(String id)
    {
		Owner[] ownerList=this.getAllOwner();
		for(int i=0;i<ownerList.length;i++)
		{
			if(ownerList[i]!=null)
			{
				if(ownerList[i].getUserId().equals(id))
				{
					ownerList[i]=null;
					break;
				}
			}
			this.write(ownerList);
		}
	} 
  
	public void updateOwner(Owner o)
	{
		Owner[] ownerList=this.getAllOwner();
		for(int i=0;i<ownerList.length;i++)
		{
			if(ownerList[i]!=null)
			{
				if(ownerList[i].getUserId().equals(o.getUserId()))
				{
					ownerList[i]=o;
					break;
				}
			}
			this.write(ownerList);
		}
	}
	public Owner searchOwnerByUserId(String id)
	{
		Owner[] ownerList=this.getAllOwner();
		for(int i=0;i<ownerList.length;i++)
		{
			if(ownerList[i]!=null)
			{
				if(ownerList[i].getUserId().equals(id))
				{
					return ownerList[i];
				}
			}
		  
		}
		return null;
	}
	public Owner[] getAllOwner()
	{
		FileIO fio=new FileIO();
		String[] data =fio.readFile("repositories/data/owner.txt");
	  
		Owner o=new Owner();
		Owner[] ownerList =new Owner[100];
		int i=0;
		for(String str:data)
		{
			if(str!=null)
			{
				ownerList[i]=o.fromStringToOwner(str);
			}
			i++;
		}
		return ownerList;
	}
	public void write(Owner[] ownerList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(ownerList[i]!=null)
			{
				data[i]=ownerList[i].toStringFromOwner();
			}
			
		}
		
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/owner.txt");
	}
	  
  
 }
 