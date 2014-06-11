package pl.store.persistance;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleState;
import pl.store.domain.LifeCycleEnum;
import pl.store.persistance.Interface.UpdateBasketDao;

public class DefoultUpdateExistingBasketDao implements UpdateBasketDao {

	private SessionFactory factory;

	private LifeCycleState lifeCycleState = new LifeCycleState();;

	@Override
	public Basket updateBasket(Basket newBasket) throws Exception {
		Session hibernateSession = getFactory().openSession();
		Transaction tx = null;
		try {
			tx = hibernateSession.beginTransaction();

			lifeCycleState = getLifeCycleByBasketId(hibernateSession, newBasket);
			if(!lifeCycleState.getLifecycle().equals("modified")){
				throw new PersistaceException("You have to block basket for update first"); 
			}
			
			lifeCycleState.setLifecycleEnum(LifeCycleEnum.NEW);
			hibernateSession.merge(newBasket);
			hibernateSession.merge(lifeCycleState);
			tx.commit();
			return newBasket;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new PersistaceException("Object has bean already modified by someone else", e); 
		} finally {
			hibernateSession.close();

		}
		
	}

	@Override
	public Basket getBasketById(int id) {
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
	public Basket blockBasketWhileUpdating(int id) {

		Basket basket = null;
		Session hibernateSession = factory.openSession();
		Transaction tx = null;
		try {
			tx = hibernateSession.beginTransaction();

			basket = (Basket) hibernateSession.get(Basket.class, id);

			lifeCycleState = getLifeCycleByBasketId(hibernateSession, basket);
			lifeCycleState.setLifecycleEnum(LifeCycleEnum.MODIFIED);
			System.out.println(lifeCycleState);
			// lifeCycle.setBasket(basket);
			hibernateSession.merge(lifeCycleState);

			System.out.println(basket);
			tx.commit();
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

	private LifeCycleState getLifeCycleByBasketId(Session hibernateSession,
			Basket basket) {
		Criteria criteria = hibernateSession.createCriteria(LifeCycleState.class)
				.add(Restrictions.eq("basket.id", basket.getId()));

		return lifeCycleState = (LifeCycleState) criteria.uniqueResult();
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public LifeCycleState getLifeCycleState() {
		return lifeCycleState;
	}

	public void setLifeCycleState(LifeCycleState lifeCycle) {
		this.lifeCycleState = lifeCycle;
	}
}
