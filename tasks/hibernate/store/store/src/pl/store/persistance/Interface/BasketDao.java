package pl.store.persistance.Interface;

import java.util.List;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;
import pl.store.persistance.PersistaceException;

public interface BasketDao {

	Basket findBasketById(int id);
	
	List<Basket> findBasketByLifecycle(LifeCycleEnum lifeCycle);
	
	Basket saveBasket(Basket basket) throws PersistaceException;
	
	Basket updateBasket(Basket basket) throws Exception;

	Basket getBasketById(int id);
	

}
