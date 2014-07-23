package pl.store.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;
import pl.store.domain.LifeCycleState;
import pl.store.persistance.Interface.LifecycleDao;

public class LifecycleDaoDefault implements LifecycleDao {

	private SessionFactory factory;

	@Override
	public void updateLifecycle(List<Basket> baskets, boolean sendRequest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLifecycle(List<Basket> baskets, String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public LifeCycleState updateLifecycle(LifeCycleState lifeCycleState) {
		Session hibernateSession = factory.openSession();
		hibernateSession.merge(lifeCycleState);
		hibernateSession.flush();
		closeSession(hibernateSession);

		return lifeCycleState;
	}

	@Override
	public LifeCycleState getLifecycleByBasketId(int id) {
		Session hibernateSession = factory.openSession();
		Criteria criteria = hibernateSession.createCriteria(LifeCycleState.class).add(Restrictions.eq("basket.id", id));

		LifeCycleState lifeCycleState = (LifeCycleState) criteria.uniqueResult();
		closeSession(hibernateSession);
		return lifeCycleState;
	}

	@Override
	public void saveNewLifecycle(Basket basket) {
		Session hibernateSession = factory.openSession();
		LifeCycleState lifeCycleState = new LifeCycleState();
		lifeCycleState.setLifecycleEnum(LifeCycleEnum.NEW);
		lifeCycleState.setBasket(basket);
		hibernateSession.save(lifeCycleState);
		closeSession(hibernateSession);
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
