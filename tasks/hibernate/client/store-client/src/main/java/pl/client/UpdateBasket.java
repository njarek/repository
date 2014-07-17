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

public class UpdateBasket {

	private CloseableHttpClient httpClient;
	private JAXBContext jaxbContext;
	private Utility utility;
	
	private static final String MEDIA_TYPE_PLAIN_TEXT = "plain/text";
	private static final String MEDIA_TYPE_APPLICATION_XML = "application/xml";
	private static final String HOST_UPADTE = "http://localhost:8082/store/rest/storeupdate/update";
	private static final String REQUEST_FOR_UPADTE = "http://localhost:8082/store/rest/storeupdate/request";

	public UpdateBasket() throws JAXBException {
		httpClient = HttpClientBuilder.create().build();
		jaxbContext = JAXBContext.newInstance(Basket.class);
		utility=new Utility();
	}

	public Basket updateBasket(int id) throws Exception, JAXBException {

		HttpPost postRequest = utility.preapreStringPostRequest(id+"",MEDIA_TYPE_PLAIN_TEXT, REQUEST_FOR_UPADTE);
		HttpResponse response = httpClient.execute(postRequest);
		Basket basket = utility.unamrshalResponse(response,jaxbContext);
		
		
		basket.getItems().add(new Item("szelki",2,2.2));
		
		
		String basketXml = utility.createBasketXml(basket,jaxbContext);
		 postRequest = utility.preapreStringPostRequest(basketXml, MEDIA_TYPE_APPLICATION_XML, HOST_UPADTE);
		 response = httpClient.execute(postRequest);
		 basket = utility.unamrshalResponse(response,jaxbContext);
		
	
		return basket;
	}
	
	

	public static void main(String[] args) throws Exception {
		
		Basket basket= new NewBasket().sendNewBasket();
		System.out.println(basket);
		Basket basket2=new UpdateBasket().updateBasket(basket.getId());
		System.out.println(basket2);
		Basket basket3=new UpdateBasket().updateBasket(basket.getId());
		
		System.out.println(basket3);
	}
}
