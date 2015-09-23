package pl.calc.business;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.business.wzory.ObliczPole;
import pl.calc.business.wzory.ObliczPolePodstawowe;
import pl.calc.business.wzory.WzorFactory;
import pl.calc.business.wzory.RysujElementy;
import pl.calc.business.wzory.RysujElementyNagrobeka;
import pl.calc.business.wzory.Wzor;
import pl.calc.domain.CenySerwer;
import pl.calc.domain.Grubosci;
import pl.calc.domain.TombstoneResult;
import pl.calc.domain.TombstoneSerwer;
import pl.calc.domain.Wykonczenia;
import pl.calc.domain.Wymiary;
import pl.calc.domain.WymiaryElementu;
import pl.calc.domain.obliczenia.WynikiObliczenPola;

public class GenerateResulImpl implements GenerateResul {

	@Override
	public TombstoneResult generate(TombstoneSerwer tombstoneSerwer) {

		CenySerwer cenySerwer = tombstoneSerwer.getCeny();
		Wymiary wymiary = tombstoneSerwer.getWymiary();
		Wykonczenia wykonczenia = tombstoneSerwer.getWykomczenia();
		Grubosci grubosci = tombstoneSerwer.getGrubosci();

		ObliczPole obliczPole = new ObliczPolePodstawowe();
		WynikiObliczenPola wynikiObliczenPola = obliczPole.oblicz(tombstoneSerwer);

//		ObrobkaElementu obrobkaNakrywy = ObrobkaElementu.getWykoczenieNakrywy(wykonczenia.getWykonczenieNakrywy());
//		ObrobkaElementu obrobkaOkladzin = ObrobkaElementu.getWykoczenieNakrywy(wykonczenia.getWykonczenieOkladzin());
//		obrobkaOkladzin.setTytul("Wykończenie Okładzin");

		

		WzorFactory factory = new WzorFactory();
		Wzor wzor = factory.getWzorRysowania(tombstoneSerwer.getWzor());
//		Map<String, Rysowalne> obrazki = wzor.getMapaRysonkow(wykonczenia.getProfilNakrywy(), wykonczenia.getProfilOkladzin());
//		Map<String, WymiaryElementu> listaWymiaryElementow = wzor.getMapaWymiarow(tombstoneSerwer, wynikiObliczenPola,obrobkaNakrywy,obrobkaOkladzin);
//		
//		RysujElementy elementy = new RysujElementyNagrobeka();
//		List<BufferedImage> images = elementy.rysujElementy(obrazki, listaWymiaryElementow);

		double zuzycie = (double)wynikiObliczenPola.getWynikiObliczenNakrywaGradus().getPoleNagrobka()  / 10000;
		double zuzycieNakrywa = (double)wynikiObliczenPola.getWynikiObliczenNakrywaGradus().getPoleNakrywy() / 10000;
		double zuzycieScian = (double) wynikiObliczenPola.getWynikiObliczenScian().getPoleScian() / 10000;
		double zuzycieGradus = (double) wynikiObliczenPola.getWynikiObliczenNakrywaGradus().getPoleGradusa() / 10000;
		double zuzycieOkladzin = (double) wynikiObliczenPola.getWynikiObliczenOkladzin().getPoleOkladzin() / 10000;

		double cenaNakrywa = zuzycieNakrywa * cenySerwer.getCenaNakrywy();
		double cenaGradus = zuzycieGradus * cenySerwer.getCenaGradusa();
		double cenaScian = zuzycieScian * cenySerwer.getCenaScian();
		double cenaOkladzin = zuzycieOkladzin * cenySerwer.getCenaOkladzin();

		double cena = cenaNakrywa + cenaGradus + cenaScian + cenaOkladzin;

		TombstoneResult tombstoneResult = new TombstoneResult(zuzycie, 0, 0, cena, zuzycieNakrywa, cenaNakrywa, zuzycieGradus, cenaGradus, zuzycieScian,
				cenaScian, zuzycieOkladzin, cenaOkladzin);

		return tombstoneResult;
	}

	private int getLuk(int szerokosc) {
		if (szerokosc >= 120) {
			return 6;
		} else if (szerokosc < 120 && szerokosc >= 100) {
			return 5;
		} else if (szerokosc < 100 && szerokosc >= 70) {
			return 4;
		} else if (szerokosc < 70) {
			return 3;
		}
		return 0;
	}

}
