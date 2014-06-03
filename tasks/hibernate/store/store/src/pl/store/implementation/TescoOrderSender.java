package pl.store.implementation;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class TescoOrderSender implements OrderSender {

	private static final String MEDIA_TYPE_PLAIN_TEXT = "plain/text";
	private static final String MEDIA_TYPE_APPLICATION_XML = "application/xml";
	private static final String HOST_GET = "http://localhost:8082/wholesale/rest/suplier/order";
	private static final String HOST_UPADTE = "http://localhost:8082/hiber.task/rest/basket/update";

	HttpClient httpClient;
	static JAXBContext jaxbContext;

	public TescoOrderSender()  {
		httpClient = HttpClientBuilder.create().build();
	}
	@Override
	public boolean sendOrder(String order) throws Exception {
		HttpPost postRequest = preapreStringPostRequest(order, MEDIA_TYPE_PLAIN_TEXT, HOST_GET);
		HttpResponse response = httpClient.execute(postRequest);

		HttpEntity httpEntity = response.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);

		System.out.println(apiOutput);
		return Boolean.parseBoolean(apiOutput);
	}

	private HttpPost preapreStringPostRequest(String message, String mediaType, String Host) throws UnsupportedEncodingException {
		HttpPost postRequest = new HttpPost(Host);
		StringEntity input = new StringEntity(message);
		input.setContentType(mediaType);
		postRequest.setEntity(input);
		return postRequest;
	}
	
	public static void main(String[] args) throws Exception {
		String message="<?xml version=\"1.0\" encoding=\"UTF-8\"?><tns:tesco xmlns:tns=\"http://www.example.org/main\" xmlns:tns1=\"http://www.example.org/tesco\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/main main.xsd \"><tns:buyerDetails id=\"0\"><tns1:contracting>smallStore</tns1:contracting><tns1:tradeDate>2001-01-01</tns1:tradeDate></tns:buyerDetails><tns:orderDetails id=\"0\"><tns1:name>tv</tns1:name><tns1:type>RTV</tns1:type><tns1:quatity>5</tns1:quatity><tns1:price>200.0</tns1:price></tns:orderDetails><tns:deliveryPriorytet>Low</tns:deliveryPriorytet></tns:tesco>";
	TescoOrderSender orderSender=new TescoOrderSender();
	System.out.println(orderSender.sendOrder(message));
	}
}
