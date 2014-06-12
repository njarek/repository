package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.PersistaceException;


public interface ProcessNewBasket {

	Basket addNewBasket(Basket basket) ;
	
}
