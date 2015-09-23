package pl.calc.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.calc.TombstoneExampleFactory;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;

public class CalculateTombstoneTest {

	TombstoneExampleFactory FACTORY = TombstoneExampleFactory.INST;
	@Test
	public void test(){
		TombstoneClient tombstoneClient= FACTORY.tombstoneClientCenaPodstawowa();
		TombstoneResult expected = FACTORY.tombstoneResult();; 
		CalculateTombstone calculateTombstone = new CalculateTombstoneImpl();
		
		TombstoneResult resultTombstone=calculateTombstone.calculateTombstone(tombstoneClient);
		
		assertEquals(expected, resultTombstone);
	}
}
