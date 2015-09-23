package pl.calc.business.transform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.calc.TombstoneExampleFactory;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneSerwer;

public class TombstoneTransformerTest {

	TombstoneExampleFactory FACTORY = TombstoneExampleFactory.INST;

	@Test
	public void testCenaPodstawowa() {

		TombstoneClient tombstoneClient = FACTORY.tombstoneClientCenaPodstawowa();
		TombstoneSerwer expected = FACTORY.tombstoneSerwerCenaPodstawowa();
		TombstoneTransformer tombstoneTransformer = new TombstoneTransformerImpl();

		TombstoneSerwer tombstoneSerwer = tombstoneTransformer.transformTombstoneClient(tombstoneClient);

		assertEquals(expected, tombstoneSerwer);
	}
	
	@Test
	public void testCenaRozszerzona() {

		TombstoneClient tombstoneClient = FACTORY.tombstoneClientCenyRozszerzone();
		TombstoneSerwer expected = FACTORY.tombstoneSerwerCenyRozszerzone();
		TombstoneTransformer tombstoneTransformer = new TombstoneTransformerImpl();

		TombstoneSerwer tombstoneSerwer = tombstoneTransformer.transformTombstoneClient(tombstoneClient);

		assertEquals(expected, tombstoneSerwer);
	}
}
