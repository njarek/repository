package pl.store.business.outbound;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.Item;
import pl.store.persistance.PersistaceException;
import pl.store.persistance.Interface.BasketDao;
import pl.store.persistance.Interface.LifecycleDao;
import pl.supplier.domain.Buyer;
import pl.supplier.domain.Order;
import pl.supplier.domain.Requirements;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TransformerTest {
	@Inject
	private DataTransformer dataTransformer;

	@Inject
	private DefoultDataCollector dataCollector;
	@Inject
	private LifecycleDao lifecycleDao;
	@Inject
	private BasketDao basketDao;

	@Before
	public void init() throws PersistaceException {
		System.out.println("elo");
		Basket basket = new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		item.setBasket(basket);
		basket.addItem(item);

		Basket basketnew = basketDao.saveBasket(basket);
		lifecycleDao.saveNewLifecycle(basketnew);
	}

	@Test
	public void tranformTest() throws Exception {

		Requirements expected = prepareReq();
		Requirements actual = dataTransformer.transform(dataCollector.getOrders());
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
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

		buyer.setTradeDate(date2);
		buyer.setId(1);

		return buyer;
	}

	private List<Order> preapreOrders() {
		List<Order> orders = new ArrayList<Order>();
		final String type = "RTV";
		int id = 0;
		Order order = new Order();
		order.setId(id++);
		order.setType(type);
		order.setName("tv");
		order.setQuatity(1);
		order.setPrice(99.9);
		orders.add(order);

		return orders;
	}

}
