package pl.jojco.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Basket")
public class Basket {

	public Basket(){
		
	}
	private int id;
	private String name;
	private Set<Item> currentBasket=new HashSet<Item>(0);;

	public Basket(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	private void setId(int id) {
		this.id = id;
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
		return "Basket [id=" + id + ", name=" + name + ", currentBasket="
				+ currentBasket + "]";
	}

}
