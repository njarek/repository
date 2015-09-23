package pl.calc.domain.obliczenia;

import com.google.common.base.Objects;

public class WynikiObliczenScian {

	private int dlugoscScianDlugich;
	private int dlugoscScianKrotkich;
	private int poleScianDlugich;
	private int poleScianKrotkich;
	private int poleScian;

	public WynikiObliczenScian(int dlugoscScianDlugich, int dlugoscScianKrotkich, int poleScianDlugich, int poleScianKrotkich, int poleScian) {
		super();
		this.dlugoscScianDlugich = dlugoscScianDlugich;
		this.dlugoscScianKrotkich = dlugoscScianKrotkich;
		this.poleScianDlugich = poleScianDlugich;
		this.poleScianKrotkich = poleScianKrotkich;
		this.poleScian = poleScian;
	}

	public int getDlugoscScianDlugich() {
		return dlugoscScianDlugich;
	}

	public void setDlugoscScianDlugich(int dlugoscScianDlugich) {
		this.dlugoscScianDlugich = dlugoscScianDlugich;
	}

	public int getDlugoscScianKrotkich() {
		return dlugoscScianKrotkich;
	}

	public void setDlugoscScianKrotkich(int dlugoscScianKrotkich) {
		this.dlugoscScianKrotkich = dlugoscScianKrotkich;
	}

	public int getPoleScianDlugich() {
		return poleScianDlugich;
	}

	public void setPoleScianDlugich(int poleScianDlugich) {
		this.poleScianDlugich = poleScianDlugich;
	}

	public int getPoleScianKrotkich() {
		return poleScianKrotkich;
	}

	public void setPoleScianKrotkich(int poleScianKrotkich) {
		this.poleScianKrotkich = poleScianKrotkich;
	}

	public int getPoleScian() {
		return poleScian;
	}

	public void setPoleScian(int poleScian) {
		this.poleScian = poleScian;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final WynikiObliczenScian other = (WynikiObliczenScian) obj;
		return Objects.equal(this.dlugoscScianDlugich, other.dlugoscScianDlugich) && Objects.equal(this.dlugoscScianKrotkich, other.dlugoscScianKrotkich)
				&& Objects.equal(this.poleScianDlugich, other.poleScianDlugich) && Objects.equal(this.poleScianKrotkich, other.poleScianKrotkich)
				&& Objects.equal(this.poleScian, other.poleScian);

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.dlugoscScianDlugich, this.dlugoscScianKrotkich, this.poleScianDlugich, this.poleScianKrotkich, this.poleScian);
	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("dlugoscScianDlugich", dlugoscScianDlugich).add("dlugoscScianKrotkich", dlugoscScianKrotkich)
				.add("poleScianDlugich", poleScianDlugich).add("poleScianKrotkich", poleScianKrotkich).add("poleScian", poleScian).toString();
	}
}
