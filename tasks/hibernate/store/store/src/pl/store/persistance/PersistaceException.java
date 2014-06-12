package pl.store.persistance;

public class PersistaceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4850587588805819586L;

	public PersistaceException() {
		// TODO Auto-generated constructor stub
	}
	public PersistaceException(String message) {
		super(message);
	}
	
	public PersistaceException(String message, Throwable cause) {
		super(message,cause);
	}

}
