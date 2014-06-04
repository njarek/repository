package pl.store.persistance;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
public class DefoulFindObjectTest {

	@Inject
	private FindOrderDao findBasketDao;
	
	@Test
	public void checkFindingBasketById(){
		Basket basket = findBasketDao.findBasketById(1);
		System.out.println(basket);
		
		assertTrue(basket!=null);
	}
}
