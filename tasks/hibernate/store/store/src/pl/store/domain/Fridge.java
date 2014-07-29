package pl.store.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Fridge")
@AttributeOverrides({ @AttributeOverride(name = "description", column = @Column(name = "I_DESCRIPTION")),
		@AttributeOverride(name = "quantity", column = @Column(name = "I_QUANTITY")),
		@AttributeOverride(name = "price", column = @Column(name = "I_Price")),
		@AttributeOverride(name = "storeLocation", column = @Column(name = "I_location")) })
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
