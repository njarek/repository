package pl.store.persistance;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.store.domain.Basket;
import pl.store.domain.Item;
import pl.store.domain.OrderDrainer;
import pl.store.persistance.Interface.OrderFinderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DefoultOrdersFinderDaoTest {

	@Inject
	private OrderFinderDao orderFinderDao;

	@Test
	public void properDaveToDb() throws PersistaceException {
		List<OrderDrainer> drainers = orderFinderDao.getOrders();
		assertEquals(9, drainers.size());
		
		drainers = orderFinderDao.getOrders();
		assertEquals(0, drainers.size());
	}
	
}
