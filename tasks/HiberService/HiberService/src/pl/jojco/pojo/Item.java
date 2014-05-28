package pl.jojco.pojo;

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
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlRootElement(name = "Item")
@XmlAccessorType(value = XmlAccessType.FIELD)

@Entity
@Table(name = "item" )
public class Item {

	public Item() {

	}

	@XmlAttribute(required = true)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "i_id", unique = true, nullable = false)
	private int idItem;
	
	@XmlAttribute(required = true)
	@Version
	@Column(name="i_version")
	private long version;
	
	@Column(name="I_DESCRIPTION")
	private String description;
	
	@Column(name="I_QUANTITY")
	private int quantity;
	
	
//	@ManyToOne()
//	@JoinColumn(name = "b_id", nullable = false)
//	@XmlInverseReference(mappedBy = "basket")
//	private Basket basket;

	public Item(String description, int quantity) {
		super();
		this.description = description;
		this.quantity = quantity;
	}

	public int getIdItem() {
		return idItem;
	}

	private void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public Basket getBasket() {
//		return basket;
//	}
//
//	
//	public void setBasket(Basket basket) {
//		this.basket = basket;
//	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", version=" + version + ", description=" + description + ", quantity=" + quantity + "]";
	}

}
