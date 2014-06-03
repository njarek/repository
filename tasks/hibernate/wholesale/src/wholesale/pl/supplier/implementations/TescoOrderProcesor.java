package wholesale.pl.supplier.implementations;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class TescoOrderProcesor implements OrderProcesor {

	private static final String MAIN_XSD = "pl/supplier/xsd/main.xsd";

	@Override
	public boolean checkOder(String order) {
		try {
			URL url = this.getClass().getClassLoader().getResource(MAIN_XSD);
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(url);
			Validator validator = schema.newValidator();
			StringReader reader = new StringReader(order);
			validator.validate(new StreamSource(reader));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean processOrder(String order) {
		return true;
	}

}
