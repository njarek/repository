package pl.calc.domain;

import com.google.common.base.Objects;

public class CenyClient {

	private int cenaPodstawowa;
	private int cenaOkladzin;
	private int cenaScian;
	private int cenaNakrywy;
	private int cenaGradusa;
	private String typCeny;
	
	public CenyClient() {
		}

	public CenyClient(int cenaPodstawowa, int cenaOkladzin, int cenaScian, int cenaNakrywy, int cenaGradusa, String typCeny) {
		super();
		this.cenaPodstawowa = cenaPodstawowa;
		this.cenaOkladzin = cenaOkladzin;
		this.cenaScian = cenaScian;
		this.cenaNakrywy = cenaNakrywy;
		this.cenaGradusa = cenaGradusa;
		this.typCeny = typCeny;
	}
	
	public int getCenaPodstawowa() {
		return cenaPodstawowa;
	}

	public void setCenaPodstawowa(int cenaPodstawowa) {
		this.cenaPodstawowa = cenaPodstawowa;
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

	public String getTypCeny() {
		return typCeny;
	}

	public void setTypCeny(String typCeny) {
		this.typCeny = typCeny;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final CenyClient other = (CenyClient) obj;
		return Objects.equal(this.cenaPodstawowa, other.cenaPodstawowa) && Objects.equal(this.cenaOkladzin, other.cenaOkladzin)
				&& Objects.equal(this.cenaScian, other.cenaScian) && Objects.equal(this.cenaNakrywy, other.cenaNakrywy)
				&& Objects.equal(this.cenaGradusa, other.cenaGradusa) && Objects.equal(this.typCeny, other.typCeny);

	}

	@Override
	public int hashCode() {

		return Objects.hashCode(this.cenaPodstawowa, this.cenaOkladzin, this.cenaScian, this.cenaNakrywy, this.cenaGradusa, this.typCeny);

	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("cenaPodstawowa", cenaPodstawowa).add("cenaOkladzin", cenaOkladzin)
				.add("cenaScian", cenaScian).add("cenaNakrywy", cenaNakrywy).add("cenaGradusa", cenaGradusa).add("typCeny", typCeny)
				.toString();

	}
}
