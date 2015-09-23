package pl.calc.business.rysowanie.wykonczenia;

import java.awt.Graphics2D;

public class WykonczenieElementuFaza extends WykonczenieElementu {

	@Override
	public void rysujTypWykonczenia(Graphics2D g, int gruboscElementu, int promien) {
		g.drawLine(X + gruboscElementu * 2 - promien, Y, X + gruboscElementu * 2, Y + promien);

	}

	@Override
	String getNazwa() {
		return "Faza";
	}

}
