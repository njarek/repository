package pl.store.persistance;

import pl.store.domain.Basket;

public interface NewOrderDao {

	Basket saveBasket(Basket basket);

	
}