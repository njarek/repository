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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((storeLocation == null) ? 0 : storeLocation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgdItem other = (AgdItem) obj;
		if (storeLocation == null) {
			if (other.storeLocation != null)
				return false;
		} else if (!storeLocation.equals(other.storeLocation))
			return false;
		return true;
	}

}