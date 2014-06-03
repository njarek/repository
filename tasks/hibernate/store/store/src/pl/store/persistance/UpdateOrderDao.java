package pl.store.persistance;

import pl.store.domain.Basket;

public interface UpdateOrderDao {
	Basket updateBasket(Basket basket) throws Exception;

	Basket getBasketById(int id);
}
