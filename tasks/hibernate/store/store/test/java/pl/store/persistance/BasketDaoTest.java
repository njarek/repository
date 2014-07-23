package pl.store.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.StaleObjectStateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.AgdItem;
import pl.store.domain.Basket;
import pl.store.domain.Fridge;
import pl.store.domain.Item;
import pl.store.domain.LifeCycleEnum;
import pl.store.persistance.Interface.BasketDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BasketDaoTest {

	@Inject
	private BasketDao basketDao;

	private int basketId;

	@Before
	public void init() throws PersistaceException {
		Basket basket = new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);

		Basket basketnew = basketDao.saveBasket(basket);
		basketId = basketnew.getId();
	}

	@Test
	public void checkFindingBasketById() {
		Basket basket = basketDao.getBasketById(basketId);
		System.out.println(basket);

		assertTrue(basket != null);
	}

	@Test
	public void checkFindingBasketByLifeCycle() {
		List<Basket> baskets = basketDao.findBasketByLifecycle(LifeCycleEnum.MODIFIED);
		System.out.println(baskets);
		assertTrue(baskets != null);
	}

	@Test
	public void properSaveToDb() throws PersistaceException {
		Basket basket = new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		item.setBasket(basket);
		AgdItem agdItem = new AgdItem();
		agdItem.setDescription("lodowka");
		agdItem.setPrice(1120.99);
		agdItem.setStoreLocation("A9");
		agdItem.setBasket(basket);
		basket.getAgdItems().add(agdItem);

		Fridge fridge = new Fridge();
		fridge.setColor("white");
		fridge.setDescription("lodowka>?");
		fridge.setPrice(1221.11);
		fridge.setStoreLocation("A0");
		fridge.setQuantity(2);
		fridge.setBasket(basket);
		basket.getFridges().add(fridge);

		System.out.println("===========================");
		Basket basketnew = basketDao.saveBasket(basket);
		System.out.println(basket);
		assertEquals(basket, basketnew);
	}

	@Test
	public void updateBasketTest() throws Exception {
		Basket basket = basketDao.getBasketById(basketId);
		basket.setName("new name");
		Item item = new Item("baterie", 3);
		basket.addItem(item);
		Basket basket2 = basketDao.updateBasket(basket);
		assertEquals(basket, basket2);
	}

	@Test(expected = StaleObjectStateException.class)
	public void cocurrentUpdateTest() throws Exception {
		Basket basket = basketDao.getBasketById(basketId);
		basket.setName("new name");
		Item item = new Item("baterie", 3);
		basket.addItem(item);
		Basket basket2 = basketDao.updateBasket(basket);
		assertEquals(basket, basket2);
		basketDao.updateBasket(basket);
		fail();
	}
}
