package pl.store.persistance;

import static org.junit.Assert.assertTrue;

import java.util.List;

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
import pl.store.persistance.Interface.FindBasketDao;
import pl.store.persistance.Interface.NewBasketDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DefoulFindBasketDaoTest {

	@Inject
	private FindBasketDao findBasketDao;
	
	@Inject 
	private NewBasketDao newOrderDao;
	
	private int basketId;
	
	@Before
	public void init() throws PersistaceException{
		Basket basket=new Basket("new");
		Item item = new Item("tv", 1);
		item.setPrice(99.9);
		basket.addItem(item);
				
		Basket basketnew = newOrderDao.saveBasket(basket);
		basketId=basketnew.getId();
	}
	
	@Test
	public void checkFindingBasketById(){
		Basket basket = findBasketDao.findBasketById(basketId);
		System.out.println(basket);
		
		assertTrue(basket!=null);
	}
	
	@Test
	public void checkFindingBasketByLifeCycle(){
		List<Basket> baskets = findBasketDao.findBasketByLifecycle(LifeCycleEnum.MODIFIED);
		System.out.println(baskets);
		
		assertTrue(baskets!=null);
	}
}
