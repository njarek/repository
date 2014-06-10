package pl.store.business.inbound;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.Item;
import pl.store.persistance.FindBasketDao;
import pl.store.persistance.NewBasketDao;
import pl.store.persistance.PersistaceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
public class DefoulNewOrderTest {

	@Inject
	private ProcessNewBasket processNewOrder;

	@Inject
	private NewBasketDao newOrderDao;

	@Inject
	private FindBasketDao findOrderDao;
	
	@Test
	public void properDaveToDb() throws PersistaceException {
		
	}

	@Test
	public void checkLifeCycleState() throws PersistaceException {

		Basket basket = new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		System.out.println(basket);

		Basket basketnew = processNewOrder.addNewBasket(basket);
		System.out.println(basketnew);
		Basket expectedBasket=findOrderDao.findBasketById(basketnew.getId());
		System.out.println(expectedBasket);
		
		assertEquals(expectedBasket,basketnew);
		
	}

}
