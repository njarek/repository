package pl.store.business.inbound;

import javax.inject.Inject;

import pl.store.domain.Basket;
import pl.store.domain.BasketVisitor;
import pl.store.persistance.PersistaceException;
import pl.store.persistance.Interface.NewBasketDao;

public class DefoultNewBasketProcesor implements ProcessNewBasket {
	
	@Inject
	private NewBasketDao newOrderDao;
	
	@Override
	public Basket addNewBasket(Basket basket)  {
		new BasketVisitor().VisitBaksket(basket);	
		Basket newBasket=null;
		try {
			newBasket = newOrderDao.saveBasket(basket);
		} catch (PersistaceException e) {
			e.printStackTrace();
		}
		return newBasket;
	}

	public NewBasketDao getNewOrderDao() {
		return newOrderDao;
	}

	public void setNewOrderDao(NewBasketDao newOrderDao) {
		this.newOrderDao = newOrderDao;
	}

	

}
