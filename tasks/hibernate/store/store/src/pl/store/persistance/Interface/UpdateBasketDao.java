package pl.store.persistance.Interface;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleState;

public interface UpdateBasketDao {
	Basket updateBasket(Basket basket) throws Exception;

	Basket getBasketById(int id);
	
	Basket blockBasketWhileUpdating(int id);

	LifeCycleState getLifeCycleState();
}
