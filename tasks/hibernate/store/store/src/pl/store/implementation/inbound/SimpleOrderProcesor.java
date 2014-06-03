package pl.store.implementation.inbound;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pl.store.domain.Basket;
import pl.store.persistance.NewOrderDao;
import pl.store.persistance.SimpleNewOrderDao;

public class SimpleOrderProcesor implements ProcessNewOrder {

	JAXBContext jaxbContext;

	public SimpleOrderProcesor() {
		try {
			jaxbContext = JAXBContext.newInstance(Basket.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String addNewBasket(String basketString) {
		Basket basket = unamrshal(basketString);
		NewOrderDao orderDao = new SimpleNewOrderDao();
		basket = orderDao.saveBasket(basket);
		return marshall(basket);
	}


	private String marshall(Basket basket) {
		String basketXml = "";
		try {
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(basket, stringWriter);
			basketXml = stringWriter.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return basketXml;
	}

	private Basket unamrshal(String basketString) {
		Basket basket = new Basket();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Basket.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			basket = (Basket) jaxbUnmarshaller.unmarshal(new StringReader(basketString));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return basket;
	}

}
