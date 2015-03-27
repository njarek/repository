package best.service;

import java.util.ArrayList;
import java.util.List;

import best.service.CathegoryCounter;

public class DisplayedAuthor implements Comparable<DisplayedAuthor> {

	String name = "";
	List<CathegoryCounter> cathegoryCounters = new ArrayList<CathegoryCounter>();

	public DisplayedAuthor() {
	}

	public DisplayedAuthor(String name, List<CathegoryCounter> cathegoryCounters) {
		super();
		this.name = name;
		this.cathegoryCounters = cathegoryCounters;
	}

	public DisplayedAuthor(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CathegoryCounter> getCathegoryCounters() {
		return cathegoryCounters;
	}

	public void setCathegoryCounters(List<CathegoryCounter> cathegoryCounters) {
		this.cathegoryCounters = cathegoryCounters;
	}

	@Override
	public String toString() {
		return "Aut [name=" + name + ", cathegoryCounters=" + cathegoryCounters + "]";
	}

	@Override
	public int compareTo(DisplayedAuthor o) {
		return this.getName().compareTo(o.getName());
	}
}
