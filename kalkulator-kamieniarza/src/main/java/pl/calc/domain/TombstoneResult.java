package pl.calc.domain;

import com.google.common.base.Objects;

public class TombstoneResult {

	private double zuzycie;
	private double dlugoscCwiercwalka;
	private double dlugoscProfilu;
	private double cena;

	private double zuzycieNakrywa;
	private double cenaNakrywa;

	private double zuzycieGradus;
	private double cenaGradus;

	private double zuzycieScian;
	private double cenaScian;

	private double zuzycieOkladzin;
	private double cenaOkladzin;
	
	public TombstoneResult() {
	}

	public TombstoneResult(double zuzycie, double dlugoscCwiercwalka, double dlugoscProfilu, double cena, double zuzycieNakrywa, double cenaNakrywa,
			double zuzycieGradus, double cenaGradus, double zuzycieScian, double cenaScian, double zuzycieOkladzin, double cenaOkladzin) {
		super();
		this.zuzycie = zuzycie;
		this.dlugoscCwiercwalka = dlugoscCwiercwalka;
		this.dlugoscProfilu = dlugoscProfilu;
		this.cena = cena;
		this.zuzycieNakrywa = zuzycieNakrywa;
		this.cenaNakrywa = cenaNakrywa;
		this.zuzycieGradus = zuzycieGradus;
		this.cenaGradus = cenaGradus;
		this.zuzycieScian = zuzycieScian;
		this.cenaScian = cenaScian;
		this.zuzycieOkladzin = zuzycieOkladzin;
		this.cenaOkladzin = cenaOkladzin;
	}

	public double getZuzycie() {
		return zuzycie;
	}

	public void setZuzycie(double zuzycie) {
		this.zuzycie = zuzycie;
	}

	public double getDlugoscCwiercwalka() {
		return dlugoscCwiercwalka;
	}

	public void setDlugoscCwiercwalka(double dlugoscCwiercwalka) {
		this.dlugoscCwiercwalka = dlugoscCwiercwalka;
	}

	public double getDlugoscProfilu() {
		return dlugoscProfilu;
	}

	public void setDlugoscProfilu(double dlugoscProfilu) {
		this.dlugoscProfilu = dlugoscProfilu;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getZuzycieNakrywa() {
		return zuzycieNakrywa;
	}

	public void setZuzycieNakrywa(double zuzycieNakrywa) {
		this.zuzycieNakrywa = zuzycieNakrywa;
	}

	public double getCenaNakrywa() {
		return cenaNakrywa;
	}

	public void setCenaNakrywa(double cenaNakrywa) {
		this.cenaNakrywa = cenaNakrywa;
	}

	public double getZuzycieGradus() {
		return zuzycieGradus;
	}

	public void setZuzycieGradus(double zuzycieGradus) {
		this.zuzycieGradus = zuzycieGradus;
	}

	public double getCenaGradus() {
		return cenaGradus;
	}

	public void setCenaGradus(double cenaGradus) {
		this.cenaGradus = cenaGradus;
	}

	public double getZuzycieScian() {
		return zuzycieScian;
	}

	public void setZuzycieScian(double zuzycieScian) {
		this.zuzycieScian = zuzycieScian;
	}

	public double getCenaScian() {
		return cenaScian;
	}

	public void setCenaScian(double cenaScian) {
		this.cenaScian = cenaScian;
	}

	public double getZuzycieOkladzin() {
		return zuzycieOkladzin;
	}

	public void setZuzycieOkladzin(double zuzycieOkladzin) {
		this.zuzycieOkladzin = zuzycieOkladzin;
	}

	public double getCenaOkladzin() {
		return cenaOkladzin;
	}

	public void setCenaOkladzin(double cenaOkladzin) {
		this.cenaOkladzin = cenaOkladzin;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TombstoneResult other = (TombstoneResult) obj;
		return Objects.equal(this.zuzycie, other.zuzycie) && Objects.equal(this.dlugoscCwiercwalka, other.dlugoscCwiercwalka)
				&& Objects.equal(this.dlugoscProfilu, other.dlugoscProfilu) && Objects.equal(this.cena, other.cena)
				&& Objects.equal(this.zuzycieGradus, other.zuzycieGradus) && Objects.equal(this.cenaGradus, other.cenaGradus)
				&& Objects.equal(this.zuzycieNakrywa, other.zuzycieNakrywa) && Objects.equal(this.cenaNakrywa, other.cenaNakrywa)
				&& Objects.equal(this.zuzycieOkladzin, other.zuzycieOkladzin) && Objects.equal(this.cenaOkladzin, other.cenaOkladzin)
				&& Objects.equal(this.zuzycieScian, other.zuzycieScian) && Objects.equal(this.cenaScian, other.cenaScian);

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.zuzycie, this.dlugoscCwiercwalka, this.dlugoscProfilu, this.cena, this.zuzycieGradus, this.cenaGradus,
				this.zuzycieNakrywa, this.cenaNakrywa, this.zuzycieScian, this.cenaScian, this.zuzycieOkladzin, this.cenaOkladzin);

	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("zuzycie", zuzycie).add("dlugoscCwiercwalka", dlugoscCwiercwalka)
				.add("dlugoscProfilu", dlugoscProfilu).add("cena", cena)
				.add("zuzycieNakrywa", zuzycieNakrywa).add("cenaNakrywa", cenaNakrywa).add("zuzycieGradus", zuzycieGradus).add("cenaGradus", cenaGradus).add("zuzycieScian", zuzycieScian)
				.add("cenaScian", cenaScian).add("zuzycieOkladzin", zuzycieOkladzin).add("cenaOkladzin", cenaOkladzin).toString();

	}
}
