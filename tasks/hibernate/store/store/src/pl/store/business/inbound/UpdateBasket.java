package pl.store.business.inbound;

import pl.store.domain.Basket;

public interface UpdateBasket {
	
	Basket updateBasket(Basket basket) ;

	Basket blockBasketForUpdate(Basket basket);
}
