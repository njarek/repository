package pl.calc.business.wzory;

import pl.calc.domain.TombstoneSerwer;
import pl.calc.domain.obliczenia.WynikiObliczenPola;

public interface ObliczPole {

	WynikiObliczenPola oblicz(TombstoneSerwer serwer);
}
