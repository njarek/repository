package pl.store.persistance;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.store.domain.OrderDrainer;
import pl.store.persistance.Interface.OrderFinderDao;

public class DefoultOrderFinderDao implements OrderFinderDao{

	@Inject
	private SessionFactory factory;

	@Override
	public List<OrderDrainer> getOrders() {
		
		List<OrderDrainer> drainers = null;
		Session hibernateSession = factory.openSession();
		Transaction tx = null;
		try {
			tx = hibernateSession.beginTransaction();

			drainers= hibernateSession.createQuery(" SELECT NEW pl.store.domain.OrderDrainer(  i.description, count(i.quantity),i.price)  from LifeCycleState as l inner join l.basket as b  inner join b.items as i where l.lifecycle='new' group by  i.description,i.quantity,i.price  ").list();
			hibernateSession.createQuery("update  LifeCycleState set lifecycle='sent' where lifecycle='new'").executeUpdate();

			System.out.println(drainers.size());
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
		return drainers;		
	}
}
