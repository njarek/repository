package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.PersistaceException;


public interface ProcessNewOrder {

	Basket addNewBasket(Basket basket) throws PersistaceException;
	
}
