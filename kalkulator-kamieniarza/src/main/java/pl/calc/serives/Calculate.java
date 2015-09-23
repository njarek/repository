package pl.calc.serives;

import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;

public interface Calculate {

	TombstoneResult calculate(TombstoneClient clientTombstone);
}
