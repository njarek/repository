package pl.store.domain;

public interface ItemElement {

	public void accept(ItemVisitor v);
}
