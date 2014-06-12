package pl.store.persistance;

import java.util.List;

import pl.store.domain.Basket;
import pl.store.persistance.Interface.LifecycleStatusUpdaterDao;

public class DefoultLifecycleStatusUpdaterDao implements LifecycleStatusUpdaterDao{

	@Override
	public void updateLifecycle(List<Basket> baskets, boolean sendRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLifecycle(List<Basket> baskets, String status) {
		// TODO Auto-generated method stub
		
	}

}
