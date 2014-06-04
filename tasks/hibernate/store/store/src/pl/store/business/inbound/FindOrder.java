package pl.store.business.inbound;

import pl.store.domain.Basket;

public interface FindOrder {

	Basket findBasket(Basket basket);
}
