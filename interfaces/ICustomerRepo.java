package interfaces;
import java.lang.*;
import entities.*;

public interface ICustomerRepo
{
	void addCustomer( Customer c);
	void removeCustomer ( String id);
	void updateCustomer( Customer c);
	
	Customer searchCustomerByUserId( String id);
	Customer [] getAllCustomer();
}

	
	