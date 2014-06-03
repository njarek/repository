package pl.store.buissnes.inbound;

public interface UpdateOrder {
	
	String updateOrder(String basket);

	String requestForBasketUpdate(String id);
}
