package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.domain.BasketVisitor;
import pl.store.persistance.NewOrderDao;
import pl.store.persistance.PersistaceException;

public class DefoultNewOrderProcesor implements ProcessNewOrder {
	private NewOrderDao newOrderDao;
	
	@Override
	public Basket addNewBasket(Basket basket) throws PersistaceException {
		new BasketVisitor().VisitBaksket(basket);	
		return newOrderDao.saveBasket(basket);
	}

	public NewOrderDao getNewOrderDao() {
		return newOrderDao;
	}

	public void setNewOrderDao(NewOrderDao newOrderDao) {
		this.newOrderDao = newOrderDao;
	}

	

}
