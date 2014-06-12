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
	public Basket updateBasket(Basket basket) {

		Basket newBasket = null;
		try {
			newBasket = orderDao.updateBasket(basket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newBasket;
	}

	@Override
	public Basket blockBasketForUpdate(Basket basket) {
		return orderDao.blockBasketWhileUpdating(basket.getId());
	}

}
