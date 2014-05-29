package pl.jojco.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import pl.jojco.pojo.Basket;

@Path("/basket")
public class BasketModifierService {

	private SessionFactory factory;

	@POST
	@Path("/get")
	//@Produces(MediaType.APPLICATION_XML)
	public Basket getBasket(String id) throws Exception {
		System.out.println("jetem ti");
		System.out.println(id);
		int basketId = Integer.parseInt(id);

		Basket basket = getBasketById(basketId);

		return basket;
	}

	private Basket getBasketById(int basketId) {
		Session session1 = null;
		Basket basket = null;
		try {
			session1 = factory.openSession();
			basket = (Basket) session1.load(Basket.class, basketId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session1 != null && session1.isOpen()) {
				session1.close();
			}
		}
		return basket;
	}

	@POST
	@Path("/update")
//	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_XML)
	public Basket updateBaket(Basket basket) throws Exception {
		
//		for(Item item:basket.getCurrentBasket()){
//			item.setBasket(basket);
//		}
		
		System.out.println(basket);
	
	
		//Basket basket2=getBasketById(basket.getId());
		try{
		Basket returnBasket=addBasket(basket);	
		return returnBasket;
		}catch(StaleObjectStateException e){
			return   basket;
		}
		
	}
	
	@Transactional
	public Basket addBasket(Basket newBasket) throws Exception {	
		Session session=factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			long prevVersion=newBasket.getVersion();
			Basket basket = (Basket) session.load(Basket.class, newBasket.getId());
			
			if ( prevVersion != basket.getVersion() ) throw new Exception();
			
			session.merge(newBasket);
			tx.commit();
			return basket;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();	
		} finally {
			session.close();
			
		}
		return newBasket;
		
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
