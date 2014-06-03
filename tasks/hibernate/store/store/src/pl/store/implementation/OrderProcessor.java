package pl.store.implementation;


public interface OrderProcessor {

	String addNewBasket(String basket);
	
	String updateBasket(String basket);
	
	String findBasketById(String basket);
}
