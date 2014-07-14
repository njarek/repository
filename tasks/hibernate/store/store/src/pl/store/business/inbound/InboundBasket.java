package pl.store.business.inbound;

import pl.store.domain.Basket;

public interface InboundBasket {
	Basket findBasket(int id);

	Basket addNewBasket(Basket basket);

	Basket updateBasket(Basket basket);

	Basket blockBasketForUpdate(int id);
}
