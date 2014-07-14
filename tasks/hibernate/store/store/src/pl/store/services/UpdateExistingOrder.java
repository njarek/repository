package pl.store.services;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.InboundBasket;
import pl.store.domain.Basket;

@Path("/storeupdate")
public class UpdateExistingOrder {

	@Inject
	private InboundBasket updateBasket;

	@POST
	@Path("/request")
	public Basket requestForUpdate(String id) {
		return updateBasket.blockBasketForUpdate(Integer.parseInt(id));
	}

	@POST
	@Path("/update")
	public Basket updateBasket(Basket basket) {
		return updateBasket.updateBasket(basket);
	}

}
