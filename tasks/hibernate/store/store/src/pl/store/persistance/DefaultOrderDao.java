package pl.store.persistance;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pl.store.domain.OrderDrainer;
import pl.store.persistance.Interface.OrderDao;

public class DefaultOrderDao implements OrderDao {

	@Inject
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<OrderDrainer> getOrders() {

		List<OrderDrainer> drainers = null;
		Session hibernateSession = factory.openSession();

		drainers = hibernateSession
				.createQuery(
						" SELECT NEW pl.store.domain.OrderDrainer(  i.description, count(i.quantity),i.price)  from LifeCycleState as l inner join l.basket as b  inner join b.items as i where l.lifecycle='new' group by  i.description,i.quantity,i.price  ")
				.list();
		hibernateSession.createQuery("update  LifeCycleState set lifecycle='sent' where lifecycle='new'").executeUpdate();
		System.out.println(drainers.size());

		if (hibernateSession != null && hibernateSession.isOpen()) {
			hibernateSession.close();
		}

		return drainers;
	}
}
