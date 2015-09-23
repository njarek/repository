package pl.calc.business.rysowanie.elementy.podstawowe;

import java.awt.image.BufferedImage;

import pl.calc.domain.WymiaryElementu;

public interface Rysowalne {
	public static final int X = 60;
	public static final int Y = 70;
	void rysuj(String tytul, BufferedImage obrazek, WymiaryElementu wymiaryElementu);
}
