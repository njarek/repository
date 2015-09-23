package pl.calc.business.rysowanie.wykonczenia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import pl.calc.business.rysowanie.Strzalki;

public abstract class WykonczenieElementu implements Wykonczenie {

	@Override
	public void rysujWykonczenie(String tytul, int gruboscElementu, BufferedImage image, int promien) {

		Graphics2D g = createGraphic(image);

		g.drawString("Wykończenie " + tytul + ": " + getNazwa(), X - 20, Y - 30);

		rysujLewaPionowaLinie(gruboscElementu, g);

		rysujGornaLinie(gruboscElementu, promien, g);

		rysujWykonczenie(gruboscElementu, promien, g);

		rysujPrawaPionowa(gruboscElementu, promien, g);

		rysujDolnaLinie(gruboscElementu, g);

		rysujWymiarowanie(gruboscElementu, promien, g);
	}

	private Graphics2D createGraphic(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setBackground(Color.white);
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(GRUBOSC_LINI_WYKONCZENIA));
		return g;
	}
	private void rysujLewaPionowaLinie(int gruboscElementu, Graphics2D g) {
		g.drawLine(X, Y, X, Y + gruboscElementu);
	}
	private void rysujGornaLinie(int gruboscElementu, int promien, Graphics2D g) {
		g.drawLine(X, Y, X + gruboscElementu * 2 - promien, Y);
	}

	private void rysujWykonczenie(int gruboscElementu, int promien, Graphics2D g) {
		rysujTypWykonczenia(g, gruboscElementu, promien);
	}

	private void rysujPrawaPionowa(int gruboscElementu, int promien, Graphics2D g) {
		g.drawLine(X + gruboscElementu * 2, Y + promien, X + gruboscElementu * 2, Y + gruboscElementu);
	}
	private void rysujDolnaLinie(int gruboscElementu, Graphics2D g) {
		g.drawLine(X + gruboscElementu * 2, Y + gruboscElementu, X, Y + gruboscElementu);
	}

	private void rysujWymiarowanie(int gruboscElementu, int promien, Graphics2D g) {
		Strzalki strzalki = Strzalki.INST;
		strzalki.rysujStrzalkepoziom(g,X + gruboscElementu * 2 - promien, Y - 10, X + gruboscElementu * 2, Y - 10, promien / 10);
		strzalki.rysujStrzalkePionNapisPoPrawej(g,X + gruboscElementu * 2 + 10, Y, X + gruboscElementu * 2 + 10, Y + promien, promien / 10);
	}

	abstract String getNazwa();

	public abstract void rysujTypWykonczenia(Graphics2D g, int gruboscElementu, int promien);

}
