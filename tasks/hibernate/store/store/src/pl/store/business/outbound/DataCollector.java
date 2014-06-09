package pl.store.business.outbound;

import java.util.List;

import pl.store.domain.Basket;

public interface DataCollector {

	List<Basket> getBaskets();

}
