package pl.store.persistance;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycle;

public interface UpdateOrderDao {
	Basket updateBasket(Basket basket) throws Exception;

	Basket getBasketById(int id);
	
	Basket blockBasketWhileUpdating(int id);

	LifeCycle getLifeCycle();
}
