package interfaces;
import java.lang.*;
import entities.*;

public interface IOrderRepo
{
	void addOrder(Order od);
	void removeOrder( String id);
	void updateOrder(Order od);
	
	Order searchOrderByOrderId( String id);
	Order[] searchOrderByUserId( String id);
	Order [] getAllOrder();
}
