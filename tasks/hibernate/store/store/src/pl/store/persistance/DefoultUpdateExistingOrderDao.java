package pl.store.persistance;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycle;
import pl.store.domain.LifeCycleEnum;

public class DefoultUpdateExistingOrderDao implements UpdateOrderDao {

	private SessionFactory factory;

	private LifeCycle lifeCycle = new LifeCycle();;

	@Override
	public Basket updateBasket(Basket newBasket) throws Exception {
		Session session = getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			long prevVersion = newBasket.getVersion();
			Basket basket = (Basket) session.get(Basket.class,
					newBasket.getId());

			session.merge(newBasket);
			tx.commit();
			return basket;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return newBasket;
	}

	@Override
	public Basket getBasketById(int id) {
		Session hibernateSession = null;
		Basket basket = null;
		try {
			hibernateSession = getFactory().openSession();
			basket = (Basket) hibernateSession.get(Basket.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (hibernateSession != null && hibernateSession.isOpen()) {
				hibernateSession.close();
			}
		}
		return basket;
	}

	@Override
	public Basket blockBasketWhileUpdating(int id) {
		Session hibernateSession = null;
		Basket basket = null;
		try {
			hibernateSession = getFactory().openSession();
			basket = (Basket) hibernateSession.get(Basket.class, id);

			System.out.println(basket);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (hibernateSession != null && hibernateSession.isOpen()) {
				hibernateSession.close();
			}
		}
		return basket;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(LifeCycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}
}
