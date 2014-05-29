package pl.jojco.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Basket")
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
	
	@Column(name = "b_name",  nullable = false, length = 20)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="b_id")
	private Set<Item> currentBasket=new HashSet<Item>(0);;

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

	
	public Set<Item> getCurrentBasket() {
		return currentBasket;
	}
	
	
	public Set<Item> addItem(Item item) {
		currentBasket.add(item);
		return currentBasket;
	}

	
	public void setCurrentBasket(Set<Item> currentBasket) {
		this.currentBasket = currentBasket;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", version=" + version + ", name=" + name + ", currentBasket=" + currentBasket + "]";
	}

	

}
