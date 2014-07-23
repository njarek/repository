package pl.store.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@DiscriminatorValue("Fridge")
public class Fridge extends AgdItem {

	private String color;

	@Column(name = "I_color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Fridge [color=" + color + ", getStoreLocation()=" + getStoreLocation() + ", getIdItem()=" + getIdItem() + ", getVersion()="
				+ getVersion() + ", getQuantity()=" + getQuantity() + ", getPrice()=" + getPrice() + "]";
	}

}
