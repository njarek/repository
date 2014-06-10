package pl.store.persistance;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.store.domain.OrderDrainer;

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

			drainers= hibernateSession.createQuery(" SELECT NEW pl.store.domain.OrderDrainer( i.i_description, sum(i.i_iquantity),i._i.price) from item i, basket b, lifecycle l where i.b_id=b.b_id and b.b_id=l.b_id and l.l_lifecycle='new' group by  i_description,I_price  order by i_description").list();
			System.out.println(drainers);
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

	
	public static void main(String[] args) {
		
	}
}
