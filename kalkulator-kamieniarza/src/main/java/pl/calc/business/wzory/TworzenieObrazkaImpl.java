package pl.calc.business.wzory;

import java.awt.image.BufferedImage;

import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.domain.WymiaryElementu;

public class TworzenieObrazkaImpl implements TworzenieObrazka{

	@Override
	public BufferedImage stworzObrazek(Rysowalne rysowalne, String tytul, WymiaryElementu wymiaryElementu) {
		
		BufferedImage obrazek = new BufferedImage( SZEROKOSC_OBRAZKA+ wymiaryElementu.getSzerokosc(), WYSOKOSC_OBRAZKA + wymiaryElementu.getDlugosc(), BufferedImage.TYPE_INT_ARGB);
		rysowalne.rysuj(tytul, obrazek, wymiaryElementu);
		return obrazek;
		
	}

}
