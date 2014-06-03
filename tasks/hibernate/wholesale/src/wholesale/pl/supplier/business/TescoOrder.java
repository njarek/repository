package wholesale.pl.supplier.business;

import wholesale.pl.supplier.implementations.OrderProcesor;
import wholesale.pl.supplier.implementations.TescoOrderProcesor;

public class TescoOrder implements Order{

	@Override
	public String processOreder(String order) {
		boolean isOrderProcessed=false;
		OrderProcesor orderProcesor= new TescoOrderProcesor();
		isOrderProcessed=orderProcesor.checkOder(order);
		
		if(isOrderProcessed) isOrderProcessed=orderProcesor.processOrder(order);
		
		return isOrderProcessed+"";
	}

}
