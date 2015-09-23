package pl.calc.domain;

import com.google.common.base.Objects;

public class TombstoneSerwer {

	private String wzor;
	private CenySerwer ceny;
	private Grubosci grubosci;
	private Wymiary wymiary;
	private Wykonczenia wykomczenia;
	
	public TombstoneSerwer() {
	}
	
	public TombstoneSerwer(String wzor, CenySerwer ceny, Grubosci grubosci, Wymiary wymiary, Wykonczenia wykomczenia) {
		super();
		this.setWzor(wzor);
		this.ceny = ceny;
		this.grubosci = grubosci;
		this.wymiary = wymiary;
		this.wykomczenia = wykomczenia;
	}
	
	public String getWzor() {
		return wzor;
	}

	public void setWzor(String wzor) {
		this.wzor = wzor;
	}

	public CenySerwer getCeny() {
		return ceny;
	}

	public void setCeny(CenySerwer ceny) {
		this.ceny = ceny;
	}

	public Grubosci getGrubosci() {
		return grubosci;
	}

	public void setGrubosci(Grubosci grubosci) {
		this.grubosci = grubosci;
	}

	public Wymiary getWymiary() {
		return wymiary;
	}

	public void setWymiary(Wymiary wymiary) {
		this.wymiary = wymiary;
	}

	public Wykonczenia getWykomczenia() {
		return wykomczenia;
	}

	public void setWykomczenia(Wykonczenia wykomczenia) {
		this.wykomczenia = wykomczenia;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TombstoneSerwer other = (TombstoneSerwer) obj;
		return Objects.equal(this.wzor, other.wzor) && Objects.equal(this.ceny, other.ceny) && Objects.equal(this.grubosci, other.grubosci)
				&& Objects.equal(this.wymiary, other.wymiary) && Objects.equal(this.wykomczenia, other.wykomczenia);

	}

	@Override
	public int hashCode() {

		return Objects.hashCode(this.wzor,this.ceny, this.grubosci, this.wymiary, this.wykomczenia);

	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("wzor", wzor).add("ceny", ceny).add("grubosci", grubosci)
				.add("wymiary", wymiary).add("wykomczenia", wykomczenia)
				.toString();

	}
}
