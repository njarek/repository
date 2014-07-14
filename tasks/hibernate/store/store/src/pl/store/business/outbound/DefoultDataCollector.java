package pl.store.business.outbound;

import java.util.List;

import javax.inject.Inject;

import pl.store.domain.OrderDrainer;
import pl.store.persistance.Interface.OrderFinderDao;

public class DefoultDataCollector implements DataCollector{

	@Inject
	private OrderFinderDao findOrdersDao;

	@Override
	public List<OrderDrainer> getOrders() {
		
		return getFindOrdersDao().getOrders();
	}

	public OrderFinderDao getFindOrdersDao() {
		return findOrdersDao;
	}

	public void setFindOrdersDao(OrderFinderDao findOrdersDao) {
		this.findOrdersDao = findOrdersDao;
	}
}
