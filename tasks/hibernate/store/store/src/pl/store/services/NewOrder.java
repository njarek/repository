package pl.store.services;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.InboundBasket;
import pl.store.domain.Basket;

@Path("/storeorder")
public class NewOrder {

	@Inject
	private InboundBasket inboundBasket;

	@POST
	@Path("/order")
	public Basket getOreder(Basket order) {

		return inboundBasket.addNewBasket(order);

	}
}
