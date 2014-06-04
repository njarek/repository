package pl.store.persistance;

import pl.store.domain.Basket;

public interface FindOrderDao {

	Basket findBasketById(int id);
}
