package pl.store.persistance;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycle;

public interface NewOrderDao {

	Basket saveBasket(Basket basket);

	LifeCycle getLifeCycle();

	
}
