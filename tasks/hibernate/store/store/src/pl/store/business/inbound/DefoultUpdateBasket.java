package pl.store.business.inbound;

import javax.inject.Inject;

import pl.store.domain.Basket;
import pl.store.domain.BasketVisitor;
import pl.store.persistance.DefoultUpdateExistingBasketDao;
import pl.store.persistance.Interface.UpdateBasketDao;

public class DefoultUpdateBasket implements UpdateBasket {

	@Inject
	private UpdateBasketDao orderDao;

	public DefoultUpdateBasket() {
		orderDao = new DefoultUpdateExistingBasketDao();
	}

	@Override
	public Basket updateBasket(Basket basket) {
		new BasketVisitor().VisitBaksket(basket);
		Basket newBasket = null;
		try {
			newBasket = orderDao.updateBasket(basket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newBasket;
	}

	@Override
	public Basket blockBasketForUpdate(int id) {
		return orderDao.blockBasketWhileUpdating(id);
	}

}
