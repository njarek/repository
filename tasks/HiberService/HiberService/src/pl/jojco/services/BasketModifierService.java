package pl.jojco.services;

import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import pl.jojco.pojo.Basket;
import pl.jojco.pojo.Pojo;

@Path("/basket")
public class BasketModifierService {

	private SessionFactory factory;

	@POST
	@Path("/get")
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
			basket = (Basket) session1.get(Basket.class, basketId);
			basket.getCurrentBasket().size();
			Hibernate.initialize(basket);
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
	public Basket updateBaket(Basket basket) {
		System.out.println(basket);
		Basket returnBasket=addBasket(basket);	
		return returnBasket;
	}
	
	public Basket addBasket(Basket basket) {	
		Session session=factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(basket);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();	
		} finally {
			session.close();
		}
		return basket;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
