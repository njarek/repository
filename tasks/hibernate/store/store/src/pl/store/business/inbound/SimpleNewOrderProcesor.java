package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.NewOrderDao;
import pl.store.persistance.SimpleNewOrderDao;

public class SimpleNewOrderProcesor implements ProcessNewOrder {
	NewOrderDao orderDao;
	
	 public SimpleNewOrderProcesor() {
		orderDao = new SimpleNewOrderDao();
	}
	
	@Override
	public Basket addNewBasket(Basket basket) {
		return orderDao.saveBasket(basket);
	}

}
