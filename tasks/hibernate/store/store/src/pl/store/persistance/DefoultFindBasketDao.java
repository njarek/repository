package pl.store.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.store.domain.Basket;

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

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
