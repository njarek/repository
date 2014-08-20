package concarent.lab1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedIncremetatorByLocks {

	private int increment;
	private Lock lock = new JareksSemafor(1);

	public static void main(String[] args) {
		SynchronizedIncremetatorByLocks byLocks = new SynchronizedIncremetatorByLocks();
		byLocks.go();
	}

	public void go() {
		Thread incrementThread = new Thread(new Runnable() {
			public void run() {
				try {
					increment();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread decrementThread = new Thread(new Runnable() {
			public void run() {
				try {
					decrement();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread incrementThread2 = new Thread(new Runnable() {
			public void run() {
				try {
					increment2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread decrementThread2 = new Thread(new Runnable() {
			public void run() {
				try {
					decrement2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		incrementThread.start();
		decrementThread.start();
		incrementThread2.start();
		decrementThread2.start();
	}

	public void increment() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
//			Thread.sleep(1000);
			lock.lock();
			increment++;
			System.out.println("plus " + increment);
			lock.unlock();
		}

	}
	
	public void increment2() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
//			Thread.sleep(1000);
			lock.lock();
			increment++;
			System.out.println("plus2 " + increment);
			lock.unlock();
		}

	}

	public void decrement() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
//			Thread.sleep(1000);
			lock.lock();
			increment--;
			System.out.println("minyus " + increment);
			lock.unlock();
		}
		
	}
	
	public void decrement2() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
//			Thread.sleep(1000);
			lock.lock();
			increment--;
			System.out.println("minyus2 " + increment);
			lock.unlock();
		}
		
	}

}
