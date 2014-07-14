package pl.store.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;
import pl.store.domain.LifeCycleState;
import pl.store.persistance.Interface.LifecycleDao;

public class LifecycleDaoDefoult implements LifecycleDao {

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
		factory.openSession().merge(lifeCycleState);
		closeSession();

		return lifeCycleState;
	}

	public LifeCycleState getLifecycleByBasketId(int id) {
		Criteria criteria = factory.openSession().createCriteria(LifeCycleState.class).add(Restrictions.eq("basket.id", id));

		LifeCycleState lifeCycleState = (LifeCycleState) criteria.uniqueResult();
		closeSession();
		return lifeCycleState;
	}

	@Override
	public void saveNewLifecycle(Basket basket) {
		LifeCycleState lifeCycleState = new LifeCycleState();
		lifeCycleState.setLifecycleEnum(LifeCycleEnum.NEW);
		lifeCycleState.setBasket(basket);
		factory.openSession().save(lifeCycleState);
		closeSession();
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
