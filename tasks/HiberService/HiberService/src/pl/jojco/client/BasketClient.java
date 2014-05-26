package pl.jojco.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.jojco.pojo.Basket;

public class BasketClient {

	// http://localhost:8080/RESTfulExample/json/product/get
	private SessionFactory factory;
	private Session session;
	public Basket getBasket(String id) throws Exception{
		

		
		/*JAXBContext jaxbContext3 = JAXBContext.newInstance(Basket.class);
		Marshaller jaxbMarshaller2 = jaxbContext3.createMarshaller();

		// output pretty printed
		jaxbMarshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter2 = new StringWriter();

		jaxbMarshaller2.marshal(basket1, stringWriter2);
		System.out.println(stringWriter2.getBuffer().toString());
		*/
//		session=factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.save(basket1);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();	
//		} finally {
//			session.close();
//		}
		
		//elo	asd as ssadf
		int id2=12;
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(
				"http://localhost:8082/hiber.task/rest/basket/get");
		
		StringEntity input = new StringEntity("1");
		input.setContentType("plain/text");
		postRequest.setEntity(input);
		HttpResponse response = httpClient.execute(postRequest);
		
		Basket basket1 =new Basket();
		
		
		HttpEntity httpEntity = response.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);

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
		
		int basketId=1;
//		Session session1 = null;
//        Basket basket = null;
//        try {
//            session1 =factory.openSession();
//            basket =  (Basket) session1.get(Basket.class,
//            		basketId);
//            basket.getCurrentBasket().size(); 
//            Hibernate.initialize(basket);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (session1 != null && session1.isOpen()) {
//                session1.close();
//            }
//        }
//        System.out.println(basket);
//        
//        Session session2 = factory.openSession();
//        Transaction tx2 = null;
//        try{
//           tx2 = session2.beginTransaction();
//           Basket employee = 
//                      (Basket)session2.get(Basket.class, basketId); 
//           System.out.println(employee);
//         //  session2.update(employee);
//           tx2.commit();
//        }catch (HibernateException e) {
//           if (tx2!=null) tx2.rollback();
//           e.printStackTrace(); 
//        }finally {
//           session2.close(); 
//        }
		return basket1;
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BasketClient basketClient=context.getBean(BasketClient.class);
//		Basket basket=basketClient.getBasket("1");
//		System.out.println("pobralem basket "+basket);
		BasketClient basketClient=new BasketClient();
		basketClient.getBasket("1");
		System.out.println(basketClient.getBasket("1"));
		
	}






	public SessionFactory getFactory() {
		return factory;
	}






	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}