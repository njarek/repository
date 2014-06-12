package pl.store.business.outbound;

import java.io.StringWriter;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import pl.store.domain.OrderDrainer;
import pl.supplier.domain.ObjectFactory;
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

	static JAXBContext jaxbContext;

	public RequestScheduler() {
		try {
			jaxbContext = JAXBContext.newInstance(Requirements.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createAnsSendRequest() {
		System.out.println("Preparing new Order...");

		List<OrderDrainer> baskets = getDataCollector().getOrders();
		Requirements requirements = dataTransformer.transform(baskets);

		if (requirements.getOrderDetails().size() <= 0) {
			System.out.println("Empty order");
			return;
		}

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

	private String marshallRequirements(Requirements requirements) {
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<Requirements> reqElement = factory.createTesco(requirements);

		Marshaller jaxbMarshaller;
		StringWriter stringWriter = null;
		try {
			jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			stringWriter = new StringWriter();
			jaxbMarshaller.marshal(reqElement, stringWriter);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String reqtXml = stringWriter.getBuffer().toString();
		return reqtXml;
	}

	public static void main(String[] args) {
		// ApplicationContext applicationContext = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
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
