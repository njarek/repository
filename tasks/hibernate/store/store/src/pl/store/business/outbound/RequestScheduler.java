package pl.store.business.outbound;

import java.io.StringWriter;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.store.domain.Basket;
import pl.store.domain.OrderDrainer;
import pl.store.persistance.Interface.LifecycleStatusUpdaterDao;
import pl.supplier.domain.Order;
import pl.supplier.domain.Requirements;

/**
 * @author niedoroj
 *
 */
public class RequestScheduler {

	@Inject
	private DefoultDataCollector dataCollector;

	@Inject
	private DataTransformer dataTransformer;

	@Inject
	private RequestSender requestSender;

	@Inject
	private LifecycleStatusUpdaterDao lifecycleDao;

	static JAXBContext jaxbContext;

	public RequestScheduler()  {
		try {
			jaxbContext = JAXBContext.newInstance(Requirements.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createAnsSendRequest()  {
		List<OrderDrainer> baskets = getDataCollector().getOrders();
		Requirements requirements = dataTransformer.transform(baskets);
		System.out.println("i'm unmarshaling req " + requirements);
		String message = marshallRequirements(requirements);
		try {
			requestSender.sendRequest(message);
		} catch (Exception e) {
			System.out.println("blad");
			e.printStackTrace();
		}

		System.out.println("i'm sending req " + message);

	}

	private String marshallRequirements(Requirements requirements)  {
		Marshaller jaxbMarshaller;
		StringWriter stringWriter=null;
		try {
			jaxbMarshaller = jaxbContext.createMarshaller();
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 stringWriter = new StringWriter();
		jaxbMarshaller.marshal(requirements, stringWriter);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String reqtXml = stringWriter.getBuffer().toString();
		return reqtXml;
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// RequestScheduler
		// requestScheduler=applicationContext.getBean(RequestScheduler.class);
		// requestScheduler.createAnsSendRequest();
	}

	public DefoultDataCollector getDataCollector() {
		return dataCollector;
	}

	public void setDataCollector(DefoultDataCollector dataCollector) {
		this.dataCollector = dataCollector;
	}
}
