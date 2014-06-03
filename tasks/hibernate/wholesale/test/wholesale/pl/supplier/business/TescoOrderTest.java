package wholesale.pl.supplier.business;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import testUtility.ExampleMessages;

public class TescoOrderTest {
	
	@Test
	public void orderProcessedOK() {
		boolean isPrccesedOk = preapreTest(ExampleMessages.MESSAGE_OK.getMessage());
		assertTrue(isPrccesedOk);	
	}
	
	@Test
	public void orderProcessedFalse() {
		boolean isPrccesedOk = preapreTest(ExampleMessages.BAD_MESSAGE.getMessage());
		assertTrue(!isPrccesedOk);		
	}

	private boolean preapreTest(String message) {
		Order order=new TescoOrder();
		boolean isPrccesedOk=Boolean.parseBoolean(order.processOreder(message)) ;
		return isPrccesedOk;
	}

}
