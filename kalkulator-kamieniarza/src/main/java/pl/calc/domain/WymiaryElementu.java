package pl.calc.domain;

import com.google.common.base.Objects;

public class WymiaryElementu {

	private int dlugosc;
	private int szerokosc;
	private int grubosc;
	private float gruboscPedzla1;
	private float gruboscPedzla2;

	public WymiaryElementu(int dlugosc, int szerokosc, int grubosc, float gruboscPedzla1, float gruboscPedzla2) {
		super();
		this.dlugosc = dlugosc;
		this.szerokosc = szerokosc;
		this.grubosc = grubosc;
		this.gruboscPedzla1 = gruboscPedzla1;
		this.gruboscPedzla2 = gruboscPedzla2;
	}

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public int getSzerokosc() {
		return szerokosc;
	}

	public void setSzerokosc(int szerokosc) {
		this.szerokosc = szerokosc;
	}

	public int getGrubosc() {
		return grubosc;
	}

	public void setGrubosc(int grubosc) {
		this.grubosc = grubosc;
	}

	public float getGruboscPedzla1() {
		return gruboscPedzla1;
	}

	public void setGruboscPedzla1(float gruboscPedzla1) {
		this.gruboscPedzla1 = gruboscPedzla1;
	}

	public float getGruboscPedzla2() {
		return gruboscPedzla2;
	}

	public void setGruboscPedzla2(float gruboscPedzla2) {
		this.gruboscPedzla2 = gruboscPedzla2;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final WymiaryElementu other = (WymiaryElementu) obj;
		return Objects.equal(this.dlugosc, other.dlugosc) && Objects.equal(this.szerokosc, other.szerokosc) && Objects.equal(this.grubosc, other.grubosc)
				&& Objects.equal(this.gruboscPedzla1, other.gruboscPedzla1) && Objects.equal(this.gruboscPedzla2, other.gruboscPedzla2);

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.dlugosc, this.szerokosc, this.grubosc, this.gruboscPedzla1, this.gruboscPedzla2);

	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("dlugosc", dlugosc).add("szerokosc", szerokosc).add("grubosc", grubosc).add("gruboscPedzla1", gruboscPedzla1)
				.add("gruboscPedzla2", gruboscPedzla2).toString();

	}
}
