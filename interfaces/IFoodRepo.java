package interfaces;
import java.lang.*;
import entities.*;

public interface IFoodRepo
{
	void addFood( Food f);
	void removeFood( String id);
	void updateFood( Food f);
	
	Food searchFoodByFoodId( String id);
	Food [] getAllFood();
}
