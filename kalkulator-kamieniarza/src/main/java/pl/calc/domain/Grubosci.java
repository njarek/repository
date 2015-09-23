package pl.calc.domain;

import com.google.common.base.Objects;

public class Grubosci {

	private int gruboscOkladzin;
	private int gruboscScian;
	private int gruboscNakrywy;
	private int gruboscGradusa;
	
	public Grubosci() {	
	}

	public Grubosci(int gruboscOkladzin, int gruboscScian, int gruboscNakrywy, int gruboscGradusa) {
		super();
		this.gruboscOkladzin = gruboscOkladzin;
		this.gruboscScian = gruboscScian;
		this.gruboscNakrywy = gruboscNakrywy;
		this.gruboscGradusa = gruboscGradusa;
	}

	public int getGruboscOkladzin() {
		return gruboscOkladzin;
	}

	public void setGruboscOkladzin(int gruboscOkladzin) {
		this.gruboscOkladzin = gruboscOkladzin;
	}

	public int getGruboscScian() {
		return gruboscScian;
	}

	public void setGruboscScian(int gruboscScian) {
		this.gruboscScian = gruboscScian;
	}

	public int getGruboscNakrywy() {
		return gruboscNakrywy;
	}

	public void setGruboscNakrywy(int gruboscNakrywy) {
		this.gruboscNakrywy = gruboscNakrywy;
	}

	public int getGruboscGradusa() {
		return gruboscGradusa;
	}

	public void setGruboscGradusa(int gruboscGradusa) {
		this.gruboscGradusa = gruboscGradusa;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Grubosci other = (Grubosci) obj;
		return Objects.equal(this.gruboscOkladzin, other.gruboscOkladzin) && Objects.equal(this.gruboscScian, other.gruboscScian)
				&& Objects.equal(this.gruboscNakrywy, other.gruboscNakrywy) && Objects.equal(this.gruboscGradusa, other.gruboscGradusa);

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.gruboscOkladzin, this.gruboscScian, this.gruboscNakrywy, this.gruboscGradusa);

	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("gruboscOkladzin", gruboscOkladzin).add("gruboscScian", gruboscScian).add("gruboscNakrywy", gruboscNakrywy)
				.add("gruboscGradusa", gruboscGradusa).toString();

	}
}
