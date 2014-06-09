package pl.store.business.outbound;

import java.util.List;

import pl.store.domain.Basket;
import pl.supplier.domain.Requirements;

public interface DataTransformer {

	Requirements transform(List<Basket> baskets);
}
