package pl.store.business.outbound;

import java.util.List;

import javax.inject.Inject;

import pl.store.persistance.OrderFinderDao;
import pl.supplier.domain.Order;

public class DefoultDataCollector implements DataCollector{

//	@Inject
//	private OrderFinder findOrders;

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@Override
//	public List<Order> getOrders() {
//		findOrders.find
//		return null;
//	}

}
