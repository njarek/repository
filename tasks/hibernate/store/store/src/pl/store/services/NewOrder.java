package pl.store.services;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.ProcessNewBasket;
import pl.store.domain.Basket;
import pl.store.persistance.PersistaceException;

@Path("/storeorder")
public class NewOrder {

	@Inject
	private ProcessNewBasket newOrder;

	@POST
	@Path("/order")
	public Basket getOreder(Basket order) {

		return newOrder.addNewBasket(order);

	}
}
