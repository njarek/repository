package pl.store.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.store.domain.Basket;
import pl.store.domain.LifeCycle;
import pl.store.domain.LifeCycleEnum;

public class DefoultNewOrderDao implements NewOrderDao{

	private SessionFactory factory;
	
	private LifeCycle lifeCycle=new LifeCycle();
	
	@Override
	public Basket saveBasket(Basket basket) {
		Session hibernateSession = null;		
		try {
			hibernateSession = getFactory().openSession();	
			//basket = (Basket) hibernateSession.save(Basket.class);
			
			getLifeCycle().setLifecycleEnum(LifeCycleEnum.NEW);
			getLifeCycle().setBasket(basket);
		    hibernateSession.save(basket);
			hibernateSession.save(getLifeCycle());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (hibernateSession != null && hibernateSession.isOpen()) {
				hibernateSession.close();
			}
		}
		return basket;
	}
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}
	public void setLifeCycle(LifeCycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}

	

}
