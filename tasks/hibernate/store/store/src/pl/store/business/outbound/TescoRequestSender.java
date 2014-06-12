package pl.store.business.outbound;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class TescoRequestSender implements RequestSender {

	private static final String MEDIA_TYPE_PLAIN_TEXT = "plain/text";
	private static final String HOST_GET = "http://localhost:8082/wholesale/rest/suplier/order";

	HttpClient httpClient;
	static JAXBContext jaxbContext;

	public TescoRequestSender() {
		httpClient = HttpClientBuilder.create().build();
	}

	@Override
	public boolean sendRequest(String order) {
		HttpPost postRequest;
		String apiOutput = null;
		try {
			postRequest = preapreStringPostRequest(order, MEDIA_TYPE_PLAIN_TEXT, HOST_GET);
			HttpResponse response = httpClient.execute(postRequest);
			HttpEntity httpEntity = response.getEntity();
			apiOutput = EntityUtils.toString(httpEntity);
		} catch (Exception e) {
			System.out.println("Blad");
			e.printStackTrace();
		}
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
		String message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><tns:tesco xmlns:tns=\"http://www.example.org/main\" xmlns:tns1=\"http://www.example.org/tesco\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/main main.xsd \"><tns:buyerDetails id=\"0\"><tns1:contracting>smallStore</tns1:contracting><tns1:tradeDate>2001-01-01</tns1:tradeDate></tns:buyerDetails><tns:orderDetails id=\"0\"><tns1:name>tv</tns1:name><tns1:type>RTV</tns1:type><tns1:quatity>5</tns1:quatity><tns1:price>200.0</tns1:price></tns:orderDetails><tns:deliveryPriorytet>Low</tns:deliveryPriorytet></tns:tesco>";
		TescoRequestSender orderSender = new TescoRequestSender();
		System.out.println(orderSender.sendRequest(message));
	}
}
