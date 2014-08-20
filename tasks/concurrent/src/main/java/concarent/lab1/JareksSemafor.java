package concarent.lab1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class JareksSemafor implements Lock {

	private boolean isLocked = false;
	private int numberOfAcceptableThreads;
	private int currentThread=0;

	public JareksSemafor(int numberOfThreads) {
		this.numberOfAcceptableThreads = numberOfThreads;
	}

	public void lock() {

		synchronized (this) {
			currentThread++;
			try {
				while (isLocked && currentThread>=numberOfAcceptableThreads ) {
					System.out.println("locked for thread");
					
					this.wait();
				}
				
				isLocked = true;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public synchronized void unlock() {
		currentThread--;
		isLocked = false;
		this.notify();

	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
