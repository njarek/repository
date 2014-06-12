package pl.store.services;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.FindBasket;
import pl.store.domain.Basket;

@Path("/storefind")
public class ViewOrder {

	@Inject
	private FindBasket findBasket;
	
	@POST
	@Path("/find")
	public Basket findBasket(Basket basket) throws Exception {
		return findBasket.findBasket(basket);

	}

}
