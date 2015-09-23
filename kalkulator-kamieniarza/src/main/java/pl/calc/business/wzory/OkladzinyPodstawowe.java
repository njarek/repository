package pl.calc.business.wzory;

import java.util.HashMap;
import java.util.Map;

import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.business.rysowanie.elementy.podstawowe.RysujProstokat;

public class OkladzinyPodstawowe implements Okladziny {

	@Override
	public Map<String, Rysowalne> rysujOkladziny(String wykonczenieOkladziny) {
		Map<String,Rysowalne> rysowalnes = new HashMap<>();
		rysowalnes.put("Okladzina Prawa", new RysujProstokat());
		rysowalnes.put("Okladzina Lewa", new RysujProstokat());	
		getElementByWykonczenie(wykonczenieOkladziny, rysowalnes,"Okladzina Przednia");	
		rysowalnes.put("Okladzina Tylna", new RysujProstokat());
		return rysowalnes;
	}

	private void getElementByWykonczenie(String wykonczenie, Map<String, Rysowalne> rysowalnes,String tytul) {
		switch(wykonczenie){
		case "proste":
			rysowalnes.put(tytul, new RysujProstokat());
			break;
		case "luk":
			;
			break;
		case "fala":
			;
			break;
			
		}
	}
}
