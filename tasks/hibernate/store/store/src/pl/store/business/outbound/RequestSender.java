package pl.store.business.outbound;

public interface RequestSender {
	boolean sendRequest(String order) throws Exception;
}
