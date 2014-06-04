package pl.store.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.DefoultUpdateOrder;
import pl.store.business.inbound.UpdateOrder;
import pl.store.domain.Basket;

@Path("/storeupdate")
public class UpdateExistingOrder {

	private UpdateOrder order;

	public UpdateExistingOrder() {
		order = new DefoultUpdateOrder();
	}

	@POST
	@Path("/request")
	public Basket requestForUpdate(Basket basket) {
		return order.blockBasketForUpdate(basket);
	}

	@POST
	@Path("/update")
	public Basket updateBasket(Basket basket) throws Exception {
		return order.updateBasket(basket);

	}
}
