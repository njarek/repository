package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.DefoultFindBasketDao;
import pl.store.persistance.Interface.FindBasketDao;

public class DefoultFindBasket implements FindBasket {

	private FindBasketDao findOrderDao;

	public DefoultFindBasket() {
		findOrderDao = new DefoultFindBasketDao();
	}

	@Override
	public Basket findBasket(Basket basket) {
		return findOrderDao.findBasketById(basket.getId());
	}

}
