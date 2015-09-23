package pl.calc.domain.obliczenia;

import com.google.common.base.Objects;

public class WynikiObliczenPola {

	private WynikiObliczenNakrywaGradus wynikiObliczenNakrywaGradus;
	private WynikiObliczenOkladzin wynikiObliczenOkladzin;
	private WynikiObliczenScian wynikiObliczenScian;

	public WynikiObliczenPola(WynikiObliczenNakrywaGradus wynikiObliczenNakrywaGradus, WynikiObliczenOkladzin wynikiObliczenOkladzin,
			WynikiObliczenScian wynikiObliczenScian) {
		super();
		this.wynikiObliczenNakrywaGradus = wynikiObliczenNakrywaGradus;
		this.wynikiObliczenOkladzin = wynikiObliczenOkladzin;
		this.wynikiObliczenScian = wynikiObliczenScian;
	}

	public WynikiObliczenNakrywaGradus getWynikiObliczenNakrywaGradus() {
		return wynikiObliczenNakrywaGradus;
	}

	public void setWynikiObliczenNakrywaGradus(WynikiObliczenNakrywaGradus wynikiObliczenNakrywaGradus) {
		this.wynikiObliczenNakrywaGradus = wynikiObliczenNakrywaGradus;
	}

	public WynikiObliczenOkladzin getWynikiObliczenOkladzin() {
		return wynikiObliczenOkladzin;
	}

	public void setWynikiObliczenOkladzin(WynikiObliczenOkladzin wynikiObliczenOkladzin) {
		this.wynikiObliczenOkladzin = wynikiObliczenOkladzin;
	}

	public WynikiObliczenScian getWynikiObliczenScian() {
		return wynikiObliczenScian;
	}

	public void setWynikiObliczenScian(WynikiObliczenScian wynikiObliczenScian) {
		this.wynikiObliczenScian = wynikiObliczenScian;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final WynikiObliczenPola other = (WynikiObliczenPola) obj;
		return Objects.equal(this.wynikiObliczenNakrywaGradus, other.wynikiObliczenNakrywaGradus)
				&& Objects.equal(this.wynikiObliczenOkladzin, other.wynikiObliczenOkladzin)
				&& Objects.equal(this.wynikiObliczenScian, other.wynikiObliczenScian);

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.wynikiObliczenNakrywaGradus, this.wynikiObliczenOkladzin, this.wynikiObliczenScian);
	}

	@Override
	public String toString() {

		return Objects.toStringHelper(this).add("wynikiObliczenNakrywaGradus", wynikiObliczenNakrywaGradus)
				.add("wynikiObliczenOkladzin", wynikiObliczenOkladzin).add("wynikiObliczenScian", wynikiObliczenScian).toString();
	}
}
