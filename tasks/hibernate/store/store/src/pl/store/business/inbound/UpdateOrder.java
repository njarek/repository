package pl.store.business.inbound;

public interface UpdateOrder {
	
	String updateBasket(String basket);

	String findBasketById(String basket);
}
