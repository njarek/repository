package pl.store.domain;

public class DefoulItemVisitor implements ItemVisitor {

	private Basket basket ;
	public DefoulItemVisitor(Basket basket) {
	this.basket=basket;
	}
	
	@Override
	public void visit(Item item) {
		item.setBasket(basket);	
	}

}
