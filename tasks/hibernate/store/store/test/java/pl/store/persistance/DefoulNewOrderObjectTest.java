package pl.store.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.Item;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
public class DefoulNewOrderObjectTest {

	@Inject
	private NewOrderDao newOrderDao;
	
	@Test
	public void properDaveToDb(){
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		
		Basket basketnew = newOrderDao.saveBasket(basket);
		System.out.println(basket);
		assertEquals(basket,basketnew);
	}
	
	@Test
	public void checkLifeCycleState(){
		
		for(int i=0;i<4;i++){
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		
		Basket basketnew = newOrderDao.saveBasket(basket);
		System.out.println(basket);
		System.out.println(newOrderDao.getLifeCycle().getLifecycle());
		assertEquals("new",newOrderDao.getLifeCycle().getLifecycle());
		assertEquals(basketnew.getId(),newOrderDao.getLifeCycle().getBasket().getId());
		}
	}
}
