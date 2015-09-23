package pl.calc.domain;

import com.google.common.base.Objects;

public class Wymiary {

	private int wysokosc;
	private int szerokosc;
	private int dlugosc;
	private int szerokoscGradusa;
	private int okap;
	private int wypustGradusa;
	private int szerokoscDlugichOkladzin;
	private int szerokoscTylnejOkladziny;
	private int szerokoscPrzedniejOkladziny;
	
	public Wymiary(){
		
	}
	
	public Wymiary(int wysokosc, int szerokosc, int dlugosc, int szerokoscGradusa, int okap, int wypustGradusa,
			int szerokoscDlugichOkladzin, int szerokoscTylnejOkladziny, int szerokoscPrzedniejOkladziny) {
		super();
		this.wysokosc = wysokosc;
		this.szerokosc = szerokosc;
		this.dlugosc = dlugosc;
		this.szerokoscGradusa = szerokoscGradusa;
		this.okap = okap;
		this.wypustGradusa = wypustGradusa;
		this.szerokoscDlugichOkladzin = szerokoscDlugichOkladzin;
		this.szerokoscTylnejOkladziny = szerokoscTylnejOkladziny;
		this.szerokoscPrzedniejOkladziny = szerokoscPrzedniejOkladziny;
	}
	
	public int getWysokosc() {
		return wysokosc;
	}

	public void setWysokosc(int wysokosc) {
		this.wysokosc = wysokosc;
	}

	public int getSzerokosc() {
		return szerokosc;
	}

	public void setSzerokosc(int szerokosc) {
		this.szerokosc = szerokosc;
	}

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public int getSzerokoscGradusa() {
		return szerokoscGradusa;
	}

	public void setSzerokoscGradusa(int szerokoscGradusa) {
		this.szerokoscGradusa = szerokoscGradusa;
	}

	public int getOkap() {
		return okap;
	}

	public void setOkap(int okap) {
		this.okap = okap;
	}

	public int getWypustGradusa() {
		return wypustGradusa;
	}

	public void setWypustGradusa(int wypustGradusa) {
		this.wypustGradusa = wypustGradusa;
	}

	public int getSzerokoscDlugichOkladzin() {
		return szerokoscDlugichOkladzin;
	}

	public void setSzerokoscDlugichOkladzin(int szerokoscDlugichOkladzin) {
		this.szerokoscDlugichOkladzin = szerokoscDlugichOkladzin;
	}

	public int getSzerokoscTylnejOkladziny() {
		return szerokoscTylnejOkladziny;
	}

	public void setSzerokoscTylnejOkladziny(int szerokoscTylnejOkladziny) {
		this.szerokoscTylnejOkladziny = szerokoscTylnejOkladziny;
	}

	public int getSzerokoscPrzedniejOkladziny() {
		return szerokoscPrzedniejOkladziny;
	}

	public void setSzerokoscPrzedniejOkladziny(int szerokoscPrzedniejOkladziny) {
		this.szerokoscPrzedniejOkladziny = szerokoscPrzedniejOkladziny;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Wymiary other = (Wymiary) obj;
		return Objects.equal(this.wysokosc, other.wysokosc) 
				&& Objects.equal(this.szerokosc, other.szerokosc)
				&& Objects.equal(this.dlugosc, other.dlugosc) 
				&& Objects.equal(this.szerokoscGradusa, other.szerokoscGradusa)
				&& Objects.equal(this.okap, other.okap) 
				&& Objects.equal(this.wypustGradusa, other.wypustGradusa)
				&& Objects.equal(this.szerokoscDlugichOkladzin, other.szerokoscDlugichOkladzin)
				&& Objects.equal(this.szerokoscTylnejOkladziny, other.szerokoscTylnejOkladziny) 
				&& Objects.equal(this.szerokoscPrzedniejOkladziny, other.szerokoscPrzedniejOkladziny)
				;

	}

	@Override
	public int hashCode() {

		return Objects.hashCode(this.wysokosc, this.szerokosc, this.dlugosc, this.szerokoscGradusa, this.okap, this.wypustGradusa,this.szerokoscDlugichOkladzin,this.szerokoscPrzedniejOkladziny,this.szerokoscTylnejOkladziny);

	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("wysokosc", wysokosc).add("szerokosc", szerokosc)
				.add("dlugosc", dlugosc).add("szerokoscGradusa", szerokoscGradusa).add("okap", okap).add("wypustGradusa", wypustGradusa)
				.add("szerokoscDlugichOkladzin", szerokoscDlugichOkladzin).add("szerokoscTylnejOkladziny", szerokoscTylnejOkladziny).add("szerokoscPrzedniejOkladziny", szerokoscPrzedniejOkladziny)
				.toString();
	}
}
