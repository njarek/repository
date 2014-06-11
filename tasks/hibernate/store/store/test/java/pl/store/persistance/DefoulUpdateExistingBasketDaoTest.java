package pl.store.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.hibernate.StaleObjectStateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.Item;
import pl.store.persistance.Interface.FindBasketDao;
import pl.store.persistance.Interface.NewBasketDao;
import pl.store.persistance.Interface.UpdateBasketDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
public class DefoulUpdateExistingBasketDaoTest {

	@Inject
	private UpdateBasketDao updateOrderDao;
	
	@Inject
	private NewBasketDao newOrderDao;
	
	@Inject
	private FindBasketDao findOrderDao;
	
	private int basketId;
	private int lifecycleId;
	
	@Before
	public void init() throws PersistaceException{
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
		item.setBasket(basket);		
		Basket basketnew = newOrderDao.saveBasket(basket);
		basketId=basketnew.getId();
		lifecycleId=newOrderDao.getLifeCycleState().getId();
	}
	
	@Test
	public void properUpdateBasket() throws Exception{
		Basket basket=updateOrderDao.blockBasketWhileUpdating(basketId);
		assertEquals("modified",updateOrderDao.getLifeCycleState().getLifecycle());
		basket.setName("new name");
		Item item =new Item("baterie",3);
		basket.addItem(item);
		item.setBasket(basket);
		basket=updateOrderDao.updateBasket(basket);
		
		System.out.println(basket);
				
		assertEquals("new",updateOrderDao.getLifeCycleState().getLifecycle());
	}
	
	@Test(expected=Exception.class)
	public void transactionLock() throws Exception{
		Basket basket=updateOrderDao.blockBasketWhileUpdating(basketId);
		assertEquals("modified",updateOrderDao.getLifeCycleState().getLifecycle());
		basket.setName("new name");
		Item item =new Item("baterie",3);
		basket.addItem(item);
		item.setBasket(basket);	
		Basket basket2=updateOrderDao.updateBasket(basket);
		Basket basket3=updateOrderDao.updateBasket(basket);
		System.out.println(basket);

	}
	
	@Test(expected=Exception.class)
	public void transactionLifeCycle() throws Exception{
		Basket basket=findOrderDao.findBasketById(basketId);
		basket.setName("new name");
		Item item =new Item("baterie",3);
		basket.addItem(item);	
		Basket basket2=updateOrderDao.updateBasket(basket);

	}
}
