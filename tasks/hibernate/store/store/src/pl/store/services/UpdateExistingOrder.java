package pl.store.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.DefoultUpdateBasket;
import pl.store.business.inbound.UpdateBasket;
import pl.store.domain.Basket;

@Path("/storeupdate")
public class UpdateExistingOrder {

	private UpdateBasket order;

	public UpdateExistingOrder() {
		order = new DefoultUpdateBasket();
	}

	@POST
	@Path("/request")
	public Basket requestForUpdate(Basket basket) {
		return order.blockBasketForUpdate(basket);
	}

	@POST
	@Path("/update")
	public Basket updateBasket(Basket basket) {
		try {
			return order.updateBasket(basket);
		} catch (Exception e) {
			return null;
		}
	

	}
}
