package wholesale.pl.supplier.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import wholesale.pl.supplier.business.Order;
import wholesale.pl.supplier.business.TescoOrder;


@Path("/suplier")

public class OrderReciever {

	@POST
	@Path("/order")
	public String getOreder(String order){
		
		Order tescoOrder = new TescoOrder();
		
		return tescoOrder.processOreder(order);
		
	}
}
