package pl.calc.business;

import pl.calc.business.transform.TombstoneTransformer;
import pl.calc.business.transform.TombstoneTransformerImpl;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;
import pl.calc.domain.TombstoneSerwer;

public class CalculateTombstoneImpl implements CalculateTombstone {

	@Override
	public TombstoneResult calculateTombstone(TombstoneClient tombstoneClient) {
		TombstoneTransformer tombstoneTransformer=new TombstoneTransformerImpl();
		TombstoneSerwer tombstoneSerwer = tombstoneTransformer.transformTombstoneClient(tombstoneClient);
		
		GenerateResul generateResult= new GenerateResulImpl();
		TombstoneResult tombstoneResult = generateResult.generate(tombstoneSerwer);
		return tombstoneResult;
	}

	

}
