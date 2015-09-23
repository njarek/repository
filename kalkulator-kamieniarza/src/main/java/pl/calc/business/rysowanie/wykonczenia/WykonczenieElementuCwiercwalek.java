package pl.calc.business.rysowanie.wykonczenia;

import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

public class WykonczenieElementuCwiercwalek extends WykonczenieElementu {

	@Override
	public void rysujTypWykonczenia(Graphics2D g, int gruboscElementu, int promien) {
		 QuadCurve2D c = new QuadCurve2D.Double((double) X + 2 * gruboscElementu - promien, (double) Y, (double) X + gruboscElementu * 2, (double) Y , (double) X + gruboscElementu * 2, (double) Y  + promien);
         g.draw(c);
		
	}

	@Override
	String getNazwa() {
		return "Ćwierćwałek";
	}

}
