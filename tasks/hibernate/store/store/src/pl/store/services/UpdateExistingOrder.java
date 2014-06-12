package pl.store.services;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.UpdateBasket;
import pl.store.domain.Basket;

@Path("/storeupdate")
public class UpdateExistingOrder {

	@Inject
	private UpdateBasket updateBasket;

	@POST
	@Path("/request")
	public Basket requestForUpdate(Basket basket) {
		return updateBasket.blockBasketForUpdate(basket);
	}

	@POST
	@Path("/update")
	public Basket updateBasket(Basket basket) {
		return updateBasket.updateBasket(basket);
	}

}
