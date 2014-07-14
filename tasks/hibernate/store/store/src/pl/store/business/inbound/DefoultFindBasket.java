package pl.store.business.inbound;

import javax.inject.Inject;

import pl.store.domain.Basket;
import pl.store.persistance.DefoultFindBasketDao;
import pl.store.persistance.Interface.FindBasketDao;

public class DefoultFindBasket implements FindBasket {

	@Inject
	private FindBasketDao findOrderDao;

	@Override
	public Basket findBasket(int id) {
		return findOrderDao.findBasketById(id);
	}

}
