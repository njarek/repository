package pl.jojco.pojo;

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
@Table(name = "basket" )
public class Basket {

	public Basket(){
		
	}
	@XmlAttribute(required = true)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "b_id", unique = true, nullable = false)
	private int id;
	
	@XmlAttribute(required = true)
	@Version
	@Column(name="b_version")
	private long version;
	
	@XmlElement(required = true)
	@Column(name = "b_name",  nullable = false, length = 20)
	private String name;
	
	@XmlElement(required = true)
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="b_id")
	private Set<Item> items=new HashSet<Item>(0);;

	public Basket(String name) {
		super();
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	
	private void setId(int id) {
		this.id = id;
	}

	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
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
