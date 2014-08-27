package concarent.lab2;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue {
	private List<String> lista = new ArrayList<String>();
	int bufforSize;
	int currentSize=0;
	
	public BlockingQueue(int size) {
		this.bufforSize=size;
	}
	
	public  void put(String message, String threadname) throws InterruptedException{
		System.out.println(threadname+" is waiting to sent message");
		synchronized (lista) {
			
		
		while(bufforSize<=currentSize){
			lista.wait();
		}

		currentSize++;
		lista.add(message);
		lista.notify();
		}
		
	}
	
	public synchronized String take() throws InterruptedException{
		System.out.println("consumet is waiting to take messsage");
		synchronized (lista) {
		while(currentSize<=0){
			lista.wait();
		}
		currentSize--;
		String string=lista.get(0);
		lista.remove(0);
		lista.notify();
		return string;
		}
		
	}
	
}
