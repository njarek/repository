package pl.jojco.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Item")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Item {

	public Item(){
		
	}
	@XmlAttribute(required=true)
	private int idItem;
	private String description;
	private int quantity;
	@XmlTransient
	private Basket basket;

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

	@Override
	public String toString() {
		return "Item [id=" + idItem + ", description=" + description + ", quantity=" + quantity  + "]";
	}
	
}
