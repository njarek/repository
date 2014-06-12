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
import pl.store.persistance.Interface.FindBasketDao;
import pl.store.persistance.Interface.NewBasketDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
public class DefoulNewBasketDaoTest {

	@Inject
	private NewBasketDao newOrderDao;
	
	@Inject
	private FindBasketDao findOrderDao;
	
	@Test
	public void properDaveToDb() throws PersistaceException{
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		item.setBasket(basket);
				
		Basket basketnew = newOrderDao.saveBasket(basket);
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
		basket= newOrderDao.saveBasket(basket);
		Basket basketnew =findOrderDao.findBasketById(basket.getId());
		System.out.println(basket);
		System.out.println(basketnew);
		System.out.println(newOrderDao.getLifeCycleState().getLifecycle());
		assertEquals("new",newOrderDao.getLifeCycleState().getLifecycle());
		assertEquals(basketnew.getId(),newOrderDao.getLifeCycleState().getBasket().getId());
		}
	}
}
