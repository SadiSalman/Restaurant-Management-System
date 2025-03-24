package interfaces;
import java.lang.*;
import entities.*;

public interface IOwnerRepo
{
	void addOwner(Owner o);
	void removeOwner( String id);
	void updateOwner( Owner o);
	
	Owner searchOwnerByUserId(String id);
	Owner[] getAllOwner();
}
	