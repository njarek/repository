package pl.store.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "item" )
public class Item {

	public Item() {

	}
	
	@XmlTransient
	private Basket basket;

	@XmlAttribute(required = true)	
	private int idItem;
	
	@XmlAttribute(required = true)	
	private long version;
	
	@XmlElement(required = true)	
	private String description;
	
	@XmlElement(required = true)	
	private int quantity;
	
	@XmlElement(required = true)
	private double price;

	public Item(String description, int quantity) {
		super();
		this.description = description;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "i_id", unique = true, nullable = false)
	public int getIdItem() {
		return idItem;
	}

	@SuppressWarnings("unused")
	private void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	@Version
	@Column(name="i_version")
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Column(name="I_DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="I_QUANTITY")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="I_Price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", version=" + version + ", description=" + description + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@ManyToOne ()
	@JoinColumn(name = "b_id",nullable = false)
	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	



	

}
