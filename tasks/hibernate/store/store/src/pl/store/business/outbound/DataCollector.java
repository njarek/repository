package pl.store.business.outbound;

import java.util.List;

import pl.store.domain.OrderDrainer;
import pl.supplier.domain.Order;

public interface DataCollector {

	List<OrderDrainer> getOrders();

}
