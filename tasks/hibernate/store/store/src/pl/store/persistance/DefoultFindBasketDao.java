package pl.store.persistance;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;
import pl.store.persistance.Interface.FindBasketDao;

public class DefoultFindBasketDao implements FindBasketDao {

	private SessionFactory factory;

	@Override
	public Basket findBasketById(int id) {
		Session hibernateSession = null;
		Basket basket = null;
		Transaction tx = null;
		try {
			hibernateSession = getFactory().openSession();
			tx = hibernateSession.beginTransaction();
			basket = (Basket) hibernateSession.get(Basket.class, id);
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (hibernateSession != null && hibernateSession.isOpen()) {
				hibernateSession.close();
			}
		}
		return basket;
	}

	@Override
	public List<Basket> findBasketByLifecycle(LifeCycleEnum lifeCycle) {
		Session hibernateSession = null;
		List<Basket> baskets = null;
		Transaction tx = null;
		try {
			hibernateSession = getFactory().openSession();
			tx = hibernateSession.beginTransaction();

			Query query = hibernateSession
					.createQuery("select b from LifeCycleState as l inner join l.basket as b where l.lifecycle= :lifecycle");
			query.setParameter("lifecycle",lifeCycle.getLifecycle());
			baskets=query.list();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (hibernateSession != null && hibernateSession.isOpen()) {
				hibernateSession.close();
			}
		}
		return baskets;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
