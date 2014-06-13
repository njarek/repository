package pl.client;

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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import pl.store.domain.Basket;

public class Utility {

	public String createBasketXml(Basket basket, JAXBContext jaxbContext) throws JAXBException, PropertyException {
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter stringWriter = new StringWriter();
		jaxbMarshaller.marshal(basket, stringWriter);
		String basketXml = stringWriter.getBuffer().toString();
		return basketXml;
	}
	
	public HttpPost preapreStringPostRequest(String message, String mediaType, String Host) throws UnsupportedEncodingException {
		HttpPost postRequest = new HttpPost(Host);
		StringEntity input = new StringEntity(message);
		input.setContentType(mediaType);
		postRequest.setEntity(input);
		return postRequest;
	}
	public Basket unamrshalResponse(HttpResponse response,JAXBContext jaxbContext) throws IOException, JAXBException {
		HttpEntity httpEntity = response.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);
		System.out.println(apiOutput);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Basket basket = (Basket) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));
		return basket;
	}
}
