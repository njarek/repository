package pl.calc.business.transform;

import pl.calc.domain.CenyClient;
import pl.calc.domain.CenySerwer;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneSerwer;

public class TombstoneTransformerImpl implements TombstoneTransformer {

	@Override
	public TombstoneSerwer transformTombstoneClient(TombstoneClient tombstoneClient) {

		CenySerwer cenySerwer;
		CenyClient cenyClient = tombstoneClient.getCeny();
		
		if (tombstoneClient.getCeny().getTypCeny().equals("podstawowa")) {
			cenySerwer = new CenySerwer(cenyClient.getCenaPodstawowa(), cenyClient.getCenaPodstawowa(), cenyClient.getCenaPodstawowa(),
					cenyClient.getCenaPodstawowa());
		} else {
			cenySerwer = new CenySerwer(cenyClient.getCenaOkladzin(), cenyClient.getCenaScian(), cenyClient.getCenaNakrywy(),
					cenyClient.getCenaGradusa());
		}

		return new TombstoneSerwer(tombstoneClient.getWzor(),cenySerwer, tombstoneClient.getGrubosci(), tombstoneClient.getWymiary(), tombstoneClient.getWykomczenia());
	}

}
