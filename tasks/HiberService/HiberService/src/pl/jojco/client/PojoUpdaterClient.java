package pl.jojco.client;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import pl.jojco.pojo.Pojo;

public class PojoUpdaterClient {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) throws Exception {

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(
				"http://localhost:8082/hiber.task/rest/hello/siema");

		Pojo pojo = new Pojo();
		pojo.setName("Jarek");
		pojo.setNumber(27);
		JAXBContext jaxbContext = JAXBContext.newInstance(Pojo.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter = new StringWriter();

		jaxbMarshaller.marshal(pojo, stringWriter);

		StringEntity input = new StringEntity(stringWriter.getBuffer()
				.toString());
		input.setContentType("application/xml");
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

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Pojo user = (Pojo) jaxbUnmarshaller.unmarshal(new StringReader(
				apiOutput));
		System.out.println(user.getId());
	}

}