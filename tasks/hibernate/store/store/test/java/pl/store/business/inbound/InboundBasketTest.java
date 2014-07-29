package pl.store.business.inbound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import pl.store.persistance.PersistaceException;
import pl.store.persistance.Interface.BasketDao;
import pl.store.persistance.Interface.LifecycleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class InboundBasketTest {

	@Inject
	private BasketDao basketDao;

	@Inject
	private LifecycleDao lifecycleDao;

	@Inject
	private InboundBasket inboundBasket;

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
	public void findBasketTest() {
		Basket basket = inboundBasket.findBasket(basketId);
		Basket basket2 = basketDao.getBasketById(basketId);
		assertEquals(basket2, basket);
	}

	@Test
	public void addNewBasketTest() {
		Basket basket = new Basket("new");
		basket = inboundBasket.addNewBasket(basket);
		Basket basket2 = basketDao.getBasketById(basket.getId());
		assertEquals(basket2, basket);
		LifeCycleState cycleState = lifecycleDao.getLifecycleByBasketId(basket.getId());
		assertEquals(LifeCycleEnum.NEW.getLifecycle(), cycleState.getLifecycle());
	}

	@Test
	public void updateBasketTest() {
		Basket basket = inboundBasket.blockBasketForUpdate(basketId);
		basket.setName("Updated");
		basket = inboundBasket.updateBasket(basket);
		Basket basket2 = basketDao.getBasketById(basketId);
		assertEquals(basket2, basket);
	}

	@Test
	public void blockBasketForUpdateTest() {
		LifeCycleState cycleState = lifecycleDao.getLifecycleByBasketId(basketId);
		assertEquals(LifeCycleEnum.NEW.getLifecycle(), cycleState.getLifecycle());
		inboundBasket.blockBasketForUpdate(basketId);
		cycleState = lifecycleDao.getLifecycleByBasketId(basketId);
		assertEquals(LifeCycleEnum.MODIFIED.getLifecycle(), cycleState.getLifecycle());
	}

	@Test
	public void unsuccesfullUpdateTest() {
		Basket basket = basketDao.getBasketById(basketId);
		basket.setName("Updated");
		basket = inboundBasket.updateBasket(basket);

		assertNull(basket);
	}

	@Test
	public void concurrentUpdate() {
		Basket basket = inboundBasket.blockBasketForUpdate(basketId);
		basket.setName("Updated");
		Basket basket2 = inboundBasket.updateBasket(basket);
		assertNotNull(basket2);
		Basket basket3 = inboundBasket.updateBasket(basket);
		assertNull(basket3);
	}

}
