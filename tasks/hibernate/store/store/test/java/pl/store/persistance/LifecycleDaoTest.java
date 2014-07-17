package pl.store.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
public class LifecycleDaoTest {

	@Inject private LifecycleDao lifecycleDao;
	@Inject private BasketDao basketDao;
	
	public void updateLifecycleTest(List<Basket> baskets, String status) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateLifecycleTest(List<Basket> baskets, boolean sendRequest) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void saveNewLifecycleTest() throws Exception {
		Basket basket2=new Basket("some");
		basket2=basketDao.saveBasket(basket2);
		lifecycleDao.saveNewLifecycle(basket2);
		
		LifeCycleState cycleState= lifecycleDao.getLifecycleByBasketId(basket2.getId());
		assertEquals(LifeCycleEnum.NEW.getLifecycle(),cycleState.getLifecycle());
		
	}

	@Test
	public void getLifecycleByBasketIdTest() {
		LifeCycleState cycleState= lifecycleDao.getLifecycleByBasketId(1);
		assertNotNull(cycleState);
	}

	@Test
	public void updateLifecycleTest() {
		LifeCycleState cycleState= lifecycleDao.getLifecycleByBasketId(1);
		assertNotNull(cycleState);
		cycleState.setLifecycleEnum(LifeCycleEnum.SENT);
		cycleState=lifecycleDao.updateLifecycle(cycleState);
		assertEquals(LifeCycleEnum.SENT.getLifecycle(),cycleState.getLifecycle());
	}

}
