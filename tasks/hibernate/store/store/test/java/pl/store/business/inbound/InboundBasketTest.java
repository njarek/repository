package pl.store.business.inbound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleEnum;
import pl.store.domain.LifeCycleState;
import pl.store.persistance.Interface.BasketDao;
import pl.store.persistance.Interface.LifecycleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class InboundBasketTest {

	@Inject
	private BasketDao basketDao;
	
	@Inject private LifecycleDao lifecycleDao;

	@Inject
	private InboundBasket inboundBasket;

	@Test
	public void findBasketTest() {
		Basket basket = inboundBasket.findBasket(1);
		Basket basket2 = basketDao.getBasketById(1);
		assertEquals(basket2, basket);
	}

	@Test
	public void addNewBasketTest() {
		Basket basket= new Basket("new");
		basket = inboundBasket.addNewBasket(basket);
		Basket basket2= basketDao.getBasketById(basket.getId());
		assertEquals(basket2, basket);
		LifeCycleState cycleState = lifecycleDao.getLifecycleByBasketId(basket.getId());
		assertEquals(LifeCycleEnum.NEW.getLifecycle(),cycleState.getLifecycle());
	}

	@Test
	public void updateBasketTest() {
		Basket basket= inboundBasket.blockBasketForUpdate(1);
		basket.setName("Updated");
		basket= inboundBasket.updateBasket(basket);
		Basket basket2= basketDao.getBasketById(1);
		assertEquals(basket2, basket);
	}

	@Test
	public void blockBasketForUpdateTest() {
		LifeCycleState cycleState= lifecycleDao.getLifecycleByBasketId(2);
		assertEquals(LifeCycleEnum.NEW.getLifecycle(),cycleState.getLifecycle());
		inboundBasket.blockBasketForUpdate(2);
		cycleState= lifecycleDao.getLifecycleByBasketId(2);
		assertEquals(LifeCycleEnum.MODIFIED.getLifecycle(),cycleState.getLifecycle());
	}
	
	@Test
	public void unsuccesfullUpdateTest(){
		Basket basket= basketDao.getBasketById(1);
		basket.setName("Updated");
		basket= inboundBasket.updateBasket(basket);
		
		assertNull( basket);
	}
	
	@Test
	public void concurrentUpdate(){
		Basket basket= inboundBasket.blockBasketForUpdate(1);
		basket.setName("Updated");
		Basket basket2= inboundBasket.updateBasket(basket);
		assertNotNull( basket2);
		Basket basket3=inboundBasket.updateBasket(basket);
		assertNull(basket3);
	}


}
