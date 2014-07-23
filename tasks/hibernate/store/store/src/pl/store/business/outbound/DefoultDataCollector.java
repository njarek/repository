package pl.store.business.outbound;

import java.util.List;

import javax.inject.Inject;

import pl.store.domain.OrderDrainer;
import pl.store.persistance.Interface.OrderDao;

public class DefoultDataCollector implements DataCollector {

	@Inject
	private OrderDao findOrdersDao;

	@Override
	public List<OrderDrainer> getOrders() {

		return getFindOrdersDao().getOrders();
	}

	public OrderDao getFindOrdersDao() {
		return findOrdersDao;
	}

	public void setFindOrdersDao(OrderDao findOrdersDao) {
		this.findOrdersDao = findOrdersDao;
	}
}
