package pl.store.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import pl.store.business.inbound.ProcessNewOrder;
import pl.store.business.inbound.SimpleNewOrderProcesor;
import pl.store.domain.Basket;



public class NewOrder {

	@POST
	@Path("/store/order/")
	public Basket getOreder(Basket order){
		ProcessNewOrder newOrder=new SimpleNewOrderProcesor();
		return newOrder.addNewBasket(order);
		
	}
}
