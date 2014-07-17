package pl.client;

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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import pl.store.domain.Basket;
import pl.store.domain.Item;

public class NewBasket {

	private CloseableHttpClient httpClient;
	private JAXBContext jaxbContext;
	private Utility utility;
	
	private static final String MEDIA_TYPE_APPLICATION_XML = "application/xml";
	private static final String HOST_UPADTE = "http://localhost:8082/store/rest/storeorder/order";

	public NewBasket() throws JAXBException {
		httpClient = HttpClientBuilder.create().build();
		jaxbContext = JAXBContext.newInstance(Basket.class);
		utility=new Utility();
	}

	public Basket sendNewBasket() throws Exception, JAXBException {

		Random generator = new Random();
		int i = generator.nextInt(1000) + 1;
		int i2 = generator.nextInt(10) + 1;
		int i3 = generator.nextInt(10) + 1;
		int i4 = generator.nextInt(10) + 1;
		int i5 = generator.nextInt(10) + 1;

		Basket basket1 = new Basket();
		basket1.setName("basket" + i);
		basket1.setVersion(1);
		basket1.addItem(new Item("elo", i2, (double) i + 0.5));
		basket1.addItem(new Item("elo4", i3, (double) i + 1.7));
		basket1.addItem(new Item("elo5", i4, (double) i + 0.9));
		basket1.addItem(new Item("elo6", i5, (double) i + 2.7));
				
		String basketXml = utility.createBasketXml(basket1,jaxbContext);
		HttpPost postRequest = utility.preapreStringPostRequest(basketXml, MEDIA_TYPE_APPLICATION_XML, HOST_UPADTE);
		HttpResponse response = httpClient.execute(postRequest);
		Basket basket = utility.unamrshalResponse(response,jaxbContext);
	
		return basket;
	}
	
	

	public static void main(String[] args) throws Exception {
		System.out.println(new NewBasket().sendNewBasket());
	}
}
