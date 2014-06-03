package pl.store.implementation.outbound;

public interface RequestSender {
	boolean sendRequest(String order) throws Exception;
}
