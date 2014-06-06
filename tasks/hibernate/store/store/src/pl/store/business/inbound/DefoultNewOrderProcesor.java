package pl.store.business.inbound;

import pl.store.domain.Basket;
import pl.store.domain.DefoulItemVisitor;
import pl.store.domain.Item;
import pl.store.domain.ItemVisitor;
import pl.store.persistance.NewOrderDao;
import pl.store.persistance.PersistaceException;

public class DefoultNewOrderProcesor implements ProcessNewOrder {
	private NewOrderDao newOrderDao;
	
	@Override
	public Basket addNewBasket(Basket basket) throws PersistaceException {
		ItemVisitor itemVisitor=new DefoulItemVisitor(basket);
		for(Item item:basket.getItems()){
			item.accept(itemVisitor);
		}
		
		return newOrderDao.saveBasket(basket);
	}

	public NewOrderDao getNewOrderDao() {
		return newOrderDao;
	}

	public void setNewOrderDao(NewOrderDao newOrderDao) {
		this.newOrderDao = newOrderDao;
	}

	

}
