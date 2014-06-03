package pl.store.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.store.domain.Basket;

public class SimpleNewOrderDao implements NewOrderDao{

	private SessionFactory factory;
	@Override
	public Basket saveBasket(Basket basket) {
		Session hibernateSession = null;		
		try {
			hibernateSession = factory.openSession();	
			basket = (Basket) hibernateSession.save(Basket.class);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (hibernateSession != null && hibernateSession.isOpen()) {
				hibernateSession.close();
			}
		}
		return basket;
	}

	

}
