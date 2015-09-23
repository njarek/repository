package pl.calc.business.rysowanie.wykonczenia;

import java.awt.image.BufferedImage;

public interface Wykonczenie {

	public static final int X = 60;
	public static final int Y = 70;
	public static final float GRUBOSC_LINI_WYKONCZENIA = (float) 2.0;

	void rysujWykonczenie(String tytul, int gruboscElementu, BufferedImage image, int promien);
}
