package pl.calc;

import pl.calc.domain.CenyClient;
import pl.calc.domain.CenySerwer;
import pl.calc.domain.Grubosci;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;
import pl.calc.domain.TombstoneSerwer;
import pl.calc.domain.Wykonczenia;
import pl.calc.domain.Wymiary;

public enum TombstoneExampleFactory {

	INST;

	public TombstoneClient tombstoneClientCenaPodstawowa() {
		return new TombstoneClient("n1", new CenyClient(500, 600, 600, 600, 700, "podstawowa"), new Grubosci(5, 5, 5, 6), new Wymiary(30, 120, 250, 30, 5, 2,
				15, 15, 25), new Wykonczenia("proste", "proste", "proste", "proste", 0, 0, 0, 0));
	}

	public TombstoneClient tombstoneClientCenyRozszerzone() {
		return new TombstoneClient("n1", new CenyClient(500, 600, 600, 600, 700, "rozszerzona"), new Grubosci(5, 5, 5, 6), new Wymiary(30, 120, 250, 30, 5, 2,
				15, 15, 25), new Wykonczenia("proste", "proste", "proste", "proste", 0, 0, 0, 0));
	}

	public TombstoneSerwer tombstoneSerwerCenaPodstawowa() {
		return new TombstoneSerwer("n1", new CenySerwer(500, 500, 500, 500), new Grubosci(5, 5, 5, 6), new Wymiary(30, 120, 250, 30, 5, 2, 15, 15, 25),
				new Wykonczenia("proste", "proste", "proste", "proste", 0, 0, 0, 0));
	}

	public TombstoneSerwer tombstoneSerwerCenyRozszerzone() {
		return new TombstoneSerwer("n1", new CenySerwer(600, 600, 600, 700), new Grubosci(5, 5, 5, 6), new Wymiary(30, 120, 250, 30, 5, 2, 15, 15, 25),
				new Wykonczenia("proste", "proste", "proste", "proste", 0, 0, 0, 0));
	}

	public TombstoneResult tombstoneResult() {
		return new TombstoneResult(5.512, 0.0, 0.0, 2756.0,  2.2, 1100.0,0.342, 171.0, 1.86, 930.0, 1.11, 555.0);
	}

}
