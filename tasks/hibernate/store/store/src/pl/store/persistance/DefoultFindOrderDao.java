package pl.store.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.store.domain.Basket;

public class DefoultFindOrderDao implements FindOrderDao {

	private SessionFactory factory;
	
	@Override
	public Basket findBasketById(int id) {
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

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
