package pl.calc.business.wzory;

import java.util.HashMap;
import java.util.Map;

import pl.calc.business.ObrobkaElementu;
import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.business.rysowanie.elementy.podstawowe.RysujProstokat;
import pl.calc.domain.Grubosci;
import pl.calc.domain.TombstoneSerwer;
import pl.calc.domain.Wymiary;
import pl.calc.domain.WymiaryElementu;
import pl.calc.domain.obliczenia.WynikiObliczenNakrywaGradus;
import pl.calc.domain.obliczenia.WynikiObliczenOkladzin;
import pl.calc.domain.obliczenia.WynikiObliczenPola;
import pl.calc.domain.obliczenia.WynikiObliczenScian;

public class WzorN1 implements Wzor {

	@Override
	public Map<String, Rysowalne> getMapaRysonkow(String wykonczenieNakrywy, String wykonczenieOkladzin) {
		Map<String, Rysowalne> rysowalnes = new HashMap<>();

		getElementByWykonczenie(wykonczenieNakrywy, rysowalnes, "Nakrywa");
		rysowalnes.put("Gradus", new RysujProstokat());
		rysowalnes.put("Sciana Lewa", new RysujProstokat());
		rysowalnes.put("Sciana Prawa", new RysujProstokat());
		rysowalnes.put("Sciana Przednia", new RysujProstokat());
		rysowalnes.put("Sciana Tylna", new RysujProstokat());
		Okladziny okladziny = new OkladzinyPodstawowe();
		rysowalnes.putAll(okladziny.rysujOkladziny(wykonczenieOkladzin));

		return rysowalnes;
	}

	@Override
	public Map<String, WymiaryElementu> getMapaWymiarow(TombstoneSerwer tombstoneSerwer, WynikiObliczenPola wynikiObliczenPola, ObrobkaElementu obrobkaNakrywy,
			ObrobkaElementu obrobkaOkladzin) {
		WynikiObliczenOkladzin wynikiObliczenOkladzin = wynikiObliczenPola.getWynikiObliczenOkladzin();
		WynikiObliczenScian wynikiObliczenScian = wynikiObliczenPola.getWynikiObliczenScian();
		WynikiObliczenNakrywaGradus wynikiObliczenNakrywaGradus = wynikiObliczenPola.getWynikiObliczenNakrywaGradus();
		Grubosci grubosci = tombstoneSerwer.getGrubosci();
		Wymiary wymiary = tombstoneSerwer.getWymiary();
		float gruboscPedzlaNakrywy1 = obrobkaNakrywy.getGruboscPedzlaObrabianychNiePowierzchni(wymiary.getSzerokoscGradusa());
		float gruboscPedzlaNakrywy2 = obrobkaNakrywy.getGruboscPedzlaObrabianychNiePowierzchni(wymiary.getSzerokoscGradusa());
		float gruboscPedzlaOkladzin1 = obrobkaOkladzin.getGruboscPedzlaObrabianychNiePowierzchni(wymiary.getSzerokoscGradusa());
		float gruboscPedzlaOkladzin2 = obrobkaOkladzin.getGruboscPedzlaObrabianychNiePowierzchni(wymiary.getSzerokoscGradusa());

		Map<String, WymiaryElementu> listaWymiaryElementow = new HashMap<>();
		listaWymiaryElementow.put(
				"Nakrywa",
				new WymiaryElementu(wynikiObliczenNakrywaGradus.getDlugoscNakrywy(), wynikiObliczenNakrywaGradus.getSzerokoscNakrywy(), grubosci
						.getGruboscNakrywy(), gruboscPedzlaNakrywy1, gruboscPedzlaNakrywy2));
		listaWymiaryElementow.put("Gradus", new WymiaryElementu(wynikiObliczenNakrywaGradus.getDlugoscGradusa(), wymiary.getSzerokoscGradusa(), grubosci.getGruboscGradusa(),
				gruboscPedzlaNakrywy1, gruboscPedzlaNakrywy2));
		listaWymiaryElementow.put("Sciana Lewa", new WymiaryElementu(wynikiObliczenScian.getDlugoscScianDlugich(), wymiary.getWysokosc(), grubosci.getGruboscScian(),
				gruboscPedzlaNakrywy1, gruboscPedzlaNakrywy2));
		listaWymiaryElementow.put("Sciana Prawa", new WymiaryElementu(wynikiObliczenScian.getDlugoscScianDlugich(), wymiary.getWysokosc(), grubosci.getGruboscScian(),
				gruboscPedzlaNakrywy1, gruboscPedzlaNakrywy2));
		listaWymiaryElementow.put("Sciana Przednia", new WymiaryElementu(wynikiObliczenScian.getDlugoscScianKrotkich(), wymiary.getWysokosc(), grubosci.getGruboscScian(),
				gruboscPedzlaNakrywy1, gruboscPedzlaNakrywy2));
		listaWymiaryElementow.put("Sciana Tylna", new WymiaryElementu(wynikiObliczenScian.getDlugoscScianKrotkich(), wymiary.getWysokosc(), grubosci.getGruboscScian(),
				gruboscPedzlaNakrywy1, gruboscPedzlaNakrywy2));
		listaWymiaryElementow.put("Okladzina Prawa",
				new WymiaryElementu(wynikiObliczenOkladzin.getDlugoscDlugichOkladzin(), wymiary.getSzerokoscDlugichOkladzin(), grubosci.getGruboscOkladzin(), gruboscPedzlaOkladzin1,
						gruboscPedzlaOkladzin2));
		listaWymiaryElementow.put("Okladzina Lewa",
				new WymiaryElementu(wynikiObliczenOkladzin.getDlugoscDlugichOkladzin(), wymiary.getSzerokoscDlugichOkladzin(), grubosci.getGruboscOkladzin(), gruboscPedzlaOkladzin1,
						gruboscPedzlaOkladzin2));
		listaWymiaryElementow.put("Okladzina Przednia",
				new WymiaryElementu(wymiary.getSzerokosc(), wymiary.getSzerokoscPrzedniejOkladziny(), grubosci.getGruboscOkladzin(), gruboscPedzlaOkladzin1,
						gruboscPedzlaOkladzin2));
		listaWymiaryElementow.put("Okladzina Tylna",
				new WymiaryElementu(wymiary.getSzerokosc(), wymiary.getSzerokoscTylnejOkladziny(), grubosci.getGruboscOkladzin(), gruboscPedzlaOkladzin1,
						gruboscPedzlaOkladzin2));
		return listaWymiaryElementow;
	}

	private void getElementByWykonczenie(String wykonczenieNakrywy, Map<String, Rysowalne> rysowalnes, String tytul) {
		switch (wykonczenieNakrywy) {
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
