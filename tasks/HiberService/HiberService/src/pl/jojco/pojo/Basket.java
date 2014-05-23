package pl.jojco.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Basket")
public class Basket {

	public Basket(){
		
	}
	private int id;
	private String name;
	private List<Item> currentBasket;

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

	public List<Item> getCurrentBasket() {
		return currentBasket;
	}

	public void setCurrentBasket(List<Item> currentBasket) {
		this.currentBasket = currentBasket;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", name=" + name + ", currentBasket="
				+ currentBasket + "]";
	}

}
