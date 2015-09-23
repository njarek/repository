package pl.calc.business;

import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;

public interface CalculateTombstone {

	TombstoneResult calculateTombstone(TombstoneClient tombstoneClient);
}
