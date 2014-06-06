package pl.store.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.ProcessNewOrder;
import pl.store.business.inbound.DefoultNewOrderProcesor;
import pl.store.domain.Basket;
import pl.store.persistance.PersistaceException;


@Path("/storeorder")
public class NewOrder {

	@POST
	@Path("/order")
	public Basket getOreder(Basket order){
		ProcessNewOrder newOrder=new DefoultNewOrderProcesor();
		try {
			return newOrder.addNewBasket(order);
		} catch (PersistaceException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
