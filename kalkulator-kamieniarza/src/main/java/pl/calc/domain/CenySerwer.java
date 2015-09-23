package pl.calc.domain;

import com.google.common.base.Objects;

public class CenySerwer {

	private int cenaOkladzin;
	private int cenaScian;
	private int cenaNakrywy;
	private int cenaGradusa;

	public CenySerwer(int cenaOkladzin, int cenaScian, int cenaNakrywy, int cenaGradusa) {
		super();
		this.cenaOkladzin = cenaOkladzin;
		this.cenaScian = cenaScian;
		this.cenaNakrywy = cenaNakrywy;
		this.cenaGradusa = cenaGradusa;
	}
	
	public int getCenaOkladzin() {
		return cenaOkladzin;
	}

	public void setCenaOkladzin(int cenaOkladzin) {
		this.cenaOkladzin = cenaOkladzin;
	}

	public int getCenaScian() {
		return cenaScian;
	}

	public void setCenaScian(int cenaScian) {
		this.cenaScian = cenaScian;
	}

	public int getCenaNakrywy() {
		return cenaNakrywy;
	}

	public void setCenaNakrywy(int cenaNakrywy) {
		this.cenaNakrywy = cenaNakrywy;
	}

	public int getCenaGradusa() {
		return cenaGradusa;
	}

	public void setCenaGradusa(int cenaGradusa) {
		this.cenaGradusa = cenaGradusa;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final CenySerwer other = (CenySerwer) obj;
		return  Objects.equal(this.cenaOkladzin, other.cenaOkladzin)
				&& Objects.equal(this.cenaScian, other.cenaScian) && Objects.equal(this.cenaNakrywy, other.cenaNakrywy)
				&& Objects.equal(this.cenaGradusa, other.cenaGradusa) ;

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.cenaOkladzin, this.cenaScian, this.cenaNakrywy, this.cenaGradusa);

	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("cenaOkladzin", cenaOkladzin)
				.add("cenaScian", cenaScian).add("cenaNakrywy", cenaNakrywy).add("cenaGradusa", cenaGradusa)
				.toString();

	}
}

