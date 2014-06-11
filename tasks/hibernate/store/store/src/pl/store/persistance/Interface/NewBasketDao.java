package pl.store.persistance.Interface;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleState;
import pl.store.persistance.PersistaceException;

public interface NewBasketDao {

	Basket saveBasket(Basket basket) throws PersistaceException;

	LifeCycleState getLifeCycleState();

	
}
