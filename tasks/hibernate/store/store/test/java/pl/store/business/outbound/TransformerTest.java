package pl.store.business.outbound;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.supplier.domain.Buyer;
import pl.supplier.domain.Order;
import pl.supplier.domain.Requirements;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
public class TransformerTest {
	@Inject
	private DataTransformer dataTransformer;

	@Inject
	DefoultDataCollector dataCollector;

	@Test
	public void tranformTest() throws Exception {

		Requirements expected = prepareReq();
		Requirements actual = dataTransformer.transform(dataCollector
				.getOrders());
		assertEquals(expected, actual);

	}

	private Requirements prepareReq() throws Exception {
		Requirements requirements = new Requirements();
		requirements.setBuyerDetails(prepareBuyer());
		requirements.setDeliveryPriorytet("Low");
		requirements.getOrderDetails().addAll(preapreOrders());
		return requirements;
	}

	private Buyer prepareBuyer() throws Exception {
		Buyer buyer = new Buyer();
		buyer.setContracting("JarekShop");
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date(12));
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(c);

		buyer.setTradeDate(date2);
		buyer.setId(1);

		return buyer;
	}

	private List<Order> preapreOrders() {
		List<Order> orders = new ArrayList<Order>();
		final String type="RTV";
		int id=0;
		Order order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("czajnik");
		order.setPrice(0.4);
		order.setQuatity(1);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("pralka");
		order.setPrice(1.2);
		order.setQuatity(1);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("czajnik2");
		order.setPrice(2.2);
		order.setQuatity(1);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("tv");
		order.setPrice(2.2);
		order.setQuatity(2);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("pralka");
		order.setPrice(2.2);
		order.setQuatity(1);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("pilot");
		order.setPrice(7.5);
		order.setQuatity(1);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("pilot");
		order.setPrice(2.2);
		order.setQuatity(1);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("baterie");
		order.setPrice(3.2);
		order.setQuatity(1);
		orders.add(order);

		order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("baterie");
		order.setPrice(2.2);
		order.setQuatity(1);
		orders.add(order);

		return orders;
	}

}
