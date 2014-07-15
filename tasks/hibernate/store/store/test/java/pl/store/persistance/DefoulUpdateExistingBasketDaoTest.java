package pl.store.persistance;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.business.inbound.InboundBasket;
import pl.store.domain.Basket;
import pl.store.domain.Item;
import pl.store.persistance.Interface.BasketDao;
import pl.store.persistance.Interface.LifecycleDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DefoulUpdateExistingBasketDaoTest {

	@Inject
	private BasketDao basketDao;
	@Inject private InboundBasket inboundBasket;
	@Inject private LifecycleDao lifecycleDao;
	
	
	private int basketId;
	private int lifecycleId;
	
	@Before
	public void init() throws PersistaceException{
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		item.setBasket(basket);		
		Basket basketnew = inboundBasket.addNewBasket(basket);
		basketId=basketnew.getId();
		lifecycleId=lifecycleDao.getLifecycleByBasketId(basketId).getId();
		System.out.println(lifecycleId);
	}
	
	@Test
	public void properUpdateBasket() throws Exception{
		Basket basket=inboundBasket.blockBasketForUpdate(basketId);
		assertEquals("modified",lifecycleDao.getLifecycleByBasketId(basketId).getLifecycle());
		basket.setName("new name");
		Item item =new Item("baterie",3);
		basket.addItem(item);
		item.setBasket(basket);
		basket=inboundBasket.updateBasket(basket);
		
		System.out.println(basket);
				
		assertEquals("new",lifecycleDao.getLifecycleByBasketId(basket.getId()).getLifecycle());
	}
	
	@Test()//expected=PersistaceException.class
	@ExpectedException(PersistaceException.class)
	public void transactionLock() throws Exception{
		Basket basket=inboundBasket.blockBasketForUpdate(basketId);
		assertEquals("modified",lifecycleDao.getLifecycleByBasketId(basketId).getLifecycle());
		basket.setName("new name");
		Item item =new Item("baterie",3);
		basket.addItem(item);
		item.setBasket(basket);	
		Basket basket2=inboundBasket.updateBasket(basket);
		Basket basket3=inboundBasket.updateBasket(basket);
		System.out.println(basket);

	}
	
	@Test(expected=Exception.class)
	public void transactionLifeCycle() throws Exception{
		Basket basket=basketDao.findBasketById(basketId);
		basket.setName("new name");
		Item item =new Item("baterie",3);
		basket.addItem(item);	
		Basket basket2=inboundBasket.updateBasket(basket);

	}
}
