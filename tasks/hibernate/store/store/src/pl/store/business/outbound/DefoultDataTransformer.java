package pl.store.business.outbound;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import pl.store.domain.OrderDrainer;
import pl.supplier.domain.Buyer;
import pl.supplier.domain.Order;
import pl.supplier.domain.Requirements;

public class DefoultDataTransformer implements DataTransformer{

	@Override
	public Requirements transform(List<OrderDrainer> baskets) {
		Requirements requirements = new Requirements();
		requirements.setDeliveryPriorytet("Low");
		Buyer buyer=createConstantBuyer();
		requirements.setBuyerDetails(buyer);
		List<Order> orders=new ArrayList<Order>();
		int id=0;
		for(OrderDrainer drainer:baskets){
			Order order=new Order();
			order.setId(id++);
			order.setName(drainer.getDescription());
			order.setPrice(drainer.getPrice());
			order.setQuatity((int) drainer.getQty());
			order.setType("RTV");
			orders.add(order);
		}
		requirements.getOrderDetails().addAll(orders);
		
		
		return requirements;
	}

	private Buyer createConstantBuyer()  {
		Buyer buyer =new  Buyer();
		buyer.setContracting("JarekShop");
		buyer.setId(1);
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date(12));
		XMLGregorianCalendar date2=null;
		try {
			date2 = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			System.out.println("Error whi;e creating current date");
		}

		buyer.setTradeDate(date2);
		return buyer;
	}

}
