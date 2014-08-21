package concarent.lab1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedIncremetatorByLocks {

	private int increment;
	private JareksSemafor lock = new JareksSemafor(4);

	public static void main(String[] args) {
		SynchronizedIncremetatorByLocks byLocks = new SynchronizedIncremetatorByLocks();
		byLocks.go();
	}

	public void go() {
		
		
		for(int i=0; i< 20; i++) {
			final int j = i;

		Thread incrementThread1 = new Thread(new Runnable() {
			public void run() {
				try {
					increment("thread" + j);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		incrementThread1.start();
		}

//		Thread incrementThread2 = new Thread(new Runnable() {
//			public void run() {
//				try {
//					increment("thread2");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//
//		Thread incrementThread3 = new Thread(new Runnable() {
//			public void run() {
//				try {
//					increment("thread3");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//
//		Thread incrementThread4 = new Thread(new Runnable() {
//			public void run() {
//				try {
//					increment("thread4");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//
//		incrementThread1.start();
//		incrementThread2.start();
//		incrementThread3.start();
//		incrementThread4.start();

	}

	public void increment(String threadName) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 500));
		System.out.println("thread " + threadName
				+ " waiting to enter synchronized scope");
		lock.lock();
		System.out.println("thread " + threadName + " in synchronized scope");
		System.out.println("Threads in scope " + lock.getCurrentThread());
		Thread.sleep(1000);
		for (int i = 0; i < 10000; i++) {
			increment++;
			// System.out.println("plus " + increment);
		}
		lock.unlock();
		System.out.println("thread " + threadName + " left synchronized scope");

	}

}
