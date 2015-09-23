package pl.calc.business.wzory;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import pl.calc.business.rysowanie.elementy.podstawowe.Rysowalne;
import pl.calc.domain.WymiaryElementu;

public interface RysujElementy {



	List<BufferedImage> rysujElementy(Map<String, Rysowalne> mapaElementow, Map<String, WymiaryElementu> wymiaryElementow);

	
	
}
