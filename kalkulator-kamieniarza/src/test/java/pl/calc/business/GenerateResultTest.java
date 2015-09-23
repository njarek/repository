package pl.calc.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.calc.TombstoneExampleFactory;
import pl.calc.business.transform.TombstoneTransformer;
import pl.calc.business.transform.TombstoneTransformerImpl;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;
import pl.calc.domain.TombstoneSerwer;

public class GenerateResultTest {

	TombstoneExampleFactory FACTORY = TombstoneExampleFactory.INST;

	@Test
	public void testCenaPodstawowa() {

		
		TombstoneSerwer tombstoneSerwer = FACTORY.tombstoneSerwerCenaPodstawowa();
		TombstoneResult expected= FACTORY.tombstoneResult();
		GenerateResul generateResul = new GenerateResulImpl();

		TombstoneResult tombstoneResult = generateResul.generate(tombstoneSerwer);

		assertEquals(expected, tombstoneResult);
	}
}
