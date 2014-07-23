package pl.store.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@DiscriminatorValue("AGD")
public class AgdItem extends Item {

	public AgdItem() {

	}

	private String storeLocation;

	@Column(name = "I_sotoreLocation")
	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	@Override
	public String toString() {
		return "AgdItem [storeLocation=" + storeLocation + ", getIdItem()=" + getIdItem() + ", getVersion()=" + getVersion()
				+ ", getDescription()=" + getDescription() + ", getQuantity()=" + getQuantity() + ", getPrice()=" + getPrice() + "]";
	}

}
