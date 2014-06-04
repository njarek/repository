package pl.store.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.Item;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
public class DefoulUpdateExistingObjectTest {

	@Inject
	private UpdateOrderDao updateOrderDao;
	
	@Inject
	private NewOrderDao newOrderDao;
	
	private int basketId;
	private int lifecycleId;
	
	@Before
	public void init(){
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		
		
		Basket basketnew = newOrderDao.saveBasket(basket);
		basketId=basketnew.getId();
		lifecycleId=newOrderDao.getLifeCycle().getId();
	}
	
	@Test
	public void properUpdateBasket() throws Exception{
		Basket basket=updateOrderDao.blockBasketWhileUpdating(1);
		assertEquals("modified",updateOrderDao.getLifeCycle().getLifecycle());
		basket.setName("new name");
		basket=updateOrderDao.updateBasket(basket);
		
		System.out.println(basket);
		assertEquals("new",updateOrderDao.getLifeCycle().getLifecycle());
	}
}
