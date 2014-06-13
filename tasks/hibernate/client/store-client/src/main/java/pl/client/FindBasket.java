package pl.client;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import pl.store.domain.Basket;

public class FindBasket {
	private CloseableHttpClient httpClient;
	private JAXBContext jaxbContext;
	private Utility utility;
	
	private static final String MEDIA_TYPE_PLAIN_TEXT = "plain/text";
	private static final String HOST_UPADTE = "http://localhost:8082/store/rest/storefind/find";
	
	public FindBasket() throws Exception {
		httpClient = HttpClientBuilder.create().build();
		jaxbContext = JAXBContext.newInstance(Basket.class);
		utility=new Utility();
	}
	
	
	public Basket findBasket(int id) throws Exception{
		HttpPost postRequest = utility.preapreStringPostRequest(id+"",MEDIA_TYPE_PLAIN_TEXT, HOST_UPADTE);
		HttpResponse response = httpClient.execute(postRequest);
		Basket basket = utility.unamrshalResponse(response,jaxbContext);
		
		return basket;
	}
	
	public static void main(String[] args) throws JAXBException, Exception {
		new NewBasket().sendNewBasket();
		System.out.println("basket found "+ new FindBasket().findBasket(3));
	}

}
