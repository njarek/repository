package pl.calc.business;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import pl.calc.business.rysowanie.wykonczenia.Wykonczenie;
import pl.calc.business.rysowanie.wykonczenia.WykonczenieElementuCwiercwalek;
import pl.calc.business.rysowanie.wykonczenia.WykonczenieElementuFaza;
import pl.calc.business.rysowanie.wykonczenia.WykonczenieInne;

public enum ObrobkaElementu {

	PROSTE("proste", 0, 2.0f), CW1("cw1", 1, 5.0f), CW2("cw2", 2, 5.0f),CW3("cw3", 3, 5.0f);

	private static final float DRUBOSC_PEDZLA_NIE_OBRABIANYCH_POWIERZCHNI = 2.0f;
	private static final float GRUBOSC_PEDZLA_OBRABIANYCH_POWIERZCHNI = 5.0f;
	private static final int WYSOKOSC_OBRAZKA = 100;
	private static final int SZEROKOSC_OBRAZKA = 300;

	private String wykonczenie;
	private String tytul = "Nakrywy i gradusa";

	private float gruboscPedzlaObrabianychPowierzchni;
	private int promien;
	private int grubosc = 0;
	private String typ;

	public static final Map<String, ObrobkaElementu> MAP = new HashMap<>();

	static {
		MAP.put("proste", PROSTE);
		MAP.put("cw1", CW1);
		MAP.put("cw2", CW2);
		MAP.put("cw3", CW3);
	}

	public void rysujWykonczenie(int grubosc, String sessionId,List<BufferedImage> listaObrazkow) {
		BufferedImage image = new BufferedImage(SZEROKOSC_OBRAZKA + grubosc * 10, WYSOKOSC_OBRAZKA + grubosc * 10,
				BufferedImage.TYPE_INT_ARGB);
		getWykonczenie(typ).rysujWykonczenie(tytul, grubosc * 10, image, promien * 10);
		listaObrazkow.add(image);
	}

	private Wykonczenie getWykonczenie(String typ) {
		switch (typ) {
		case "pr":
			return new WykonczenieElementuFaza();
		case "fa":
			return new WykonczenieElementuFaza();
		case "cw":
			return new WykonczenieElementuCwiercwalek();
		case "in":
			return new WykonczenieInne();
		}
		return null;
	}

	private ObrobkaElementu(String wykonczenie, int promien, float gruboscPedzlaObrabianychPowierzchni) {
		this.wykonczenie = wykonczenie;
		this.promien = promien;
		this.gruboscPedzlaObrabianychPowierzchni = gruboscPedzlaObrabianychPowierzchni;
		this.typ = wykonczenie.substring(0, 2);
	}

	public String getWykonczenie() {
		return wykonczenie;
	}

	public static ObrobkaElementu getWykoczenieNakrywy(String wykonczenie) {
		return MAP.get(wykonczenie);
	}

	public int getPromien() {
		return promien;
	}

	public int getGrubosc() {
		return grubosc;
	}

	public void setGrubosc(int grubosc) {
		this.grubosc = grubosc;
	}

	public float getGruboscPedzlaObrabianychNiePowierzchni(int szerokoscGradusa) {

		return szerokoscGradusa == 0 && !(typ.endsWith("pr")) ? GRUBOSC_PEDZLA_OBRABIANYCH_POWIERZCHNI
				: DRUBOSC_PEDZLA_NIE_OBRABIANYCH_POWIERZCHNI;
	}

	public float getGruboscPedzlaObrabianychPowierzchni() {
		return gruboscPedzlaObrabianychPowierzchni;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	
	public static void main(String[] args) {
		List<BufferedImage> list=new ArrayList<>();
		ObrobkaElementu elementu= ObrobkaElementu.getWykoczenieNakrywy("cw3");
		elementu.rysujWykonczenie(15, "elo", list);
		
		for (BufferedImage image:list){
			try {
	            ImageIO.write(image, "png", new File("elo.png"));
	        } catch (IOException e) {
	          


	        }
		}
	}

}
