package pl.calc.domain.obliczenia;

import com.google.common.base.Objects;

public class WynikiObliczenOkladzin {

	private int dlugoscDlugichOkladzin;
	private int polePrzednieOkladziny;
	private int poleTylnejOkladziny;
	private int poleDlugiejOkladziny;
	private int poleOkladzin;

	public WynikiObliczenOkladzin(int dlugoscDlugichOkladzin, int polePrzednieOkladziny, int poleTylnejOkladziny, int poleDlugiejOkladziny, int poleOkladzin) {
		super();
		this.dlugoscDlugichOkladzin = dlugoscDlugichOkladzin;
		this.polePrzednieOkladziny = polePrzednieOkladziny;
		this.poleTylnejOkladziny = poleTylnejOkladziny;
		this.poleDlugiejOkladziny = poleDlugiejOkladziny;
		this.poleOkladzin = poleOkladzin;
	}

	public int getDlugoscDlugichOkladzin() {
		return dlugoscDlugichOkladzin;
	}

	public void setDlugoscDlugichOkladzin(int dlugoscDlugichOkladzin) {
		this.dlugoscDlugichOkladzin = dlugoscDlugichOkladzin;
	}

	public int getPolePrzednieOkladziny() {
		return polePrzednieOkladziny;
	}

	public void setPolePrzednieOkladziny(int polePrzednieOkladziny) {
		this.polePrzednieOkladziny = polePrzednieOkladziny;
	}

	public int getPoleTylnejOkladziny() {
		return poleTylnejOkladziny;
	}

	public void setPoleTylnejOkladziny(int poleTylnejOkladziny) {
		this.poleTylnejOkladziny = poleTylnejOkladziny;
	}

	public int getPoleDlugiejOkladziny() {
		return poleDlugiejOkladziny;
	}

	public void setPoleDlugiejOkladziny(int poleDlugiejOkladziny) {
		this.poleDlugiejOkladziny = poleDlugiejOkladziny;
	}

	public int getPoleOkladzin() {
		return poleOkladzin;
	}

	public void setPoleOkladzin(int poleOkladzin) {
		this.poleOkladzin = poleOkladzin;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final WynikiObliczenOkladzin other = (WynikiObliczenOkladzin) obj;
		return Objects.equal(this.dlugoscDlugichOkladzin, other.dlugoscDlugichOkladzin)
				&& Objects.equal(this.polePrzednieOkladziny, other.polePrzednieOkladziny) && Objects.equal(this.poleTylnejOkladziny, other.poleTylnejOkladziny)
				&& Objects.equal(this.poleDlugiejOkladziny, other.poleDlugiejOkladziny) && Objects.equal(this.poleOkladzin, other.poleOkladzin);

	}

	@Override
	public int hashCode() {
		return Objects
				.hashCode(this.dlugoscDlugichOkladzin, this.polePrzednieOkladziny, this.poleTylnejOkladziny, this.poleDlugiejOkladziny, this.poleOkladzin);
	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("dlugoscDlugichOkladzin", dlugoscDlugichOkladzin).add("polePrzednieOkladziny", polePrzednieOkladziny)
				.add("poleTylnejOkladziny", poleTylnejOkladziny).add("poleDlugiejOkladziny", poleDlugiejOkladziny).add("poleOkladzin", poleOkladzin).toString();
	}
}
