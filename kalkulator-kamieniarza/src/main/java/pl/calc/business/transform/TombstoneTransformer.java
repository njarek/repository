package pl.calc.business.transform;

import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneSerwer;

public interface TombstoneTransformer {

	TombstoneSerwer transformTombstoneClient(TombstoneClient tombstoneClient);
}
