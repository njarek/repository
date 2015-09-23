package pl.calc.business.wzory;

import java.util.Map;

import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;

public interface Okladziny {

	Map<String, Rysowalne> rysujOkladziny(String wykonczenieOkladziny);
	
}
