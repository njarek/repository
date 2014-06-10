package pl.store.business.outbound;

import java.util.List;

import pl.supplier.domain.Order;

public interface DataCollector {

	List<Order> getOrders();

}
