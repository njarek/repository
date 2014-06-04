package pl.store.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@XmlRootElement(name = "Basket")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "basket")
public class Basket {

	public Basket() {

	}

	@XmlAttribute(required = true)
	private int id;

	@XmlAttribute(required = true)
	private long version;

	@XmlElement(required = true)
	private String name;
	
	@XmlElement(required = true)
	private boolean isUpdated=false;

	@XmlElement(required = true)
	private Set<Item> items = new HashSet<Item>(0);

	public Basket(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "b_id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	@Version
	@Column(name = "b_version")
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Column(name = "b_name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "b_is_updated", nullable = false, length = 20)
	public boolean isUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "b_id")
	public Set<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void setItems(Set<Item> Items) {
		this.items = Items;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", version=" + version + ", name=" + name + ", items=" + items + "]";
	}

}
