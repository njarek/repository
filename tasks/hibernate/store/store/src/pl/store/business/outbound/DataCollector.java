package pl.store.business.outbound;

import java.util.List;

import pl.store.domain.OrderDrainer;

public interface DataCollector {

	List<OrderDrainer> getOrders();

}
