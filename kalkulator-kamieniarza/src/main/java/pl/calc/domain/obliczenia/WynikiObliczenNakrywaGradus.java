package pl.calc.domain.obliczenia;

import com.google.common.base.Objects;

public class WynikiObliczenNakrywaGradus {

	private int dlugoscGradusa;
	private int poleGradusa;
	private int dlugoscNakrywy;
	private int szerokoscNakrywy;
	private int poleNakrywy;
	private int poleNagrobka;

	public WynikiObliczenNakrywaGradus(int dlugoscGradusa, int poleGradusa, int dlugoscNakrywy, int szerokoscNakrywy, int poleNakrywy, int poleNagrobka) {
		super();
		this.dlugoscGradusa = dlugoscGradusa;
		this.poleGradusa = poleGradusa;
		this.dlugoscNakrywy = dlugoscNakrywy;
		this.szerokoscNakrywy = szerokoscNakrywy;
		this.poleNakrywy = poleNakrywy;
		this.poleNagrobka = poleNagrobka;
	}

	public int getDlugoscGradusa() {
		return dlugoscGradusa;
	}

	public void setDlugoscGradusa(int dlugoscGradusa) {
		this.dlugoscGradusa = dlugoscGradusa;
	}

	public int getPoleGradusa() {
		return poleGradusa;
	}

	public void setPoleGradusa(int poleGradusa) {
		this.poleGradusa = poleGradusa;
	}

	public int getDlugoscNakrywy() {
		return dlugoscNakrywy;
	}

	public void setDlugoscNakrywy(int dlugoscNakrywy) {
		this.dlugoscNakrywy = dlugoscNakrywy;
	}

	public int getSzerokoscNakrywy() {
		return szerokoscNakrywy;
	}

	public void setSzerokoscNakrywy(int szerokoscNakrywy) {
		this.szerokoscNakrywy = szerokoscNakrywy;
	}

	public int getPoleNakrywy() {
		return poleNakrywy;
	}

	public void setPoleNakrywy(int poleNakrywy) {
		this.poleNakrywy = poleNakrywy;
	}

	public int getPoleNagrobka() {
		return poleNagrobka;
	}

	public void setPoleNagrobka(int poleNagrobka) {
		this.poleNagrobka = poleNagrobka;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final WynikiObliczenNakrywaGradus other = (WynikiObliczenNakrywaGradus) obj;
		return Objects.equal(this.dlugoscGradusa, other.dlugoscGradusa) && Objects.equal(this.poleGradusa, other.poleGradusa)
				&& Objects.equal(this.dlugoscNakrywy, other.dlugoscNakrywy) && Objects.equal(this.szerokoscNakrywy, other.szerokoscNakrywy)
				&& Objects.equal(this.poleNakrywy, other.poleNakrywy) && Objects.equal(this.poleNagrobka, other.poleNagrobka);

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.dlugoscGradusa, this.poleGradusa, this.dlugoscNakrywy, this.szerokoscNakrywy, this.poleNakrywy, this.poleNagrobka);
	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("dlugoscGradusa", dlugoscGradusa).add("poleGradusa", poleGradusa).add("dlugoscNakrywy", dlugoscNakrywy)
				.add("szerokoscNakrywy", szerokoscNakrywy).add("poleNakrywy", poleNakrywy).add("poleNagrobka", poleNagrobka).toString();
	}
}
