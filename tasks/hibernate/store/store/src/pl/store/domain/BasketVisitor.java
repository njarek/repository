package pl.store.domain;

public class BasketVisitor {

	public void VisitBaksket(Basket basket) {
		for (Item item : basket.getItems()) {
			visitItem(basket, item);
		}
	}

	private void visitItem(Basket basket, Item item) {
		item.setBasket(basket);
	}
}
