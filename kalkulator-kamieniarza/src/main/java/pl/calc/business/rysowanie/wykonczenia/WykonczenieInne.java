package pl.calc.business.rysowanie.wykonczenia;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class WykonczenieInne implements Wykonczenie {

	@Override
	public void rysujWykonczenie(String tytul, int gruboscElementu, BufferedImage image, int promien) {
		// image = new BufferedImage(300, 80, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setBackground(Color.white);
		g.setColor(Color.BLACK);
		g.drawString("Wykończenie " + tytul + "ne: ...................", X - 20, Y - 30);

	}

}
