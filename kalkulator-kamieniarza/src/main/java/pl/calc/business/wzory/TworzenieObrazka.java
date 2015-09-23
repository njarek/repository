package pl.calc.business.wzory;

import java.awt.image.BufferedImage;

import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.domain.WymiaryElementu;

public interface TworzenieObrazka {

	public static final int WYSOKOSC_OBRAZKA = 100;
	public static final int SZEROKOSC_OBRAZKA = 300;
	BufferedImage stworzObrazek(Rysowalne rysowalne, String tytul, WymiaryElementu wymiaryElementu);
}
