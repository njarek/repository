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

import pl.jojco.pojo.Basket;
import pl.jojco.pojo.Pojo;

public class BasketClient {

	// http://localhost:8080/RESTfulExample/json/product/get
	
	public Basket getBasket(String id) throws Exception{
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(
				"http://localhost:8082/hiber.task/rest/basket/get");

		StringEntity input = new StringEntity(id);
		input.setContentType("text/plain");
		postRequest.setEntity(input);
		HttpResponse response = httpClient.execute(postRequest);
		HttpEntity httpEntity = response.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);

		// Lets see what we got from API
		System.out.println(apiOutput); // <user
										// id="10"><firstName>demo</firstName><lastName>user</lastName></user>

		// In realtime programming, you will need to convert this http response
		// to some java object to re-use it.
		// Lets see how to jaxb unmarshal the api response content
		JAXBContext jaxbContext = JAXBContext.newInstance(Basket.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Basket basket = (Basket) jaxbUnmarshaller.unmarshal(new StringReader(
				apiOutput));
		System.out.println(basket);
		return basket;
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		BasketClient basketClient=new BasketClient();
		Basket basket=basketClient.getBasket("1");
		System.out.println("pobralem basket "+basket);
		
	}

}