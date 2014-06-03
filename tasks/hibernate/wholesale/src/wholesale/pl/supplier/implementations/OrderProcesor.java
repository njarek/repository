package wholesale.pl.supplier.implementations;

public interface OrderProcesor {

	boolean checkOder(String order);
	boolean processOrder(String order);
}
