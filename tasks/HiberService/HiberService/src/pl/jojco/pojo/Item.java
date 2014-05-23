package pl.jojco.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	public Item(){
		
	}
	private int id;
	private String description;
	private int quantity;
	private Basket basket;

	public Item(String description, int quantity) {
		super();
		this.description = description;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	private void setId(int id) {
		this.id = id;
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

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}
}
