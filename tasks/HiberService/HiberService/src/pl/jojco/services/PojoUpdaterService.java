package pl.jojco.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import pl.jojco.pojo.Pojo;

@Path("/hello")
public class PojoUpdaterService {

	private SessionFactory factory;
	private Session session;
	@POST
	@Path("/siema")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Pojo create(Pojo pojo) throws Exception {		
	System.out.println(pojo);
		Pojo returnPojo=addPojo(pojo);
//		System.out.println(returnPojo);
//		JAXBContext jaxbContext = JAXBContext.newInstance(Pojo.class);
//		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
// 
//		// output pretty printed
//		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		StringWriter stringWriter = new StringWriter();
//		
//		jaxbMarshaller.marshal(returnPojo, stringWriter);
//		
//		StringEntity input = new StringEntity(stringWriter.getBuffer().toString());
//		System.out.println(stringWriter.getBuffer().toString());
//		System.out.println(returnPojo.getId());
		return returnPojo;
	}

	@Transactional
	public Pojo addPojo(Pojo pojo) {	
		session=factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(pojo);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();	
		} finally {
			session.close();
		}
		return pojo;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}