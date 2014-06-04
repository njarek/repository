package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.DefoultUpdateExistingOrderDao;
import pl.store.persistance.UpdateOrderDao;

public class DefoultUpdateOrder implements UpdateOrder {

	private UpdateOrderDao orderDao;

	public DefoultUpdateOrder() {
		orderDao = new DefoultUpdateExistingOrderDao();
	}

	@Override
	public Basket updateBasket(Basket basket) throws Exception {
		

		return orderDao.updateBasket(basket);
	}

	@Override
	public Basket blockBasketForUpdate(Basket basket) {
		return orderDao.blockBasketWhileUpdating(basket.getId());
	}

}
