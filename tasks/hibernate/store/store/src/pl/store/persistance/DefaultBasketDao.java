package pl.store.persistance;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;
import pl.store.persistance.Interface.BasketDao;

public class DefaultBasketDao implements BasketDao {
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Basket> findBasketByLifecycle(LifeCycleEnum lifeCycle) {

		Session hibernateSession = getFactory().openSession();
		Query query = hibernateSession
				.createQuery("select b from LifeCycleState as l inner join l.basket as b where l.lifecycle= :lifecycle");
		query.setParameter("lifecycle", lifeCycle.getLifecycle());
		List<Basket> baskets = query.list();
		closeSession(hibernateSession);
		return baskets;
	}

	@Override
	public Basket saveBasket(Basket basket) throws PersistaceException {
		Session hibernateSession = factory.openSession();

		hibernateSession.save(basket);
		closeSession(hibernateSession);
		return basket;
	}

	@Override
	public Basket updateBasket(Basket newBasket) throws Exception {
		Session hibernateSession = getFactory().openSession();

		hibernateSession.merge(newBasket);
		hibernateSession.flush();
		closeSession(hibernateSession);
		return newBasket;

	}

	@Override
	public Basket getBasketById(int id) {

		Session hibernateSession = getFactory().openSession();

		Basket basket = (Basket) hibernateSession.get(Basket.class, id);
		closeSession(hibernateSession);
		return basket;
	}

	private void closeSession(Session hibernateSession) {
		if (hibernateSession != null && hibernateSession.isOpen()) {
			hibernateSession.close();
		}
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
