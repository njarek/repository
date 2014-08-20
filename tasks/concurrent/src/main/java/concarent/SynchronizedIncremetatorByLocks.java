package concarent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedIncremetatorByLocks {

	private  int increment;
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		SynchronizedIncremetatorByLocks byLocks= new SynchronizedIncremetatorByLocks();
		byLocks.go();
	}
	
	public void go() {
		Thread incrementThread = new Thread(new Runnable() {
			public void run() {			
					increment();				
			}
		});

		Thread decrementThread = new Thread(new Runnable() {
			public void run() {
				decrement();
			}
		});
		incrementThread.start();
		decrementThread.start();
	}

	public  void increment() {
		lock.lock();
		for (int i = 0; i < 10000; i++) {
			increment++;
			System.out.println("plus " + increment);
		}
		lock.unlock();
	}

	public  void decrement() {
		lock.lock();
		for (int i = 0; i < 10000; i++) {
			increment--;
			System.out.println("minyus " + increment);
		}
		lock.unlock();
	}

}
