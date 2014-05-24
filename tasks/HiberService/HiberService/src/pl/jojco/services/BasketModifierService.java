package pl.jojco.services;

import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.http.entity.StringEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.jojco.pojo.Basket;
import pl.jojco.pojo.IdProvider;

@Path("/basket")
public class BasketModifierService {

	private SessionFactory factory;
	
	@POST
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String getBasket(IdProvider id) throws Exception{
//		System.out.println(id);
//		int basketId=Integer.parseInt(id);
		int basketId=id.getId();
		Session session = null;
        Basket basket = null;
        try {
            session =factory.openSession();
            basket =  (Basket) session.load(Basket.class,
            		basketId);
            Hibernate.initialize(basket);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        JAXBContext jaxbContext2 = JAXBContext.newInstance(Basket.class);
		Marshaller jaxbMarshaller = jaxbContext2.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter = new StringWriter();

		jaxbMarshaller.marshal(basket, stringWriter);
		System.out.println(stringWriter.getBuffer().toString());
		
        return stringWriter.getBuffer().toString();
		
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public boolean  updateBaket(Basket basket){
		
		return true;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
