package pl.calc.domain;

import com.google.common.base.Objects;

public class Wykonczenia {

	private String wykonczenieNakrywy;
	private String wykonczenieOkladzin;
	private String profilNakrywy;
	private String profilOkladzin;
	private int cenaWykonczenieNakrywy;
	private int cenaWykonczenieOkladzin;
	private int cenaProfilNakrywy;
	private int cenaProfilOkladzin;
	
	public Wykonczenia() {
	}

	public Wykonczenia(String wykonczenieNakrywy, String wykonczenieOkladzin, String profilNakrywy, String profilOkladzin,
			int cenaWykonczenieNakrywy, int cenaWykonczenieOkladzin, int cenaProfilNakrywy, int cenaProfilOkladzin) {
		super();
		this.wykonczenieNakrywy = wykonczenieNakrywy;
		this.wykonczenieOkladzin = wykonczenieOkladzin;
		this.profilNakrywy = profilNakrywy;
		this.profilOkladzin = profilOkladzin;
		this.cenaWykonczenieNakrywy = cenaWykonczenieNakrywy;
		this.cenaWykonczenieOkladzin = cenaWykonczenieOkladzin;
		this.cenaProfilNakrywy = cenaProfilNakrywy;
		this.cenaProfilOkladzin = cenaProfilOkladzin;
	}

	public String getWykonczenieNakrywy() {
		return wykonczenieNakrywy;
	}

	public void setWykonczenieNakrywy(String wykonczenieNakrywy) {
		this.wykonczenieNakrywy = wykonczenieNakrywy;
	}

	public String getWykonczenieOkladzin() {
		return wykonczenieOkladzin;
	}

	public void setWykonczenieOkladzin(String wykonczenieOkladzin) {
		this.wykonczenieOkladzin = wykonczenieOkladzin;
	}

	public String getProfilNakrywy() {
		return profilNakrywy;
	}

	public void setProfilNakrywy(String profilNakrywy) {
		this.profilNakrywy = profilNakrywy;
	}

	public String getProfilOkladzin() {
		return profilOkladzin;
	}

	public void setProfilOkladzin(String profilOkladzin) {
		this.profilOkladzin = profilOkladzin;
	}

	public int getCenaWykonczenieNakrywy() {
		return cenaWykonczenieNakrywy;
	}

	public void setCenaWykonczenieNakrywy(int cenaWykonczenieNakrywy) {
		this.cenaWykonczenieNakrywy = cenaWykonczenieNakrywy;
	}

	public int getCenaWykonczenieOkladzin() {
		return cenaWykonczenieOkladzin;
	}

	public void setCenaWykonczenieOkladzin(int cenaWykonczenieOkladzin) {
		this.cenaWykonczenieOkladzin = cenaWykonczenieOkladzin;
	}

	public int getCenaProfilNakrywy() {
		return cenaProfilNakrywy;
	}

	public void setCenaProfilNakrywy(int cenaProfilNakrywy) {
		this.cenaProfilNakrywy = cenaProfilNakrywy;
	}

	public int getCenaProfilOkladzin() {
		return cenaProfilOkladzin;
	}

	public void setCenaProfilOkladzin(int cenaProfilOkladzin) {
		this.cenaProfilOkladzin = cenaProfilOkladzin;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Wykonczenia other = (Wykonczenia) obj;
		return Objects.equal(this.wykonczenieNakrywy, other.wykonczenieNakrywy)
				&& Objects.equal(this.wykonczenieOkladzin, other.wykonczenieOkladzin)
				&& Objects.equal(this.profilNakrywy, other.profilNakrywy) && Objects.equal(this.profilOkladzin, other.profilOkladzin)
				&& Objects.equal(this.cenaWykonczenieNakrywy, other.cenaWykonczenieNakrywy)
				&& Objects.equal(this.cenaWykonczenieOkladzin, other.cenaWykonczenieOkladzin)
				&& Objects.equal(this.cenaProfilNakrywy, other.cenaProfilNakrywy)
				&& Objects.equal(this.cenaProfilOkladzin, other.cenaProfilOkladzin);

	}

	@Override
	public int hashCode() {

		return Objects.hashCode(this.wykonczenieNakrywy, this.wykonczenieOkladzin, this.profilNakrywy, this.profilOkladzin,
				this.cenaWykonczenieNakrywy, this.cenaWykonczenieOkladzin, this.cenaProfilNakrywy, this.cenaProfilOkladzin);

	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("wykonczenieNakrywy", wykonczenieNakrywy).add("wykonczenieOkladzin", wykonczenieOkladzin)
				.add("profilNakrywy", profilNakrywy).add("profilOkladzin", profilOkladzin)
				.add("cenaWykonczenieNakrywy", cenaWykonczenieNakrywy).add("cenaWykonczenieOkladzin", cenaWykonczenieOkladzin)
				.add("cenaProfilNakrywy", cenaProfilNakrywy).add("cenaProfilOkladzin", cenaProfilOkladzin).toString();
	}
}