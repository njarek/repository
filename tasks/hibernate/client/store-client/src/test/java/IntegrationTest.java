import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pl.client.FindBasket;
import pl.client.NewBasket;
import pl.client.UpdateBasket;
import pl.store.domain.Basket;

public class IntegrationTest {

	@Test
	public void test() throws Exception {
		Basket findBasket = new FindBasket().findBasket(1);
		assertNotNull(findBasket);
		Basket basket = new NewBasket().sendNewBasket();
		assertNotNull(basket);

		Basket basket2 = new UpdateBasket().updateBasket(basket.getId());
		assertNotNull(basket2);
		Basket basket3 = new UpdateBasket().updateBasket(basket.getId());
		assertNotNull(basket3);

		Basket basket4 = new NewBasket().sendNewBasket();
		assertNotNull(basket4);
		Basket basket5 = new NewBasket().sendNewBasket();
		assertNotNull(basket5);
	}
}
