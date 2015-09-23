package pl.calc.business.wzory;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.domain.WymiaryElementu;

public class RysujElementyNagrobeka implements RysujElementy {
	TworzenieObrazka tworzenieObrazka;

	public RysujElementyNagrobeka() {
		tworzenieObrazka = new TworzenieObrazkaImpl();

	}

	@Override
	public List<BufferedImage> rysujElementy(Map<String, Rysowalne> mapaElementow, Map<String,WymiaryElementu> wymiaryElementow) {

		Set<String> listaElementow = mapaElementow.keySet();
		List<BufferedImage> images = new ArrayList<>();
		for (String tytul : listaElementow) {
			Rysowalne rysowalne = mapaElementow.get(tytul);
			WymiaryElementu wymiaryElementu= wymiaryElementow.get(tytul);
			images.add(tworzenieObrazka.stworzObrazek(rysowalne, tytul, wymiaryElementu));
		}

		return images;
	}

}
