package pl.store.persistance;

import static org.junit.Assert.assertEquals;
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
import pl.store.domain.LifeCycleEnum;
import pl.store.domain.LifeCycleState;
import pl.store.persistance.Interface.BasketDao;
import pl.store.persistance.Interface.LifecycleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class LifecycleDaoTest {

	@Inject
	private LifecycleDao lifecycleDao;
	@Inject
	private BasketDao basketDao;
	private int basketId;
	
	@Before
	public void init() throws PersistaceException {
		Basket basket = new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		item.setBasket(basket);
		basket.addItem(item);

		Basket basketnew = basketDao.saveBasket(basket);
		lifecycleDao.saveNewLifecycle(basketnew);
		basketId = basketnew.getId();
	}

	@Test
	public void saveNewLifecycleTest() throws Exception {
		Basket basket2 = new Basket("some");
		basket2 = basketDao.saveBasket(basket2);
		lifecycleDao.saveNewLifecycle(basket2);

		LifeCycleState cycleState = lifecycleDao.getLifecycleByBasketId(basket2.getId());
		assertEquals(LifeCycleEnum.NEW.getLifecycle(), cycleState.getLifecycle());

	}

	@Test
	public void getLifecycleByBasketIdTest() {
		LifeCycleState cycleState = lifecycleDao.getLifecycleByBasketId(basketId);
		assertNotNull(cycleState);
	}

	@Test
	public void updateLifecycleTest() {
		LifeCycleState cycleState = lifecycleDao.getLifecycleByBasketId(basketId);
		assertNotNull(cycleState);
		cycleState.setLifecycleEnum(LifeCycleEnum.SENT);
		cycleState = lifecycleDao.updateLifecycle(cycleState);
		assertEquals(LifeCycleEnum.SENT.getLifecycle(), cycleState.getLifecycle());
	}

}
