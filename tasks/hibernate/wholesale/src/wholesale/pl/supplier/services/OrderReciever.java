package wholesale.pl.supplier.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.xml.sax.SAXException;

import wholesale.pl.supplier.business.OrderProcesor;
import wholesale.pl.supplier.business.TescoOrderProcesor;

@Path("/suplier")
public class OrderReciever {

	@POST
	@Path("/order")
	public String getOreder(String order) throws SAXException {

		OrderProcesor tescoOrder = new TescoOrderProcesor();

		return tescoOrder.processOrder(order) + "";

	}
}
