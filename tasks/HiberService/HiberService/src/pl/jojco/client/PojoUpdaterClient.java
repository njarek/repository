package pl.jojco.client;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

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

import pl.jojco.pojo.Pojo;

public class PojoUpdaterClient {

	public static void main(String[] args) throws Exception {

		HttpClient httpClient = HttpClientBuilder.create().build();
		JAXBContext jaxbContext = JAXBContext.newInstance(Pojo.class);
		HttpPost postRequest = createPostRequest(jaxbContext);
		HttpResponse response = httpClient.execute(postRequest);
		Pojo user = unamrshalResponse(jaxbContext, response);
		System.out.println(user.getId());
	}

	private static Pojo unamrshalResponse(JAXBContext jaxbContext, HttpResponse response) throws IOException, JAXBException {
		HttpEntity httpEntity = response.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);

		System.out.println(apiOutput);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Pojo user = (Pojo) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));
		return user;
	}

	private static HttpPost createPostRequest(JAXBContext jaxbContext) throws JAXBException, PropertyException,
			UnsupportedEncodingException {
		HttpPost postRequest = new HttpPost("http://localhost:8082/hiber.task/rest/hello/siema");
		String pojoXml = createPojoXml(jaxbContext);
		StringEntity input = new StringEntity(pojoXml);
		input.setContentType("application/xml");
		postRequest.setEntity(input);
		return postRequest;
	}

	private static String createPojoXml(JAXBContext jaxbContext) throws JAXBException, PropertyException {
		Pojo pojo = createPojo();
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter = new StringWriter();
		jaxbMarshaller.marshal(pojo, stringWriter);
		String pojoXml = stringWriter.getBuffer().toString();
		return pojoXml;
	}

	private static Pojo createPojo() {
		Pojo pojo = new Pojo();
		pojo.setName("Jarek");
		pojo.setNumber(27);
		return pojo;
	}

}