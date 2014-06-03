package pl.store.buissnes;

import pl.store.domain.Basket;

public interface OrderSupporter {

	String addNewOrder(String basket);
	
	String updateOrder(String basket);
	
	String requestForBasketUpdate(String id);
}
