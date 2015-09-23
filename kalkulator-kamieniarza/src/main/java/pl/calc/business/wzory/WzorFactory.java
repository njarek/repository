package pl.calc.business.wzory;

public class WzorFactory {

	public Wzor getWzorRysowania(String wzor) {

		switch (wzor) {
		case "n1":
			return new WzorN1();
		}

		return null;
	}
}
