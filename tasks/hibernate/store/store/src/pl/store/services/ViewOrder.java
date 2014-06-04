package pl.store.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.DefoultFindOrder;
import pl.store.business.inbound.FindOrder;
import pl.store.domain.Basket;

@Path("/storefind")
public class ViewOrder {

	private FindOrder findOrder;
	
	public ViewOrder() {
		 findOrder=new DefoultFindOrder();
	}
	
	@POST
	@Path("/find")
	public Basket findBasket(Basket basket) throws Exception {
		return findOrder.findBasket(basket);

	}
}
