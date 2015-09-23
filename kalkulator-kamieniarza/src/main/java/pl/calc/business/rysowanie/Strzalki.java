package pl.calc.business.rysowanie;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import pl.calc.business.rysowanie.wykonczenia.Wykonczenie;

public enum Strzalki {

	INST;

	public void rysujStrzalkepoziom(Graphics2D graphic, int x1, int y1, int x2, int y2, int wymiar) {

		if (wymiar < 10) {
			rysujStrzalkeBezGrotow(graphic, x1, y1, x2, y2);
		} else {
			rysujStrzalkeBezGrotow(graphic, x1, y1, x2, y2);
			graphic.drawLine(x1, y1, x1 + 5, y1 - 5);
			graphic.drawLine(x1, y1, x1 + 5, y1 + 5);
			graphic.drawLine(x2, y2, x2 - 5, y2 - 5);
			graphic.drawLine(x2, y2, x2 - 5, y2 + 5);
		}
		graphic.drawString(wymiar + "", x1 + (x2 - x1) / 2 - 10, y1 - 5);

	}

	public void rysujStrzalkePionNapisPoPrawej(Graphics2D graphic, int x1, int y1, int x2, int y2, int wymiar) {

		if (wymiar < 10) {
			rysujStrzalkeBezGrotow(graphic, x1, y1, x2, y2);
		} else {
			rysujStrzalkeBezGrotow(graphic, x1, y1, x2, y2);
			rysojGroty(graphic, x1, y1, x2, y2);
		}
		graphic.drawString(wymiar + "", x2 + 10, Wykonczenie.Y + (y2 - Wykonczenie.Y) / 2);

	}

	public void rysujStrzalkePionNapisPoLewej(Graphics2D graphic, int x1, int y1, int x2, int y2, int wymiar) {

		if (wymiar < 10) {
			rysujStrzalkeBezGrotow(graphic, x1, y1, x2, y2);
		} else {
			rysujStrzalkeBezGrotow(graphic, x1, y1, x2, y2);
			rysojGroty(graphic, x1, y1, x2, y2);
		}
		graphic.drawString(wymiar + "", x2 - 30, Wykonczenie.Y + (y2 - Wykonczenie.Y) / 2);
	}

	private void rysujStrzalkeBezGrotow(Graphics2D graphic, int x1, int y1, int x2, int y2) {
		graphic.setStroke(new BasicStroke((float) 1.0));
		graphic.drawLine(x1, y1, x2, y2);
	}

	private void rysojGroty(Graphics2D graphic, int x1, int y1, int x2, int y2) {
		graphic.drawLine(x1, y1, x1 - 5, y1 + 5);
		graphic.drawLine(x1, y1, x1 + 5, y1 + 5);
		graphic.drawLine(x2, y2, x2 - 5, y2 - 5);
		graphic.drawLine(x2, y2, x2 + 5, y2 - 5);
	}
}
