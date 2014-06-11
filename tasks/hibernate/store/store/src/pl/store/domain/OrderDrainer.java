package pl.store.domain;

public class OrderDrainer {

	private String description;
	private long qty;
	private double price;

	public OrderDrainer(String description, long qty, double price) {
		super();
		this.setDescription(description);
		this.setQty(qty);
		this.setPrice(price);
	}

	public OrderDrainer(String description, int qty) {
		super();
		this.setDescription(description);
		this.setQty(qty);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDrainer [description=" + description + ", qty=" + qty
				+ ", price=" + price + "]";
	}

}
