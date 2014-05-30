package pl.jojco.services;

import java.io.StringWriter;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.jojco.pojo.Basket;

@Path("/basket")
public class BasketModifierService {

	private SessionFactory factory;

	@POST
	@Path("/get")
//	@Produces(MediaType.APPLICATION_XML)
	public Basket getBasket(String id) throws Exception {
		System.out.println("jetem ti");
		System.out.println(id);
		int basketId = Integer.parseInt(id);

		Basket basket23 = getBasketById(basketId);
		JAXBContext jaxbContext = JAXBContext.newInstance(Basket.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter = new StringWriter();
		jaxbMarshaller.marshal(basket23, stringWriter);
		String basketXml = stringWriter.getBuffer().toString();
		System.out.println(basketXml);
		return basket23;
	}

	private Basket getBasketById(int basketId) {
		Session session1 = null;
		Basket basket = null;
		try {
			session1 = factory.openSession();
			//basket = (Basket) session1.load(Basket.class, basketId);
			basket = (Basket) session1.load(Basket.class, basketId);
//			basket = (Basket) session1.load(Basket.class, basketId);
//			basket.getItems().size();
//			Hibernate.initialize(basket);
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
	public Basket updateBaket(Basket basket){
		
//		for(Item item:basket.getCurrentBasket()){
//			item.setBasket(basket);
//		}
		
		System.out.println(basket);
	
	
		//Basket basket2=getBasketById(basket.getId());
		try{
		Basket returnBasket=addBasket(basket);	
		return returnBasket;
		}catch(Exception e){
			return   basket;
		}
		
	}
	
	//@Transactional
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
