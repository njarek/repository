package pl.store.implementation;

public interface OrderSender {
	boolean sendOrder(String order) throws Exception;
}
