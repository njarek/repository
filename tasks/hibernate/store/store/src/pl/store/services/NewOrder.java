package pl.store.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.ProcessNewBasket;
import pl.store.business.inbound.DefoultNewBasketProcesor;
import pl.store.domain.Basket;
import pl.store.persistance.PersistaceException;


@Path("/storeorder")
public class NewOrder {

	@POST
	@Path("/order")
	public Basket getOreder(Basket order){
		ProcessNewBasket newOrder=new DefoultNewBasketProcesor();
		try {
			return newOrder.addNewBasket(order);
		} catch (PersistaceException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
