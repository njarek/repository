package pl.jojco.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "item" )
public class Item {

	public Item() {

	}

	@XmlAttribute(required = true)	
	private int idItem;
	
	@XmlAttribute(required = true)	
	private long version;
	
	@XmlElement(required = true)	
	private String description;
	
	@XmlElement(required = true)	
	private int quantity;

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

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", version=" + version + ", description=" + description + ", quantity=" + quantity + "]";
	}

}
