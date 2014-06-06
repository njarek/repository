package pl.store.persistance;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleState;

public interface NewOrderDao {

	Basket saveBasket(Basket basket) throws PersistaceException;

	LifeCycleState getLifeCycleState();

	
}
