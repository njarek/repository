package pl.store.persistance.Interface;

import java.util.List;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;

public interface FindBasketDao {

	Basket findBasketById(int id);
	
	List<Basket> findBasketByLifecycle(LifeCycleEnum lifeCycle);
}
