package pl.calc.business.rysowanie.elementy.podstawowe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import pl.calc.business.rysowanie.Strzalki;
import pl.calc.domain.WymiaryElementu;

public class RysujProstokat implements Rysowalne {

	@Override
	public void rysuj(String tytul, BufferedImage image, WymiaryElementu wymiaryElementu) {

		int dlugosc = wymiaryElementu.getDlugosc();
		int szerokosc = wymiaryElementu.getSzerokosc();
		int grubosc = wymiaryElementu.getGrubosc();
		float gruboscPedzla1 = wymiaryElementu.getGruboscPedzla1();
		float gruboscPedzla2 = wymiaryElementu.getGruboscPedzla2();

		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setBackground(Color.white);
		g.setColor(Color.BLACK);

		g.drawString(tytul + " ,gruboÅ›Ä‡ stosowanej pÅ‚yty " + grubosc, X - 20, Y - 30);
		g.setStroke(new BasicStroke(gruboscPedzla1));
		g.drawLine(X, Y, X, Y + szerokosc);

		g.setStroke(new BasicStroke(gruboscPedzla2));

		g.drawLine(X, Y, X + dlugosc, Y);

		g.setStroke(new BasicStroke(gruboscPedzla2));
		g.drawLine(X + dlugosc, Y, X + dlugosc, Y + szerokosc);

		g.setStroke(new BasicStroke(gruboscPedzla2));
		g.drawLine(X + dlugosc, Y + szerokosc, X, Y + szerokosc);

		Strzalki strzalki = Strzalki.INST;
		strzalki.rysujStrzalkepoziom(g, X, Y - 10, X + dlugosc, Y - 10, dlugosc);
		strzalki.rysujStrzalkePionNapisPoLewej(g, X - 10, Y, X - 10, Y + szerokosc, szerokosc);

	}

}
