package pl.store.services;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.InboundBasket;
import pl.store.domain.Basket;

@Path("/storefind")
public class ViewOrder {

	@Inject
	private InboundBasket inboundBasket;
	
	@POST
	@Path("/find")
	public Basket findBasket(String id) throws Exception {
		return inboundBasket.findBasket(Integer.parseInt(id));

	}

}
