package pl.calc.business.wzory;

import java.util.logging.Logger;

import pl.calc.domain.Grubosci;
import pl.calc.domain.TombstoneSerwer;
import pl.calc.domain.Wymiary;
import pl.calc.domain.obliczenia.WynikiObliczenNakrywaGradus;
import pl.calc.domain.obliczenia.WynikiObliczenOkladzin;
import pl.calc.domain.obliczenia.WynikiObliczenPola;
import pl.calc.domain.obliczenia.WynikiObliczenScian;

public class ObliczPolePodstawowe implements ObliczPole {

	private static final Logger log = Logger.getLogger(ObliczPolePodstawowe.class.getName());
	@Override
	public WynikiObliczenPola oblicz(TombstoneSerwer tombstoneSerwer) {

		Wymiary wymiary = tombstoneSerwer.getWymiary();
		Grubosci grubosci = tombstoneSerwer.getGrubosci();

		int dlugoscDlugichOkladzin = wymiary.getDlugosc() - wymiary.getSzerokoscPrzedniejOkladziny() - wymiary.getSzerokoscTylnejOkladziny();
		int polePrzednieOkladziny = wymiary.getSzerokosc() * wymiary.getSzerokoscPrzedniejOkladziny();
		int poleTylnejOkladziny = wymiary.getSzerokosc() * wymiary.getSzerokoscTylnejOkladziny();
		int poleDlugiejOkladziny = dlugoscDlugichOkladzin * wymiary.getSzerokoscDlugichOkladzin();
		int poleOkladzin = polePrzednieOkladziny + poleTylnejOkladziny + 2 * poleDlugiejOkladziny;
		WynikiObliczenOkladzin wynikiObliczenOkladzin = new WynikiObliczenOkladzin(dlugoscDlugichOkladzin, polePrzednieOkladziny, poleTylnejOkladziny,
				poleDlugiejOkladziny, poleOkladzin);
		
		log.info("Pole przedniej okladziny: "+polePrzednieOkladziny+" Pole tylnej okldziny: "+poleTylnejOkladziny+" Pole"
				+ " dlugich okladzin :"+ poleDlugiejOkladziny + "Pole Okladzin: "+poleOkladzin);
		 

		int dlugoscScianDlugich = dlugoscDlugichOkladzin;
		int dlugoscScianKrotkich = (wymiary.getSzerokosc() - wymiary.getSzerokoscDlugichOkladzin() * 2) + 2 * grubosci.getGruboscScian();
		System.out.println(wymiary.getSzerokosc() + " "+wymiary.getSzerokoscDlugichOkladzin() +" "+ grubosci.getGruboscScian());
		int poleScianDlugich = dlugoscScianDlugich * wymiary.getWysokosc();
		int poleScianKrotkich = dlugoscScianKrotkich * wymiary.getWysokosc();
		int poleScian = 2 * poleScianDlugich + 2 * poleScianKrotkich;
		WynikiObliczenScian wynikiObliczenScian = new WynikiObliczenScian(dlugoscScianDlugich, dlugoscScianKrotkich, poleScianDlugich, poleScianKrotkich,
				poleScian);
		
		log.info("dlugoscScianDlugich: "+dlugoscScianDlugich+" dlugoscScianKrotkich: "+dlugoscScianKrotkich
				+ " poleScianDlugich :"+ poleScianDlugich + "poleScianKrotkich: "+poleScianKrotkich+" poleScian: "+poleScian);

		int dlugoscGradusa = dlugoscScianKrotkich + 2 * wymiary.getOkap() + 2 * wymiary.getWypustGradusa();
		int poleGradusa = dlugoscGradusa * wymiary.getSzerokoscGradusa();

		int dlugoscNakrywy = (dlugoscScianDlugich + 2 * grubosci.getGruboscScian() + 2 * wymiary.getOkap()) - wymiary.getSzerokoscGradusa();
		int szerokoscNakrywy = dlugoscScianKrotkich + 2 * wymiary.getOkap();
		int poleNakrywy = dlugoscNakrywy * szerokoscNakrywy;

		int poleNagrobka = poleOkladzin + poleScian + poleGradusa + poleNakrywy;
		WynikiObliczenNakrywaGradus wynikiObliczenNakrywaGradus = new WynikiObliczenNakrywaGradus(dlugoscGradusa, poleGradusa, dlugoscNakrywy,
				szerokoscNakrywy, poleNakrywy, poleNagrobka);
		return new WynikiObliczenPola(wynikiObliczenNakrywaGradus, wynikiObliczenOkladzin, wynikiObliczenScian);
	}

}
