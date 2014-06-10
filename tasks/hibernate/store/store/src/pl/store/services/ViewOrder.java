package pl.store.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.DefoultFindBasket;
import pl.store.business.inbound.FindBasket;
import pl.store.domain.Basket;

@Path("/storefind")
public class ViewOrder {

	private FindBasket findOrder;
	
	public ViewOrder() {
		 findOrder=new DefoultFindBasket();
	}
	
	@POST
	@Path("/find")
	public Basket findBasket(Basket basket) throws Exception {
		return findOrder.findBasket(basket);

	}
}
