package pl.store.persistance;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;
import pl.store.persistance.Interface.BasketDao;

public class DefaultBasketDao implements BasketDao {
	private SessionFactory factory;

	@Override
	public Basket findBasketById(int id) {

		Basket basket = (Basket) factory.openSession().get(Basket.class, id);
		closeSession();

		return basket;
	}

	@Override
	public List<Basket> findBasketByLifecycle(LifeCycleEnum lifeCycle) {

		Session hibernateSession = getFactory().openSession();
		Query query = hibernateSession
				.createQuery("select b from LifeCycleState as l inner join l.basket as b where l.lifecycle= :lifecycle");
		query.setParameter("lifecycle", lifeCycle.getLifecycle());
		List<Basket> baskets = query.list();
		closeSession();
		return baskets;
	}

	@Override
	public Basket saveBasket(Basket basket) throws PersistaceException {
		Session hibernateSession = factory.openSession();

		hibernateSession.save(basket);
		closeSession();
		return basket;
	}

	@Override
	public Basket updateBasket(Basket newBasket) throws Exception {
		Session hibernateSession = getFactory().openSession();

		hibernateSession.merge(newBasket);
		closeSession();
		return newBasket;

	}

	@Override
	public Basket getBasketById(int id) {

		Session hibernateSession = getFactory().openSession();

		Basket basket = (Basket) hibernateSession.get(Basket.class, id);
		closeSession();
		return basket;
	}

	private void closeSession() {
		if (factory.getCurrentSession() != null && factory.getCurrentSession().isOpen()) {
			factory.getCurrentSession().close();
		}
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
