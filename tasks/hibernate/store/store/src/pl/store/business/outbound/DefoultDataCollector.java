package pl.store.business.outbound;

import java.util.List;

import javax.inject.Inject;

import pl.store.domain.OrderDrainer;
import pl.store.persistance.OrderFinderDao;
import pl.supplier.domain.Order;

public class DefoultDataCollector implements DataCollector{

	@Inject
	private OrderFinderDao findOrdersDao;

	@Override
	public List<OrderDrainer> getOrders() {
		
		return findOrdersDao.getOrders();
	}
}
