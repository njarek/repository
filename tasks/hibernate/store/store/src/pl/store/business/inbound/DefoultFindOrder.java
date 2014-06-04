package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.persistance.DefoultFindOrderDao;
import pl.store.persistance.FindOrderDao;

public class DefoultFindOrder implements FindOrder {

	private FindOrderDao findOrderDao;

	public DefoultFindOrder() {
		findOrderDao = new DefoultFindOrderDao();
	}

	@Override
	public Basket findBasket(Basket basket) {
		return findOrderDao.findBasketById(basket.getId());
	}

}
