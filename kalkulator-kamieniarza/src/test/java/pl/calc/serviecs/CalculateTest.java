package pl.calc.serviecs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.calc.TombstoneExampleFactory;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;
import pl.calc.serives.Calculate;
import pl.calc.serives.CalculateImpl;

public class CalculateTest {

	TombstoneExampleFactory FACTORY = TombstoneExampleFactory.INST;
	@Test
	public void test(){
		TombstoneClient clientTombstone= FACTORY.tombstoneClientCenaPodstawowa();
		TombstoneResult expected = FACTORY.tombstoneResult(); 
		Calculate calculate = new CalculateImpl();
		
		TombstoneResult resultTombstone=calculate.calculate(clientTombstone);
		
		assertEquals(expected, resultTombstone);
	}
}
