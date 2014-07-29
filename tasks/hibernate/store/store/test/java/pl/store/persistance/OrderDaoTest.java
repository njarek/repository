package pl.store.persistance;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.Item;
import pl.store.persistance.Interface.BasketDao;
import pl.store.persistance.Interface.LifecycleDao;
import pl.store.persistance.Interface.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderDaoTest {

	@Inject
	private OrderDao orderDao;
	@Inject
	private LifecycleDao lifecycleDao;
	@Inject
	private BasketDao basketDao;
	
	@Before
	public void init() throws PersistaceException {
		Basket basket = new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		item.setBasket(basket);
		basket.addItem(item);

		Basket basketnew = basketDao.saveBasket(basket);
		lifecycleDao.saveNewLifecycle(basketnew);
		
	}
	@Test
	public void getOredersTest() {
		assertNotNull(orderDao.getOrders());
	}
}
