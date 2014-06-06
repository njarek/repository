package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.NewOrderDao;
import pl.store.persistance.DefoultNewOrderDao;
import pl.store.persistance.PersistaceException;

public class DefoultNewOrderProcesor implements ProcessNewOrder {
	NewOrderDao orderDao;

	public DefoultNewOrderProcesor() {
		orderDao = new DefoultNewOrderDao();
	}

	@Override
	public Basket addNewBasket(Basket basket) throws PersistaceException {
		return orderDao.saveBasket(basket);
	}

}
