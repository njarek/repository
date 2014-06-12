package pl.store.persistance.Interface;

import java.util.List;

import pl.store.domain.Basket;

public interface LifecycleStatusUpdaterDao {

	void updateLifecycle(List<Basket> baskets, String status);

	void updateLifecycle(List<Basket> baskets, boolean sendRequest);

}
