package pl.store.buissnes.outbound;

import pl.supplier.domain.Requirements;

public interface Request {

	String makeOrder(Requirements requirements);
}
