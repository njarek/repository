package wholesale.pl.supplier.business;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.xml.sax.SAXException;

import testUtility.ExampleMessages;

public class TescoOrderTest {
	
	@Test
	public void orderProcessedOK() throws SAXException {
		OrderProcesor order=new TescoOrderProcesor();
		boolean isPrccesedOk=order.processOrder(ExampleMessages.MESSAGE_OK.getMessage()) ;
		assertTrue(isPrccesedOk);	
	}
	
	@Test
	public void orderProcessedFalse() throws SAXException {
		OrderProcesor order=new TescoOrderProcesor();
		boolean isPrccesedOk=order.processOrder(ExampleMessages.BAD_MESSAGE.getMessage()) ;
		assertTrue(!isPrccesedOk);		
	}
}
