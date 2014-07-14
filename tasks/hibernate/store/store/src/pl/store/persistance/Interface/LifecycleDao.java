package pl.store.persistance.Interface;

import java.util.List;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycleState;

public interface LifecycleDao {

	void updateLifecycle(List<Basket> baskets, String status);

	void updateLifecycle(List<Basket> baskets, boolean sendRequest);

	void saveNewLifecycle(Basket basket);

	LifeCycleState getLifecycleByBasketId(int id);

	LifeCycleState updateLifecycle(LifeCycleState cycleState);
}
