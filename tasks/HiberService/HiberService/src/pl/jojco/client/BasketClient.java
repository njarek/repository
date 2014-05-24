package pl.jojco.client;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.jojco.pojo.Basket;
import pl.jojco.pojo.IdProvider;
import pl.jojco.pojo.Item;
import pl.jojco.pojo.Pojo;

public class BasketClient {

	// http://localhost:8080/RESTfulExample/json/product/get
	private SessionFactory factory;
	private Session session;
	public Basket getBasket(String id) throws Exception{
		
		
		
		Basket basket1=new  Basket("elo");
		
		
		JAXBContext jaxbContext3 = JAXBContext.newInstance(Basket.class);
		Marshaller jaxbMarshaller2 = jaxbContext3.createMarshaller();

		// output pretty printed
		jaxbMarshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter2 = new StringWriter();

		jaxbMarshaller2.marshal(basket1, stringWriter2);
		System.out.println(stringWriter2.getBuffer().toString());
		
		session=factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(basket1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();	
		} finally {
			session.close();
		}
		
		Item item = new Item();
		item.setDescription("1");
		item.setQuantity(2);
		
		
		Item item2 = new Item();
		item2.setDescription("2");
		item2.setQuantity(23);
		
		
		basket1.getCurrentBasket().add(item);
		basket1.getCurrentBasket().add(item2);
		
		
//		IdProvider idProvider=new IdProvider(id);
//		HttpClient httpClient = HttpClientBuilder.create().build();
//		HttpPost postRequest = new HttpPost(
//				"http://localhost:8082/hiber.task/rest/basket/get");
//		JAXBContext jaxbContext2 = JAXBContext.newInstance(IdProvider.class);
//		Marshaller jaxbMarshaller = jaxbContext2.createMarshaller();
//
//		// output pretty printed
//		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		StringWriter stringWriter = new StringWriter();
//
//		jaxbMarshaller.marshal(idProvider, stringWriter);
//		System.out.println(stringWriter.getBuffer().toString());
//		StringEntity input = new StringEntity(stringWriter.getBuffer()
//				.toString());
//		input.setContentType("application/xml");
//		postRequest.setEntity(input);
//		HttpResponse response = httpClient.execute(postRequest);
//		
//		HttpEntity httpEntity = response.getEntity();
//		String apiOutput = EntityUtils.toString(httpEntity);
//
//		// Lets see what we got from API
//		System.out.println(apiOutput); // <user
//										// id="10"><firstName>demo</firstName><lastName>user</lastName></user>
//
//		// In realtime programming, you will need to convert this http response
//		// to some java object to re-use it.
//		// Lets see how to jaxb unmarshal the api response content
//		JAXBContext jaxbContext = JAXBContext.newInstance(Basket.class);
//		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//		Basket basket = (Basket) jaxbUnmarshaller.unmarshal(new StringReader(
//				apiOutput));
//		System.out.println(basket);
		return basket1;
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("2applicationContext.xml");
		BasketClient basketClient=context.getBean(BasketClient.class);
		Basket basket=basketClient.getBasket("1");
		System.out.println("pobralem basket "+basket);
		
	}






	public SessionFactory getFactory() {
		return factory;
	}






	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}