package interfaces;
import java.lang.*;
import entities.*;

public interface IOrderLineRepo
{
	void addOrderLine(OrderLine ol);
	void removeOrderLine(String id);
	void updateOrderLine(OrderLine ol);
	 
	OrderLine searchOrderLineByOrderLineId(String id);
	OrderLine[] searchOrderLineByOrderId(String id);
	OrderLine[] searchOrderLineByFoodId(String id);
	OrderLine[] getAllOrderLine();
}