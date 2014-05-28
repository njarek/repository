package pl.jojco.client;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.SessionFactory;

import pl.jojco.pojo.Basket;
import pl.jojco.pojo.Item;

public class BasketClient {

	private static final String MEDIA_TYPE_PLAIN_TEXT = "plain/text";
	private static final String MEDIA_TYPE_APPLICATION_XML = "application/xml";
	private static final String HOST_GET = "http://localhost:8082/hiber.task/rest/basket/get";
	private static final String HOST_UPADTE = "http://localhost:8082/hiber.task/rest/basket/update";
	private SessionFactory factory;
	HttpClient httpClient;
	static JAXBContext jaxbContext;

	public BasketClient() throws JAXBException {
		httpClient = HttpClientBuilder.create().build();
		jaxbContext = JAXBContext.newInstance(Basket.class);
	}

	public Basket getBasket(int id) throws Exception {
		HttpPost postRequest = preapreStringPostRequest("" + id, MEDIA_TYPE_PLAIN_TEXT, HOST_GET);
		HttpResponse response = httpClient.execute(postRequest);

		Basket basket = unamrshalResponse(response);
		return basket;
	}

	public Basket updateBasket(Basket basket) throws PropertyException, JAXBException, IOException {
		String basketXml = createBasketXml(basket);
		HttpPost postRequest = preapreStringPostRequest(basketXml, MEDIA_TYPE_APPLICATION_XML, HOST_UPADTE);
		HttpResponse response = httpClient.execute(postRequest);
		basket = unamrshalResponse(response);
		return basket;

	}

	private String createBasketXml(Basket basket) throws JAXBException, PropertyException {
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter = new StringWriter();
		jaxbMarshaller.marshal(basket, stringWriter);
		String basketXml = stringWriter.getBuffer().toString();
		return basketXml;
	}

	private HttpPost preapreStringPostRequest(String message, String mediaType, String Host) throws UnsupportedEncodingException {
		HttpPost postRequest = new HttpPost(Host);
		StringEntity input = new StringEntity(message);
		input.setContentType(mediaType);
		postRequest.setEntity(input);
		return postRequest;
	}

	private Basket unamrshalResponse(HttpResponse response) throws IOException, JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Basket.class);
		HttpEntity httpEntity = response.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);

		System.out.println(apiOutput);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Basket basket = (Basket) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));
		return basket;
	}

	public static void main(String[] args) throws Exception {
		BasketClient basketClient = new BasketClient();
		Basket basket = basketClient.getBasket(1);
		System.out.println(basket);

		Random generator = new Random();
		int i = generator.nextInt(10) + 1;

		Thread.sleep(i * 1000);
		basket.setName("nowy");
		for(Item item:basket.getCurrentBasket()){
			
			int i2 = generator.nextInt(10) + 1;
				
				item.setQuantity(i2);
			
		}
		basket = basketClient.updateBasket(basket);
		System.out.println(basket);

	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}