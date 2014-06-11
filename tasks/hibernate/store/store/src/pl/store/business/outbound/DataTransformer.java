package pl.store.business.outbound;

import java.util.List;

import pl.store.domain.Basket;
import pl.store.domain.OrderDrainer;
import pl.supplier.domain.Requirements;

public interface DataTransformer {

	Requirements transform(List<OrderDrainer> baskets);
}
