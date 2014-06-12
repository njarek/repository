package pl.store.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleState;
import pl.store.domain.LifeCycleEnum;
import pl.store.persistance.Interface.NewBasketDao;

public class DefoultNewBasketDao implements NewBasketDao {

	private SessionFactory factory;

	private LifeCycleState lifeCycleState = new LifeCycleState();

	@Override
	public Basket saveBasket(Basket basket) throws PersistaceException {
		Session hibernateSession = factory.openSession();
		Transaction tx = null;
		try {
			tx = hibernateSession.beginTransaction();
			lifeCycleState.setLifecycleEnum(LifeCycleEnum.NEW);
			lifeCycleState.setBasket(basket);
			hibernateSession.save(basket);
			hibernateSession.save(lifeCycleState);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new PersistaceException("Persitane problem", e); 
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

	public LifeCycleState getLifeCycleState() {
		return lifeCycleState;
	}

	public void setLifeCycleState(LifeCycleState lifeCycle) {
		this.lifeCycleState = lifeCycle;
	}

}
