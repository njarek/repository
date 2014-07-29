package pl.store.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "agd")
@AttributeOverrides({
    @AttributeOverride(name="description", column=@Column(name="I_DESCRIPTION")),
    @AttributeOverride(name="quantity", column=@Column(name="I_QUANTITY")),
    @AttributeOverride(name="price", column=@Column(name="I_Price"))
})
public class AgdItem extends Item {

	public AgdItem() {

	}

	private String storeLocation;

	@Column(name = "I_location")
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
