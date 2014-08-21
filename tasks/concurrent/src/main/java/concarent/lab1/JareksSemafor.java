package concarent.lab1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class JareksSemafor implements Lock {

	private int numberOfAcceptableThreads;
	private int threadCount = 0;

	public JareksSemafor(int numberOfThreads) {
		this.setNumberOfAcceptableThreads(numberOfThreads);
	}

	public void lock() {

		synchronized (this) {
			try {
				while (getCurrentThread() >= getNumberOfAcceptableThreads()) {
					// System.out.println("locked for thread");

					this.wait();
				}
				threadCount++;

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
		threadCount--;
		this.notifyAll();

	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumberOfAcceptableThreads() {
		return numberOfAcceptableThreads;
	}

	public void setNumberOfAcceptableThreads(int numberOfAcceptableThreads) {
		this.numberOfAcceptableThreads = numberOfAcceptableThreads;
	}

	public int getCurrentThread() {
		return threadCount;
	}

	public void setCurrentThread(int currentThread) {
		this.threadCount = currentThread;
	}

}
