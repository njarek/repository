package pl.store.persistance;

import pl.store.domain.Basket;

public interface FindBasketDao {

	Basket findBasketById(int id);
}
