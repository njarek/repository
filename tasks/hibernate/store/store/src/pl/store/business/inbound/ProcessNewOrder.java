package pl.store.business.inbound;

import pl.store.domain.Basket;


public interface ProcessNewOrder {

	Basket addNewBasket(Basket basket);
	
}
