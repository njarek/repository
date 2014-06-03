package pl.store.persistance;

import pl.store.domain.Basket;

public interface OrderDao {

	Basket saveBasket(Basket basket);

	Basket updateBasket(Basket basket) throws Exception;

	Basket getBasketById(int id);
}
