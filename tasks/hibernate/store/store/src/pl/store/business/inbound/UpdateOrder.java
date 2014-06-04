package pl.store.business.inbound;

import pl.store.domain.Basket;

public interface UpdateOrder {
	
	Basket updateBasket(Basket basket) throws Exception;

	Basket blockBasketForUpdate(Basket basket);
}
