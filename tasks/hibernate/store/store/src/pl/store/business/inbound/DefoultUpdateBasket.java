package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.DefoultUpdateExistingBasketDao;
import pl.store.persistance.Interface.UpdateBasketDao;

public class DefoultUpdateBasket implements UpdateBasket {

	private UpdateBasketDao orderDao;

	public DefoultUpdateBasket() {
		orderDao = new DefoultUpdateExistingBasketDao();
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
