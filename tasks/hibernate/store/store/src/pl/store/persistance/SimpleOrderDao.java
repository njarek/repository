package pl.store.persistance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.store.domain.Basket;

public class SimpleOrderDao implements OrderDao{

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

	@Override
	public Basket updateBasket(Basket newBasket) throws Exception {
		Session session=factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			long prevVersion=newBasket.getVersion();
			Basket basket = (Basket) session.get(Basket.class, newBasket.getId());
			
			if ( prevVersion != basket.getVersion() ) throw new Exception();
			
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
			hibernateSession = factory.openSession();
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

}
