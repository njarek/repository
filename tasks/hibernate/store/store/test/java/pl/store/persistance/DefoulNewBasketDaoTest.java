package pl.store.persistance;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.dom4j.tree.FlyweightCDATA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
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
public class DefoulNewBasketDaoTest {
	
	@Inject
	private BasketDao basketDao;
	
	@Inject
	private LifecycleDao lifecycleDao; 
	@Inject
	private InboundBasket inboundBasket;
	
	@Test
	public void properDaveToDb() throws PersistaceException{
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		item.setBasket(basket);
				
		Basket basketnew = basketDao.saveBasket(basket);
		System.out.println(basket);
		assertEquals(basket,basketnew);
	}
	
	@Test
	public void checkLifeCycleState() throws PersistaceException{
		
		for(int i=0;i<4;i++){
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		item.setBasket(basket);	
		basket= inboundBasket.addNewBasket(basket);
		Basket basketnew =basketDao.findBasketById(basket.getId());
		System.out.println(basket);
		System.out.println(basketnew);
		System.out.println(lifecycleDao.getLifecycleByBasketId(basketnew.getId()).getLifecycle());
		assertEquals("new",lifecycleDao.getLifecycleByBasketId(basketnew.getId()).getLifecycle());
		assertEquals(basketnew.getId(),lifecycleDao.getLifecycleByBasketId(basketnew.getId()).getBasket().getId());
		}
	}
}
