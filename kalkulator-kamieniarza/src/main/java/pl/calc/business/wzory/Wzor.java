package pl.calc.business.wzory;

import java.util.Map;

import pl.calc.business.ObrobkaElementu;
import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.domain.TombstoneSerwer;
import pl.calc.domain.WymiaryElementu;
import pl.calc.domain.obliczenia.WynikiObliczenPola;

public interface Wzor {

	Map<String, Rysowalne> getMapaRysonkow(String wykonczenieNakrywy, String wykonczenieOkladzin);

	Map<String, WymiaryElementu> getMapaWymiarow(TombstoneSerwer tombstoneSerwer, WynikiObliczenPola wynikiObliczenPola, ObrobkaElementu obrobkaNakrywy,
			ObrobkaElementu obrobkaOkladzin);
}
