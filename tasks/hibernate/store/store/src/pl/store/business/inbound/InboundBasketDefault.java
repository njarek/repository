package pl.store.business.inbound;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import pl.store.domain.Basket;
import pl.store.domain.BasketVisitor;
import pl.store.domain.LifeCycleEnum;
import pl.store.domain.LifeCycleState;
import pl.store.persistance.PersistaceException;
import pl.store.persistance.Interface.BasketDao;
import pl.store.persistance.Interface.LifecycleDao;

public class InboundBasketDefault implements InboundBasket {

	@Inject
	private BasketDao basketDao;

	@Inject
	private LifecycleDao lifecycleDao;

	@Override
	public Basket findBasket(int id) {
		return basketDao.getBasketById(id);
	}

	@Override
	@Transactional
	public Basket addNewBasket(Basket basket) {
		new BasketVisitor().VisitBaksket(basket);
		Basket newBasket = null;
		try {
			newBasket = basketDao.saveBasket(basket);
			lifecycleDao.saveNewLifecycle(newBasket);
		} catch (PersistaceException e) {
			e.printStackTrace();
		}
		return newBasket;
	}

	@Override
	@Transactional
	public Basket updateBasket(Basket basket) {
		new BasketVisitor().VisitBaksket(basket);
		Basket newBasket = null;
		try {

			LifeCycleState lifeCycleState = lifecycleDao.getLifecycleByBasketId(basket.getId());
			if (!lifeCycleState.getLifecycle().equals("modified")) {
				throw new PersistaceException("You have to block basket for update first");
			}
			lifeCycleState.setLifecycleEnum(LifeCycleEnum.NEW);
			lifecycleDao.updateLifecycle(lifeCycleState);
			newBasket = basketDao.updateBasket(basket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newBasket;
	}

	@Override
	@Transactional
	public Basket blockBasketForUpdate(int id) {
		LifeCycleState lifeCycleState = lifecycleDao.getLifecycleByBasketId(id);
		lifeCycleState.setLifecycleEnum(LifeCycleEnum.MODIFIED);
		Basket basket = basketDao.getBasketById(id);
		lifeCycleState.setBasket(basket);
		lifecycleDao.updateLifecycle(lifeCycleState);
		return basket;
	}
}
