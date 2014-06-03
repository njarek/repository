package wholesale.pl.supplier.business;

import org.xml.sax.SAXException;

public class TescoOrderProcesor implements OrderProcesor {

	private SchemaValidator validator;

	public TescoOrderProcesor() throws SAXException {
		validator = new SchemaValidator();
	}

	@Override
	public boolean processOrder(String order) {
		validator.checkOder(order);
		return validator.checkOder(order);
	}

}
