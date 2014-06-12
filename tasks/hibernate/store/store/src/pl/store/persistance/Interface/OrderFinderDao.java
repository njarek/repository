package pl.store.persistance.Interface;

import java.util.List;

import pl.store.domain.OrderDrainer;

public interface OrderFinderDao {

	List<OrderDrainer> getOrders();
}
